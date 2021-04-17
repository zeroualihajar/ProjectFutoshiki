package futochiki;
import static futochiki.Backtracking.backtracking;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class futoshiki extends javax.swing.JFrame {
    
    private int dim = 4;                //----- Dimension de la matrice contenant juste les nombres
    private int dimMatrice = 4;         //----- Dimension de la matrice globale contenant les nombres et les symboles
    private JTextField[][] matrice;     //----- Les TextField contenant les symboles + les nombres
    private String[][] valeurs;         //----- La matrice des vaelurs correspondant au matrice globales des TextField
    int[][] val;                        //----- La matrice des valeurs (juste les nombres) taille = dim x dim
    char[][] horizContraintes;          //----- La matrice des contraintes horizontales
    char[][] vertContraintes;           //----- La matrice des contrintes verticales
    private String dimString;           //----- Dimension choisi par l'utilisateur sur combobox
    private String levelCom;            //----- le niveau choisi par l'utilisateur sur combobox 
    JOptionPane erruer;                 //----- le panel sur laquel l'erreur (s'il existe) sera afficher
    private String var = "Simple";      //----- la variable sur laquel sera stocke le choix de variable choisi a partir de combobox
    private String dom = "Simple";      //----- la variable sur laquel sera stocke le domain choisi a partir de combobox
    private String amel= "Forward Checking";  //----- la variable sur laquel sera stocke l'algorithme d'amelioration choisi a partir de combobox
    
    
    private ST<String, SET<String>>domains;   //----- Domain de chaque cellule
    ST<String, String> config;

    //------------------------Getters & setters---------------------------------
    public int getDim()
    {
        return dim;
    }
    public int getDimMatrice()
    {
        return dimMatrice;
    }
    
    public int[][] getVal()
    {
        return val;
    }
    
    public char[][] getHorizContraintes()
    {
        return horizContraintes;
    }
    
    public char[][] getVertContraintes()
    {
        return vertContraintes;
    }
    
    public String[][] getValeurs()
    {
        return valeurs;
    }
    
    public String getVar()
    {
        return this.var;
    }
    
    public String getDom()
    {
        return this.dom;
    }
    
    public String getAmel()
    {
        return this.amel;
    }
    
    //--------------------------------Constructeur------------------------------
    public futoshiki() 
    {
        initComponents();
        
        //----On va afficher le temps d'execution sur le textField "temps" 
        //----- On va le mettre inmodifiable lorsqu'il est affiché
        temps.setEditable(false);
        
        //----- panel contenant les TextField
        grille.setBounds(300, 300,  300, 300);
        
        //----- Affichage des TextField
        afficher();

      //----- Centrer la fenetre 
      Dimension screenSize,frameSize;
      int x,y;
      screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      frameSize=getSize();
      x=(screenSize.width-frameSize.width)/2;
      y=(screenSize.height-frameSize.height)/2;
      setLocation(x, y);
      
      //------- Eliminer le droit d'agrandir le panel
      this.setResizable(false);
    }
    
    

    //--------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principal = new javax.swing.JPanel();
        grille = new javax.swing.JPanel();
        duree = new javax.swing.JLabel();
        temps = new javax.swing.JTextField();
        controls = new javax.swing.JPanel();
        dimensionCombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        verifier = new javax.swing.JButton();
        resoudre = new javax.swing.JButton();
        quitter = new javax.swing.JButton();
        vider1 = new javax.swing.JButton();
        varCom = new javax.swing.JComboBox<>();
        dif = new javax.swing.JLabel();
        level = new javax.swing.JComboBox<>();
        domCom = new javax.swing.JComboBox<>();
        amelCom = new javax.swing.JComboBox<>();
        dif1 = new javax.swing.JLabel();
        dif2 = new javax.swing.JLabel();
        dif3 = new javax.swing.JLabel();
        rempl = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Futoshiki");

        principal.setBackground(new java.awt.Color(153, 0, 51));

        grille.setBackground(new java.awt.Color(153, 0, 51));
        grille.setForeground(new java.awt.Color(51, 51, 51));
        grille.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        grille.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout grilleLayout = new javax.swing.GroupLayout(grille);
        grille.setLayout(grilleLayout);
        grilleLayout.setHorizontalGroup(
            grilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        grilleLayout.setVerticalGroup(
            grilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        duree.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        duree.setForeground(new java.awt.Color(255, 255, 204));
        duree.setText("Temps d'execution en (s)");
        duree.setToolTipText("");

        javax.swing.GroupLayout principalLayout = new javax.swing.GroupLayout(principal);
        principal.setLayout(principalLayout);
        principalLayout.setHorizontalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalLayout.createSequentialGroup()
                .addGroup(principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(principalLayout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(duree)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(temps, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(principalLayout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(grille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        principalLayout.setVerticalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(duree, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(temps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131)
                .addComponent(grille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );

        controls.setBackground(new java.awt.Color(153, 0, 51));

        dimensionCombo.setBackground(new java.awt.Color(255, 202, 0));
        dimensionCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "4x4", "5x5", "6x6", "7x7", "8x8" }));
        dimensionCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dimensionComboActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Dimension");

        verifier.setBackground(new java.awt.Color(153, 0, 51));
        verifier.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        verifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help-icon.png"))); // NOI18N
        verifier.setToolTipText("Verifier Solution");
        verifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifierActionPerformed(evt);
            }
        });

        resoudre.setBackground(new java.awt.Color(204, 255, 255));
        resoudre.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        resoudre.setText("Résoudre");
        resoudre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resoudreActionPerformed(evt);
            }
        });

        quitter.setBackground(new java.awt.Color(153, 0, 51));
        quitter.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        quitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Windows-Close-Program-icon (1).png"))); // NOI18N
        quitter.setToolTipText("Quitter");
        quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterActionPerformed(evt);
            }
        });

        vider1.setBackground(new java.awt.Color(153, 0, 51));
        vider1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        vider1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Reload-icon.png"))); // NOI18N
        vider1.setToolTipText("Recommencer");
        vider1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vider1ActionPerformed(evt);
            }
        });

        varCom.setBackground(new java.awt.Color(255, 202, 0));
        varCom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simple", "MVR", "Degree", "Degree & MVR" }));

        dif.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        dif.setForeground(new java.awt.Color(255, 255, 255));
        dif.setText("Difficulté");

        level.setBackground(new java.awt.Color(255, 202, 0));
        level.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "facile", "trivial", "normal", "difficile" }));
        level.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelActionPerformed(evt);
            }
        });

        domCom.setBackground(new java.awt.Color(255, 202, 0));
        domCom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simple", "LCV" }));

        amelCom.setBackground(new java.awt.Color(255, 202, 0));
        amelCom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Forward Checking", "AC-1", "FC & AC-1" }));

        dif1.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        dif1.setForeground(new java.awt.Color(255, 255, 255));
        dif1.setText("Choix de variable");

        dif2.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        dif2.setForeground(new java.awt.Color(255, 255, 255));
        dif2.setText("Domaine");

        dif3.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        dif3.setForeground(new java.awt.Color(255, 255, 255));
        dif3.setText("Amélioration");

        rempl.setBackground(new java.awt.Color(204, 255, 255));
        rempl.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        rempl.setText("Remplir");
        rempl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remplActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlsLayout = new javax.swing.GroupLayout(controls);
        controls.setLayout(controlsLayout);
        controlsLayout.setHorizontalGroup(
            controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dimensionCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(level, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(varCom, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dif1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(domCom, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dif2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(amelCom, 0, 124, Short.MAX_VALUE)
                    .addComponent(dif3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rempl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resoudre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(verifier, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(vider1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quitter, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        controlsLayout.setVerticalGroup(
            controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controlsLayout.createSequentialGroup()
                        .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(dif)
                            .addComponent(dif1)
                            .addComponent(dif2)
                            .addComponent(dif3)
                            .addComponent(rempl))
                        .addGap(6, 6, 6)
                        .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dimensionCombo)
                            .addComponent(level)
                            .addComponent(varCom)
                            .addComponent(domCom)
                            .addComponent(amelCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resoudre)))
                    .addGroup(controlsLayout.createSequentialGroup()
                        .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(vider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(verifier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quitter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(controls, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(controls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //----------------------------Creation des textFieled-----------------------
    public void creation()
    {
        //----- dimension selectionné par l'utilisateur
        dimString = dimensionCombo.getSelectedItem().toString();
        
        //----- niveau selectionné par l'utilisateur
        levelCom = level.getSelectedItem().toString();
        
        switch (dimString) {
            case "4x4":
                dim = 4;
                break;
            case "5x5":
                dim = 5;
                break;
            case "6x6":
                dim = 6;
                break;
            case "7x7":
                dim = 7;
                break;
            case "8x8":
                dim = 8;
                break;
            case "9x9":
                dim = 9;
                break;
            default:
                break;
        }
        
        //----- dimension de la grille contenant les contraintes et les valeurs
        dimMatrice = 2 * dim - 1;
        
        //----- L'instanciation de la grille des textFields affichées
        matrice = new JTextField[dimMatrice][dimMatrice];
        
        //----- L'instanciation de la grille des valeurs correspondant à la gille "matrice"
        valeurs = new String[dimMatrice][dimMatrice];
        
        // suppression de la matrice des TextField lorsque la dimencion est changé
        grille.removeAll();
        
        //----- Dessin de la grille selon la dim choisi
        grille.repaint();
       
        //----- La position de la nouvelle grille
        switch(dim)
        {
            case 4:
                grille.setBounds(principal.getX()+280, principal.getY()+90,  300, 300);         
                break;
            case 5:
                grille.setBounds(principal.getX()+240, principal.getY()+90, 375, 375);
                break;
            case 6:
                grille.setBounds(principal.getX()+228, principal.getY()+40, 450, 450);
                break;
            case 7:
                grille.setBounds(principal.getX()+185, principal.getY(), 550, 550);
                break;
            case 8:
                grille.setBounds(principal.getX()+120, principal.getY()-40, 625, 625);
                break; 
        }
        
        //----- L'instanciation de chaque element de la matrice des textFieled
        for(int i = 0; i < dimMatrice; i++)
        {
            for(int j = 0; j < dimMatrice; j++)
            {
                matrice[i][j] = new JTextField();
                valeurs[i][j] = "";
                matrice[i][j].setHorizontalAlignment(JTextField.CENTER);
                matrice[i][j].setFont(new java.awt.Font("Bookman Old Style", 1, 24));
        
                grille.add(matrice[i][j]);
                
                //----- Les cellules contenant les nombres
                if(i % 2 == 0 && j % 2 == 0)
                {
                    matrice[i][j].setBounds(j * 40, i * 40, 50, 50);


                }
                //----- Les reste des cellules 
                else
                {
                    matrice[i][j].setBounds(j * 40 + 10, i * 40 + 10, 30, 30);
                    matrice[i][j].setBackground(new java.awt.Color(153, 0, 51));
                    matrice[i][j].setForeground(Color.yellow);
                    matrice[i][j].setFont(new java.awt.Font("", Font.PLAIN, 24));
                    matrice[i][j].setBorder(null);
                    matrice[i][j].setEditable(false);
                }
                 
                //----- Ne pas afficher les cellules qui ne contient ni les nombres ni les cellules
                if (i % 2 != 0 && j % 2 != 0)
                   matrice[i][j].setVisible(false);
            }
        }
    }
    
    
    //--------------------------------------------------------------------------
    
    //------- Remplir les cellules selon le niveux correspond a chaque dimension
    
    //----- Niveau : Facile
    public void facile()
    {
        switch(dim)
        {
            case 4:
                matrice[0][0].setText("2");
                matrice[1][0].setText("v");
                matrice[4][5].setText(">");
                matrice[6][0].setText("3");
                matrice[6][3].setText(">");
                matrice[5][6].setText("v");

                //---- Mettre les cellules non modifiable
                matrice[0][0].setEditable(false);
                matrice[6][0].setEditable(false);
                  
                break;
            
            case 5:
                matrice[0][3].setText("<");
                matrice[1][0].setText("^");
                matrice[2][6].setText("1");
                matrice[4][1].setText("<");
                matrice[4][3].setText("<");
                matrice[4][4].setText("3");
                matrice[5][6].setText("v");
                matrice[6][5].setText("<");
                matrice[7][2].setText("^");
                matrice[7][4].setText("v");
                matrice[8][0].setText("3");
                
                //---- Mettre les cellules non modifiable
                matrice[2][6].setEditable(false);
                matrice[4][4].setEditable(false);
                matrice[8][0].setEditable(false);
                
                break;
                
            case 6:
                matrice[0][1].setText(">");
                matrice[0][7].setText(">");
                matrice[0][9].setText(">");
                matrice[1][6].setText("^");
                matrice[3][2].setText("^");
                matrice[3][8].setText("v");
                matrice[3][10].setText("^");
                matrice[4][0].setText("4");
                matrice[5][2].setText("v");
                matrice[5][4].setText("v");
                matrice[6][6].setText("5");
                matrice[6][10].setText("2");
                matrice[7][2].setText("v");
                matrice[8][3].setText(">");
                matrice[8][9].setText("<");
                matrice[10][2].setText("1");
                matrice[10][9].setText("<");
                
                //---- Mettre les cellules non modifiable
                matrice[4][0].setEditable(false);
                matrice[6][6].setEditable(false);
                matrice[6][10].setEditable(false);
                matrice[10][2].setEditable(false);
                
                break;
            
            case 7 :
                matrice[0][1].setText("<");
                matrice[0][10].setText("3");
                matrice[0][12].setText("7");
                matrice[1][0].setText("v");
                matrice[1][6].setText("v");
                matrice[2][3].setText(">");
                matrice[4][4].setText("3");
                matrice[4][9].setText("<");
                matrice[5][10].setText("^");
                matrice[6][2].setText("6");
                matrice[6][5].setText("<");
                matrice[7][8].setText("^");
                matrice[7][10].setText("^");
                matrice[9][12].setText("^");
                matrice[10][10].setText("4");
                matrice[11][2].setText("v");
                matrice[11][4].setText("v");
                matrice[12][7].setText(">");
                matrice[12][12].setText("1");
                
                //---- Mettre les cellules non modifiable
                matrice[0][10].setEditable(false);
                matrice[0][12].setEditable(false);
                matrice[4][4].setEditable(false);
                matrice[6][2].setEditable(false);
                matrice[10][10].setEditable(false);
                matrice[12][12].setEditable(false);
                
                break;
                
            case 8:
                matrice[0][1].setText("<");
                matrice[0][3].setText("<");
                matrice[0][9].setText("<");
                matrice[0][13].setText("<");
                matrice[1][6].setText("v");
                matrice[2][2].setText("2");
                matrice[3][0].setText("^");
                matrice[4][5].setText("<");
                matrice[4][7].setText("<");
                matrice[4][11].setText(">");
                matrice[5][10].setText("^");
                matrice[5][14].setText("^");
                matrice[6][9].setText(">");
                matrice[6][13].setText(">");
                matrice[7][0].setText("^");
                matrice[8][6].setText("3");
                matrice[9][8].setText("v");
                matrice[9][10].setText("^");
                matrice[10][6].setText("5");
                matrice[10][7].setText("<");
                matrice[11][0].setText("v");
                matrice[11][2].setText("v");
                matrice[11][4].setText("v");
                matrice[11][14].setText("v");
                matrice[12][0].setText("7");
                matrice[12][13].setText("<");
                matrice[13][4].setText("^");
                matrice[13][8].setText("^");
                matrice[13][10].setText("v");
                matrice[14][3].setText(">");
                matrice[14][7].setText(">");
                matrice[14][11].setText(">");
                matrice[14][13].setText(">");
                matrice[14][14].setText("3");
                
                //---- Mettre les cellules non modifiable
                matrice[2][2].setEditable(false);
                matrice[8][6].setEditable(false);
                matrice[10][6].setEditable(false);
                matrice[12][0].setEditable(false);
                matrice[14][14].setEditable(false);
                break;
            
        }
    }
    
     //----- Niveau : Trivial
    public void trivial()
    {
        switch(dim)
        {
            case 4:
                
                matrice[0][6].setText("2");
                matrice[2][2].setText("1");
                matrice[2][4].setText("2");
                matrice[4][0].setText("4");
                matrice[4][6].setText("1");
                
                //---- Mettre les cellules non modifiable
                matrice[0][6].setEditable(false);
                matrice[2][2].setEditable(false);
                matrice[2][4].setEditable(false);
                matrice[4][0].setEditable(false);
                matrice[4][6].setEditable(false);
                
                break;
                
            case 5:
                matrice[0][0].setText("2");
                matrice[2][2].setText("4");
                matrice[4][2].setText("1");
                matrice[6][0].setText("4");
                matrice[6][4].setText("5");
                matrice[6][6].setText("2");
                matrice[8][4].setText("1");
                matrice[8][8].setText("3");
                
                //---- Mettre les cellules non modifiable
                matrice[0][0].setEditable(false);
                matrice[2][2].setEditable(false);
                matrice[4][2].setEditable(false);
                matrice[6][0].setEditable(false);
                matrice[6][4].setEditable(false);
                matrice[6][6].setEditable(false);
                matrice[8][4].setEditable(false);
                matrice[8][8].setEditable(false);
                break;
            
            case 6:
                matrice[0][10].setText("3");
                matrice[2][0].setText("5");
                matrice[2][8].setText("1");
                matrice[4][0].setText("4");
                matrice[4][2].setText("2");
                matrice[4][6].setText("3");
                matrice[6][2].setText("3");
                matrice[6][6].setText("4");
                matrice[6][8].setText("2");
                matrice[8][0].setText("3");
                matrice[8][4].setText("1");
                matrice[10][2].setText("6");
                
                //---- Mettre les cellules non modifiable
                matrice[0][10].setEditable(false);
                matrice[2][0].setEditable(false);
                matrice[2][8].setEditable(false);
                matrice[4][0].setEditable(false);
                matrice[4][2].setEditable(false);
                matrice[4][6].setEditable(false);
                matrice[6][2].setEditable(false);
                matrice[6][6].setEditable(false);
                matrice[6][8].setEditable(false);
                matrice[8][0].setEditable(false);
                matrice[8][4].setEditable(false);
                matrice[10][2].setEditable(false);
                
                break;
                
            case 7 : 
                matrice[0][2].setText("7");
                matrice[0][6].setText("5");
                matrice[0][8].setText("3");
                matrice[0][10].setText("2");
                matrice[2][8].setText("2");
                matrice[2][12].setText("5");
                matrice[4][0].setText("3");
                matrice[4][6].setText("1");
                matrice[4][10].setText("5");
                matrice[4][12].setText("7");
                matrice[6][2].setText("5");
                matrice[6][4].setText("2");
                matrice[6][10].setText("6");
                matrice[8][10].setText("1");
                matrice[10][2].setText("1");
                matrice[10][8].setText("5");
                matrice[10][12].setText("3");
                matrice[12][0].setText("1");
                matrice[12][6].setText("4");
                
                //---- Mettre les cellules non modifiable
                matrice[0][2].setEditable(false);
                matrice[0][6].setEditable(false);
                matrice[0][8].setEditable(false);
                matrice[0][10].setEditable(false);
                matrice[2][8].setEditable(false);
                matrice[2][12].setEditable(false);
                matrice[4][0].setEditable(false);
                matrice[4][6].setEditable(false);
                matrice[4][10].setEditable(false);
                matrice[4][12].setEditable(false);
                matrice[6][2].setEditable(false);
                matrice[6][4].setEditable(false);
                matrice[6][10].setEditable(false);
                matrice[8][10].setEditable(false);
                matrice[10][2].setEditable(false);
                matrice[10][8].setEditable(false);
                matrice[10][12].setEditable(false);
                matrice[12][0].setEditable(false);
                matrice[12][6].setEditable(false);
                
                break;
                
            case 8 :
                matrice[0][4].setText("8");
                matrice[0][6].setText("2");
                matrice[0][8].setText("6");
                matrice[2][2].setText("1");
                matrice[4][4].setText("5");
                matrice[4][6].setText("3");
                matrice[4][12].setText("7");
                matrice[4][14].setText("4");
                matrice[6][6].setText("1");
                matrice[6][12].setText("2");
                matrice[8][0].setText("3");
                matrice[8][8].setText("7");
                matrice[8][12].setText("6");
                matrice[10][2].setText("7");
                matrice[10][8].setText("4");
                matrice[10][10].setText("2");
                matrice[10][12].setText("3");
                matrice[12][0].setText("1");
                matrice[12][2].setText("6");
                matrice[12][4].setText("4");
                matrice[12][12].setText("5");
                matrice[14][0].setText("6");
                matrice[14][2].setText("3");
                matrice[14][8].setText("2");
                matrice[14][12].setText("4");
                matrice[14][14].setText("7");
                
                //---- Mettre les cellules non modifiable
                matrice[0][4].setEditable(false);
                matrice[0][6].setEditable(false);
                matrice[0][8].setEditable(false);
                matrice[2][2].setEditable(false);
                matrice[4][4].setEditable(false);
                matrice[4][6].setEditable(false);
                matrice[4][12].setEditable(false);
                matrice[4][14].setEditable(false);
                matrice[6][6].setEditable(false);
                matrice[6][12].setEditable(false);
                matrice[8][0].setEditable(false);
                matrice[8][8].setEditable(false);
                matrice[8][12].setEditable(false);
                matrice[10][2].setEditable(false);
                matrice[10][8].setEditable(false);
                matrice[10][10].setEditable(false);
                matrice[10][12].setEditable(false);
                matrice[12][0].setEditable(false);
                matrice[12][2].setEditable(false);
                matrice[12][4].setEditable(false);
                matrice[12][12].setEditable(false);
                matrice[14][0].setEditable(false);
                matrice[14][2].setEditable(false);
                matrice[14][8].setEditable(false);
                matrice[14][12].setEditable(false);
                matrice[14][14].setEditable(false);
                
                break;
                
            
        }
    }
    
    public void normal()
    {
        switch(dim)
        {
            case 4 :
                matrice[0][0].setText("2");
                matrice[4][5].setText(">");
                matrice[5][0].setText("^");
                matrice[6][1].setText("<");
                matrice[6][5].setText("<");
                
                //---- Mettre les cellules non modifiable
                matrice[0][0].setEditable(false);
                
                break;
                
            case 5 :
                matrice[1][0].setText("v");
                matrice[2][4].setText("3");
                matrice[3][4].setText("v");
                matrice[4][1].setText(">");
                matrice[6][7].setText("<");
                matrice[7][0].setText("v");
                matrice[7][8].setText("v");
                matrice[8][1].setText(">");
                matrice[8][3].setText(">");
                
                //---- Mettre les cellules non modifiable
                matrice[2][4].setEditable(false);
                
                break;
                
            case 6 :
                matrice[0][0].setText("4");
                matrice[0][3].setText(">");
                matrice[0][5].setText(">");
                matrice[0][7].setText(">");
                matrice[0][9].setText("<");
                matrice[1][10].setText("^");
                matrice[2][1].setText(">");
                matrice[2][9].setText(">");
                matrice[3][0].setText("^");
                matrice[3][10].setText("v");
                matrice[4][7].setText("<");
                matrice[5][0].setText("^");
                matrice[6][9].setText("<");
                matrice[7][6].setText("v");
                matrice[7][8].setText("v");
                matrice[8][5].setText(">");
                matrice[8][7].setText(">");
                matrice[10][3].setText("<");
                matrice[10][7].setText("<");
                
                //---- Mettre les cellules non modifiable
                matrice[0][0].setEditable(false);
               
                break;
                
            case 7 :
                matrice[0][0].setText("3");
                matrice[0][7].setText("<");
                matrice[0][11].setText("<");
                matrice[1][2].setText("v");
                matrice[1][6].setText("v");
                matrice[1][12].setText("^");
                matrice[2][9].setText("<");
                matrice[2][11].setText("<");
                matrice[3][12].setText("^");
                matrice[4][3].setText("<");
                matrice[4][4].setText("4");
                matrice[5][2].setText("v");
                matrice[7][8].setText("^");
                matrice[9][4].setText("v");
                matrice[10][6].setText("3");
                matrice[10][7].setText(">");
                matrice[10][10].setText("4");
                matrice[11][4].setText("^");
                matrice[12][5].setText("<");
                matrice[12][7].setText("<");
                matrice[12][8].setText("5");
                matrice[12][12].setText("7");
                
                //---- Mettre les cellules non modifiable
                matrice[0][0].setEditable(false);
                matrice[4][4].setEditable(false);
                matrice[10][6].setEditable(false);
                matrice[10][10].setEditable(false);
                matrice[12][8].setEditable(false);
                matrice[12][12].setEditable(false);
                
                break;
                
            case 8 :
                matrice[0][0].setText("4");
                matrice[0][1].setText("<");
                matrice[0][3].setText("<");
                matrice[0][4].setText("7");
                matrice[0][10].setText("2");
                matrice[0][11].setText(">");
                matrice[2][2].setText("7");
                matrice[2][5].setText("<");
                matrice[2][7].setText("<");
                matrice[2][8].setText("4");
                matrice[3][14].setText("^");
                matrice[5][6].setText("v");
                matrice[5][12].setText("v");
                matrice[6][9].setText("<");
                matrice[8][4].setText("2");
                matrice[9][8].setText("^");
                matrice[10][1].setText("<");
                matrice[10][2].setText("6");
                matrice[10][4].setText("4");
                matrice[10][5].setText(">");
                matrice[10][7].setText(">");
                matrice[10][10].setText("7");
                matrice[12][1].setText(">");
                matrice[12][5].setText("<");
                matrice[12][8].setText("3");
                matrice[12][9].setText(">");
                matrice[12][12].setText("2");
                matrice[13][4].setText("v");
                matrice[14][1].setText(">");
                matrice[14][14].setText("5");
                
                //---- Mettre les cellules non modifiable
                matrice[0][0].setEditable(false);
                matrice[0][1].setEditable(false);
                matrice[0][3].setEditable(false);
                matrice[0][4].setEditable(false);
                matrice[0][10].setEditable(false);
                matrice[0][11].setEditable(false);
                matrice[2][2].setEditable(false);
                matrice[2][5].setEditable(false);
                matrice[2][7].setEditable(false);
                matrice[2][8].setEditable(false);
                matrice[3][14].setEditable(false);
                matrice[5][6].setEditable(false);
                matrice[5][12].setEditable(false);
                matrice[6][9].setEditable(false);
                matrice[8][4].setEditable(false);
                matrice[9][8].setEditable(false);
                matrice[10][1].setEditable(false);
                matrice[10][2].setEditable(false);
                matrice[10][4].setEditable(false);
                matrice[10][5].setEditable(false);
                matrice[10][7].setEditable(false);
                matrice[10][10].setEditable(false);
                matrice[12][1].setEditable(false);
                matrice[12][5].setEditable(false);
                matrice[12][8].setEditable(false);
                matrice[12][9].setEditable(false);
                matrice[12][12].setEditable(false);
                matrice[13][4].setEditable(false);
                matrice[14][1].setEditable(false);
                matrice[14][14].setEditable(false);
                
                break;
                
        }
        
    }
    
    public void difficile()
    {
        switch(dim)
        {
            case 4 : 
                matrice[0][0].setText("2");
                matrice[0][6].setText("3");
                matrice[3][4].setText("^");
                matrice[3][6].setText("^");
                matrice[4][3].setText("<");
                matrice[4][5].setText(">");
                matrice[6][3].setText(">");
                
                //---- Mettre les cellules non modifiable
                matrice[0][0].setEditable(false);
                matrice[0][6].setEditable(false);
                matrice[3][4].setEditable(false);
                matrice[3][6].setEditable(false);
                matrice[4][3].setEditable(false);
                matrice[4][5].setEditable(false);
                matrice[6][3].setEditable(false);
                break;
            
            case 5 :
                matrice[0][5].setText("<");
                matrice[0][8].setText("4");
                matrice[1][0].setText("^");
                matrice[1][8].setText("v");
                matrice[2][3].setText(">");
                matrice[2][7].setText("<");
                matrice[4][4].setText("3");
                matrice[5][0].setText("^");
                matrice[6][7].setText("<");
                matrice[7][6].setText("^");
                matrice[8][7].setText("<");
                
                //---- Mettre les cellules non modifiable
                matrice[0][5].setEditable(false);
                matrice[0][8].setEditable(false);
                matrice[1][0].setEditable(false);
                matrice[1][8].setEditable(false);
                matrice[2][3].setEditable(false);
                matrice[2][7].setEditable(false);
                matrice[4][4].setEditable(false);
                matrice[5][0].setEditable(false);
                matrice[6][7].setEditable(false);
                matrice[7][6].setEditable(false);
                matrice[8][7].setEditable(false);
                break;
                
            case 6 : 
                matrice[0][0].setText("2");
                matrice[3][0].setText("v");
                matrice[3][2].setText("^");
                matrice[3][6].setText("^");
                matrice[5][4].setText("v");
                matrice[5][10].setText("^");
                matrice[6][7].setText(">");
                matrice[7][0].setText("^");
                matrice[7][4].setText("^");
                matrice[8][5].setText("<");
                matrice[9][0].setText("^");
                matrice[9][2].setText("v");
                matrice[10][1].setText("<");
                matrice[10][3].setText("<");
                
                //---- Mettre les cellules non modifiable
                matrice[0][0].setEditable(false);
                matrice[3][0].setEditable(false);
                matrice[3][2].setEditable(false);
                matrice[3][6].setEditable(false);
                matrice[5][4].setEditable(false);
                matrice[5][10].setEditable(false);
                matrice[6][7].setEditable(false);
                matrice[7][0].setEditable(false);
                matrice[7][4].setEditable(false);
                matrice[8][5].setEditable(false);
                matrice[9][0].setEditable(false);
                matrice[9][2].setEditable(false);
                matrice[10][1].setEditable(false);
                matrice[10][3].setEditable(false);
                
                break;
                
            case 7 :
                matrice[0][8].setText("3");
                matrice[0][10].setText("6");
                matrice[1][0].setText("v");
                matrice[1][2].setText("^");
                matrice[1][4].setText("^");
                matrice[1][8].setText("v");
                matrice[1][10].setText("v");
                matrice[1][12].setText("^");
                matrice[3][0].setText("^");
                matrice[3][4].setText("^");
                matrice[3][12].setText("^");
                matrice[4][4].setText("4");
                matrice[5][4].setText("v");
                matrice[5][8].setText("^");
                matrice[5][10].setText("^");
                matrice[5][12].setText("v");
                matrice[6][1].setText(">");
                matrice[6][5].setText(">");
                matrice[6][9].setText(">");
                matrice[7][2].setText("v");
                matrice[7][8].setText("^");
                matrice[7][12].setText("v");
                matrice[8][2].setText("2");
                matrice[9][4].setText("v");
                matrice[9][6].setText("^");
                matrice[9][12].setText("v");
                matrice[11][8].setText("^");
                matrice[11][12].setText("^");
                matrice[12][9].setText("<");
                
                //---- Mettre les cellules non modifiable
                matrice[0][8].setEditable(false);
                matrice[0][10].setEditable(false);
                matrice[1][0].setEditable(false);
                matrice[1][2].setEditable(false);
                matrice[1][4].setEditable(false);
                matrice[1][8].setEditable(false);
                matrice[1][10].setEditable(false);
                matrice[1][12].setEditable(false);
                matrice[3][0].setEditable(false);
                matrice[3][4].setEditable(false);
                matrice[3][12].setEditable(false);
                matrice[4][4].setEditable(false);
                matrice[5][4].setEditable(false);
                matrice[5][8].setEditable(false);
                matrice[5][10].setEditable(false);
                matrice[5][12].setEditable(false);
                matrice[6][1].setEditable(false);
                matrice[6][5].setEditable(false);
                matrice[6][9].setEditable(false);
                matrice[7][2].setEditable(false);
                matrice[7][8].setEditable(false);
                matrice[7][12].setEditable(false);
                matrice[8][2].setEditable(false);
                matrice[9][4].setEditable(false);
                matrice[9][6].setEditable(false);
                matrice[9][12].setEditable(false);
                matrice[11][8].setEditable(false);
                matrice[11][12].setEditable(false);
                matrice[12][9].setEditable(false);
               
                break;
                
            case 8 :
                matrice[0][0].setText("6");
                matrice[0][3].setText(">");
                matrice[0][7].setText(">");
                matrice[1][4].setText("v");
                matrice[1][10].setText("^");
                matrice[2][14].setText("3");
                matrice[3][4].setText("v");
                matrice[3][10].setText("^");
                matrice[3][12].setText("v");
                matrice[3][14].setText("^");
                matrice[4][5].setText(">");
                matrice[4][7].setText(">");
                matrice[5][12].setText("v");
                matrice[6][5].setText("<");
                matrice[6][7].setText(">");
                matrice[6][13].setText(">");
                matrice[7][0].setText("^");
                matrice[7][12].setText("^");
                matrice[8][2].setText("1");
                matrice[8][9].setText("<");
                matrice[8][13].setText("<");
                matrice[10][3].setText("<");
                matrice[10][4].setText("4");
                matrice[10][6].setText("2");
                matrice[10][13].setText("<");
                matrice[11][12].setText("v");
                matrice[12][6].setText("8");
                matrice[12][9].setText("<");
                matrice[12][13].setText(">");
                matrice[13][10].setText("^");
                matrice[13][12].setText("^");
                matrice[14][13].setText("<");
                matrice[14][14].setText("6");
                
                //---- Mettre les cellules non modifiable
                matrice[0][0].setEditable(false);
                matrice[0][3].setEditable(false);
                matrice[0][7].setEditable(false);
                matrice[1][4].setEditable(false);
                matrice[1][10].setEditable(false);
                matrice[2][14].setEditable(false);
                matrice[3][4].setEditable(false);
                matrice[3][10].setEditable(false);
                matrice[3][12].setEditable(false);
                matrice[3][14].setEditable(false);
                matrice[4][5].setEditable(false);
                matrice[4][7].setEditable(false);
                matrice[5][12].setEditable(false);
                matrice[6][5].setEditable(false);
                matrice[6][7].setEditable(false);
                matrice[6][13].setEditable(false);
                matrice[7][0].setEditable(false);
                matrice[7][12].setEditable(false);
                matrice[8][2].setEditable(false);
                matrice[8][9].setEditable(false);
                matrice[8][13].setEditable(false);
                matrice[10][3].setEditable(false);
                matrice[10][4].setEditable(false);
                matrice[10][6].setEditable(false);
                matrice[10][13].setEditable(false);
                matrice[11][12].setEditable(false);
                matrice[12][6].setEditable(false);
                matrice[12][9].setEditable(false);
                matrice[12][13].setEditable(false);
                matrice[13][10].setEditable(false);
                matrice[13][12].setEditable(false);
                matrice[14][13].setEditable(false);
                matrice[14][14].setEditable(false);
                
                break;
            
        }
        
    }
    
    //--------------------------------------------------------------------------
    //---- Remplissage selon le niveau et dimension
    public void remplir()
    {
        switch(levelCom)
        {
            case "facile":
                facile();
                break;
            
            case "trivial":
                trivial();
                break;
                
            case "normal":
                normal();
                break;
            
            case "difficile":
                difficile();
                break; 
        }
    }       
        
    //--------------------------------------------------------------------------
    //---- affichage sur l'ecran
    public void afficher()
    {
        creation();
        remplir();
    }
    
    //--------------------------------------------------------------------------
    //---------L'action de combobox qui correspond au choix de dimension--------
    private void dimensionComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dimensionComboActionPerformed
        afficher();        
    }//GEN-LAST:event_dimensionComboActionPerformed

    
    //--------------------------------------------------------------------------
    //---------L'action de bouton quitter --------------------------------------
    private void quitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterActionPerformed
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(false);        
    }//GEN-LAST:event_quitterActionPerformed

    
    //--------------------------------------------------------------------------
    //------ L'action de bouton de verification du solution ajouter par l'user
    private void verifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifierActionPerformed

        for(int i = 0; i < dimMatrice; i++) 
        {
            for (int j = 0; j < dimMatrice; j++) 
            {
                //----reccupèration des valeurs
                valeurs[i][j] = matrice[i][j].getText();
            }
        }
        
        //affecter au tableau valeurs tous les nombres existe sur les TexteFields
        if(affecter(valeurs))
        {
            //---- si tous les contraintes sont verifiées
            if(verifierContraintes(valeurs))
            {
                for(int i = 0 ; i < dim; i++)
                {
                    for(int j = 0 ; j < dim; j++)
                    {
                        //----- verifier si la case est vide
                        if(val[i][j] == 0)
                        {
                            // si la condition est vrai, alors afficher message d'erreur sur l'ecran
                            erreur("Vous n'avez pas rempli toute la grille, essayer de la remplir :)");
                            return;
                        }
                    }
                }
                //----- Afficher sur l'ecran un message indiquant que la solution proposé par le joueur est valide
                JFrame fr =  new JFrame("showMessageDialog");
                JOptionPane.showMessageDialog(fr, "Bien joue, vous avez trouver la solution :)", "Reussir", JOptionPane.INFORMATION_MESSAGE); 
            }
            else
            {
                System.out.println("ERROR");
            }
       
        }  
    }//GEN-LAST:event_verifierActionPerformed

    //--------------------------------------------------------------------------
    //---- L'action de button resoudre
    private void resoudreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resoudreActionPerformed
  
        //---- affecter aux variables les choix de joueur poiur rsoudre
        var = varCom.getSelectedItem().toString();
        dom = domCom.getSelectedItem().toString();
        amel = amelCom.getSelectedItem().toString();

        //---- la fonction de resolution de jeu
        resoudre();  

    }//GEN-LAST:event_resoudreActionPerformed

    
     //-------------------------------------------------------------------------
    //----- la fonction de resolution en utilisant le Backtracking
    public void resoudre()
    {
     
        //---- la renitialisation
        temps.setText("");
        
        //----temps d'execution : start execution
        long lStartTime =  System.currentTimeMillis();
        
        Graph graph = new Graph();
        
        //----- récupperation des valeurs
        for(int i = 0; i < dimMatrice; i++) 
        {
            for (int j = 0; j < dimMatrice; j++) 
            {
                valeurs[i][j] = matrice[i][j].getText();
            }
        }
        
        affecter(valeurs);

        //----- Contraintes au niveau des lignes
        for(int i = 0 ; i < dim ; i++)              
        {
            System.out.println("");
            for(int j = 0 ; j < dim - 1 ; j++)
            { 
                for(int k = j+1 ; k < dim ; k++)
                {
                    String var1 ="x"+i+""+j;
                    String var2 ="x"+i+""+k;
                    graph.addEdge(var1, var2);
                    System.out.print("( " + var1 + " , " + var2 + " )");
                }
            }
        }

        //----- Contraintes des colonnes
        for(int i = 0; i < dim; i++)
        {
            System.out.println("");
            for(int j = 0; j < dim; j++)
            { 
                for(int k = j + 1; k < dim; k++)
                {
                    String var1 = "x" + j + "" + i;
                    String var2 = "x" + k + "" + i;
                    graph.addEdge(var1, var2);
                    System.out.print("( " + var1 + " , " + var2 + " )");
                }
            }
        }
        System.out.println("\n");
        
        for(int i=0; i<dim ; i++)
        {
            System.out.println("");
            for(int j=0; j<dim ; j++)
            {
                if(i<dim-1 && (vertContraintes[i][j]=='v'|| vertContraintes[i][j]=='^') )
                {
                    //si con = true il faut que val[i][j]>val[i+1][j]
                    boolean con = vertContraintes[i][j]=='v';

                    //s : sup => (i,j) dans le cas con = vrai
                    //i:inf => (i+1,j) dans le cas con = vrai
                    String var1 = con ? "s" + i + "" + j : "s" + (i+1) + "" + j;
                    String var2 = con ? "x" + (i+1) + "" + j : "x" + i + "" + j;
                    
                    graph.addEdge(var1, var2);
                    System.out.print("var1 : " + var1 + " var2 : " +var2);
                    
                    var1 = var1.replace("s", "x");
                    var2 = var2.replace("x", "i");
	            graph.addEdge(var1, var2);
                    
                }
                
                if(j<dim-1 && (horizContraintes[i][j]=='>'|| horizContraintes[i][j]=='<') )
                {
                    //si con = true il faut que val[i][j]>val[i+1][j]
                    boolean con = horizContraintes[i][j]=='>';
                    
                    //s : sup => (i+1,j) dans le cas con = vrai
                    //i:inf => (i,j) dans le cas con = vrai
                    String var1 = con ? "s" + i + "" + j : "s" + i + "" + (j+1);
                    String var2 = con ? "x" + i + "" + (j+1) : "x" + i + "" + j;
                    
                    graph.addEdge(var1, var2);
                    System.out.print("var1 : " + var1 + " var2 : " +var2);
                    
                    var1 = var1.replace("s", "x");
                    var2 = var2.replace("x", "i");
	            graph.addEdge(var1, var2);
                    
                }
            }
        }
        
        //------- Tables des domaines
        ST<String, SET<String>> domainTable = new ST<String, SET<String>>();
        
        // Remplissage des domaines
        Object[][] domains = new Object[dim][dim];      //4*4 ...
        
        for(int ligne = 0; ligne < dim;ligne++)       // Colonne 
        {
            for(int col = 0; col < dim;col++)      // Ligne
            {
                domains[ligne][col] = new SET<String>();
            }
        }
        
        //----- Remplissage les domaines
        for(int i = 0; i < dim; i++) // Colonne
        {
            for(int j = 0; j < dim; j++) // Ligne
            {
                //---- Si la case n'est pas nulle, alors ajouter cette valeur au domaine correspondant à la case
                if(val[i][j] != 0)
                {
                    //------Domaine avec une seule valeur (case remplie)
                    ((SET<String>)domains[i][j]).add(new String(String.valueOf(val[i][j]))); 
                }
                //---- Sinon affecter a cette cellule tous les valeurs possibles
                else
                {
                    for(int k = 1; k <= dim; k++)
                    {
                        ((SET<String>)domains[i][j]).add(""+k);
                    }
                }
            }
        }
        
        //------ Affichage des domaines de chaque cellule
        for(int i = 0 ; i< dim ; i++)
        {
            for(int j = 0 ; j<dim ; j++)
            {
                System.out.println("dom : "+domains[i][j]);
            }
        }
        
        //------ Ajouter les domaines à la table  
        for(int i = 0 ; i < dim ; i++)       
        {
            for(int j = 0 ; j < dim ; j++)
            {
                domainTable.put("x"+i+""+j, ((SET<String>)domains[i][j]));
                System.out.println("Domanine Table : \n x"+i+""+j +" :" + domainTable.get("x"+i+""+j));
            }
        }
        
        //-----Configuration initiale
        config = new ST<String, String>();
        
        for(int ligne = 0 ; ligne < dim ; ligne++)
        {
            for(int col = 0 ; col <dim; col++)
            {
                config.put("x"+ligne+""+col,""); 
            }
        }
        
        System.out.println("\nCalcul en cours ... ");
        
        //----- Backtracking
        Backtracking back = new Backtracking(this);
        ST<String, String> result = backtracking(config, domainTable, graph);
        
        //----- Affichage de solution
        for(int i=0;i<dim;i++)
        {
            for(int j=0;j<dim;j++)
            {
                    matrice[i*2][j*2].setText(config.get("x"+i+""+j));
            }
        } 
         //----temps d'execution : end execution
        long lEndTime =  System.currentTimeMillis();
        
        //---- Le temps d'execution sera le temps de la fin - le temps de depart'
        //---- On va l'afficher en (ms)
        float output = (lEndTime - lStartTime)/1000F;
       
        //---- Afficher le temps d'execution
        temps.setText(""+output);
        
    }
   
    
    
    //--------------------------------------------------------------------------
    //---- Vider la matrice en supprimant les nombres ajoutées par l'user-------
    private void vider1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vider1ActionPerformed
        vider();
    }//GEN-LAST:event_vider1ActionPerformed

    //--------------------------------------------------------------------------
    //---- declaration de la fonction : vider()
    public void vider()
    {
        for(int i = 0 ; i < dimMatrice; i ++)
        {
            for(int j = 0 ; j< dimMatrice; j++)
            {
                //---- suppression de contenu
                matrice[i][j].setText("");
            }
        }
        temps.setText("");
        //---- afficher le jeu
        afficher();
    }
    
    //--------------------------------------------------------------------------
    //---- Action de combobox "level"
    private void levelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_levelActionPerformed
        afficher(); 
    }//GEN-LAST:event_levelActionPerformed

    //----- Remplir une case d'une manière aléatoire
    private void remplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remplActionPerformed

        //----Resolution
        if(config == null)
            resoudre();
        //---- ligne aleatoire
        int n1 = ThreadLocalRandom.current().nextInt(0, dim);
        //---- colonne aleatoire
        int n2 = ThreadLocalRandom.current().nextInt(0, dim);

        //---- si la case contient une valeur alors on l'affiche
        if(config.get("x"+n1+""+n2) != null)
        {
            matrice[n1*2][n2*2].setText(config.get("x"+n1+""+n2));
            matrice[n1*2][n2*2].setEditable(false);
        }
        
    }//GEN-LAST:event_remplActionPerformed

    
    //-------------------------------------------------------------------------------------
    //----- Reccuperation des valeurs de toute la matrice
    public boolean affecter(String[][] valeurs)
    {
        //initialisation de la matrice des valeurs
        val = new int[dim][dim];
        
        //Initialisation des contraintes
        horizContraintes = new char[dim][dim - 1];   //matrice 4x3
        vertContraintes = new char[dim - 1][dim];   //matrice 3x4
        
        for (int i = 0; i < valeurs.length; i++) 
        {
            for (int j = 0; j < valeurs.length; j++) 
            {
                //-----si la valeurs[i][j] n'est nulle
                if (!valeurs[i][j].equals("")) 
                {
                    //---- les cellules contenant les nombres
                    if (i % 2 == 0 && j % 2 == 0) 
                    {
                        try 
                        {
                            int value = Integer.parseInt(valeurs[i][j]);
                            //---- si la valeur récuperé dépasse l'intervalle [1, dim], afficher un message d'erreur
                            if (value < 1 || value > dim) 
                            {
                                erreur("La valeur ( " + value +  " ) dépasse l'intervalle. \n" + "Voir la cellule ( " + (i+1) +" , " + (j+1) + " )");
                                return false;
                            }
                            //---- sinon affecter la valeur au matrice val[][]
                            val[i / 2][j / 2] = value;
                        } catch (NumberFormatException e) 
                        {
                            System.out.println(e);
                        }
                    } 
                    
                    //---- Verifions les contraintes ajoutées
                    //---- Contrinets horizontales 
                    else if (i % 2 == 0 && j % 2 != 0) 
                    {
                        if (!(valeurs[i][j].equals("<") || valeurs[i][j].equals(">"))) 
                        {
                            erreur("Le symbole inseré dans la cellule ( " + valeurs[i][j] + ") est non valide");
                            return false;
                        }
                        horizContraintes[i / 2][(j - 1) / 2] = valeurs[i][j].charAt(0);
                    } 
                    
                    //---- Contrinets verticales 
                    else if (i % 2 != 0 && j % 2 == 0) 
                    {
                        if (!(valeurs[i][j].charAt(0) == '^' || valeurs[i][j].charAt(0) == 'v')) 
                        {
                            erreur("Le symbole inseré dans la cellule ( " + valeurs[i][j] + ") est non valide");
                            return false;
                        }
                        vertContraintes[(i - 1) / 2][j / 2] = valeurs[i][j].charAt(0);
                    }
                }
            }
        }
        return true;
    }
    
    //--------------------------------------------------------------------------
    //----- Verifier si une valeur est doubler
    public boolean doubler(String[][] valeurs)
    {
        //----- Verifion l'existence d'un doublons
        for (int ligne = 0; ligne < dim; ligne++)
        {
            for (int col = 0; col < dim; col++) 
            {
                int value = val[ligne][col];
                
                //----- Si la cellule est remplie
                if (value != 0) 
                {
                    //------ Chercher l'existence des doublons dans les lignes de la meme colonne
                    for (int i = 0; i < dim; i++) 
                    {
                        if (i != ligne)
                        {
                            //----- Si un doublons est trouvé, alors en affichant un message d'erreur
                            if (val[i][col] == value) 
                            {
                                erreur("La valeur " + value +  " est doublé dans la colonne " + (col +1)+ ". \n Voir les cellules : ( " + (ligne+1) + ", " + (col+1) + " ) et ( " + (i+1) + " , " + (col+1)+ " )");
                                return false;
                            }
                        }
                    }
                    //----- Chercher l'existence des doublons dans les colnnes de la meme ligne
                    for (int j = 0; j < dim; j++) 
                    {
                        //----- Si la cellule est remplie
                        if (j != col)
                        {
                            //----- Si un doublons est trouvé, alors en affichant un message d'erreur
                            if (val[ligne][j] == value) 
                            {
                                erreur("La valeur " + value +  " est doublé dans la ligne " + (ligne +1)+ ". \n Voir les cellules : ( " + (ligne+1) + ", " + (col+1) + " ) et ( " + (ligne+1) + " , " + (j+1)+ " )");
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    
     //-------------------------------------------------------------------------
    //----- La fonction de verification des contraintes  retourne vrai si les contraintes sont respectées
    public boolean verifierContraintes(String[][] valeurs)
    {
        //------ Si aucune valeur n'est doublé
        if(doubler(valeurs));
        {
            //-----comparaison de la cellule et la cellule +1 (gauche)
            for (int ligne = 0; ligne < dim; ligne++)
            {
                for (int col = 0; col < dim; col++) 
                {
                    int value = val[ligne][col];

                    //-----horizontalement
                    if (col >= 1 && col != dim - 1) //dim des contraintes horizantales (colonnes)  est  1<= col= <dim-1
                    {

                        if (horizContraintes[ligne][col - 1] != ' ') // la cellule est non nulle
                        {
                            if (val[ligne][col - 1] != 0) // la cellule à gauche est non null
                            {
                                switch (horizContraintes[ligne][col - 1]) 
                                {
                                    case '>':
                                        //----- Si la contraintes n'est pas verifier afficher message d'erreur
                                        if (val[ligne][col - 1] < value) 
                                        {
                                            erreur("Sysmbole non respecté ("+ val[ligne][col - 1] + ">"+ value + ").");
                                                return false;
                                        }
                                        break;
                                    case '<':
                                        //----- Si la contraintes n'est pas verifier afficher message d'erreur
                                        if (val[ligne][col - 1] > value) 
                                        {
                                                erreur("Sysmbole non respecté ("+ val[ligne][col - 1] + "<"  + value + ").");
                                                return false;
                                        }
                                        break;
                                }
                            }

                            //------ Comparaison de la cellule et la cellule - 1 (droite)
                            if (val[ligne][col + 1] != 0) // la cellule est non null
                            {
                                switch (horizContraintes[ligne][col]) 
                                {
                                    case '>':
                                         //----- Si la contraintes n'est pas verifier afficher message d'erreur
                                        if (value < val[ligne][col + 1]) 
                                        {
                                            erreur("Contrainte non respecte ("+ value + ">" + val[ligne][col + 1] + ").");
                                                return false;
                                        }
                                        break;
                                    case '<':
                                         //----- Si la contraintes n'est pas verifier afficher message d'erreur
                                        if (value > val[ligne][col + 1]) 
                                        {
                                            erreur("Contrainte non respecte (" + value + "<"+ val[ligne][col + 1] + ").");
                                            return false;
                                        }
                                        break;
                                }
                            }
                        }
                    }

                    //----- Verticalement
                    if (ligne != 0 && ligne != dim - 1) //dim des contraintes verticales = dim -1 et la ligne >=1 (en haut)
                    {
                        if (vertContraintes[ligne - 1][col] != ' ')
                        {
                            if (val[ligne - 1][col] != 0) 
                            {
                                switch (vertContraintes[ligne - 1][col]) 
                                {
                                    case '^':
                                         //----- Si la contraintes n'est pas verifier afficher message d'erreur
                                        if (val[ligne - 1][col] > value) 
                                        {
                                            erreur("Contrainte non respecte ("+ val[ligne - 1][col] + "<" + value + ").");
                                            return false;
                                        }
                                        break;
                                    case 'v':
                                         //----- Si la contraintes n'est pas verifier afficher message d'erreur
                                        if (val[ligne - 1][col] < value) 
                                        {
                                            erreur("Contrainte non respecte (" + val[ligne - 1][col] + ">"+ value + ").");
                                            return false;
                                        }
                                        break;
                                }
                            }

                            if (val[ligne + 1][col] != 0) 
                            {
                                switch (vertContraintes[ligne][col]) 
                                {
                                    case '^':
                                         //----- Si la contraintes n'est pas verifier afficher message d'erreur
                                        if (value > val[ligne + 1][col]) 
                                        {
                                            erreur("Contrainte non respecte (" + value + "<" + val[ligne + 1][col] + ").");
                                            return false;
                                        }
                                        break;
                                    case 'v':
                                         //----- Si la contraintes n'est pas verifier afficher message d'erreur
                                        if (value < val[ligne + 1][col]) 
                                        {
                                            erreur("Contrainte non respecte ("+ value + ">" + val[ligne + 1][col] + ").");
                                            return false;
                                        }
                                        break;
                                }
                            }
                        }
                    }                  
                }

            }
        }
        
    return true;
}
    
    
      
    //--------------------------------------------------------------------------
    //----- JOption d'erreur
    public void erreur(String message)
    {
        JFrame fr =  new JFrame("showMessageDialog");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(fr,message,"Erreur",JOptionPane.ERROR_MESSAGE);
    }
    
    //--------------------------------------------------------------------------
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(futoshiki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(futoshiki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(futoshiki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(futoshiki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new futoshiki().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> amelCom;
    private javax.swing.JPanel controls;
    private javax.swing.JLabel dif;
    private javax.swing.JLabel dif1;
    private javax.swing.JLabel dif2;
    private javax.swing.JLabel dif3;
    private javax.swing.JComboBox<String> dimensionCombo;
    private javax.swing.JComboBox<String> domCom;
    private javax.swing.JLabel duree;
    private javax.swing.JPanel grille;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> level;
    private javax.swing.JPanel principal;
    private javax.swing.JButton quitter;
    private javax.swing.JButton rempl;
    private javax.swing.JButton resoudre;
    private javax.swing.JTextField temps;
    private javax.swing.JComboBox<String> varCom;
    private javax.swing.JButton verifier;
    private javax.swing.JButton vider1;
    // End of variables declaration//GEN-END:variables
}
