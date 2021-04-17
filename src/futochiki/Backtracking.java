/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futochiki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


//------Pour trier des listes de (String, Integer) par ordre croissant de Integer
class cmpComptage implements Comparator 
{
    @Override
    public int compare(Object e1, Object e2) 
    {
        return ((Map.Entry<String, Integer>)e1).getValue().compareTo(((Map.Entry<String,
        Integer>)e2).getValue());
    }
}

/**
 *
 * @author HP
 */
public class Backtracking {
    
    static private int dim;
    static private int dimMatrice;
    static private String[][] valeurs;
    static private int[][] val;
    static char[][] horizContraintes;
    static char[][] vertContraintes;
    static ST<String, SET<String>> domain;
    static private String var;
    static private String dom;
    static private String amel;
    
    public static boolean WITHMRV = false ;   
    public static boolean WITHDEGRES = false;
    public static boolean WITHLCV = false;
    public static boolean WITHFC = false;
    public static boolean WITHAC = false;
    
    
    
     //-------------------------- Constructeur ---------------------------------
    public Backtracking(futoshiki jeu)
    {
        this.valeurs = jeu.getValeurs();
        this.horizContraintes = jeu.getHorizContraintes();
        this.vertContraintes = jeu.getVertContraintes();
        this.val = jeu.getVal();
        this.dim = jeu.getDim();
        this.dimMatrice = jeu.getDimMatrice();
        this.var = jeu.getVar();
        this.dom = jeu.getDom();
        this.amel = jeu.getAmel();
        
        //----- Le choix de variable par le joueur
        switch(var)
        {
            case "MVR" :
                WITHMRV = true;
                break;
            case "Degree" :
                WITHDEGRES = true;
                break;
            case "MVR & Degree" :
                WITHDEGRES = true;
                WITHMRV = true;
                break;
        }
        
        //----- Le choix de domaine par le joueur
         switch(dom)
        {
            case "LCV" :
                WITHLCV = true;
                break;
        }
        
        //----- L'algorithme d'amelioration choisie par le joueur
        switch(amel)
        {
            case "Forward Checking" :
                WITHFC = true;
                break;
                
            case "AC-1" :
                WITHAC = true;
                break;
                
            case "FC & AC-1" :
                WITHAC = true;
                WITHFC = true;
                break;
        }
    }

    //-------------------------------- Simple-----------------------------------
    public static String getVariable(ST<String, String> config) {
		
	// Retrieve a variable based on a heuristic or the next 'unfilled' one if there is no heuristic
        for (String s : config) {
        	if(config.get(s).equalsIgnoreCase(""))
        		return s;
        }
		
        // Get variable failed (all variables have been coloured)
		return null;
	}
    
    //--------------------- getVariableDegres ----------------------------------
    // Avoir une variable non affectée avec l'heuristique des degrés
    public static String getVariableDegres( Graph g, ST<String, String> config)
    {
        // Stocker (variable, nombre de contraintes)
        TreeMap<String,Integer> compteParVariable = new TreeMap<>();
        // Table associative triée par ordre décroissant (à cause du - )
        for (String var : config)
            if(config.get(var).equalsIgnoreCase(""))
                compteParVariable.put(var, -g.degree(var)) ;
        // Mettre sous forme d'une liste puis trier
        List list = new ArrayList(compteParVariable.entrySet());
        Collections.sort(list, new cmpComptage());
        return ((Map.Entry<String, Integer>)list.get(0)).getKey();
    }
    
    //---------------------- getVariableMRV ------------------------------------
    // Avoir une variable non affectée avec l'heuristique MRV
    public static String getVariableMRV(ST<String, SET<String>> domain , ST<String, String> config)
    {
        // Stocker (variable, taille du domaine)
        TreeMap<String, Integer> compteParVariable = new TreeMap<>();
        // Table associative triée par ordre croissant
        for (String var : config)
        if(config.get(var).equalsIgnoreCase(""))
        compteParVariable.put(var,domain.get(var).size()) ;
        // Mettre sous forme d'une liste puis trier
        List list = new ArrayList(compteParVariable.entrySet());
        Collections.sort(list, new cmpComptage());
        return ((Map.Entry<String, Integer>)list.get(0)).getKey();
    }
    
