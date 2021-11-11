/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iagrafos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Algoritmo extends Grafos {

    static ArrayList<Nodo> guia = new ArrayList();

    public static void mostrarMatriz() {
        try {
            System.out.println("");
            for (int i = 0; i < listaAdyacente.size(); i++) {
                for (int j = 0; j < listaAdyacente.size(); j++) {
                    System.out.print(+matriz[i][j] + " ");
                }
                System.out.println("");
            }
        } catch (NullPointerException we) {
            JOptionPane.showMessageDialog(null, "Error 4098_MM: \n Matriz Vacia");
        }
    }
//5

    public static void eliminarListaDeAdyacensia(String nodo) {
        Nodo aux;
        for (int i = 0; i < listaAdyacente.size(); i++) {
            if (listaAdyacente.get(i).getDatoDelNodo().equals(nodo)) {
                listaAdyacente.remove(i);
            }
        }
        for (int j = 0; j < listaAdyacente.size(); j++) {
            if ((aux = listaAdyacente.get(j).BuscarEnListaDeAdyacensia(nodo)) != null) {
                aux.setNodoSiguiente(aux.getNodoSiguiente().getNodoRelacionado().getNodoSiguiente());
            }
        }
    }

    static String NodoYaCreado = "";

    public static void mostrarCaminoMInimo() {
        String nodoD = JOptionPane.showInputDialog("Dame el nodo Destino");
        String nodoO = JOptionPane.showInputDialog("Dame el nodo Origen");
        Nodo destino = null;
        Nodo origen = null;
        for (int i = 0; i < listaAdyacente.size(); i++) {
            if (listaAdyacente.get(i).getDatoDelNodo().equalsIgnoreCase(nodoD)) {
                destino = listaAdyacente.get(i);
            }
            if (listaAdyacente.get(i).getDatoDelNodo().equalsIgnoreCase(nodoO)) {
                origen = listaAdyacente.get(i);
            }
        }
        try {
            if (origen != null && destino != null) {
                if (!NodoYaCreado.equalsIgnoreCase(origen.getDatoDelNodo())) {
                    NodoYaCreado = origen.getDatoDelNodo();
                    for (int i = 0; i < listaAdyacente.size(); i++) {
                        listaAdyacente.get(i).getEtiqueta().setPeso(0);
                        listaAdyacente.get(i).getEtiqueta().setNodoRelacionado(null);
                    }
                    CrearGrafo(origen);
                    ImprimirCaminoMinimo(origen, destino);
                } else {
                    ImprimirCaminoMinimo(origen, destino);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No encontrado");
            }
        } catch (StackOverflowError | NullPointerException we) {
            JOptionPane.showMessageDialog(null, "No existe camino");
            Nodo.arreglo.clear();
        }
    }

    public static void ImprimirCaminoMinimo(Nodo origen, Nodo destino) {
        destino.BuscarCaminoMinimo(origen);
        System.out.println("El camino minimo entre: " + origen.getDatoDelNodo() + "   --->   " + destino.getDatoDelNodo() + "  es:");
        for (int i = Nodo.arreglo.size() - 1; i >= 0; i--) {
            System.out.print(Nodo.arreglo.get(i));
        }
        System.out.println("    Peso Total: " + destino.getEtiqueta().getPeso());
        Nodo.arreglo.clear();
    }

    public static void crearMatriz() {
        matriz = new int[listaAdyacente.size()][listaAdyacente.size()];
        for (int i = 0; i < listaAdyacente.size(); i++) {
            for (int j = 0; j < listaAdyacente.size(); j++) {
                matriz[i][j] = 0;
            }
        }
        for (int i = 0; i < listaAdyacente.size(); i++) {
            listaAdyacente.get(i).crearMatriz(i);
        }
    }

    public static void CrearGrafo(Nodo nodo) {
        nodo.EtiquetarRelaciones();
        for (int i = 0; i < guia.size(); i++) {
            guia.get(i).EtiquetarRelaciones();
        }
        guia.clear();
    }

    public static void MostrarListaDeAdyacensia() {
        listaAdyacente.forEach(x -> {
            System.out.println("\n" + "Lista Adyecente de:   " + x.getDatoDelNodo());
            x.MostrarListaDelObjeto();
        });
    }
}
