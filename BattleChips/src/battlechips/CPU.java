/*
 * CLASSE CPU
 * EXTENDE A CLASSE PLAYER
 * JOGADOR COM INTELIGENCIA ARTIFICIAL
 */
package battlechips;

import java.util.Random;


public class CPU extends Player 
{
    //construtor que construteia
    public CPU(int id, Dificuldade dificuldade) 
    {
        super(id, dificuldade);
        this.tabuleiro = new Table(super.dificuldade);
    }
  
    //variáveis que vareiam
    int x,y,aux;
    Table tabuleiro;
    Table cpuTable = new Table(dificuldade);
    int CPUauxTable[][] = new int[dificuldade.TABSIZE][dificuldade.TABSIZE];
    
    
    public boolean hunt(Table adTable)
    {
        x = tabuleiro.getRandomPosition();
        y = tabuleiro.getRandomPosition();
        boolean acerto = false;
        
        while (CPUauxTable[x][y] ==0 || CPUauxTable[x][y] == 1)
        {
            x = tabuleiro.getRandomPosition();
            y = tabuleiro.getRandomPosition();
        }    
        acerto = adTable.Shoot(x,y);   
        if (acerto == true)
            CPUauxTable[x][y] = 1;
        else
            CPUauxTable[x][y] = 0;
            
    return acerto;
    }
   //tiro no chip = 1; tiro na água = 0;
    public boolean destroy(int posição1,int posição2,Table adTable)
    {
        if(CPUauxTable[x][y+1]==0 && CPUauxTable[x][y-1]==0 && CPUauxTable[x+1][y]==0 && CPUauxTable[x-1][y] == 0)
        {
            
        }
        
        
        
        
        if (CPUauxTable[x][y+1] == 1)
        {
            boolean acerto = adTable.Shoot(x,y-1);
             
            if (acerto == true)
                CPUauxTable[x][y-1] = 1;
            else
                CPUauxTable[x][y-1] = 0;
            
        }
        
        if (CPUauxTable[x][y-1] ==1)
        
        if (CPUauxTable[x+1][y] == 1)
        
        if (CPUauxTable[x-1][y] == 1)
        
        
    }
   
    
   
    
   
    
    public void PosicionarChips() {
        
        //adicionar peças no tabuleiro;
        super.getTable().InserirChip(0, 0, 0, 0);
        
        
    }
}
