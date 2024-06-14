/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formularios;

/**
 *
 * @author eswinpineda
 */
public class ListaTH extends javax.swing.JFrame {
    protected NodoTH inicio;
    protected NodoTH Listath;
    protected NodoTH aux;
    
    ListaTH(){
        Listath = null;
        inicio = null;
    }
    
    public void Insertar(String n, int t, String c)
    {
        NodoTH nuevo = new NodoTH(n, t, c);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            nuevo.setSig(inicio);
            inicio = nuevo;
        }
    }
    
    public String recorrer()
    {
        StringBuilder mostrar = new StringBuilder();
        NodoTH aux = inicio;
        while (aux != null) {
            mostrar.append(aux.getNombre()).append("\t")
                   .append(aux.getTelefono()).append("\t")
                   .append(aux.getCorreo()).append("\n");
            aux = aux.getSig();
        }
        return mostrar.toString();
    }
    
    public NodoTH buscarNodo(String nombre) {
        NodoTH actual = inicio;
        while (actual != null) {
            if (actual.getNombre().equals(nombre)) {
                return actual;
            }
            actual = actual.getSig();
        }
        return null;
    }
    
    public boolean eliminar(String nombre) {
        NodoTH actual = inicio;
        NodoTH anterior = null;
        while (actual != null && !actual.getNombre().equals(nombre)) {
            anterior = actual;
            actual = actual.getSig();
        }
        if (actual != null) {
            if (anterior == null) {
                inicio = actual.getSig();
            } else {
                anterior.setSig(actual.getSig());
            }
            return true;
        }
        return false;
    }
    
    public boolean busqueda(String referencia) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
