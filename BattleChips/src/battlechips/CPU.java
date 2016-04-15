/*
 * CLASSE CPU
 * EXTENDE A CLASSE PLAYER
 * JOGADOR COM INTELIGENCIA ARTIFICIAL
 */
package battlechips;

import java.util.Random;


public class CPU extends Player 
{


    public CPU(int id, Dificuldade dificuldade) 
    {
        super(id, dificuldade);
    }
    
    Table tabuleiro = new Table(super.dificuldade);
    
 
    public boolean hunt(Table adTable)
    {
       boolean acerto = adTable.Shoot(tabuleiro.getRandomPosition(), tabuleiro.getRandomPosition());
       return acerto;
    //Return true se acertar; false se errar.    
    }
    
    public void PosicionarChips() {
        
        //adicionar peças no tabuleiro;
        super.getTable().InserirChip(0, 0, 0, 0);
        
        
    }
}
