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
public class Table_test {
    Table t;
    Scanner s = new Scanner(System.in);
    
    
    public Table_test(int dificuldade) {
     t = new Table(dificuldade,new Player());
     
    }
    
    public void prepararJogo() {
        
        for (int i=1; i<=4; i++) {
            int x=1,y=1;
            switch (i) {
                case 1 :
                    while (t.VerificarBloco(x, y).getChipPiece()==null) {
                        x = t.getRandomPosition();
                        y = t.getRandomPosition();
                        t.InserirChip(t.getRandomOrientation(), x, y, Chip.BOTAO);
                    }
                    break;
                case 2 :
                    while (t.VerificarBloco(x, y).getChipPiece()==null) {
                        x = t.getRandomPosition();
                        y = t.getRandomPosition();
                        t.InserirChip(t.getRandomOrientation(), x, y, Chip.DECOD);
                    }
                    break;
                case 3 :
                    while (t.VerificarBloco(x, y).getChipPiece()==null) {
                        x = t.getRandomPosition();
                        y = t.getRandomPosition();
                        t.InserirChip(t.getRandomOrientation(), x, y, Chip.MICRO);
                    }
                    break;
                case 4 :
                    while (t.VerificarBloco(x, y).getChipPiece()==null) {
                        x = t.getRandomPosition();
                        y = t.getRandomPosition();
                        t.InserirChip(t.getRandomOrientation(), x, y, Chip.RESIS);
                    }
                    break;
            }
        }
        
    }
    
    public void iniciarJogo() {
        System.out.println("Inicio de Jogo!");
        boolean shoot;
        
        while (t.chipsCrashed()<t.getNChips()) {
            t.imprimeStatus();
            
            shoot = false;
            
            while (shoot==false) {
                
                System.out.println("  ");
            System.out.println("Informe um local para atirar");
            System.out.println("Valor de X: ");
            int x = s.nextInt();
            System.out.println("Valor de y: ");
            int y = s.nextInt();
            Block b = t.VerificarBloco(x, y);
              
            if (b!=null) {
                if (!b.IsShot()) {
                    b.setShot();
                    shoot=true;
                    
                } else System.out.println("O local já foi atirado");
            } else System.out.println("Local Fora do Tabuleiro");
            
            }
        }
        
        System.out.println("Fim de jogo!");
        t.imprimeStatus();
    }
}
