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
    
    System.out.println(Dificuldade.N_CHIPS);
    jog1 = new Player(1,Dificuldade);
    cpu = new CPU(2,Dificuldade);
    PartidaIniciada = false;
    
    cpu.PosicionarChips();
    
    
  
    }
    
    public Player GetPlayer(int player) {
        if (player==1) {
            return jog1;
        } else return cpu;
    }
    
     
    public boolean setChipPlayer(int x,int y,int orientação,int tipoChip) {
      
      if (jog1.ChipsProntos()) 
      {
          System.out.println("o jogador ja posicionou todos os seus chips");
          return false;
      } else 
      {
      if (jog1.getTable().VerificarBloco(x, y).getChipPiece()!=null) {
          return false;
      }
      else
      {
          jog1.getTable().InserirChip(orientação, x, y, tipoChip);
          return true;
      }
        
      }  
    } 
    
    
   public boolean Shoot (int x,int y,int player)
   {       
       boolean acerto;
       if (PartidaIniciada==true) {
        if (player==1) {
            acerto = jog1.MakeShoot(x, y, cpu.getTable());      
        } else
        {
            acerto = cpu.hunt(jog1.getTable());
        } 
       }
       else 
       {
           System.out.println("erro, partida não inciada");
           return false;
       }
       
       ChecarFimDeJogo();
       return acerto;
       
       }
    
    
   public boolean ChecarFimDeJogo() {
       boolean fimDeJogo = false;
       if (jog1.getTable().chipsCrashed()>=jog1.getTable().getNChips()) {
           winner = cpu;
           fimDeJogo = true;
           PartidaIniciada = false;
       }
       if (cpu.getTable().chipsCrashed()>=cpu.getTable().getNChips()) {
           winner = jog1;
           fimDeJogo = true;
           PartidaIniciada = false;
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
