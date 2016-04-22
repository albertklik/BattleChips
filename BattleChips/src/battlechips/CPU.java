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
    //construtor que construteia
    public CPU(int id, Dificuldade dificuldade) 
    {
        super(id, dificuldade);
        this.tabuleiro = new Table(super.dificuldade);
    }
  
    //variáveis que vareiam
    boolean AlreadyShot;
    int x,y;
    int aux1,aux2,aux3,aux4,aux = 0;
    Table tabuleiro;
    Table cpuTable = new Table(dificuldade);
    int CPUauxTable[][] = new int[dificuldade.TABSIZE][dificuldade.TABSIZE];
    Random rand = new Random();
    
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
    
    public boolean ChecarBotão() //checa se é um botão, duh
    {
        if (super.getTable().VerificarBloco(x,y).getChipPiece().getTipo() != 1)
         return false;
        else
         return true;
            
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
    {  
        AlreadyShot = false;      
        boolean acerto = false;
        
        if(y!=dificuldade.TABSIZE && AlreadyShot == false)
        {
        if (y!= 1 && CPUauxTable[x][y+1] == 1 && CPUauxTable[x][y-1] != 0 )
        {
            acerto = adTable.Shoot(x,y-1);
             
            if (acerto == true)
            {
                CPUauxTable[x][y-1] = 1;
                AlreadyShot = true;
            }    
            else
            {
                CPUauxTable[x][y-1] = 0;
                AlreadyShot = true;  
            }   
        }
       
        
        else if(CPUauxTable[x][y+1] == 1 && CPUauxTable[x][y-1] == 0 && CPUauxTable[x][y+1] != 0)
            {
                while(CPUauxTable[x][y+1]==1)
                {
                    y++;
                }
            
                acerto = adTable.Shoot(x,y+1);
             
            if (acerto == true)
            {
                CPUauxTable[x][y+2] = 1;
                y++;
                AlreadyShot = true;
            }    
           
            }
        else if (CPUauxTable[x][y+1] == 0 && CPUauxTable[x][y-1] == 0)
        {
        
           if(x!=dificuldade.TABSIZE && AlreadyShot == false)
            {
                if (y!= 0 && CPUauxTable[x+1][y] == 1 && CPUauxTable[x-1][y] != 0 )
                {
                    acerto = adTable.Shoot(x-1,y);
             
                    if (acerto == true)
                    {
                        CPUauxTable[x-1][y] = 1;
                        AlreadyShot = true;
                    }    
                    else
                    {
                        CPUauxTable[x-1][y] = 0;
                        AlreadyShot = true;  
                    }   
                }
       
        
                else if(CPUauxTable[x+1][y] == 1 && CPUauxTable[x-1][y] == 0 && CPUauxTable[x+1][y] != 0)
                {
                    while(CPUauxTable[x+1][y]==1)
                    {
                        x++;
                    }
            
                    acerto = adTable.Shoot(x+1,y);
             
                    if (acerto == true)
                    {
                        CPUauxTable[x+2][y] = 1;
                        x++;
                        AlreadyShot = true;
                    }    
                }
            }
        }
    }
    return acerto;    
}
       // Resto do antigo código, caso seja preciso mudar algo 
      
    /*    if(x!=dificuldade.TABSIZE && AlreadyShot == false)
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
      */
         
        


       
public void CPUturn(Table adTable) // Método principal da classe CPU. Executa uma jogada.
{
    boolean jogada = false;
    for (int x = 0;x <= dificuldade.TABSIZE;x++)
    {
        for(int y = 0; y <= dificuldade.TABSIZE;y++)
        {   
           
            if (CPUauxTable[x][y] == 1 || jogada == false)
            {
                destroy(x,y,adTable);
                if (AlreadyShot == false)
                {
                    if(CheckAround(x,y,adTable)==1)  
                    {
                        adTable.Shoot(x,y);
                        jogada = true;
                    }
                }
            }
            else if (jogada == false)
            {
                hunt(adTable);
                jogada = true;
            }
        }
    } 
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
        
        //adicionar peças no tabuleiro;
        super.getTable().InserirChip(0, 0, 0, 0);
        
        
    }
}
