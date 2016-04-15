/*
 * CLASSE CPU
 * EXTENDE A CLASSE PLAYER
 * JOGADOR COM INTELIGENCIA ARTIFICIAL
 */
package battlechips;

import java.util.Random;


public class CPU extends Player 
{
Dificuldade dificuldade;
    public CPU(String nome, Dificuldade dificuldade) 
    {
        super(nome, dificuldade);
        this.dificuldade = dificuldade;
    }
    
    Table tabuleiro = new Table(dificuldade);
    Random rand = new Random();
 
    //Vai atirar aleatoriamente no tabuleiro
    boolean hunt()
    {
       tabuleiro.Shoot(tabuleiro.getRandomPosition(), tabuleiro.getRandomPosition());
       
    //Return true se acertar; false se errar.    
    }
    
    public void PosicionarChips() {
        
    }
}
