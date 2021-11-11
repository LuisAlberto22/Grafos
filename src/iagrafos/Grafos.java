/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iagrafos;

import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Oscar
 */
public class Grafos extends javax.swing.JFrame {

    static ArrayList<Nodo> listaAdyacente = new ArrayList();
    static int matriz[][];
    Graphics j;

    public Grafos() {
        initComponents();
        this.j = PanelDeDibujo.getGraphics();
        j.setColor(Color.DARK_GRAY);
        this.setFocusable(true);
        Descripcion.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelDeDibujo = new javax.swing.JPanel();
        MostrarNodos = new javax.swing.JButton();
        ConetarNodos = new javax.swing.JButton();
        MostrarRelaciones = new javax.swing.JButton();
        btnEliminarNodo = new javax.swing.JButton();
        Descripcion = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grafos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusTraversalPolicyProvider(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelDeDibujo.setBackground(new java.awt.Color(255, 255, 255));
        PanelDeDibujo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelDeDibujoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelDeDibujoLayout = new javax.swing.GroupLayout(PanelDeDibujo);
        PanelDeDibujo.setLayout(PanelDeDibujoLayout);
        PanelDeDibujoLayout.setHorizontalGroup(
            PanelDeDibujoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        PanelDeDibujoLayout.setVerticalGroup(
            PanelDeDibujoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        getContentPane().add(PanelDeDibujo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        MostrarNodos.setText("Algoritmo Dijkstra");
        MostrarNodos.setFocusable(false);
        MostrarNodos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MostrarNodosMouseMoved(evt);
            }
        });
        MostrarNodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MostrarNodosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MostrarNodosMouseExited(evt);
            }
        });
        getContentPane().add(MostrarNodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        ConetarNodos.setText("Conectar Nodos");
        ConetarNodos.setFocusable(false);
        ConetarNodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConetarNodosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ConetarNodosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ConetarNodosMouseExited(evt);
            }
        });
        getContentPane().add(ConetarNodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, -1, -1));

        MostrarRelaciones.setText("Mostrar Lista y Matriz");
        MostrarRelaciones.setFocusable(false);
        MostrarRelaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MostrarRelacionesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MostrarRelacionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MostrarRelacionesMouseExited(evt);
            }
        });
        getContentPane().add(MostrarRelaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, -1, -1));

        btnEliminarNodo.setText("Eliminar Nodo");
        btnEliminarNodo.setFocusable(false);
        btnEliminarNodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarNodoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarNodoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarNodoMouseExited(evt);
            }
        });
        getContentPane().add(btnEliminarNodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, -1, -1));

        Descripcion.setBackground(new java.awt.Color(51, 51, 51));
        Descripcion.setForeground(new java.awt.Color(153, 153, 153));
        Descripcion.setText("Mostrar Nodos(M)");
        getContentPane().add(Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 170, 20));
        Descripcion.getAccessibleContext().setAccessibleName("descripcion");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void PanelDeDibujoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelDeDibujoMouseClicked
        Point punto = MouseInfo.getPointerInfo().getLocation();
        int x, y;
        x = punto.x;
        y = punto.y;
        String dato = JOptionPane.showInputDialog(null, "Ingrese el dato del grafo en las cordenadas x: " + x + " y: " + y);
        if (dato != null) {
            if (EncontrarEnArreglo(dato) == null) {
                Nodo obj = new Nodo(x, y, dato);
                listaAdyacente.add(obj);
                j.setColor(Color.DARK_GRAY);
                j.drawOval(x - 19, y - 25, 30, 30);
                j.fillOval(x - 19, y - 25, 30, 30);
                j.setColor(Color.white);
                j.drawString(dato, x - 7, y - 3);
            } else {
                JOptionPane.showMessageDialog(null, "El Grafo Ya existe");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se debe ingresar un contenido al grafo");
        }
    }//GEN-LAST:event_PanelDeDibujoMouseClicked

    private void MostrarNodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MostrarNodosMouseClicked
        Algoritmo.mostrarCaminoMInimo();
    }//GEN-LAST:event_MostrarNodosMouseClicked

    public Nodo EncontrarEnArreglo(String dato) {
        for (int i = 0; i < listaAdyacente.size(); i++) {
            String d = listaAdyacente.get(i).getDatoDelNodo();
            if (d.equals(dato)) {
                return listaAdyacente.get(i);
            }
        }
        return null;
    }

    public int posicion(String dato) {
        for (int i = 0; i < listaAdyacente.size(); i++) {
            String d = listaAdyacente.get(i).getDatoDelNodo();
            if (d.equals(dato)) {
                return i;
            }
        }
        return 0;
    }

    public void dibujarCamino(int x1, int y1, int x2, int y2, int peso, Color color) {
        int a, b;
        if (x1 == x2 && y1 == y2) {
            j.drawArc(x1 - 3, y1 - 10, 30, 30, 180, 270);
            j.fillRect(x1 + 5, y1, 15, 15);
            j.setColor(color);
            j.drawString(String.valueOf(peso), x1 + 10, y1 + 13);
        } else if (x1 < x2 && y1 >= y2) {
            a = ((x1) + ((x2 - x1) / 2));
            b = ((y1) - ((y1 - y2) / 2));
            j.setColor(color);
            j.drawLine(x1 + 8, y1 - 8, x2 - 16, y2 - 8);
            j.setColor(color);
            j.fillOval(x2 - 20, y2 - 8, 5, 5);
            j.drawString(String.valueOf(peso), a + 7, b + 12);
        } else if (x1 >= x2 && y1 <= y2) {
            a = (x1) + ((x2 - x1) / 2);
            b = (y2) - (y2 - y1) / 2;
            j.drawLine(x1 - 8, y1 + 3, x2 + 8, y2 - 2);
            j.fillRect(a, b, 20, 20);
            j.setColor(color);
            j.fillOval(x2 + 6, y2 - 7, 5, 5);
            j.drawString(String.valueOf(peso), a + 7, b + 12);
        } else if (x1 < x2 && y1 <= y2) {
            a = (x1) + ((x2 - x1) / 2);
            b = (y2) - (y2 - y1) / 2;
            j.drawLine(x1 - 5, y1 + 3, x2 - 16, y2 - 8);
            j.fillRect(a, b, 20, 20);
            j.setColor(color);
            j.fillOval(x2 - 16, y2 - 8, 5, 5);
            j.drawString(String.valueOf(peso), a + 7, b + 12);
        } else if (x1 >= x2 && y1 >= y2) {
            a = (x1) + ((x2 - x1) / 2);
            b = (y2) + (y1 - y2) / 2;
            j.drawLine(x1 - 16, y1 - 8, x2, y2);
            j.fillRect(a, b, 20, 20);
            j.setColor(color);
            j.fillOval(x2, y2, 5, 5);
            j.drawString(String.valueOf(peso), a + 7, b + 12);
        }
    }

    public void borrarCamino(int x1, int y1, int x2, int y2, int peso, boolean destino) {
        int a, b;
        j.setColor(Color.white);
        if (x1 == x2 && y1 == y2) {
            j.setColor(Color.white);
            j.drawArc(x1 - 3, y1 - 10, 30, 30, 180, 270);
            j.fillRect(x1 + 5, y1, 15, 15);
            j.drawString(String.valueOf(peso), x1 + 10, y1 + 13);
        } else if (x1 < x2 && y1 >= y2) {
            a = ((x1) + ((x2 - x1) / 2));
            b = ((y1) - ((y1 - y2) / 2));
            j.drawLine(x1 + 8, y1 - 8, x2 - 16, y2 - 8);
            j.fillRect(a, b, 20, 20);
            if (!destino) {
                j.setColor(Color.darkGray);
                j.fillOval(x2 - 20, y2 - 8, 5, 5);
            }
            j.setColor(Color.white);
            j.drawString(String.valueOf(peso), a + 7, b + 12);
        } else if (x1 >= x2 && y1 <= y2) {
            a = (x1) + ((x2 - x1) / 2);
            b = (y2) - (y2 - y1) / 2;
            j.drawLine(x1 - 8, y1 + 3, x2 + 8, y2 - 2);
            j.fillRect(a, b, 20, 20);
            if (!destino) {
                j.setColor(Color.darkGray);
                j.fillOval(x2 + 6, y2 - 7, 5, 5);
            }
            j.setColor(Color.white);
            j.drawString(String.valueOf(peso), a + 7, b + 12);
        } else if (x1 < x2 && y1 <= y2) {
            a = (x1) + ((x2 - x1) / 2);
            b = (y2) - (y2 - y1) / 2;
            j.drawLine(x1 - 5, y1 + 3, x2 - 16, y2 - 8);
            j.fillRect(a, b, 20, 20);
            if (!destino) {
                j.setColor(Color.darkGray);
                j.fillOval(x2 - 16, y2 - 8, 5, 5);
            }
            j.setColor(Color.white);
            j.drawString(String.valueOf(peso), a + 7, b + 12);
        } else if (x1 >= x2 && y1 >= y2) {
            a = (x1) + ((x2 - x1) / 2);
            b = (y2) + (y1 - y2) / 2;
            j.drawLine(x1 - 16, y1 - 8, x2, y2);
            j.fillRect(a, b, 20, 20);
            if (!destino) {
                j.setColor(Color.darkGray);
                j.fillOval(x2, y2, 5, 5);
            }
            j.setColor(Color.white);
            j.drawString(String.valueOf(peso), a + 7, b + 12);
        }
    }

    public void conectarNodos() {
        String nodoO = "";
        String nodoD = "";
        int peso = 0;
        int posO, posD;
        nodoO = JOptionPane.showInputDialog("Ingrese Nodo origen");
        if (EncontrarEnArreglo(nodoO) != null) {
            posO = posicion(nodoO);
            nodoD = JOptionPane.showInputDialog("Ingrese Nodo destino");
            if (EncontrarEnArreglo(nodoD) != null) {
                posD = posicion(nodoD);
                int x1, x2, y1, y2;
                x1 = listaAdyacente.get(posO).getCordenadaX();
                y1 = listaAdyacente.get(posO).getCordenadaY();
                x2 = listaAdyacente.get(posD).getCordenadaX();
                y2 = listaAdyacente.get(posD).getCordenadaY();
                peso = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el peso del camino"));
                dibujarCamino(x1, y1, x2, y2, peso, Color.DARK_GRAY);
                Relaciones rel = new Relaciones(peso, listaAdyacente.get(posD).Clonar());
                listaAdyacente.get(posO).crearListaDeAdyacensia(rel);
            } else {
                JOptionPane.showMessageDialog(null, "El nodo: " + nodoD + " no existe");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El nodo: " + nodoO + " no existe");
        }
    }
    private void ConetarNodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConetarNodosMouseClicked
        conectarNodos();
    }//GEN-LAST:event_ConetarNodosMouseClicked

    private void MostrarRelacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MostrarRelacionesMouseClicked
        Algoritmo.MostrarListaDeAdyacensia();
    }//GEN-LAST:event_MostrarRelacionesMouseClicked
    public void eliminarNodo() {
//        String nodo;
//        boolean destino = false;
//        Graphics j = jPanel1.getGraphics();
//        if (creado) {
//            nodo = JOptionPane.showInputDialog("Ingrese el Nodo que a eliminar");
//            if (encontrar(nodo) != null) {
//                //ciclo para eliminar nodo
//                for (int i = 0; i < listaObjeto.size(); i++) {
//                    if (listaObjeto.get(i).getDatoDelNodo().equals(nodo)) {
//                        int x = listaObjeto.get(i).getCordenadaX(), y = listaObjeto.get(i).getY();
//                        String dato = listaObjeto.get(i).getDatoDelNodo();
//                        j.setColor(Color.white);
//                        j.drawOval(x - 19, y - 25, 30, 30);
//                        j.fillOval(x - 19, y - 25, 30, 30);
//                        j.drawString(dato, x - 7, y - 3);
//                    }
//                }
//                //ciclo para eliminar relaciones(caminos) que contengan el Nodo a eliminar
////                for (int i = 0; i < listaRelacion.size(); i++) {
////                    System.out.println("tamaño relacion: " + listaRelacion.size());
////                    if (listaRelacion.get(i).getNodoO().equals(nodo)
////                            || listaRelacion.get(i).getNodoD().equals(nodo)) {
////                        System.out.println("entro a borrar relacion");
////                        int peso = listaRelacion.get(i).getPeso();
////                        int posO = posicion(listaRelacion.get(i).getNodoO()), posD = posicion(listaRelacion.get(i).getNodoD());
////                        int x1, x2, y1, y2;
////                        x1 = listaObjeto.get(posO).getX();
////                        y1 = listaObjeto.get(posO).getY();
////                        x2 = listaObjeto.get(posD).getX();
////                        y2 = listaObjeto.get(posD).getY();
////                        if (listaRelacion.get(i).getNodoD().equals(nodo)) {
////                            destino = true;
////                        }
////                        borrarCamino(x1, y1, x2, y2, peso, destino);
////                        destino = false;
////                        listaRelacion.remove(i);
////                        i--;
////                    }
//                }
//                //eliminar Nodo de nuestra lista de Nodos
//                //posicion encuentra la pos del nodo
//                System.out.println("nodo a eliminar: " + listaObjeto.get(posicion(nodo)).getDatoDelNodo());
//                listaObjeto.remove(posicion(nodo));
////                listaRelacion.size();
////                //Rehacer ;
////                Algoritmo.crearMatriz();
////                Algoritmo.eliminarListaDeAdyacensia(nodo);
//
//            } else {
//                JOptionPane.showMessageDialog(null, "El nodo no existe");
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Relaciones no creadas");
        String nodo = JOptionPane.showInputDialog("Ingrese el Nodo que a eliminar");
        Algoritmo.eliminarListaDeAdyacensia(nodo);
//        }
    }
    private void btnEliminarNodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarNodoMouseClicked
        eliminarNodo();
    }//GEN-LAST:event_btnEliminarNodoMouseClicked

    private void MostrarNodosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MostrarNodosMouseMoved
        Descripcion.setVisible(true);
        Descripcion.setText("Algoritmo Dijkstra (D)");
    }//GEN-LAST:event_MostrarNodosMouseMoved

    private void MostrarNodosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MostrarNodosMouseExited
        Descripcion.setVisible(false);
    }//GEN-LAST:event_MostrarNodosMouseExited

    private void ConetarNodosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConetarNodosMouseEntered
        Descripcion.setVisible(true);
        Descripcion.setText("Conectar Nodos (C)");
    }//GEN-LAST:event_ConetarNodosMouseEntered

    private void ConetarNodosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConetarNodosMouseExited
        Descripcion.setVisible(false);
    }//GEN-LAST:event_ConetarNodosMouseExited

    private void MostrarRelacionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MostrarRelacionesMouseEntered
        Descripcion.setVisible(true);
        Descripcion.setText("Mostrar Relaciones (R)");
    }//GEN-LAST:event_MostrarRelacionesMouseEntered

    private void MostrarRelacionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MostrarRelacionesMouseExited
        Descripcion.setVisible(false);
    }//GEN-LAST:event_MostrarRelacionesMouseExited

    private void btnEliminarNodoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarNodoMouseEntered
        Descripcion.setVisible(true);
        Descripcion.setText("Eliminar Nodo (B)");
    }//GEN-LAST:event_btnEliminarNodoMouseEntered

    private void btnEliminarNodoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarNodoMouseExited
        Descripcion.setVisible(false);
    }//GEN-LAST:event_btnEliminarNodoMouseExited

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_D:
                Algoritmo.mostrarCaminoMInimo();
                break;
            case KeyEvent.VK_B:
                eliminarNodo();
                break;
            case KeyEvent.VK_C:
                conectarNodos();
                break;
            case KeyEvent.VK_R:
                Algoritmo.MostrarListaDeAdyacensia();
                Algoritmo.crearMatriz();
                Algoritmo.mostrarMatriz();
                break;
        }
    }//GEN-LAST:event_formKeyPressed

    public JPanel getPanelDeDibujo() {
        return PanelDeDibujo;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Grafos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grafos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grafos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grafos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grafos().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConetarNodos;
    private java.awt.Label Descripcion;
    private javax.swing.JButton MostrarNodos;
    private javax.swing.JButton MostrarRelaciones;
    private javax.swing.JPanel PanelDeDibujo;
    private javax.swing.JButton btnEliminarNodo;
    // End of variables declaration//GEN-END:variables
}
