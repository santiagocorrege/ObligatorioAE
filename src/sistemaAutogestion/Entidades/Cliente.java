/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaAutogestion.Entidades;

import sistemaAutogestion.Lista;

/**
 *
 * @author Ryzen
 */
public class Cliente {
    private String _pasaporte;
    private String _nombre;
    private int _edad;
    private Lista _listaVuelos;
    private Lista _listaPasajes;
    private Lista _listaPasajesDevueltos;
    
    public Cliente(String pasaporte, String nombre, int edad){
        _pasaporte = pasaporte;
        _nombre = nombre;
        _edad = edad;
        _listaVuelos = new Lista(-1);
        _listaPasajes = new Lista(-1);
        _listaPasajesDevueltos = new Lista(-1);

    }


    public String listarVuelos(){
        String str = "";
        str += "\n=== VUELOS CLIENTE " + _pasaporte + " ===\n";
        str += "\n          ==CPR==\n\n";
        str += _listaVuelos.MostrarString() + "\n";
        str += "\n          ===DEV===\n";
        str += _listaPasajesDevueltos.MostrarString();        
        return str;
    }

    //METHODS
    @Override
    public String toString(){
        return "==Cliente==\nPasaporte:" + _pasaporte + "\nNombre: " + _nombre + "\nEdad: " + _edad + "\n";
    }
    
    
    public Lista getListaVuelos() {
        return _listaVuelos;
    }

    public void setListaVuelos(Lista _listaVuelos) {
        this._listaVuelos = _listaVuelos;
    }
    
    //PROPERTIES
    public String getPasaporte() {
        return _pasaporte;
    }

    public void setPasaporte(String _pasaporte) {
        this._pasaporte = _pasaporte;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public int getEdad() {
        return _edad;
    }

    public void setEdad(int _edad) {
        this._edad = _edad;
    }
    
    
    public Lista getListaPasajes() {
        return _listaPasajes;
    }

    public void setListaPasajes(Lista _listaPasajes) {
        this._listaPasajes = _listaPasajes;
    }

    
    public Lista getListaPasajesDevueltos() {
        return _listaPasajesDevueltos;
    }


}
