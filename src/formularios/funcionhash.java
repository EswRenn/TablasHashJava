/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formularios;

/**
 *
 * @author eswinpineda
 */
public class funcionhash extends ListaTH {
    protected int size;
    protected NodoTH buscar;
    
    int pSize = 20;
    ListaTH tabla[];
    
    public funcionhash(){
        size = pSize;
        tabla = new ListaTH[pSize];
    }
    
    public int hash(String nombre, int telefono, String correo)
    {
        int indice;
        int valor = 0;
        char[] ascii = nombre.toCharArray();
        for(char ch : ascii) {
            valor = valor += (int) ch;
        }
        indice = valor % size;
        return indice;
    }
    
    public void ingresar(String nom, int tel, String cor)
    {
        int indice = hash(nom, tel, cor);
        if (tabla[indice] == null) {
            tabla[indice] = new ListaTH();
        }
        tabla[indice].Insertar(nom, tel, cor);
    }
    
    public String Recorrer()
    {
        StringBuilder mostrar = new StringBuilder();
    for (int x = 0; x < size; x++) {
        mostrar.append("Indice ").append(x).append(": ");
        if (tabla[x] != null && tabla[x].inicio != null) {
            mostrar.append(formatearDatos(tabla[x])).append(" \n");
        } else {
            mostrar.append(" \n");
        }
    }
    return mostrar.toString();
    }
    
    private String formatearDatos(ListaTH lista) {
        StringBuilder datosFormateados = new StringBuilder();
    NodoTH actual = lista.inicio;
    boolean primerElemento = true; // Para controlar la inserción de "->"
    while (actual != null) {
        if (!primerElemento) {
            datosFormateados.append("      ->      ");
        } else {
            primerElemento = false;
        }
        datosFormateados.append(actual.getNombre()).append("\t\t")
                        .append(actual.getTelefono()).append("\t\t")
                        .append(actual.getCorreo());
        actual = actual.getSig();
    }
    datosFormateados.append(" ");
    return datosFormateados.toString();
    }
    
    public int buscarhash(String nom)
    {
        int indice;
        int valor = 0;
        char[] ascii = nom.toCharArray();
        for (char ch : ascii) {
            valor = valor += (int) ch;
        }
        indice = valor % size;
        return indice;
    }
    
    public String buscar(String referencia) {
        referencia = "";
        int indice = buscarhash(referencia);
        
        while (tabla[indice] != null) {
            if (tabla[indice].busqueda(referencia)) {
                
            }
        }
        indice = indice % size;
        return referencia;
    }
    
    public NodoTH buscarNodo(String nombre) {
        int indice = buscarhash(nombre);
        if (tabla[indice] != null) {
            return tabla[indice].buscarNodo(nombre);
        }
        return null;
    }
    

    public String actualizar(String nombreAntiguo, String nuevoNombre, int nuevoTelefono, String nuevoCorreo) {
        NodoTH nodo = buscarNodo(nombreAntiguo);
        if (nodo != null) {
            int oldIndex = buscarhash(nombreAntiguo);
            int newIndex = hash(nuevoNombre, nuevoTelefono, nuevoCorreo);

            // Eliminar del índice antiguo
            if (tabla[oldIndex] != null) {
                tabla[oldIndex].eliminar(nombreAntiguo);
            }

            // Insertar el nodo actualizado en el nuevo índice
            ingresar(nuevoNombre, nuevoTelefono, nuevoCorreo);
            return "Indice " + newIndex + ": " + nuevoNombre + "\t\t" + nuevoTelefono + "\t\t" + nuevoCorreo;
        }
        return "Nombre no encontrado";
    }

    public boolean eliminar(String nombre) {
        int indice = buscarhash(nombre);
        if (tabla[indice] != null) {
            boolean eliminado = tabla[indice].eliminar(nombre);
            return eliminado;
        }
        return false;
    }
}
