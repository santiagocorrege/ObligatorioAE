/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaAutogestion.Entidades;

import sistemaAutogestion.Entidades.Cliente;

/**
 *
 * @author Ryzen
 */
public class Pasaje {

    private Cliente _cliente; 
    private int _categoriaPasaje;
    private String _codigoVuelo;
    
    public Pasaje(Cliente cliente, int categoria, String codigoVuelo){
        _cliente = cliente;
        _categoriaPasaje = categoria;
        _codigoVuelo = codigoVuelo;
    }
    
    @Override
    public String toString(){
        return "==Cliente==\nPasaje: " + _cliente.toString() + "\nCategoria(Primera = 1/ Economica = 2): " + _categoriaPasaje + "\nCodigo Vuelo: " + _codigoVuelo + "\n";
    }
    
    public String getCodigoVuelo() {
        return _codigoVuelo;
    }

    public void setCodigoVuelo(String _codigoVuelo) {
        this._codigoVuelo = _codigoVuelo;
    }
    
        public Cliente getCliente() {
        return _cliente;
    }

    public void setCliente(Cliente _cliente) {
        this._cliente = _cliente;
    }

    public int getCategoriaPasaje() {
        return _categoriaPasaje;
    }

    public void setCategoriaPasaje(int _categoriaPasaje) {
        this._categoriaPasaje = _categoriaPasaje;
    }
    


}
