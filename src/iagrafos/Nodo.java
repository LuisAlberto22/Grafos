/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iagrafos;

import java.util.ArrayList;

public class Nodo extends Grafos {

    private int cordenadaX;
    private int cordenadaY;
    private final String datoDelNodo;
    private Relaciones etiqueta;
    public static ArrayList arreglo = new ArrayList();
    private Relaciones nodoSiguiente;

    public Nodo(int x, int y, String dato) {
        this.cordenadaX = x;
        this.cordenadaY = y;
        this.datoDelNodo = dato;
        this.etiqueta = new Relaciones(0, this);
    }

    public void crearMatriz(int i) {
        Nodo auxNR = this;
        int pos;
        while (auxNR.nodoSiguiente != null) {
            pos = posicion(auxNR.nodoSiguiente.getNodoRelacionado().datoDelNodo);
            matriz[i][pos] = 1;
            auxNR = auxNR.nodoSiguiente.nodoRelacionado;
        }
    }

    public Nodo Clonar() {
        Nodo pablo = new Nodo(0, 0, this.datoDelNodo);
        return pablo;
    }

    public void BuscarCaminoMinimo(Nodo nodoO) {
        if (this == nodoO) {
            arreglo.add(this.datoDelNodo);
            return;
        }
        arreglo.add("  --->  " + this.datoDelNodo);
        this.etiqueta.getNodoRelacionado().BuscarCaminoMinimo(nodoO);
    }
//1
    public void EtiquetarRelaciones() {
        int auxp;
        Nodo Buscar;
        Nodo auxNR = this;
        while (auxNR.nodoSiguiente != null) {
            Buscar = EncontrarEnArreglo(auxNR.nodoSiguiente.nodoRelacionado.datoDelNodo);
            auxp = this.etiqueta.getPeso() + auxNR.nodoSiguiente.getPeso();
            if (!Algoritmo.guia.contains(Buscar)) {
                Algoritmo.guia.add(Buscar);
            }
            if (auxp < Buscar.etiqueta.getPeso() || Buscar.etiqueta.getPeso() == 0) {
                Buscar.etiqueta.setNodoRelacionado(this);
                Buscar.etiqueta.setPeso(auxp);
            }
            auxNR = auxNR.nodoSiguiente.nodoRelacionado;
        }
    }
//2
    public void crearListaDeAdyacensia(Relaciones relacion) {
        Nodo aux = this;
        while (aux.nodoSiguiente != null) {
            aux = aux.nodoSiguiente.nodoRelacionado;
        }
        aux.nodoSiguiente = relacion;
    }
//3
    public Nodo BuscarEnListaDeAdyacensia(String objeto) {
        Nodo aux = this;
        try {
            while (objeto != null) {
                if (aux.nodoSiguiente.nodoRelacionado.datoDelNodo.equalsIgnoreCase(objeto)) {
                    break;
                } else {
                    aux = aux.nodoSiguiente.nodoRelacionado;
                }
            }
        } catch (NullPointerException we) {
            return null;
        }
        return aux;
    }
//4
    public void MostrarListaDelObjeto() {
        System.out.print(this.getDatoDelNodo() + " ---->  ");
        if (nodoSiguiente != null) {
            nodoSiguiente.nodoRelacionado.MostrarListaDelObjeto();
        }
    }

    public int getCordenadaX() {
        return cordenadaX;
    }

    public void setCordenadaX(int cordenadaX) {
        this.cordenadaX = cordenadaX;
    }

    public int getCordenadaY() {
        return cordenadaY;
    }

    public void setCordenadaY(int cordenadaY) {
        this.cordenadaY = cordenadaY;
    }

    public String getDatoDelNodo() {
        return datoDelNodo;
    }

    public Relaciones getEtiqueta() {
        return etiqueta;
    }

    public Relaciones getNodoSiguiente() {
        return nodoSiguiente;
    }

    public void setNodoSiguiente(Relaciones nodoSiguiente) {
        this.nodoSiguiente = nodoSiguiente;
    }

}
