/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaAutogestion;

/**
 *
 * @author Ryzen
 */
public class NodoCola<T> {
    private T _objeto;
    private NodoCola _anterior;
    private NodoCola _siguiente;
    private String _clave;
    private Class<?> _tipo;

            
    public NodoCola(T objeto, String clave) {
        _objeto = objeto;
        _anterior = null;
        _siguiente = null;
        _tipo = objeto.getClass();
        _clave = clave;
    }

    public boolean Iguales (Nodo nodo){
        if(nodo == null){
            return false;
        }
        boolean tiposIguales = (_tipo != null && nodo.getTipo() != null) && _tipo.equals(nodo.getTipo());
        boolean clavesIguales = (_clave != null && nodo.getClave() != null) && _clave.equals(nodo.getClave());
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

    public NodoCola getSiguiente() {
        return _siguiente;
    }

    public void setSiguiente(NodoCola _siguiente) {
        this._siguiente = _siguiente;
    }

    public NodoCola getAnterior() {
        return _anterior;
    }

    public void setAnterior(NodoCola _anterior) {
        this._anterior = _anterior;
    }
    
    public Class<?> getTipo() {
        return _tipo;
    }

    public void setTipo(Class<?> _tipo) {
        this._tipo = _tipo;
    }

}
