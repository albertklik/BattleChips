/*
 * 
 */
package battlechips;

/**
 *
 * @author paulo
 */
public class Table {
    
    private ChipPiece [][]Casas;
    private int dificuldade;
    private Player Jogador;
    public final int FÁCIL = 8;  
    public final int MÉDIO = 10;  
    public final int DIFÍCIL = 15;  

    public Table (int dificuldade,Player jogador) {
        //cria o tabuleiro com o tamanho de acordo com a dificuldade
        Casas = new ChipPiece[dificuldade][dificuldade];
        this.dificuldade = dificuldade;
        this.Jogador = Jogador;
    }
    
    public void VerificarCasa() {
        
    }
    
    public void InserirChip() {
        
    }
    
}
