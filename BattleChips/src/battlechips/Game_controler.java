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
    private Dificuldade Dificuldade;
    
    
    public Game_controler(Dificuldade dif) {
    this.Dificuldade = dif;
    jog1 = new Player("player1",Dificuldade);
    cpu = new CPU("CPU",Dificuldade);
    PartidaIniciada = false;
    
    cpu.PosicionarChips();
    
    
  
    }
    
     
    public boolean setChipPlayer(int x,int y,int orientação,int tipoChip) {
      if (jog1.getTable().VerificarBloco(x, y).getChipPiece()!=null) {
          return false;
      }
      else
      {
          jog1.getTable().InserirChip(orientação, x, y, tipoChip);
          return true;
      }
        
        
    } 
    
    
   /* public boolean Shoot (int x,int y, Player p) {
        
        if () {
            return jog1.getTable().Shoot(x, y);      
        } else
        {
            return cpu.getTable().Shoot(x, y);
        } 
    }*/
    
    
    
    
    public void IiciarJogo() 
    {
        if (jog1.ChipsProntos()) {
            PartidaIniciada = true;
        }
        
        
    }
    
    
    
}