    //--------------------- getVariableDegresMRV -------------------------------
    // Avoir une variable non affectée avec l'heuristique des degrés suivie de MRV
    public static String getVariableDegresMRV(Graph g, ST<String, SET<String>> domain , ST<String,
    String> config)
    {
        // Stocker (variable, nombre de contraintes)
        TreeMap<String, Integer> compteParVariable1 = new TreeMap<>();
        // Stocker (variable, nombre de valeurs)
        TreeMap<String, Integer> compteParVariable2 = new TreeMap<>();
        // Table associative triée par ordre décroissant (à cause du - )
        
        for (String var : config)
            if(config.get(var).equalsIgnoreCase(""))
                compteParVariable1.put(var, -g.degree(var)) ;
        // Mettre sous forme d'une liste puis trier
        List list = new ArrayList(compteParVariable1.entrySet());
        Collections.sort(list, new cmpComptage());
        Integer compte0 = ((Map.Entry<String, Integer>)list.get(0)).getValue();
        Iterator it = list.iterator();
        // Garder les variables avec le nombre de degrés

        while(it.hasNext())
        {
            Map.Entry entree = (Map.Entry)it.next();
            if(((Integer)entree.getValue()).equals(compte0))
            {
                String var = (String)entree.getKey();
                compteParVariable2.put(var,domain.get(var).size());
            }
            else break;
        }
        list = new ArrayList(compteParVariable2.entrySet());
        Collections.sort(list, new cmpComptage());
        return ((Map.Entry<String, Integer>)list.get(0)).getKey();
    }
    
        
    //-------------------------- Forward Checking ------------------------------
    public static SET<String> forwardChecking(String u , String variable , Graph g ,ST<String, String>
                config ,ST<String, SET<String>> domain )
    { // Variables touchées
        SET<String> vars = new SET<>();
        for(String adj: g.adjacentTo(variable))
        {
            if(config.get(adj) != null && config.get(adj).equalsIgnoreCase("") && domain.get(adj).contains(u))
            {
                domain.get(adj).remove(u);
                vars.add(adj);
            }
        }
        return vars;
      
    }
    
    //---------------------------- af ------------------------------------------
    public static void af(ST<String, String> config)
    {
        for(int ligne = 0 ; ligne< dim ; ligne++)//lignes
        {
            for(int col = 0 ; col < dim; col++)//colonne
            {
                config.put("x"+ligne+""+col,""); // Variables non affectées    
            }
        }
    }
    
    //--------------------------------- AC-1 -----------------------------------
    public static void AC1(Graph g, ST<String, String> config, ST<String, SET<String>> domain)
    {
        boolean changement;
        do 
        {
            changement = false;
            for(String variable : config)
            {
                if(config.get(variable).equalsIgnoreCase("")) // Pour chaque variable non affectée
                {
                    for(String adj : g.adjacentTo(variable))
                    {
                        if(config.get(adj).equalsIgnoreCase("")) // Adjacente non affectée
                        {
                            // Pour éviter l'erreur : Exception in thread "main"
                            // java.util.ConcurrentModificationException
                            SET<String> valeurs = new SET<>(domain.get(variable).getSet());
                            for(String val : valeurs)
                            {
                                SET<String> adjDomain = domain.get(adj);
                                // Valeur consistante introuvable
                                if((adjDomain != null) && (adjDomain.contains(val)) && (adjDomain.size() == 1))
                                {
                                    // Supprimer le domaine de la variable
                                    domain.get(variable).remove(val);
                                    changement = true;
                                }
                            }
                        }
                    }
                }
            }
        } while(changement);
    }
    
    //--------------------------------- Consistent -----------------------------
    public static boolean consistent(String value, String variable, ST<String, String> config, Graph g) 
    {
        for(String adj: g.adjacentTo(variable)) 
        {
            if(!adj.contains("s") && !adj.contains("i")){
                if(config.get(adj).equalsIgnoreCase(value))
                    return false;
            }
            else if(adj.contains("s"))
            {
                String nom = adj.replace("s", "x");
                if(!config.get(nom).equals(""))
                {
                    int val = Integer.parseInt(value);
                    int sup = Integer.parseInt(config.get(nom));

                    if(sup <= val)
                        return false;
                }
            }
            else
            {
                String nom = adj.replace("i", "x");
                if(!config.get(nom).equals(""))
                {
                    int val = Integer.parseInt(value);
                    int inf = Integer.parseInt(config.get(nom));

                    if(inf > val)
                        return false;
                }
            }
        }
        return true;
    }
     
     
    //-------------------------------- Consistent ------------------------------
    public static boolean consistent(String value, String variable, ST<String, String> config,
                                   ST<String, ST<String, ST<String, SET<String>>>> constraintsTable) 
    {	
       //we need to get the constraint list for the variable
       for(String constraints: constraintsTable.get(variable)) 
       {
           //if the adjacency list member's value is equal to the variable's selected value, then consistency fails
           if(!config.get(constraints).equals("") && !(constraintsTable.get(constraints).get(value).contains(config.get(constraints)))) 
           {
                   return false;
           }
       }

       //consistency check passed according to the variable's adjacancy list
       return true;
       }
     
