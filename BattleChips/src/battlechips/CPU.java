/*
 *  GABRIEL QUE FEZ :D
 * CLASSE CPU
 * EXTENDE A CLASSE PLAYER
 * JOGADOR COM INTELIGENCIA ARTIFICIAL
  a cpu é um player com técnicas de inteligencia para tomar decisões de 
 jogo automaticamente
 */
package battlechips;

import java.util.Random;


public class CPU extends Player 
{
    
  
    //variáveis que vareiam
    int x,y;
    int aux1,aux2,aux3,aux4,aux = 0;
    Table tabuleiro;
    Table cpuTable = new Table(dificuldade);
    int CPUauxTable[][] = new int[dificuldade.TABSIZE][dificuldade.TABSIZE];
    Random rand = new Random();
    Table adTable;
    boolean lastHit = false;
    int NumConssecHits;
    int DificultyLevel;
    int OrientationShots;
    int direction;
    boolean outroLado;
    
    
    
    
    //construtor que construteia
    public CPU(int id, Dificuldade dificuldade) 
    {
        super(id, dificuldade);
        this.tabuleiro = new Table(super.dificuldade);
        DificultyLevel = 2;
        
    }
    
    
    
    private void updateRandom() {
        x = tabuleiro.getRandomPosition();
        y = tabuleiro.getRandomPosition();
    }
    
    private boolean TemChip(int a,int b) {
        return (adTable.VerificarBloco(a, b).getChipPiece()!=null);
    }
    
    private boolean hunt(int verifications)
    {
        boolean acerto = false;
        
        for (int i=0; i<verifications; i++) {
            updateRandom(); 
            boolean check = TemChip(x,y);
            if (check==true) {
                acerto = adTable.Shoot(x,y);
                break;
            }
        }
        
        if (acerto==false) {
            acerto = adTable.Shoot(x,y);
        }
        
        return acerto;
    }
    
    private boolean SideShoot() {
        int a=0,b=0;
        int sort; 
        boolean tiroFeito=false;
             
                   
        while (tiroFeito==false) {      
        sort = (int) ((Math.random() * (4))+1);
            System.out.println(sort);
        //sorteia uma das 4 direções para verificar
        
        switch (sort) {
        
            case 1: 
                if (x!=dificuldade.TABSIZE) {
                a=x+1; b=y;
                
                if (!adTable.VerificarBloco(a, b).IsShot()) tiroFeito=true;
                direction=1;
                OrientationShots=2;
                }
                break;
            case 2: 
                if (x!=1) {
                a=x-1; b=y;
                if (!adTable.VerificarBloco(a, b).IsShot()) tiroFeito=true;
                direction=-1;
                OrientationShots=2;
                }
                break;
            case 3: 
                if (y!=dificuldade.TABSIZE) {
                a=x; b=y+1;
                if (!adTable.VerificarBloco(a, b).IsShot()) tiroFeito=true;
                direction=+1;
                OrientationShots=1;
                }
                break;
            case 4: 
                if (y!=1) {
                a=x; b=y-1;
                if (!adTable.VerificarBloco(a, b).IsShot()) tiroFeito=true;
                direction=-1;
                OrientationShots=1;
                }
                break;    
                
        }
        }
        
        x=a;
        y=b;
        return adTable.Shoot(a,b);
          
    }
    
    
     private boolean LineShoot1() {
        int a=0,b=0;
        int sort; 
        boolean tiroFeito=false;
            
                   
        while (tiroFeito==false) {      
        sort = (int) ((Math.random() * (2))+1);
            System.out.println(sort);
        //sorteia uma das 4 direções para verificar
            int range;
            if (direction>0) {
                range = 2;
            } else range = 1;
            
        
        switch (sort) {
        
            case 1:   
                if (OrientationShots==2) {
                    if (x!=(dificuldade.TABSIZE-1)) {
                        a=x+range;b=y;
                        if (!adTable.VerificarBloco(a, b).IsShot()) tiroFeito=true;
                    }
                } else {
                    if (y!=(dificuldade.TABSIZE-1)) {    
                        a=x; b=y+range;
                        if (!adTable.VerificarBloco(a, b).IsShot()) tiroFeito=true;
                    }
                }
                break;
            case 2: 
                if (OrientationShots==24
                        ) {
                    if (x!=2) {
                        a=x-range;b=y;
                        if (!adTable.VerificarBloco(a, b).IsShot()) tiroFeito=true;
                    }
                } else {
                    if (y!=2) {    
                        a=x; b=y-range;
                        if (!adTable.VerificarBloco(a, b).IsShot()) tiroFeito=true;
                    }
                }
                break;        
        }
        }
        
        x=a;
        y=b;
        return adTable.Shoot(a,b);
          
    }
    
    
    
    
    
    
    public boolean ChecarBotão() //checa se é um botão, duh
    {
        return adTable.VerificarBloco(x,y).getChipPiece().getTipo() == 1;
    }
    
