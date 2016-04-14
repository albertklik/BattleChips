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
    
    private int dificuldade;
    private int acertos;
    
    
    public Player (String nome,int dificuldade) {
        this.nome = nome;
        TabJogador = new Table(dificuldade);
    }
    
    //pegar o tabuleiro do jogador (ele da pra todos, é publico)
    public Table getTable() {
        return this.TabJogador;
    }
    
    
}
