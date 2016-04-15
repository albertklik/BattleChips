/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlechips;

/**
 *
 * @author berto
 */
public abstract class Dificuldade {
    
    public static Dificuldade FACIL = new Facil();
    public static Dificuldade NORMAL = new Normal();
    public static Dificuldade DIFICIL = new Dificil();
    
    
    public int DIFICULDADE;
    public int TABSIZE;
    public int N_CHIPS;
    public int N_CHIP1;
    public int N_CHIP2;
    public int N_CHIP3;
    public int N_CHIP4;
    
    
   

    
    
    
}