      //verifica as casas ao redor, para ver se estão disponíveis, então atira em uma
    public int CheckAround(int x,int y,Table adTable) 
    {   
        if (ChecarBotão() == false)
        {   
            aux = 0;
            if( y != dificuldade.TABSIZE )
            {
            if (CPUauxTable[x][y+1] != 0)
            aux1 = 1;
            }
            if (y != 0)
            {
            if (CPUauxTable[x][y-1] != 0)
            aux2 = 2;
            }
            if (x != dificuldade.TABSIZE)
            {
            if (CPUauxTable[x+1][y] != 0 )
            aux3 = 3;
            }
            if(x != 0)
            {
            if (CPUauxTable[x-1][y] != 0 )
            aux4 = 4;
            }
        }
        while (aux == 0 || aux != aux1 && aux != aux2 && aux != aux3 && aux != aux4)
        { 
            aux = rand.nextInt(4)+1;
        }
        int somethingthere = 0; 
        if(aux == aux1)
        {
            y++;
        somethingthere = 1;
        }
        else if(aux == aux2)
        {
            y--;
        somethingthere = 1;
        }
        else if(aux == aux3)
        {
            x++;
        somethingthere = 1;
        }
        else if(aux == aux4)
        {
            x--;
        somethingthere = 1;
        }
        
        return somethingthere;
    }
        
    
   
    
    
