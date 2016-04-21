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
    private JLabel nButtons;
    private JLabel nResist;
    private JLabel nDecod;
    private JLabel nMicro;
    private JPanel imgBotao;
    private JPanel imgResist;
    private JPanel imgDecod;
    private JPanel imgMicro;
    
            
    //CONSTRUTOR        
    public Gui_SetupBoard (Game_controler jogo) {
        
        
        this.jogo = jogo;
        OrientationSet = 1;
        TipoChipSet = 3;
        Dificuldade = jogo.getDificuldade();
        casas = new Gui_TableBlock[Dificuldade.TABSIZE][Dificuldade.TABSIZE];
        tabAux = new Table(Dificuldade);
        InitComponents();
    
    }        
    
    
    //inicia o componente
    private void InitComponents() {
        
        
        
        
        
        
        //painel principal criação
        PainelPrincipal = new JPanel();
        PainelPrincipal.setBackground(new java.awt.Color(59, 174, 14));
        //PainelPrincipal.setSize(new java.awt.Dimension(584, 447));
        
        
        
        //titulo criação
        titulo = new JLabel();
        titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/SetUpBoard.png"))); // NOI18N
        

        
        //criação tabuleiro
        tabuleiro = new JPanel();
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
             
             
             }
             );
             
             
             tabuleiro.add(b);
             
             
         }
         
         
         
         
     }
       //inicialização de componentes
       setSize(800,tabuleiro.getHeight()+100);
       
       
        //definição layout painel principal
        java.awt.BorderLayout painelLayout = new java.awt.BorderLayout(10,10);
        PainelPrincipal.setLayout(painelLayout);
        PainelPrincipal.add(titulo,BorderLayout.NORTH);
        JPanel painel = new JPanel();
        painel.setLayout(new java.awt.FlowLayout());
        painel.setBackground(new java.awt.Color(59, 174, 14));
        painel.add(tabuleiro, BorderLayout.CENTER);      
        PainelPrincipal.add(painel,BorderLayout.EAST);
        
        //setResizable(false);
        setVisible(true);
        javax.swing.GroupLayout SetPosition_EasyLayout = new javax.swing.GroupLayout(getContentPane());
        setResizable(false);
        setContentPane(PainelPrincipal);
        
    }
    
    
    //atualiza o Grid de Blocos
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
    
    //é acionado quando detecta o click do botão no bloco
    private void ButtonClick (java.awt.event.MouseEvent evt) {
        
        //recebe o botão que acionou o evento
        Gui_TableBlock block = (Gui_TableBlock) evt.getSource();
        
        //recebe o bloco da mesma posição
        Block bloco = tabAux.VerificarBloco(block.getPosition(1), block.getPosition(2));
        
         
      
        //verificar se tem um chip no local
         
         //verifica se o chip não foi o que eu acabei de colocar
         
         
        if (bloco.getChipPiece()!=null) {
            if (bloco.getChipPiece().getChip()!=ChipTemp) {
            //pega o tipo do chip e seta para o tipo selecionado
            TipoChipSet = bloco.getChipPiece().getTipo();
            OrientationSet = bloco.getChipPiece().getOrient();
            //cadastra o chip como temporario;
            ChipTemp = bloco.getChipPiece().getChip();
            //atualiza a linha
            UpdateTableFocus(block.getPosition(1),block.getPosition(2));
             
            
             
             tabAux.imprimeStatus();
         
            
        } else  ChipTemp=null;
         } 
        
        
       
        
       
            
        
        
        
    }
    
    private void ButtonFocusGained (java.awt.event.MouseEvent evt) {
        
         Gui_TableBlock block = (Gui_TableBlock) evt.getSource();
         
         
         
         //verifica se o maximo de chip foi atingido
         
         if (tabAux.espacosVazios(block.getPosition(1), block.getPosition(2), OrientationSet , TipoChipSet)) {
             tabAux.InserirChip( OrientationSet ,block.getPosition(1), block.getPosition(2), TipoChipSet );
             ChipTemp = tabAux.VerificarBloco(block.getPosition(1), block.getPosition(2)).getChipPiece().getChip();
             UpdateTableFocus(block.getPosition(1),block.getPosition(2));
             tabAux.imprimeStatus();
         }
         
         
    }
    
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

    
    
}
