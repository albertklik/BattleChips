/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlechips;
import java.util.Scanner;
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
        Dificuldade d = new Facil();
        
                Game_controler g = new Game_controler(d);
        g.IiciarJogo();
        
        
        Player p = g.GetPlayer(1);
        
        for (int i =1; i<=4; i++) {
            
        
        while (!(p.getTable().getNichipsTipo(i)>=d.getNchipsTipo(i))) {
            g.setChipPlayer(1,p.getTable().getRandomPosition(), p.getTable().getRandomPosition(), 
                    p.getTable().getRandomOrientation(), i);
        }
        
        }
        
       
        
        
        g.IiciarJogo();
      
        
         p = g.GetPlayer(2);
         for (int i =1; i<=4; i++) {
            
        
        while (!(p.getTable().getNichipsTipo(i)>=d.getNchipsTipo(i))) {
            g.setChipPlayer(2,p.getTable().getRandomPosition(), p.getTable().getRandomPosition(), 
                    p.getTable().getRandomOrientation(), i);
        }
        
        }
        
        
        
        
        g.IiciarJogo();
        
    
        g.GetPlayer(2).getTable().imprimeStatus();
        
        Scanner s = new Scanner(System.in);
        int x,y;
        while (!g.ChecarFimDeJogo()) {
            System.out.println("informe um valor para x e y");
            int a = s.nextInt();
            int b = s.nextInt();
            g.PlayerShoot(a, b);
            
            g.CpuShoot();
            
            g.GetPlayer(2).getTable().imprimeStatus();
            g.GetPlayer(1).getTable().imprimeStatus();
        }
        
    }
    
}
