/*
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
        
     /*   while (CPUauxTable[x][y] ==0 || CPUauxTable[x][y] == 1)
        {
            x = tabuleiro.getRandomPosition();
            y = tabuleiro.getRandomPosition();
        }    
       */ acerto = adTable.Shoot(x,y);   
       /* if (acerto == true)
            CPUauxTable[x][y] = 1;
        else
            CPUauxTable[x][y] = 0;
         */   
    return acerto;
    }
    
    public boolean ChecarBotão() //checa se é um botão, duh
    {
        return super.getTable().VerificarBloco(x,y).getChipPiece().getTipo() == 1;
    }
    
    public boolean CheckAround(int x,int y,Table adTable) //verifica as casas ao redor, para ver se estão disponíveis
    {   
        if (ChecarBotão() == false)
        {
            if (CPUauxTable[x][y+1] != 0)
            aux1 = 1;
            if (CPUauxTable[x][y-1] != 0)
            aux2 = 2;
            if (CPUauxTable[x+1][y] != 0)
            aux3 = 3;
            if (CPUauxTable[x-1][y] != 0)
            aux4 = 4;
        }
        while (aux == 0 || aux != aux1 && aux != aux2 && aux != aux3 && aux != aux4)
        { 
            aux = rand.nextInt(4)+1;
        }
        if(aux == aux1)
            y++;
        else if(aux == aux2)
            y--;
        else if(aux == aux3)
            x++;
        else if(aux == aux4)
            x--;
        
        boolean acerto = adTable.Shoot(x,y);   
        if (acerto == true)
            CPUauxTable[x][y] = 1;
        else
            CPUauxTable[x][y] = 0;
            
        return acerto;
    }
        
    
   
    
    
   //tiro no chip = 1; tiro na água = 0;
    public boolean destroy(int x,int y,Table adTable)
    {         
        boolean acerto = false;
        if (CPUauxTable[x][y+1] == 1)
        {
            acerto = adTable.Shoot(x,y-1);
             
            if (acerto == true)
            {
                CPUauxTable[x][y-1] = 1;
                y--;
            }    
            else
                CPUauxTable[x][y-1] = 0;
        }
        
<<<<<<< HEAD
        else if (CPUauxTable[x][y-1] == 1)
        {
            acerto = adTable.Shoot(x, y+1);
            if(acerto == true)
            {
                CPUauxTable[x][y+1] = 1;
                y++;
            }
            else
                CPUauxTable[x][y+1] = 0;
        }
        
        else if (CPUauxTable[x+1][y] == 1)
        {
            acerto = adTable.Shoot(x+1,y);
            if(acerto == true)
            {
                CPUauxTable[x-1][y] = 1;
                x++;
            }
            else
                CPUauxTable[x-1][y] = 0;
        }
       
        else if (CPUauxTable[x-1][y] == 1)
        {
            acerto = adTable.Shoot(x-1, y);
            if (acerto == true)
            {
                CPUauxTable[x+1][y] = 1;
                x--;
            }
            else
                CPUauxTable[x+1][y] = 0;
        }
        return acerto;
    }
=======
        if (CPUauxTable[x][y-1] ==1);
        
        if (CPUauxTable[x+1][y] == 1);
        
        if (CPUauxTable[x-1][y] == 1);
        
      return false;  
}
>>>>>>> origin/master
   
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
