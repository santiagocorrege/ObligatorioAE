/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaAutogestion.Entidades;

import sistemaAutogestion.Cola;
import sistemaAutogestion.Lista;
import sistemaAutogestion.MatrizAsientos;
import sistemaAutogestion.Nodo;
import sistemaAutogestion.NodoCola;

/**
 *
 * @author Ryzen
 */
public class Vuelo {
    private String _codigoVuelo;
    private String _codigoAerolinea;
    private Avion _avion;
    private String _paisDestino;
    private int _dia;
    private int _mes;
    private int _ano;
    private int _cantidadPasajesEconomicos;
    private int _cantidadPasajesEconomicosRestantes;
    private int _cantidadPasajesPrimeraClase;
    private int _cantidadPasajesPrimeraClaseRestantes;
    private Lista _listaPasajes;
    private Cola _colaPasajesPendientesPrimeraClase;
    private Cola _colaPasajesPendientesEconomica;
    private MatrizAsientos _matrizAsientos;
    
    public Vuelo(String codigoVuelo, String codigoAerolinea, Avion avion, String paisDestino, int dia, int mes, int ano, int cantidadPEconomicos, int cantidadPPrimeraClase ){
        _codigoVuelo = codigoVuelo;
        _codigoAerolinea = codigoAerolinea;
        _avion = avion;
        _paisDestino = paisDestino;
        _dia = dia;
        _mes = mes;
        _ano = ano;
        _cantidadPasajesEconomicos = cantidadPEconomicos;
        _cantidadPasajesEconomicosRestantes = cantidadPEconomicos;
        _cantidadPasajesPrimeraClase = cantidadPPrimeraClase;
        _cantidadPasajesPrimeraClaseRestantes = cantidadPPrimeraClase;
        _listaPasajes = new Lista(cantidadPEconomicos + cantidadPPrimeraClase);
        _matrizAsientos = new MatrizAsientos(cantidadPEconomicos, cantidadPPrimeraClase);
        _colaPasajesPendientesPrimeraClase = new Cola();
        _colaPasajesPendientesEconomica = new Cola();
    }

    
    public Nodo ComprarPasaje(Cliente cliente, String codigoVuelo, int categoria){
        Pasaje pasaje = new Pasaje(cliente, categoria, codigoVuelo);
        //Podria hacer que la clave fuese codigo de vuelo + codigo asiento
        String clave = cliente.getPasaporte() + _codigoVuelo;
        Nodo nodoPasaje = new Nodo(pasaje, clave);
        if(categoria == 1){
            if(_cantidadPasajesPrimeraClaseRestantes == 0){
                NodoCola nodo = new NodoCola(pasaje, clave);
                _colaPasajesPendientesPrimeraClase.encolar(nodo);
                return null;
            }else{
                _cantidadPasajesPrimeraClaseRestantes--;
                _matrizAsientos.AgregarAsiento(pasaje);
                _listaPasajes.Agregar(nodoPasaje);                
                return nodoPasaje;
            }            
        }else if(categoria == 2){
            if(_cantidadPasajesEconomicosRestantes == 0){
                NodoCola nodo = new NodoCola(pasaje, clave);
                _colaPasajesPendientesEconomica.encolar(nodo);
                return null;    
            }else{
                _cantidadPasajesEconomicosRestantes--;
                _matrizAsientos.AgregarAsiento(pasaje);
                _listaPasajes.Agregar(nodoPasaje);
                return nodoPasaje;
            }
            
        }else{
            return null;
        }                
    }
    
