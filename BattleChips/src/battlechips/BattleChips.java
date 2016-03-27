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
public class BattleChips {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Table t= new Table (Table.DIFÍCIL,new Player());
        t.imprimeStatus();
        System.out.println("");
        t.InserirChip(Table.VERTICAL, 9, 9, Chip.BOTAO);
        t.InserirChip(Table.VERTICAL, 1, 1, Chip.MICRO);
        t.InserirChip(Table.VERTICAL, 6, 6, Chip.RESIS);
        t.InserirChip(Table.HORIZONTAL, 3, 3, Chip.DECOD);
        t.InserirChip(Table.HORIZONTAL, 5, 1, Chip.MICRO);
        ChipPiece chip = t.VerificarCasa(3, 3);
        t.imprimeStatus();
        System.out.println("");
        chip.crash();
        t.imprimeStatus();
        
       
    }
    
}
