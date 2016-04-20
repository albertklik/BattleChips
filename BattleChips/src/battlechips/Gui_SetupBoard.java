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
    private Gui_TableBlock casas[][];
    private int OrientationSet;
    private int TipoChipSet;
    private JLabel titulo; 
    private Table tabAux; 
    private Dificuldade Dificuldade;
            
            
    public Gui_SetupBoard (Game_controler jogo) {
        
        
        this.jogo = jogo;
        Dificuldade = jogo.getDificuldade();
        casas = new Gui_TableBlock[Dificuldade.TABSIZE][Dificuldade.TABSIZE];
        tabAux = new Table(Dificuldade);
        InitComponents();
    
    }        
    
    
    
    private void InitComponents() {
        
        PainelPrincipal = new JPanel();
        tabuleiro = new JPanel();
        titulo = new JLabel();
        OrientationSet = 1;
        TipoChipSet = 2;
        
        

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
             
             
             JButton b = casas[i][j] = new Gui_TableBlock(i+1,j+1,30);
             
             
             b.addMouseListener(new java.awt.event.MouseListener() {

                 

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
             
             
             tabuleiro.add(b);
             
             
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
    
    
    private void UpdateTableFocus(int x, int y) {
        //alternancia de linha
        
        System.out.println(" " + x + " " + y);
        for (int i = 0; i<=Dificuldade.TABSIZE; i++) {
         
         
         //alterncanci de coluna
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
    
    
    private void ButtonFocusGained (java.awt.event.MouseEvent evt) {
        
         Gui_TableBlock block = (Gui_TableBlock) evt.getSource();
         
         if (tabAux.espacosVazios(block.getPosition(1), block.getPosition(2), OrientationSet , TipoChipSet)) {
             tabAux.InserirChip( OrientationSet ,block.getPosition(1), block.getPosition(2), TipoChipSet );
             UpdateTableFocus(block.getPosition(1),block.getPosition(2));
             tabAux.imprimeStatus();
         }
         
         
    }
    
    private void ButtonFocusLost (java.awt.event.MouseEvent evt) {
        Gui_TableBlock block = (Gui_TableBlock) evt.getSource();
        
        if (tabAux.VerificarBloco(block.getPosition(1), block.getPosition(2))!=null) {
             tabAux.RemoveChip(block.getPosition(1), block.getPosition(2));
             UpdateTableFocus(block.getPosition(1),block.getPosition(2));
             tabAux.imprimeStatus();
         }
         
    }

    
    
}
