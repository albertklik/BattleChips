/*
 * CLASSE CPU
 * EXTENDE A CLASSE PLAYER
 * JOGADOR COM INTELIGENCIA ARTIFICIAL
 */
package battlechips;

import java.util.Random;


public class CPU extends Player 
{
int dificuldade;
    public CPU(String nome, int dificuldade) 
    {
        super(nome, dificuldade);
        this.dificuldade = dificuldade;
    }
    
    Table tabuleiro = new Table(dificuldade);
    Random rand = new Random();
 
    //Vai atirar aleatoriamente no tabuleiro
    boolean hunt()
    {
       tabuleiro.Shoot(rand.nextInt(dificuldade), rand.nextInt(dificuldade));
        
    //Return true se acertar; false se errar.    
    }
}