    //La clase sistema ya comprobo la existencia
    public void DevolverPasaje(String clavePasaje, String pasaporteCliente, int categoria, Nodo nodoVuelo){           
        if(categoria == 1){
            _matrizAsientos.eliminarElemntoMatriz(clavePasaje);            
            if(_colaPasajesPendientesPrimeraClase.getCantidad() > 0){
                NodoCola nodoColaPasajeDesencolado = _colaPasajesPendientesPrimeraClase.desencolar();
                Pasaje pasaje = (Pasaje) nodoColaPasajeDesencolado.getObjeto();
                String clave = nodoColaPasajeDesencolado.getClave();
                Nodo nodoPasajeDesencolado = new Nodo(pasaje, clave);                
                _listaPasajes.Agregar(nodoPasajeDesencolado);
                Pasaje pasajeDesencoladoCliente = (Pasaje) nodoPasajeDesencolado.getObjeto();            
                _matrizAsientos.AgregarAsiento(pasajeDesencoladoCliente);
                Cliente clientePasajeDesencolado = pasajeDesencoladoCliente.getCliente();
                clientePasajeDesencolado.getListaPasajes().Agregar(nodoPasajeDesencolado);
                clientePasajeDesencolado.getListaVuelos().Agregar(nodoVuelo);  
            }
            
        }else{            
            _matrizAsientos.eliminarElemntoMatriz(pasaporteCliente);
            if(_colaPasajesPendientesEconomica.getCantidad() > 0){
                NodoCola nodoColaPasajeDesencolado = _colaPasajesPendientesEconomica.desencolar();
                Pasaje pasaje = (Pasaje) nodoColaPasajeDesencolado.getObjeto();
                String clave = nodoColaPasajeDesencolado.getClave();
                Nodo nodoPasajeDesencolado = new Nodo(pasaje, clave);                   
                _listaPasajes.Agregar(nodoPasajeDesencolado);
                Pasaje pasajeDesencoladoCliente = (Pasaje) nodoPasajeDesencolado.getObjeto();
                _matrizAsientos.AgregarAsiento(pasajeDesencoladoCliente);
                Cliente clientePasajeDesencolado = pasajeDesencoladoCliente.getCliente();
                clientePasajeDesencolado.getListaPasajes().Agregar(nodoPasajeDesencolado);
                clientePasajeDesencolado.getListaVuelos().Agregar(nodoVuelo);                
            }      
        }

        _listaPasajes.EliminarElemento(clavePasaje);
    }

    @Override
    public String toString(){        
        int pasajesPVendidos = _cantidadPasajesPrimeraClase - _cantidadPasajesPrimeraClaseRestantes;
        int pasajesEVendidos = _cantidadPasajesEconomicos - _cantidadPasajesEconomicosRestantes;
        return "==VUELO==\nCodigo Vuelo:" + _codigoVuelo + "\nCodigo Aerolinea: " + _codigoAerolinea + "\nCodigo Avion: " + _avion.getCodigo() + "\n=Pasajes Vendidos\nClase Economica: " + pasajesEVendidos + "\nPrimera Clase: " + pasajesPVendidos  + "\n";
    }
    
    
    public MatrizAsientos getMatrizAsientos() {
        return _matrizAsientos;
    }

    public void setMatrizAsientos(MatrizAsientos _matrizAsientos) {
        this._matrizAsientos = _matrizAsientos;
    }

    public String getCodigoAerolinea() {
        return _codigoAerolinea;
    }

    public void setCodigoAerolinea(String _codigoAerolinea) {
        this._codigoAerolinea = _codigoAerolinea;
    }

    public Lista getListaPasajes() {
        return _listaPasajes;
    }

    public void setListaPasajes(Lista _listaPasajes) {
        this._listaPasajes = _listaPasajes;
    }

    public String getCodigoVuelo() {
        return _codigoVuelo;
    }

    public void setCodigoVuelo(String _codigoVuelo) {
        this._codigoVuelo = _codigoVuelo;
    }

    public String getAerolinea() {
        return _codigoAerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this._codigoAerolinea = aerolinea;
    }

    public Avion getAvion() {
        return _avion;
    }

    public void setAvion(Avion _avion) {
        this._avion = _avion;
    }

    public String getPaisDestino() {
        return _paisDestino;
    }

    public void setPaisDestino(String _paisDestino) {
        this._paisDestino = _paisDestino;
    }

    public int getDia() {
        return _dia;
    }

    public void setDia(int _dia) {
        this._dia = _dia;
    }

    public int getMes() {
        return _mes;
    }

    public void setMes(int _mes) {
        this._mes = _mes;
    }

    public int getAno() {
        return _ano;
    }

    public void setAno(int _ano) {
        this._ano = _ano;
    }

    public int getCantidadPasajesEconomicos() {
        return _cantidadPasajesEconomicos;
    }

    public void setCantidadPasajesEconomicos(int _cantidadPasajesEconomicos) {
        this._cantidadPasajesEconomicos = _cantidadPasajesEconomicos;
    }

    public int getCantidadPasajesPrimeraClase() {
        return _cantidadPasajesPrimeraClase;
    }

    public void setCantidadPasajesPrimeraClase(int _cantidadPasajesPrimeraClase) {
        this._cantidadPasajesPrimeraClase = _cantidadPasajesPrimeraClase;
    }
    

}
