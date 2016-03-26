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
public class ChipPiece {
    public static final int BOTAO = 1;
    public static final int RESIS = 2;
    public static final int DECOD = 3;
    public static final int MICRO = 4;
    
    private int identificador;
    private int tipo;
    private int pedaco;
    private boolean crashed; 
    
    public ChipPiece (int ident,int tipo, int pedaco) {
        identificador = ident;
        this.tipo = tipo;
        this.pedaco = pedaco;
        crashed = false;
    }
    
    public int getIdent() {
        return identificador;
    }
    
    public int getTipo() {
        return tipo;
    }
    
    public int getpedaço() {
        return pedaco;
    }
    
    public void crash() {
        crashed = true;
    }
    
    public boolean Iscrashed () {
        return crashed;
    }
    
    
}
