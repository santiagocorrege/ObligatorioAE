/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaAutogestion;

/**
 *
 * @author Ryzen
 */
public class Cola {
    private NodoCola _final;
    private NodoCola _inicio;
    private int _cantidad;
    
    public Cola(){
        _inicio = _final = null;    
        _cantidad = 0;
    }
    
    public void encolar(NodoCola nodo){   
        if(EstaVacia()){
            nodo.setAnterior(null);
            nodo.setSiguiente(null);
            _inicio = nodo;
            _final = nodo;            
        }else{            
            _final.setSiguiente(nodo);
            nodo.setAnterior(_final);
            _final = nodo;
        }
        _cantidad++;
    }
    
    public NodoCola desencolar(){        
        if(EstaVacia()){
            System.out.println("Error: La cola esta vacia");
            return null;
        }else{
            if(_cantidad == 1){
                NodoCola aux = _inicio;
                _inicio = null;
                _final = null;
                _cantidad--;            
                return aux;
            }else{
                NodoCola aux = _inicio;
                NodoCola nuevoFront = _inicio.getSiguiente();
                nuevoFront.setAnterior(null);
                _inicio = nuevoFront;
                _cantidad--;
                return aux;
            }
        }
    }
    
    public void mostrarCola() {
        if (EstaVacia()) {
            System.out.println("Error: La cola este vacia");
        } else {
            NodoCola aux = _inicio;
            while (aux != null) {
                System.out.println(aux.getObjeto().toString());  
                aux = aux.getSiguiente();
            }
        }
    }


    @Override
    public String toString(){
        String str = "";
        if (EstaVacia()) {
            str += "Error: La cola este vacia\n";
        } else {
            NodoCola aux = _inicio;
            while (aux != null) {
                str += aux.getObjeto().toString() + "\n";  
                aux = aux.getSiguiente();
            }
        }
        return str;
    }
    
    public int getCantidad() {
        return _cantidad;
    }

    public void setCantidad(int _cantidad) {
        this._cantidad = _cantidad;
    }
    
    public boolean EstaVacia(){
        return _inicio == null;
    }
    


}
