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
    private int n_pecas;
    private Player Jogador;
    public static final int FÁCIL = 8;  
    public static final int MÉDIO = 10;  
    public static final int DIFÍCIL = 15;
    public static final int VERTICAL = 2;
    public static final int HORIZONTAL= 1;
    

    public Table (int dificuldade,Player jogador) {
        //cria o tabuleiro com o tamanho de acordo com a dificuldade
        Casas = new ChipPiece[dificuldade][dificuldade];
        this.dificuldade = dificuldade;
        this.Jogador = Jogador;
        n_pecas = 0;
    }
    
    public ChipPiece VerificarCasa(int x, int y) {
        ChipPiece chip = null;
        
        if (((0<x)&(x<=this.dificuldade))&((0<y)&(y<=this.dificuldade))) //veirifca se o x e o y esta dentro do tamanho do tabuleiro
        {
            chip = Casas[x][y];
        } 
        else 
        {
            System.out.println("ERRO, fora do tabuleiro");
        }
        
        
        
        return chip;
    }
    
    public void InserirChip(int orientacao, int x, int y,int tipo) {
        if (((0<x)&(x<=this.dificuldade))&((0<y)&(y<=this.dificuldade)))
        {
            switch (orientacao) 
            {
                case 1 :
                    if (espacosVazios(x,y,orientacao,tipo)) {
                        n_pecas ++;
                        int j = 0;
                        for (int i = y; i<=(y+(tipo-1)); i++) {
                            j++;
                            ChipPiece newchip = new ChipPiece(n_pecas,tipo,j);
                            Casas[(x-1)][(i-1)] = newchip;
                        }
                    }
                    else
                    {
                        System.out.println("erro: casas ocupadas ou sem espaço suficiente");
                    }
                    break;
                case 2 :
                    if (espacosVazios(x,y,orientacao,tipo)) {
                        n_pecas ++;
                        int j = 0;
                        for (int i = x; i<=(x+(tipo-1)); i++) {
                            j++;
                            ChipPiece newchip = new ChipPiece(n_pecas,tipo,j);
                            Casas[(i-1)][(y-1)] = newchip;
                        }
                    }
                    else
                    {
                        System.out.println("erro: casas ocupadas ou sem espaço suficiente");
                    }
                    break;
                default : 
                    System.out.println("erro: ORIENTAÇÃO DESCONHECIDA");
                    break;
                    
                
            }
            
            
        }
        else 
        {
            System.out.println("ERRO, fora do tabuleiro");
        }
        
    }
    
    
    //função que recebe posição e orientaçãoe e verifica se existe espaço vazio para a peça
    public boolean espacosVazios(int x, int y, int orientacao, int NdeCasas) {
        boolean result = true;
        
        switch (orientacao) 
            {
                case 1 :
                    if (((y+(NdeCasas-1))>this.dificuldade)) 
                    {
                        result = false;
                        System.out.println("Erro - sem espaço");
                    }
                    else
                    {
                    for (int i = y; i<=(y+(NdeCasas-1)); i++) {
                        if (Casas[(x-1)][(i-1)]!=null) {
                            result = false;
                            break;
                        }
                    }
                    }
                    break;
                case 2 :
                    if (((x+(NdeCasas-1))>this.dificuldade)) 
                    {
                        result = false;
                        System.out.println("Erro - sem espaço");
                    }
                    else
                    {
                    for (int i = x; i<=(x+(NdeCasas-1)); i++) {
                        if (Casas[(i-1)][(y-1)]!=null) {
                            result = false;
                            break;
                        }
                    }
                    }
                    break;
                default : 
                    System.out.println("erro: ORIENTAÇÃO DESCONHECIDA");
                    break;
                    
                
            }
        
        return result;
    }
    
    
    
    //MÉTODO DE TESTE
    
    public void imprimeStatus() {
        for (int i=0; i<dificuldade; i++) {
            for (int j=0; j<dificuldade; j++) {
                System.out.print(" | ");
                if (Casas[i][j]!=null) {
                    System.out.print(Casas[i][j].getIdent());
                } else System.out.print(" ");
                System.out.print(" | ");
        }
            System.out.println("");
        }
    }
    
}