    //---------------------------- OrderDomainValue ----------------------------
    public static List<String> orderDomainValue(String variable, ST<String, SET<String>> domain)
    {
        List<String> valeurs = new ArrayList<>();
        // Return the SET of domain values for the variable
        for(String val:domain.get(variable))
             valeurs.add(val);
         return valeurs;
    }

    
    //-------------------------- orderDomainValueLCV ---------------------------
    // -------Liste des valeurs du domaine d'une variable, avec l'heuristique LCV
    public static List<String> orderDomainValueLCV(String variable,Graph g, ST<String, SET<String>>domain) 
    {
        // Stocker (variable, nombre de contraintes)
        TreeMap< String, Integer> compteParValeur = new TreeMap<>();
        //return the SET of domain values for the variable
        SET<String> vu = domain.get(variable);
        for(String v:vu)
        {
            int n=1;
            for(String adj: g.adjacentTo(variable))
                if(domain.get(adj) != null && domain.get(adj).contains(v))
                    n++;
            compteParValeur.put(v,n);
        }
        // Mettre sous forme d'une liste puis trier
        List list = new ArrayList(compteParValeur.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() 
        {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) 
            {
                return e1.getValue().compareTo(e2.getValue());
            }
        });
        // Liste des valeurs
        List<String> vals = new ArrayList<>();
        Iterator it = list.iterator();
        while(it.hasNext())
        {
            Map.Entry<String, Integer> entree= (Map.Entry<String, Integer>)it.next();
            vals.add((String)entree.getKey());
        }
        return vals;
    }
        
    //-------------------------------- Complete --------------------------------
    public static boolean complete(ST<String, String> config) 
    {

        for(String s: config) 
        {
            //if we find a variable in the config with no value, then this means that the config is NOT complete
            if(config.get(s).equalsIgnoreCase(""))
                    return false;
        }
        //ALL variables in config have a value, so the configuration is complete
        return true;
    }
	
        
    //----------------------------------- Affichage ----------------------------
    static void aff(ST<String, String> config)
    {
        System.out.println("");
        System.out.print(" - ");

        if(config ==null)
            System.out.print("Pas de solution");
        else
             for (String s : config)
                System.out.print("("+s + ", "+ config.get(s)+")");
    }
	public boolean verifierCont()
        {
            return true;
        }
    
    //------------------------------ backtracking ------------------------------
    public static ST<String, String> backtracking(ST<String, String> config, ST<String, SET<String>>
        domain, Graph g)
    {
        if(complete(config))
            return config;
        ST<String, String> result = null;
        // Extraire une variable
        String v =null;
        if(WITHMRV && WITHDEGRES)
            v = getVariableDegresMRV(g, domain, config);
        else if (WITHMRV)
            v = getVariableMRV(domain, config);
        else if(WITHDEGRES)
            v = getVariableDegres(g, config);
        else
            v = getVariable(config);
        // Liste des valeurs du domaine de la variable choisie
        List <String> vu;
        if(WITHLCV)
            vu = orderDomainValueLCV(v, g, domain);
        else
            vu = orderDomainValue(v, domain);
        // Variables affectées par la vérification en aval
        SET<String> variablesTouchees=null;
        // Préparer la sauvegarde des domaines
        ST<String, SET<String>> tmpDomain = null;
        for(String u: vu) 
        {
            if(consistent(u, v, config, g)) { // 
                config.put(v, u); //
                aff(config);
                // Sauvegarde des domaines
                if(WITHAC || WITHFC)
                {
                    tmpDomain = new ST<>();
                    for(String vr : domain)
                        tmpDomain.put(vr, new SET<>(domain.get(vr).getSet()));
                }
                if(WITHFC)
                    variablesTouchees = forwardChecking(u, v, g, config, domain);
                //--------------------------------------------------------
                if(WITHAC || WITHFC)
                    result = backtracking(config, tmpDomain, g);
                else
                    result = backtracking(config, domain, g);
                if(result != null)
                    return result;

                config.put(v,""); // X config.remove(v)
                if(WITHFC)
                    for(String var : variablesTouchees)
                        domain.get(var).add(u);
            }
        }
        return null;
    }
    
}
