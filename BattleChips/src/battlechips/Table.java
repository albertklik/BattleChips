/*
 * 
 */
package battlechips;

/**
 *
 * @author paulo
 */
public class Table {
    
    private final ChipPiece [][]Casas;
    private final Chip []Chips;
    private final int dificuldade;
    private int n_chips;
    private Player Jogador;
    
    
    public static final int FÁCIL = 8;  
    public static final int MÉDIO = 10;  
    public static final int DIFÍCIL = 15;
    
    public static final int VERTICAL = 2;
    public static final int HORIZONTAL= 1;
    
    //MÉTODO CONSTRUTOR
    public Table (int dificuldade,Player jogador) {
        //cria o tabuleiro com o tamanho de acordo com a dificuldade
        Casas = new ChipPiece[dificuldade][dificuldade];
        Chips = new Chip[50];
        this.dificuldade = dificuldade;
        this.Jogador = jogador;                   //jogado associado ao tabuleiro
        n_chips = 0;
    }
    
    
    //Verifica a casa e retorna um pedaço de Chip
    public ChipPiece VerificarCasa(int x, int y) {
        ChipPiece chip = null;
        
        if (((0<x)&(x<=this.dificuldade))&((0<y)&(y<=this.dificuldade))) //veirifca se o x e o y esta dentro do tamanho do tabuleiro
        {
            chip = Casas[(x-1)][(y-1)];
        } 
        else 
        {
            System.out.println("ERRO, fora do tabuleiro");
        }
        
        return chip;
    }
    
    
    //insere um chipPiece no tabuleiro
    public void InserirChip(int orientacao, int x, int y,int tipo) {
        if (((0<x)&(x<=this.dificuldade))&((0<y)&(y<=this.dificuldade)))
        {
            switch (orientacao) 
            {
                case 1 :
                    if (espacosVazios(x,y,orientacao,tipo)) {
                        n_chips ++;
                        int j = 0;
                        Chip chip = new Chip(tipo,n_chips);
                        Chips[n_chips-1] = chip;
                        for (int i = y; i<=(y+(tipo-1)); i++) {
                            j++;
                            ChipPiece newchip = new ChipPiece(chip,j);
                            chip.addPiece(newchip, newchip.getpedaço());
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
                        n_chips ++;
                        int j = 0;
                        Chip chip = new Chip(tipo,n_chips);
                        Chips[n_chips-1] = chip;
                        for (int i = x; i<=(x+(tipo-1)); i++) {
                            j++;
                            ChipPiece newchip = new ChipPiece(chip,j);
                            chip.addPiece(newchip, newchip.getpedaço());
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
                        for (int i = y; i<=(y+(NdeCasas-1)); i++) 
                        {
                            if (Casas[(x-1)][(i-1)]!=null) 
                            {
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
                        for (int i = x; i<=(x+(NdeCasas-1)); i++) 
                        {
                            if (Casas[(i-1)][(y-1)]!=null) 
                            {
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
    
    
    
    //méotodo retorna o numero de peças quebradas
    public int chipsCrashed() {
        int soma = 0;
        for (int i = 0; i<n_chips; i++) {
            if (Chips[i].checkCrached()) {
                soma++;
            }
        }
        return soma;
    }
    
 
    
    //MÉTODO DE TESTE
    //imprime no console informações sobre o status do tabuleiro
    public void imprimeStatus() {
        System.out.println("----------------------TABULEIRO-----------------------");
        for (int i=0; i<dificuldade; i++) {
            for (int j=0; j<dificuldade; j++) {
                System.out.print("[");
                if (Casas[i][j]!=null) {
                    if (Casas[i][j].Iscrashed()) 
                    {
                        System.out.print("*");
                    } else System.out.print(Casas[i][j].getIdent());
                } else System.out.print(" ");
                System.out.print("]");
        }
            System.out.println("");
        }
        System.out.println("------------------------------------------------------");
        System.out.println("");
        System.out.println("Numero de peças Adicionadas: " + n_chips);
        System.out.println("Numero de peças quebradas: " + chipsCrashed());
        for (int i = 0; i<n_chips; i++) {
            System.out.print("Chip [" + (i+1) + "] ");
            System.out.print ("  Tipo: ");
            switch (Chips[i].getTipo()) {
                case 1: 
                    System.out.print("Botão           ");
                    break;
                case 2:
                    System.out.print("Resistor        ");
                    break;
                case 3:
                    System.out.print("Decodificador   ");
                    break; 
                case 4:
                    System.out.print("Microprocessador");
                    break;
            
            }
            
            System.out.print(" Status:");
            
            if (Chips[i].checkCrached()) {
                System.out.println("Quebrado");
            } 
            else
            {
                System.out.println(" " + Chips[i].NumCrashed() + " Peças quebradas.");
            }
        }
    }
  
}
