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
    
    
    public ImageIcon Icons[][] = new ImageIcon[5][2]; 
    
    
    
    
    
    
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
        Icons[0][0] = Icons[0][1] = new javax.swing.ImageIcon(getClass().getResource("/resources/Default_BackgroundTile_final.png"));
        Icons[1][0] = new javax.swing.ImageIcon(getClass().getResource("/resources/Default_BackgroundTile_final.png"));
        Icons[1][1] = new javax.swing.ImageIcon(getClass().getResource("/resources/Default_BackgroundTile_final.png"));
        Icons[2][0] = new javax.swing.ImageIcon(getClass().getResource("/resources/Default_BackgroundTile_final.png"));
        Icons[1][0] = new javax.swing.ImageIcon(getClass().getResource("/resources/Default_BackgroundTile_final.png"));
        
        
        
        java.awt.Dimension Bsize = new java.awt.Dimension(Size, Size);
        setSize(Bsize);
        setMaximumSize(Bsize);
        setMinimumSize(Bsize);
        setPreferredSize(Bsize);
        setFocusable(false);
        
        
         
        setIcon(reSize(BlockDefault));
        
    }
    
    
    public void setIconChip(int tipo, int orient) {
        if (tipo == )
       
    }
    
    
    private ImageIcon reSize(ImageIcon img) {
        
        img.setImage(img.getImage().getScaledInstance(Size, Size, Image.SCALE_DEFAULT));
       
        return img;
    }
    
    
    
}
