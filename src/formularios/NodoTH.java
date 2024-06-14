/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formularios;

/**
 *
 * @author eswinpineda
 */
public class NodoTH {
    private String nombre;
    private int telefono;
    private String correo;
    private NodoTH sig;
    
    NodoTH(String pnom, int ptel, String pcor)
    {
        nombre = pnom;
        telefono = ptel;
        correo = pcor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public NodoTH getSig() {
        return sig;
    }

    public void setSig(NodoTH sig) {
        this.sig = sig;
    }
    
}