   //tiro no chip = 1; tiro na água = 0;
    public boolean destroy(int x,int y,Table adTable)
    {   boolean AlreadyShot = false;      
        boolean acerto = false;
        
        if(y!=dificuldade.TABSIZE && AlreadyShot == false )
        {
        if (CPUauxTable[x][y+1] == 1 && y!= 0)
        {
            acerto = adTable.Shoot(x,y-1);
             
            if (acerto == true)
            {
                CPUauxTable[x][y-1] = 1;
                y--;
                AlreadyShot = true;
            }    
            else
                CPUauxTable[x][y-1] = 0;
                AlreadyShot = true;
        }
        }
        if(y!=0 && AlreadyShot == false)
        {
            if (CPUauxTable[x][y-1] == 1 && y!= dificuldade.TABSIZE)

        {
            acerto = adTable.Shoot(x, y+1);
            if(acerto == true)
            {
                CPUauxTable[x][y+1] = 1;
                y++;
                AlreadyShot = true;
            }
            else
                CPUauxTable[x][y+1] = 0;
                AlreadyShot = true;
        }
        }
        if(x!=dificuldade.TABSIZE && AlreadyShot == false)
        {
            if (CPUauxTable[x+1][y] == 1 && x!= 0)
            {
            acerto = adTable.Shoot(x+1,y);
            if(acerto == true)
            {
                CPUauxTable[x-1][y] = 1;
                x++;
                AlreadyShot = true;
            }
            else
                CPUauxTable[x-1][y] = 0;
                AlreadyShot = true;
            }
        }
        if(x!=0 && AlreadyShot == false)
        {
         if (CPUauxTable[x-1][y] == 1 && x!= dificuldade.TABSIZE)
        {
            acerto = adTable.Shoot(x-1, y);
            if (acerto == true)
            {
                CPUauxTable[x+1][y] = 1;
                x--;
                AlreadyShot = true;
            }
            else
                CPUauxTable[x+1][y] = 0;
                AlreadyShot = true;
        }
        }
         
        return acerto;
    }


       
public void CPUturn(Table advTable) // Método principal da classe CPU. Executa uma jogada.
{
    boolean jogada = false;
    this.adTable = advTable;
    
    if (NumConssecHits>0) {
        
        //verificar se não é um botão
        if (adTable.VerificarBloco(x, y).getChipPiece()!=null&&adTable.VerificarBloco(x, y).getChipPiece().getTipo() != 1) {
            System.out.println("Não é um botão");
            
        //    if (NumConssecHits>1) { 
            
                //pode ser um micro controlador ou um microprocessador
                //tentar mais um tiro nas laterais
                
              //  if (NumConssecHits>2) {
                    
                    
                    //temos três acertos consecutivos e o chip ainda não morreu
                    //só pode ser o microchip
                    
                    
                    
                    
                    
           /*     } else  {
                    
                    boolean Hit = LineShoot1();
                    if (Hit==true) {
                        if (adTable.VerificarBloco(x, y).getChipPiece().getChip().checkCrached()) {
                          //é um Decoder
                        NumConssecHits = 0;
                        }else{
                            
                            //não é um decoder
                        NumConssecHits++;
                        }
                    
                    } 
                    
                } 
               
            */
            
            
            
            
       //     } else {
            
             
            boolean Hit = SideShoot();
            if (Hit==true) {
                if (adTable.VerificarBloco(x, y).getChipPiece().getChip().checkCrached()) {
                    System.out.println("É um resistor");
                    //é um resistor
                    NumConssecHits = 0;
                }else{
                NumConssecHits++;
                }
            } else {
            
            //outroLado = true;
            
            
            }
            
            
                
               
                
                
                
           
            
        //    }

            
        } else {
            
            System.out.println("É um Botão");
            NumConssecHits=0;
            
            //outro tiro aleatorio
            boolean Hit=hunt(DificultyLevel);
            if (Hit==true) {
                NumConssecHits++;
                
            }
            
            
            
        }
        
    } else
    { 
       
            //tiro aleatorio
            Boolean Hit=hunt(DificultyLevel);
            if (Hit==true) {
                NumConssecHits++;
            }
    }
    
    

    System.out.println("Numero consec de acertos" + NumConssecHits);
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    



    /*Ok, seu merdinha, sabe que horas são? é hora de eu explicar a porra do código.
Primeiro vc chama a função hunt, pra ele dar um tiro mais aleatório que o método como
seus pais se conheceram, depois, SE ELE ACERTAR (note que ele retorna um boolean)
    Ele chama a função verificarBotão, pq senão ele vai ficar procurando ao redor do alvo 
por algo que não existe, tipo o amor que você acha que aquela garota tem por vc.
    Depois ele vai chamar a função check, pra que ele olhe ao redor da peça, SABENDO QUE 
ESSA PORRA NÃO É UM BOTÃO, e com base no sorteio de números aleatórios, ele vai selecionar
uma das possíveis casas aonde o tipo possa acertar e atirar lá. Essa porra vai te dizer se tem
algo ou não e aí vai fodendo marcar na porra da tabelinha da metelança.
    quando tiver acertado PELO MENOS 2 PEÇAS CONSECUTIVAS, vem o método DESTROY(dat pussy)
    que vai pegar a linha/coluna e atirar lá até matar tudo, que nem hitler fez com os judeus.*/

   
    
   
    
    public void PosicionarChips() 
    {
        
        for (int i =1; i<=4; i++) {
        //adicionar peças no tabuleiro;
        while (!(super.getTable().getNichipsTipo(i)>=dificuldade.getNchipsTipo(i))) {
            super.getTable().InserirChip(super.getTable().getRandomOrientation(),super.getTable()
                    .getRandomPosition(),super.getTable().getRandomPosition(), 
                     i);
        }
        
        }
        
        
    }
}
