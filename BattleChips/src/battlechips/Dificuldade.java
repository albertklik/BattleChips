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
    
   
    
    public int DIFICULDADE;
    public int TABSIZE;
    public int N_CHIPS;
    public int N_CHIP1;
    public int N_CHIP2;
    public int N_CHIP3;
    public int N_CHIP4;
    
    public int getNchipsTipo(int Tipo) {
        if (Tipo == 1 ) return N_CHIP1;
        else if (Tipo == 2) return N_CHIP2;
        else if (Tipo == 3) return N_CHIP3;
        else if (Tipo == 4) return N_CHIP4;
        else return 0;
        } 
    
    
    }
    
    
    

