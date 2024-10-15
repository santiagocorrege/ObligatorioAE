/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaAutogestion;

/**
 *
 * @author Ryzen
 */
public class Nodo<T> {
    private T _objeto;
    private Nodo _siguiente;
    private String _clave;
    private Class<?> _tipo;
            
    public Nodo(T objeto, String clave) {
        _objeto = objeto;
        _siguiente = null;
        _tipo = objeto.getClass();
        _clave = clave;
    }

    public boolean Iguales (Nodo nodo){
        if(nodo == null){
            return false;
        }
        boolean tiposIguales = (_tipo != null && nodo._tipo != null) && _tipo.equals(nodo._tipo);
        boolean clavesIguales = (_clave != null && nodo._clave != null) && _clave.equals(nodo._clave);
        return tiposIguales && clavesIguales;
    }
    
    public boolean Iguales(String clave){
        return _clave.equals(clave);
    }
    
    public String getClave() {
        return _clave;
    }

    public void setClave(String _clave) {
        this._clave = _clave;
    }

    public T getObjeto() {
        return _objeto;
    }

    public void setObjeto(T _objeto) {
        this._objeto = _objeto;
    }

    public Nodo getSiguiente() {
        return _siguiente;
    }

    public void setSiguiente(Nodo _siguiente) {
        this._siguiente = _siguiente;
    }

    public Class<?> getTipo() {
        return _tipo;
    }

    public void setTipo(Class<?> _tipo) {
        this._tipo = _tipo;
    }

}
