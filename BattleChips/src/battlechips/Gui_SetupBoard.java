/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlechips;

import java.awt.BorderLayout;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;

/**
 *
 * @author berto
 */
public class Gui_SetupBoard extends JFrame  {
    
    
    private Game_controler jogo;
    
    
    private int OrientationSet;
    private int TipoChipSet;
    private int nButtonRest;
    private int nResistRest;
    private int nDecodRest;
    private int nMicroRest;
    private Dificuldade Dificuldade;
    private Chip ChipTemp;
    private Table tabAux;
    
    
    //itens de GUI
    private Gui_TableBlock casas[][]; //criação do array de paineis;
    private JLabel titulo;  
    private JPanel PainelPrincipal;
    private JPanel tabuleiro;
    private JLabel TextoInic;
    private JLabel X;
    private JLabel X2;
    private JLabel X3;
    private JLabel X4;
    private JLabel nButtons;
    private JLabel nResist;
    private JLabel nDecod;
    private JLabel nMicro;
    private JPanel imgBotao;
    private JPanel imgResist;
    private JPanel imgDecod;
    private JPanel imgMicro;
    private JButton editar;
    private JButton salvar;
    private JButton IniciarJogo;
    
            
    //CONSTRUTOR        
    public Gui_SetupBoard (Game_controler jogo) {
        
        
        this.jogo = jogo;
        OrientationSet = 1;
        TipoChipSet = 0;
        Dificuldade = jogo.getDificuldade();
        nButtonRest = Dificuldade.N_CHIP1;
        nResistRest = Dificuldade.N_CHIP2;
        nDecodRest = Dificuldade.N_CHIP3;
        nMicroRest = Dificuldade.N_CHIP4;
        
        casas = new Gui_TableBlock[Dificuldade.TABSIZE][Dificuldade.TABSIZE];
        tabAux = new Table(Dificuldade);
        InitComponents();
    
    }        
    
    
    //inicia o componente
    private void InitComponents() {
        
     
        //painel principal criação
        PainelPrincipal = new JPanel();
        PainelPrincipal.setBackground(new java.awt.Color(59, 174, 14));
      
     
        //titulo criação
        titulo = new JLabel();
        titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/SetUpBoard.png"))); // NOI18N
        
        
        //texto inicial criação
        TextoInic = new JLabel();
        TextoInic.setFont(new java.awt.Font("Verdana Pro SemiBold", 1, 14)); // NOI18N
        TextoInic.setText("SELECT THE CHIP AND CLICK WHERE YOU WANT IT TO BE:");
        
        //texto de x criação
        X = new JLabel();
        X.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        X.setText("x");
        
        X2 = new JLabel();
        X2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        X2.setText("x");
        
        X3 = new JLabel();
        X3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        X3.setText("x");
        
        X4 = new JLabel();
        X4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        X4.setText("x");       

        
        
       
        
        //numeros criação
        nButtons = new JLabel();
        nButtons.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        nButtons.setText(""+ nButtonRest);
        
        nResist = new JLabel();
        nResist.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        nResist.setText(""+ nResistRest);
        
        nDecod = new JLabel();
        nDecod.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        nDecod.setText(""+ nDecodRest);
        
        nMicro = new JLabel();
        nMicro.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        nMicro.setText(""+ nMicroRest);
        
        //icones criação
        int TamanhoIcone = 37;
        
        
        imgBotao = new JPanel();
        imgBotao.setLayout(new java.awt.GridLayout(1,1));
        imgBotao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        imgBotao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Gui_TableBlock botao = new Gui_TableBlock(1,1,TamanhoIcone);
        botao.setIconChip(1,1,1);
        imgBotao.add(botao);
        
        imgResist = new JPanel();
        imgResist.setLayout(new java.awt.GridLayout(1,2));
        imgResist.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        imgResist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Gui_TableBlock Resist1 = new Gui_TableBlock(2,1,TamanhoIcone);
        Gui_TableBlock Resist2 = new Gui_TableBlock(2,2,TamanhoIcone);
        Resist1.setIconChip(2,1,1);
        Resist2.setIconChip(2,1,2);
        imgResist.add(Resist1);
        imgResist.add(Resist2);
        
        imgDecod = new JPanel();
        imgDecod.setLayout(new java.awt.GridLayout(1,3));
        imgDecod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        imgDecod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Gui_TableBlock Decod1 = new Gui_TableBlock(3,1,TamanhoIcone);
        Gui_TableBlock Decod2 = new Gui_TableBlock(3,2,TamanhoIcone);
        Gui_TableBlock Decod3 = new Gui_TableBlock(3,3,TamanhoIcone);
        Decod1.setIconChip(3,1,1);
        Decod2.setIconChip(3,1,2);
        Decod3.setIconChip(3,1,3);
        imgDecod.add(Decod1);
        imgDecod.add(Decod2);
        imgDecod.add(Decod3);
        
        imgMicro = new JPanel();
        imgMicro.setLayout(new java.awt.GridLayout(1,4));
        imgMicro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        imgMicro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Gui_TableBlock Micro1 = new Gui_TableBlock(4,1,TamanhoIcone);
        Gui_TableBlock Micro2 = new Gui_TableBlock(4,2,TamanhoIcone);
        Gui_TableBlock Micro3 = new Gui_TableBlock(4,3,TamanhoIcone);
        Gui_TableBlock Micro4 = new Gui_TableBlock(4,4,TamanhoIcone);
        Micro1.setIconChip(4,1,1);
        Micro2.setIconChip(4,1,2);
        Micro3.setIconChip(4,1,3);
        Micro4.setIconChip(4,1,4);
        
        
        imgMicro.add(Micro1);
        imgMicro.add(Micro2);
        imgMicro.add(Micro3);
        imgMicro.add(Micro4);
        
        
        //deninição de objeto Listener para cada botão 
        java.awt.event.MouseListener chipBotListener = new java.awt.event.MouseListener() {

                 

                 @Override
                 public void mouseClicked(MouseEvent e) {
                     imgChipClicado (e);
                 }

                 @Override
                 public void mousePressed(MouseEvent e) {
                     //do nothing
                 }

                 @Override
                 public void mouseReleased(MouseEvent e) {
                     //do nothing
                 }

                 @Override
                 public void mouseEntered(MouseEvent e) {
                     imgChipFocus(e);
                 }

                 @Override
                 public void mouseExited(MouseEvent e) {
                     imgChipNoFocus(e);
                 }
             
             
             };
        
        
        botao.addMouseListener(chipBotListener);
        Resist1.addMouseListener(chipBotListener);
        Resist2.addMouseListener(chipBotListener);
        Decod1.addMouseListener(chipBotListener);
        Decod2.addMouseListener(chipBotListener);
        Decod3.addMouseListener(chipBotListener);
        Micro1.addMouseListener(chipBotListener);
        Micro2.addMouseListener(chipBotListener);
        Micro3.addMouseListener(chipBotListener);
        Micro4.addMouseListener(chipBotListener);
        
        //Definição dos botões
        editar = new JButton();
        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Button_Cancel.png"))); // NOI18N
        editar.setText("jButton1");
        editar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        editar.setBorderPainted(false);
        editar.setContentAreaFilled(false);
        editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editar.setMaximumSize(new java.awt.Dimension(219, 39));
        editar.setMinimumSize(new java.awt.Dimension(219, 39));
        editar.setPreferredSize(new java.awt.Dimension(219, 39));
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarClicado(evt);
            }
        });
        
        salvar = new JButton(); 
        salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Button_SetChipr.png"))); // NOI18N
        salvar.setText("jButton1");
        salvar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        salvar.setBorderPainted(false);
        salvar.setContentAreaFilled(false);
        salvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salvar.setMaximumSize(new java.awt.Dimension(219, 39));
        salvar.setMinimumSize(new java.awt.Dimension(219, 39));
        salvar.setPreferredSize(new java.awt.Dimension(219, 39));
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarClicado(evt);
            }
        });
 
        
        IniciarJogo = new JButton();
        IniciarJogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Button_StartGame.png"))); // NOI18N
        IniciarJogo.setText("jButton1");
        IniciarJogo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        IniciarJogo.setBorderPainted(false);
        IniciarJogo.setContentAreaFilled(false);
        IniciarJogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IniciarJogo.setMaximumSize(new java.awt.Dimension(219, 39));
        IniciarJogo.setMinimumSize(new java.awt.Dimension(219, 39));
        IniciarJogo.setPreferredSize(new java.awt.Dimension(219, 39));
        IniciarJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarJogoClicado(evt);
            }
        });
        
        //criação tabuleiro
        tabuleiro = new JPanel();
        tabuleiro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        java.awt.Dimension d = new java.awt.Dimension((jogo.getDificuldade().TABSIZE*30)+5, (jogo.getDificuldade().TABSIZE*30)+5);
        tabuleiro.setSize(d);
        java.awt.GridLayout TabLayout = new java.awt.GridLayout(jogo.getDificuldade().TABSIZE,jogo.getDificuldade().TABSIZE);
        tabuleiro.setLayout(TabLayout);
        
        
        java.awt.event.MouseListener blockListener = new java.awt.event.MouseListener() {

                 @Override
                 public void mouseClicked(MouseEvent e) {
                     ButtonClick(e);
                 }

                 @Override
                 public void mousePressed(MouseEvent e) {
                     //do nothing
                 }

                 @Override
                 public void mouseReleased(MouseEvent e) {
                     //do nothing
                 }

                 @Override
                 public void mouseEntered(MouseEvent e) {
                     ButtonFocusGained(e);
                 }

                 @Override
                 public void mouseExited(MouseEvent e) {
                     ButtonFocusLost(e);
                 }
             
             
             } ;
        
        //alternancia de linha
        for (int i = 0; i<jogo.getDificuldade().TABSIZE; i++) {  
         //alterncanci de coluna
         for (int j = 0; j<jogo.getDificuldade().TABSIZE; j++) {
             
             JButton b = casas[i][j] = new Gui_TableBlock(i+1,j+1,30);
             b.addMouseListener(blockListener);
             tabuleiro.add(b);

         }       
     }
        
       //inicialização de componentes
       setSize(tabuleiro.getWidth()+300,tabuleiro.getHeight()+200);
       
       
       
       
       
       
       
       
       
       
        //definição layout painel principal
  javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(PainelPrincipal);
        PainelPrincipal.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(imgBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(X)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TextoInic, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(imgResist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(X2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nResist, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(imgDecod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(X3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nDecod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(imgMicro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(X4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nMicro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    )
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        )
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(IniciarJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 382, Short.MAX_VALUE)
                        .addComponent(tabuleiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextoInic, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(imgBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(X, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imgResist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(X2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nResist, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imgDecod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(X3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nDecod, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imgMicro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(X4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nMicro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(tabuleiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IniciarJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37))
        );
        
        setResizable(false);
        setVisible(true);
        javax.swing.GroupLayout SetPosition_EasyLayout = new javax.swing.GroupLayout(getContentPane());
        setResizable(false);
        setContentPane(PainelPrincipal);
        updateButtons();
    }
    
    
    
    //METODOS DE CONTROLE E ATUALIZAÇÃO
    
    
   
    
   //
   private JPanel GetPainelChip (int tipo) {
       JPanel painel;
       switch (tipo) {
           case 1: painel = imgBotao; break;
           case 2: painel = imgResist; break;
           case 3: painel = imgDecod; break;
           case 4: painel = imgMicro; break;
           default: painel = new JPanel();    
               
       }
   return painel;
   }
   
   private void setChipRest (int tipo,int val) {
 
       switch (tipo) {
           case 1: nButtonRest = val; break;
           case 2: nResistRest = val; break;
           case 3: nDecodRest = val; break;
           case 4: nMicroRest = val; break;
           
               
       }
  
   }
   
   
   //atualiza o Grid de Blocos
   private void UpdateTableFocus(int x, int y) {
      
        
        System.out.println(" " + x + " " + y);
        for (int i = 0; i<=Dificuldade.TABSIZE; i++) {
         
         
         
             if (OrientationSet==1) {
                 y = i;
             } else x = i;
                 
             if (tabAux.VerificarBloco(x,y)!=null) {
             if (tabAux.VerificarBloco(x,y).getChipPiece()!=null) {
                 ChipPiece chip = tabAux.VerificarBloco(x,y).getChipPiece();
                 casas[x-1][y-1].setIconChip(chip.getTipo(),chip.getOrient(),chip.getpedaço());
             } else {
                 casas[x-1][y-1].setIconChip(0,0,0);
             }
             
             }
             
             
            
        }
    
    }
   
   //atualiza as imagesn de chip (seleção de chip) 
   private void updateImgChips() {
       
       //atualizar os paineis
       for (int i =1; i<=4 ; i++) {
           JPanel painel = GetPainelChip (i);
           //se o numero for o chip setado
           if (i==TipoChipSet) {
               painel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 3));
           } else painel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
           
       } 
      
       
   } 
  
   //atualiza o numero de chips restantes na tela
   private void updateNumChipPanels() {
        nButtons.setText(""+ nButtonRest);
        nResist.setText(""+ nResistRest);
        nDecod.setText(""+ nDecodRest);
        nMicro.setText(""+ nMicroRest);
   }
   
   //atualiza o numero de chips restantes
   private void updateNums() {
        nButtonRest = Dificuldade.N_CHIP1 - tabAux.getNichipsTipo(1);
        nResistRest = Dificuldade.N_CHIP2 - tabAux.getNichipsTipo(2);
        nDecodRest = Dificuldade.N_CHIP3 - tabAux.getNichipsTipo(3);
        nMicroRest = Dificuldade.N_CHIP4 - tabAux.getNichipsTipo(4);
        
        
   }
   
   //atualiza os botões de ação
   private void updateButtons() {
       
       Table tabjog = jogo.GetPlayer(1).getTable();
       
       if ((nButtonRest+nResistRest+nDecodRest+nMicroRest==0)&&(tabjog.getNChips()!=Dificuldade.N_CHIPS)) {
           salvar.setEnabled(true);
       } else salvar.setEnabled(false);
       
       if (tabjog.getNChips()==Dificuldade.N_CHIPS) {
           IniciarJogo.setEnabled(true);
       } else IniciarJogo.setEnabled(false);
       
       if (tabjog.getNChips()==Dificuldade.N_CHIPS) {
           editar.setEnabled(true);
       } else editar.setEnabled(false);
       
       
   }
   
   //disableTable
   private void TableEnabled(boolean enabled) {
       for (int i = 0; i<jogo.getDificuldade().TABSIZE; i++) {  
         //alterncanci de coluna
         for (int j = 0; j<jogo.getDificuldade().TABSIZE; j++) {
             
             JButton b = casas[i][j];
             b.setEnabled(enabled);
   
         }
       }
   }
   
   
   
   
   
   //METODOS DE RESPOSTA A EVENTOS
   
    
    //é acionado quando detecta o click do botão no bloco
    private void ButtonClick (java.awt.event.MouseEvent evt) {
        
        //recebe o botão que acionou o evento
        Gui_TableBlock block = (Gui_TableBlock) evt.getSource();
        
        //recebe o bloco da mesma posição
        Block bloco = tabAux.VerificarBloco(block.getPosition(1), block.getPosition(2));
      
        //clicou com o lado Esquerdo
        if((evt.getModifiers() & java.awt.event.MouseEvent.BUTTON1_MASK) != 0) {
         
             
         //verificar se tem um chip no local
        if (bloco.getChipPiece()!=null) {
            
            //verifica se o chip não foi o que eu acabei de colocar
            if (bloco.getChipPiece().getChip()!=ChipTemp) {
            //pega o tipo do chip e seta para o tipo selecionado
            TipoChipSet = bloco.getChipPiece().getTipo();
            OrientationSet = bloco.getChipPiece().getOrient();
            //cadastra o chip como temporario;
            ChipTemp = bloco.getChipPiece().getChip();
            
            setChipRest ( TipoChipSet, (Dificuldade.getNchipsTipo(TipoChipSet)-tabAux.getNichipsTipo(TipoChipSet))+1 );
            updateNumChipPanels();
            //atualiza a linha
            UpdateTableFocus(block.getPosition(1),block.getPosition(2));
             updateImgChips();
            
             
             tabAux.imprimeStatus();
         
            
        } else  {
                ChipTemp=null;
                updateNums ();
                updateNumChipPanels();
                
            }
            
            
         } 
        
            
        } //clicou com o lado direito
          else if((evt.getModifiers() & java.awt.event.MouseEvent.BUTTON3_MASK) != 0) {
              
          ChipPiece c = tabAux.VerificarBloco(block.getPosition(1), block.getPosition(2)).getChipPiece();
              //se tiver algum chip na casa
          if (c!=null) {
               
                //se o chip for temporario
                if (c.getChip()==ChipTemp) {
              
        
                //remove o chip
               
            
                 
                  tabAux.RemoveChip(block.getPosition(1), block.getPosition(2));
                  UpdateTableFocus(block.getPosition(1),block.getPosition(2));
                  
                  
                  //troca a orientação
                  if (OrientationSet == 1)
                  OrientationSet = 2;
                  else OrientationSet = 1;
                  
                  //adiciona novo chip se tiver espaço
                  if (tabAux.espacosVazios(block.getPosition(1), block.getPosition(2), OrientationSet , TipoChipSet)) {
                  tabAux.InserirChip( OrientationSet ,block.getPosition(1), block.getPosition(2), TipoChipSet );
                  ChipTemp = tabAux.VerificarBloco(block.getPosition(1), block.getPosition(2)).getChipPiece().getChip();
                  UpdateTableFocus(block.getPosition(1),block.getPosition(2));
                  tabAux.imprimeStatus();
         }
                  
        
               }
              
              
              
          
              
              
              
              
          }
          }
        
         
         
        
  
       
            updateButtons();
        
        
        
    }
    
    //é acionado quando um bloco ganha foco
    private void ButtonFocusGained (java.awt.event.MouseEvent evt) {
        
         Gui_TableBlock block = (Gui_TableBlock) evt.getSource();
         
         
         //verifica se nenhum chip esta setado
         if (TipoChipSet>0&TipoChipSet<=4) {
         //verifica se o maximo de chip foi atingido
         if (tabAux.getNichipsTipo(TipoChipSet)<jogo.getDificuldade().getNchipsTipo(TipoChipSet)) {
             //verifica se tem espaço disponivel para adicionar o bloco
         if (tabAux.espacosVazios(block.getPosition(1), block.getPosition(2), OrientationSet , TipoChipSet)) {
             tabAux.InserirChip( OrientationSet ,block.getPosition(1), block.getPosition(2), TipoChipSet );
             ChipTemp = tabAux.VerificarBloco(block.getPosition(1), block.getPosition(2)).getChipPiece().getChip();
             UpdateTableFocus(block.getPosition(1),block.getPosition(2));
             tabAux.imprimeStatus();
         }
         }
    }
         
    }
    
    //é acionado quando um bloco perde foco
    private void ButtonFocusLost (java.awt.event.MouseEvent evt) {
        Gui_TableBlock block = (Gui_TableBlock) evt.getSource();
        ChipPiece c = tabAux.VerificarBloco(block.getPosition(1), block.getPosition(2)).getChipPiece();
        
        if (c!=null) {
            
            if (c.getChip()==ChipTemp) {
             tabAux.RemoveChip(block.getPosition(1), block.getPosition(2));
             UpdateTableFocus(block.getPosition(1),block.getPosition(2));
             tabAux.imprimeStatus();
         
            }
        
        }
         
    }

    
    private void imgChipClicado(java.awt.event.MouseEvent evt) {
       Gui_TableBlock block = (Gui_TableBlock) evt.getSource();
       JPanel painel = GetPainelChip (block.getPosition(1));
       if (TipoChipSet!=block.getPosition(1)) {
       TipoChipSet = block.getPosition(1);
       } else TipoChipSet = 0;
       updateImgChips();
       
       
   }
   
    
   private void imgChipFocus(java.awt.event.MouseEvent evt) {
       Gui_TableBlock block = (Gui_TableBlock) evt.getSource();
       if (TipoChipSet!=block.getPosition(1)) {
       GetPainelChip (block.getPosition(1)).setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
       }
   }
   
   
   private void imgChipNoFocus(java.awt.event.MouseEvent evt) {
       Gui_TableBlock block = (Gui_TableBlock) evt.getSource();
       if (TipoChipSet!=block.getPosition(1)) {
       GetPainelChip (block.getPosition(1)).setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
       }
       
   }


   //é acionado quando o botão editar é clicado
    private void editarClicado (java.awt.event.ActionEvent evt) {
        Table GameTable = jogo.GetPlayer(1).getTable();
        for (int i=0; i<Dificuldade.N_CHIPS; i++ ) {
           Chip ChipMove = tabAux.getChip(i);
           GameTable.RemoveChip(ChipMove.getPiece(0).getPosition(1), 
                   ChipMove.getPiece(0).getPosition(2));
           
           
           
             
     }
        updateButtons();
        TableEnabled(true);
    }
    
     private void salvarClicado (java.awt.event.ActionEvent evt) {
        
         Table GameTable = jogo.GetPlayer(1).getTable();
         
         for (int i=0; i<Dificuldade.N_CHIPS; i++ ) {
           Chip ChipMove = tabAux.getChip(i);
           GameTable.InserirChip(ChipMove.getOrient(), 
                   ChipMove.getPiece(0).getPosition(1), 
                   ChipMove.getPiece(0).getPosition(2),
                   ChipMove.getTipo());
           
           
           
           
            
             
     }
         
         updateButtons();
         
       TableEnabled(false);  
         
    }
     
      
    private void iniciarJogoClicado (java.awt.event.ActionEvent evt) {
        
        jogo.CPUPosicionarChips();
        jogo.IiciarJogo();
        setVisible(false);
        
    }
    
}
