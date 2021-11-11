/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iagrafos;

/**
 *
 * @author guich
 */
public class Relaciones {
    private int peso;
    Nodo nodoRelacionado;

    public Relaciones(int peso, Nodo nodoRelacionado) {
        this.peso = peso;
        this.nodoRelacionado = nodoRelacionado;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Nodo getNodoRelacionado() {
        return nodoRelacionado;
    }

    public void setNodoRelacionado(Nodo nodoRelacionado) {
        this.nodoRelacionado = nodoRelacionado;
    }
    
}
