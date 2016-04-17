/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*
 *classe que representa um jogador no Jogo
 */
package battlechips;

/**
 *
 * @author paulo
 * 
 *  
 */
public class Player {
    
    private int ID;
    private int pontos;
    
    private Table TabJogador; //tabuleiro do jogador
    
    protected Dificuldade dificuldade;
    private int acertos;
    
    
    
    
    public Player (int ID,Dificuldade dif) {
        this.ID = ID;
        dificuldade = dif;
        TabJogador = new Table(dif);
    }
    
    
    public int getID() {
        return ID;
    }
    
    
    public boolean MakeShoot (int x,int y, Table adTable) {
         
        boolean acerto = adTable.Shoot(x, y);
        
        return acerto;
    }


    //pegar o tabuleiro do jogador (ele da pra todos, é publico)
    public Table getTable() {
        return this.TabJogador;
    }
    
    
    public boolean ChipsProntos() {
        
        if (TabJogador.getNChips()==dificuldade.N_CHIPS) {
            return true;
        } else
            return false;
    }
    
}
