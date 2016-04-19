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
    
    //criação do array de paineis;
    private JPanel PainelPrincipal;
    private JPanel tabuleiro;
    private JButton casas[][];
    private JLabel titulo; 
    private Table tabAux; 
            
            
    public Gui_SetupBoard (Game_controler jogo) {
        
        
        this.jogo = jogo;
        casas = new JButton[jogo.getDificuldade().TABSIZE][jogo.getDificuldade().TABSIZE];
        tabAux = new Table(jogo.getDificuldade());
        InitComponents();
    
    }        
    
    
    
    private void InitComponents() {
        
        PainelPrincipal = new JPanel();
        tabuleiro = new JPanel();
        titulo = new JLabel();
        
        
        

        PainelPrincipal.setBackground(new java.awt.Color(59, 174, 14));
        //PainelPrincipal.setSize(new java.awt.Dimension(584, 447));
        

        
        
        
        
        titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/SetUpBoard.png"))); // NOI18N
        

        java.awt.BorderLayout painelLayout = new java.awt.BorderLayout(10,10);
        PainelPrincipal.setLayout(painelLayout);
        PainelPrincipal.add(titulo,BorderLayout.NORTH);
        JPanel painel = new JPanel();
        painel.setLayout(new java.awt.FlowLayout());
        painel.setBackground(new java.awt.Color(59, 174, 14));
                
                
                painel.add(tabuleiro, BorderLayout.CENTER);
                
                
        PainelPrincipal.add(painel,BorderLayout.EAST);
        
        
        
        

        
        
        
        tabuleiro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        java.awt.Dimension d = new java.awt.Dimension((jogo.getDificuldade().TABSIZE*30)+5, (jogo.getDificuldade().TABSIZE*30)+5);
        tabuleiro.setSize(d);
        java.awt.GridLayout TabLayout = new java.awt.GridLayout(jogo.getDificuldade().TABSIZE,jogo.getDificuldade().TABSIZE);
        tabuleiro.setLayout(TabLayout);
        
        
        
        
        //alternancia de linha
        for (int i = 0; i<jogo.getDificuldade().TABSIZE; i++) {
         
         
         //alterncanci de coluna
         for (int j = 0; j<jogo.getDificuldade().TABSIZE; j++) {
             
             
             JButton b = casas[i][j] = new JButton();
             b.setSize(30, 30);
             b.setMaximumSize(new java.awt.Dimension(30, 30));
             b.setMinimumSize(new java.awt.Dimension(30, 30));
             b.setPreferredSize(new java.awt.Dimension(30, 30));
             b.setFocusable(false);
             
             b.setText("button");
             
             casas[i][j].addMouseListener(new java.awt.event.MouseListener() {

                 

                 @Override
                 public void mouseClicked(MouseEvent e) {
                     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 }

                 @Override
                 public void mousePressed(MouseEvent e) {
                     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 }

                 @Override
                 public void mouseReleased(MouseEvent e) {
                     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 }

                 @Override
                 public void mouseEntered(MouseEvent e) {
                     ButtonFocusGained(e);
                 }

                 @Override
                 public void mouseExited(MouseEvent e) {
                     ButtonFocusLost(e);
                 }
             
             
             }
             );
             
             casas[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Default_BackgroundTile.png")));
             tabuleiro.add(casas[i][j]);
             
             
         }
         
         
         
         
     }
       //inicialização de componentes
       setSize(800,tabuleiro.getHeight()+100);
        
        //setResizable(false);
        setVisible(true);
        javax.swing.GroupLayout SetPosition_EasyLayout = new javax.swing.GroupLayout(getContentPane());
        setResizable(false);
       setContentPane(PainelPrincipal);
        
    }
    
    
    
    
    
    private void ButtonFocusGained (java.awt.event.MouseEvent evt) {
         JButton button = (JButton) evt.getSource();
         button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Chip_button.png")));
        
    }
    
    private void ButtonFocusLost (java.awt.event.MouseEvent evt) {
        JButton button = (JButton) evt.getSource();
         button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Default_BackgroundTile.png")));
    }

    
    
}
