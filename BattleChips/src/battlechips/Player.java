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
public class Player {
    
    private String nome;
    private int pontos;
    
    private Table TabJogador; //tabuleiro do jogador
    
    private Dificuldade dificuldade;
    private int acertos;
    
    
    
    
    public Player (String nome,Dificuldade dificuldade) {
        this.nome = nome;
        TabJogador = new Table(dificuldade);
    }
    
    /*
    //jogador faz um tiro no tabuleiro do adversario
    public MakeShoot (int x,int y) {
        
    }*/


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
