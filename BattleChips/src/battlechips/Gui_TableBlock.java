/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlechips;

import javax.swing.ImageIcon;
import java.awt.Image;

/**
 *
 * @author berto
 */
public class Gui_TableBlock extends javax.swing.JButton {
    
    private int position[] = new int[2];
    private int Size;
    private int orient;
    
    
    //variaveis imageIcon para os icones das casas de acordo com o chip e a orientação
    private ImageIcon Icons[][] = new ImageIcon[9][5];
    
    
    
    
    
    
    
    public Gui_TableBlock(int x, int y, int size) {
        position[0] = x;
        position[1] = y;
        Size = size;
        
        initComponent();
    }
    
    public int getPosition (int pos) {
        if (pos == 1 ) return position[0];
        else if (pos == 2 ) return position[1];
        else return 0;
    }
    
    
    public void initComponent() {
        
        
        //inicia as imagens de icone
        Icons[0][0] = new javax.swing.ImageIcon(getClass().getResource("/resources/Default_BackgroundTile_final.png"));
        Icons[1][1] = new javax.swing.ImageIcon(getClass().getResource("/resources/Chip_button_final.png"));
        Icons[2][1] = new javax.swing.ImageIcon(getClass().getResource("/resources/Chip_Resistor_1_final.png"));
        Icons[2][2] = new javax.swing.ImageIcon(getClass().getResource("/resources/Chip_Resistor_2_final.png"));
        Icons[3][1] = new javax.swing.ImageIcon(getClass().getResource("/resources/Chip_Decoder_1_final.png"));
        Icons[3][2] = new javax.swing.ImageIcon(getClass().getResource("/resources/Chip_Decoder_2_final.png"));
        Icons[3][3] = new javax.swing.ImageIcon(getClass().getResource("/resources/Chip_Decoder_3_final.png"));
        Icons[4][1] = new javax.swing.ImageIcon(getClass().getResource("/resources/Chip_Microcontroller_1_final.png"));
        Icons[4][2] = new javax.swing.ImageIcon(getClass().getResource("/resources/Chip_Microcontroller_2_final.png"));
        Icons[4][3] = new javax.swing.ImageIcon(getClass().getResource("/resources/Chip_Microcontroller_3_final.png"));
        Icons[4][4] = new javax.swing.ImageIcon(getClass().getResource("/resources/Chip_Microcontroller_4_final.png"));
        Icons[5][1] = new javax.swing.ImageIcon(getClass().getResource("/resources/Chip_button_final.png"));
        Icons[6][1] = new javax.swing.ImageIcon(getClass().getResource("/resources/Chip_Resistor_1_Vert_final.png"));
        Icons[6][2] = new javax.swing.ImageIcon(getClass().getResource("/resources/Chip_Resistor_2_Vert_final.png"));
        Icons[7][1] = new javax.swing.ImageIcon(getClass().getResource("/resources/Chip_Decoder_1_Vert_final.png"));
        Icons[7][2] = new javax.swing.ImageIcon(getClass().getResource("/resources/Chip_Decoder_2_Vert_final.png"));
        Icons[7][3] = new javax.swing.ImageIcon(getClass().getResource("/resources/Chip_Decoder_3_Vert_final.png"));
        Icons[8][1] = new javax.swing.ImageIcon(getClass().getResource("/resources/Chip_Microcontroller_1_Vert_final.png"));
        Icons[8][2] = new javax.swing.ImageIcon(getClass().getResource("/resources/Chip_Microcontroller_2_Vert_final.png"));
        Icons[8][3] = new javax.swing.ImageIcon(getClass().getResource("/resources/Chip_Microcontroller_3_Vert_final.png"));
        Icons[8][4] = new javax.swing.ImageIcon(getClass().getResource("/resources/Chip_Microcontroller_4_Vert_final.png"));
        
        
        
        java.awt.Dimension Bsize = new java.awt.Dimension(Size, Size);
        setSize(Bsize);
        setMaximumSize(Bsize);
        setMinimumSize(Bsize);
        setPreferredSize(Bsize);
        setFocusable(false);
        
        
        
         
        setIcon(reSize(Icons[0][0]));
        
    }
    
    
    public void setIconChip(int tipo, int orient, int Piece) {
        if (orient == 2) tipo = tipo+4;
        setIcon(reSize(Icons[tipo][Piece]));
    }
    
    
    private ImageIcon reSize(ImageIcon img) {
        
        img.setImage(img.getImage().getScaledInstance(Size, Size, Image.SCALE_DEFAULT));
       
        return img;
    }
    
    
    
}
