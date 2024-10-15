/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaAutogestion.Entidades;

import sistemaAutogestion.Cola;
import sistemaAutogestion.Lista;


/**
 *
 * @author Ryzen
 */
public class Aerolinea implements Comparable<Aerolinea>{
    private String _nombre;
    private String _pais;
    private Lista _listaAviones;
    private Lista _listaPilotos;
    private Lista _listaVuelos;
    private Cola _colaPasajesDevueltos;
    
    public Aerolinea(String nombre, String pais, int cantMaxAviones){
        _nombre = nombre;
        _pais = pais;
        _listaAviones = new Lista(cantMaxAviones);
        //No se estipula una cantidad maxima de Pilotos y vuelos en la realidad planteada
        _listaPilotos = new Lista(-1);
        _listaVuelos = new Lista(-1);
        _colaPasajesDevueltos = new Cola();
    }


    
    @Override
    public int compareTo(Aerolinea otraAerolinea){
        return _nombre.compareTo(otraAerolinea.getNombre());
    }
    @Override
    public String toString(){
        return "==Aerolinea==\nNombre:" + _nombre + "\nPais: " + _pais + "\nCapacidad Aviones: " + _listaAviones.getLimite() + "\nCantidad Aviones: " + _listaAviones.getContadorNodos() + "\n\n";
    }
    
    public Cola getColaPasajesDevueltos() {
        return _colaPasajesDevueltos;
    }

    public void setColaPasajesDevueltos(Cola _colaPasajesDevueltos) {
        this._colaPasajesDevueltos = _colaPasajesDevueltos;
    }
    
    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getPais() {
        return _pais;
    }

    public void setPais(String _pais) {
        this._pais = _pais;
    }

    public Lista getListaAviones() {
        return _listaAviones;
    }

    public void setListaAviones(Lista _listaAviones) {
        this._listaAviones = _listaAviones;
    }

    public Lista getListaPilotos() {
        return _listaPilotos;
    }

    public void setListaPilotos(Lista _listaPilotos) {
        this._listaPilotos = _listaPilotos;
    }

    public Lista getListaVuelos() {
        return _listaVuelos;
    }

    public void setListaVuelos(Lista _listaVuelos) {
        this._listaVuelos = _listaVuelos;
    }
    

    
    
}
