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
        Dificuldade d = new Normal();
        
                Game_controler g = new Game_controler(d);
        g.IiciarJogo();
        g.GetPlayer(1).getTable().imprimeStatus();
        g.GetPlayer(2).getTable().imprimeStatus();
        
        Player p = g.GetPlayer(1);
        while (!p.ChipsProntos()) {
            g.setChipPlayer(p.getTable().getRandomPosition(), p.getTable().getRandomPosition(), 
                    p.getTable().getRandomOrientation(), 4);
        }
        
        
        g.GetPlayer(1).getTable().imprimeStatus();
        g.GetPlayer(2).getTable().imprimeStatus();
            
        
    }
    
}
