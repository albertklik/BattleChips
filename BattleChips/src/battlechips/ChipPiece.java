/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlechips;

/**
 *
 * @author paulo
 */
public class ChipPiece {   
    private final Chip Chip;
    private final int pedaco;
    private boolean crashed;
    private final int []position = new int[2]; 
    
    public ChipPiece (Chip chip, int pedaco,int x,int y) {
        this.Chip = chip;
        this.pedaco = pedaco;
        crashed = false;
        position[0] = x;
        position[1] = y;
    }
    
    public int getPosition (int coord) {
        if (coord == 1 ) return position[0];
        else if (coord == 2 ) return position[1];
        else return 0;
    }
    
    public Chip getChip() {
        return Chip;
    }
    
    public int getIdent() {
        return Chip.getIdent();
    }
    
    public int getTipo() {
        return Chip.getTipo();
    }
    
    public int getpedaço() {
        return pedaco;
    }
    
    public void crash() {
        crashed = true;
    }
    
    public boolean Iscrashed () {
        return crashed;
    }
    
    
}
