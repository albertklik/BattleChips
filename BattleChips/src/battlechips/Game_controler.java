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
public class Game_controler {
   
    //modos de jogo
    
    
    private Player jog1;
    private CPU cpu;
    private boolean PartidaIniciada;
    private Player winner;
    private Dificuldade Dificuldade;
    boolean vez;
    
    
    public Game_controler(Dificuldade dif) {
        
    this.Dificuldade = dif;
        System.out.println("Jogo iniciado na dificuldade " + dif.DIFICULDADE);
    jog1 = new Player(1,Dificuldade);
    cpu = new CPU(2,Dificuldade);
    PartidaIniciada = false;
    
    }
    
    
    public void CPUPosicionarChips() {
        
        cpu.PosicionarChips();
        System.out.println("CPU posicionou os seus Chips");
    }
    
    
    public Player GetPlayer(int player) {
        if (player==1) {
            return jog1;
        } else return cpu;
    }
    
    //checa se existe espaço para posicionar um chip
    public boolean checarEspaçoPlayer(int x, int y, int orientação, int tipochip) {
        return jog1.getTable().espacosVazios(x, y, orientação, tipochip);
    }
    
    
    
    //coloca um chip em uma posição no tabuleiro do player
    public boolean setChipPlayer(int player, int x,int y,int orientação,int tipoChip) {
      
      Player p = GetPlayer(player);  
        
        
      if (p.ChipsProntos()) 
      {
          System.out.println("erro: o jogador ja posicionou todos os seus chips");
          return false;
      } 
      else 
      {
          if (p.getTable().getNichipsTipo(tipoChip)>=Dificuldade.getNchipsTipo(tipoChip))
          {
              System.out.println("erro: Todos os chips do tipo " + tipoChip + " ja foram posicionados");
              return false;
          }
          else {
              
          
      if (p.getTable().VerificarBloco(x, y).getChipPiece()!=null) {
          return false;
      }
      else
      {
          p.getTable().InserirChip(orientação, x, y, tipoChip);
          return true;
      }
        
      }  
      }
    } 
    
    
   public boolean PlayerShoot(int x,int y)
   {       
       boolean acerto;
       if (PartidaIniciada==true) {
        
            acerto = jog1.MakeShoot(x, y, cpu.getTable());      
        
       }
       else 
       {
           System.out.println("erro, partida não inciada");
           return false;
       }
       
       ChecarFimDeJogo();
       return acerto;
       
       }
   
   public boolean CpuShoot() {
       boolean acerto;
       if (PartidaIniciada==true) {
        
                  acerto = cpu.hunt(jog1.getTable());
        
       }
       else 
       {
           System.out.println("erro, partida não inciada");
           return false;
       }
       
       
       
       return acerto;
   }
    
    
   public boolean ChecarFimDeJogo() {
       boolean fimDeJogo = false;
       if (jog1.getTable().chipsCrashed()>=jog1.getTable().getNChips()) {
           winner = cpu;
           fimDeJogo = true;
           PartidaIniciada = false;
           System.out.println("fim de jogo! jogador perdeu");
       }
       if (cpu.getTable().chipsCrashed()>=cpu.getTable().getNChips()) {
           winner = jog1;
           fimDeJogo = true;
           PartidaIniciada = false;
           System.out.println("fim de jogo! jogador ganhou");
       }
       return fimDeJogo;
   } 
    
   
   
    public void IiciarJogo() 
    {
        if (jog1.ChipsProntos()&cpu.ChipsProntos()) {
            PartidaIniciada = true;
            System.out.println("jogo inciado");
        }else
            System.out.println("jogadores não estão prontos");
        
        
    }
    
    
    
}
