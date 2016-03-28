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
public class Block {
    private ChipPiece Chip;                //chip associado
    boolean Shot;
    private final int []position = new int[2];
    
    public Block(int x, int y) {
        Shot = false;
        position[0] = x;
        position[1] = y;
    }
    
    public int[] getPosition () {
        return position;
    }
    
    
    public void setShot() {
        Shot=true;
        if (Chip!=null){
            Chip.crash();
        }
    }
    
    public boolean IsShot () {
        return Shot;
    }
    
    public void SetChipPiece (ChipPiece Chip) {
        if (this.Chip==null) {
            this.Chip = Chip;
        }
        else { 
            System.out.println("ERRO: chipPiece já adicionado no bloco");
        }
    }
    
    public ChipPiece getChipPiece() {
        return Chip;
    }
    
}
