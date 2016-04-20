/*
 * 
 */
package battlechips;

/**
 *
 * @author paulo
 */
public class Table {
    
    private final Block [][]Casas;
    private final Chip []Chips;
    private final Dificuldade dificuldade;
    private int n_chips;
    private Player Jogador;
    
    
    public static final int VERTICAL = 2;
    public static final int HORIZONTAL = 1;
    
    //MÉTODO CONSTRUTOR
    public Table (Dificuldade dif) {
        dificuldade = dif;
        //cria o tabuleiro com o tamanho de acordo com a dificuldade
        Casas = new Block[dificuldade.TABSIZE][dificuldade.TABSIZE];
        
        //preencher a matriz com objetos blocs
        for (int i=1; i<=dificuldade.TABSIZE; i++) {
            for (int j=1; j<=dificuldade.TABSIZE; j++) {
                Casas[(i-1)][(j-1)] = new Block(i,j);
            }
        }
        
        
        //cria a array de chips de acordo com o numero de chips permitido pelo nivel de dificuldade
        Chips = new Chip[dificuldade.N_CHIPS];
        
        //inicia o número de Chips para 0;
        n_chips = 0;
    }
    
    
    //Verifica a casa e retorna um Bloco
    public Block VerificarBloco(int x, int y) {
        Block B = null;
        if (((0<x)&(x<=this.dificuldade.TABSIZE))&((0<y)&(y<=this.dificuldade.TABSIZE))) //veirifca se o x e o y esta dentro do tamanho do tabuleiro
        {
            B = Casas[(x-1)][(y-1)];
        } 
        else 
        {
            System.out.println("ERRO, Bloco fora do tabuleiro");
        }
        
        return B;
    }
    
    
    //insere um chipPiece no tabuleiro
    public void InserirChip(int orientacao, int x, int y,int tipo) {
        switch (orientacao) 
            {
                case 1 :
                    if (espacosVazios(x,y,orientacao,tipo)) {
                        n_chips ++;
                        int j = 0;
                        Chip chip = new Chip(orientacao,tipo,n_chips);
                        Chips[n_chips-1] = chip;
                        for (int i = y; i<=(y+(tipo-1)); i++) {
                            j++;
                            ChipPiece newchip = new ChipPiece(chip,j,x,i);
                            chip.addPiece(newchip, newchip.getpedaço());
                            VerificarBloco(x,i).SetChipPiece(newchip);
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
                        Chip chip = new Chip(orientacao,tipo,n_chips);
                        Chips[n_chips-1] = chip;
                        for (int i = x; i<=(x+(tipo-1)); i++) {
                            j++;
                            ChipPiece newchip = new ChipPiece(chip,j,i,y);
                            chip.addPiece(newchip, newchip.getpedaço());
                            VerificarBloco(i,y).SetChipPiece(newchip);
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
    
    
    
    
    //função que remove um chip dada posição x,y;
    public boolean RemoveChip(int x, int y) {
        boolean result = false;
        
        
        if (VerificarBloco(x, y).getChipPiece()!=null) {
           
            //remover pedaços do tabuleiro
            Chip chipRemove = VerificarBloco(x, y).getChipPiece().getChip();
            for (int i = 0; i<chipRemove.getTipo(); i++) {
                VerificarBloco(chipRemove.getPiece(i).getPosition(1), 
                        chipRemove.getPiece(i).getPosition(2)).removeChipPiece();
            }
            
            
            //remove o chip da lista
            int index = chipRemove.getIdent();
            Chips[index-1] = null;
            n_chips--;
            
            //realoca a array de chips
            for (int i = index; i<=n_chips; i++ ) {
                Chips[i].setIdent(i);
                Chips[i-1] = Chips[i];
            }
            
            result = true;
            
        } else {
            System.out.println("erro: não tem nenum chip para remover");
        }
        
        return result;
    }
    
    
    //função que recebe posição e orientaçãoe e verifica se existe espaço vazio para a peça
    public boolean espacosVazios(int x, int y, int orientacao, int NdeCasas) {
        boolean result = true;     
        switch (orientacao) 
            {
                case 1 :
                    if (((y+(NdeCasas-1))>this.dificuldade.TABSIZE)) 
                    {
                        result = false;
                        System.out.println("Erro - sem espaço");
                    }
                    else
                    {
                        for (int i = y; i<=(y+(NdeCasas-1)); i++) 
                        {
                            if (Casas[(x-1)][(i-1)].getChipPiece()!=null) 
                            {
                                result = false;
                                break;
                            }
                        }
                    }
                    break;
                case 2 :
                    if (((x+(NdeCasas-1))>this.dificuldade.TABSIZE)) 
                    {
                        result = false;
                        System.out.println("Erro - sem espaço");
                    }
                    else
                    {
                        for (int i = x; i<=(x+(NdeCasas-1)); i++) 
                        {
                            if (Casas[(i-1)][(y-1)].getChipPiece()!=null) 
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
    
    public int getNichipsTipo (int tipo) {
        int soma = 0;
        for (int i = 0; i<n_chips; i++) {
            if (Chips[i].getTipo()==tipo) {
                soma++;
            }
        }
        return soma;
    }
    
    //retorna o numero de Chips
    public int getNChips() {
        return n_chips;
    }
    
    //fazer um tiro em uma posição x,y
    public boolean Shoot(int x, int y) {
        Block b = VerificarBloco(x, y);
        if (b.IsShot()) 
        {
            System.out.println("Erro: bloco já atacado"); //mudar de mensagem para retorno;
            return false;
        } 
        else  
            {
                VerificarBloco(x, y).setShot();
                
                return VerificarBloco(x, y).getChipPiece()!=null;
            }
        
 
    }

  

//retorna posição aleatória dentro do tabuleiro
public int getRandomPosition() 
{
  return (int) ((Math.random() * (dificuldade.TABSIZE))+1);
}

//retorna orientação aleatoria
public int getRandomOrientation () {
    return (int) (((Math.random() * 2)+1));
}




//MÉTODO DE TESTE
    //imprime no console informações sobre o status do tabuleiro
    public void imprimeStatus() {
        System.out.println("----------------------TABULEIRO-----------------------");
        System.out.print("[ ]");
        for (int i=0; i<dificuldade.TABSIZE; i++) {
            
            System.out.print("["+(i+1)+"]");}
        System.out.println("");
        
        for (int i=0; i<dificuldade.TABSIZE; i++) {
            
            System.out.print("["+(i+1)+"]");
            for (int j=0; j<dificuldade.TABSIZE; j++) {
                
                System.out.print("[");
                
                if (Casas[i][j].getChipPiece()!=null) {
                    if (Casas[i][j].getChipPiece().Iscrashed()) 
                    {
                        System.out.print("*");
                    } else System.out.print(Casas[i][j].getChipPiece().getIdent());
                } else {
                    if (Casas[i][j].IsShot()) {
                        System.out.print("O");
                        
                 } else System.out.print(" ");
                }
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