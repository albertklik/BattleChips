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
    
    public ChipPiece (Chip chip, int pedaco) {
        this.Chip = chip;
        this.pedaco = pedaco;
        crashed = false;
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
