/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlechips;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author berto
 */
public class Gui_TableBlock extends javax.swing.JButton {
    
    private int position[] = new int[2];
    private int Size;
    private int orient;
    
    
    
    
    
    
    public Gui_TableBlock(int x, int y, int size) {
        position[0] = x;
        position[1] = y;
        Size = size;
        
        initComponent();
    }
    
    
    public void initComponent() {
        
        java.awt.Dimension Bsize = new java.awt.Dimension(Size, Size);
        setSize(Bsize);
        setMaximumSize(Bsize);
        setMinimumSize(Bsize);
        setPreferredSize(Bsize);
        setFocusable(false);
        
        
         
        setIcon(reSize(resources.r.BlockDefault));
        
    }
    
    
    public void setIconChip(int tipo, int orient) {
       
    }
    
    
    private ImageIcon reSize(ImageIcon img) {
        
        img.setImage(img.getImage().getScaledInstance(Size, Size, Image.SCALE_DEFAULT));
       
        return img;
    }
    
    
    
}
