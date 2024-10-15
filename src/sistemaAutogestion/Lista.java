/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaAutogestion;

import sistemaAutogestion.Entidades.Aerolinea;

/**
 *
 * @author Ryzen
 */
public class Lista {
    Nodo _primero;
    Nodo _ultimo;
    int _contadorNodos;
    int _limite;

    public Lista(int limite){
        _primero = null;
        _ultimo = null;
        _contadorNodos = 0;        
        _limite = limite;
    }
    //METHODS - Agregar al principio mas eficiente
    public boolean Agregar(Nodo nodo){
        boolean operacion = true;
        if(EstaVacia()){
            _primero = nodo;
            _ultimo = nodo;
            _contadorNodos++;
        }else if(!Existe(nodo) && !EstaLlena()){
            nodo.setSiguiente(_primero);
            _primero = nodo;
            _contadorNodos++;
        }else{
            //System.out.println("Metodo.Error: El elemento que deseas agregar ya existe\n");
            operacion = false;
        }
        return operacion;
    }
    //CUIDADO QUE NO LA HICE BOOLEAN
    public void AgregarInicio(Nodo nodo){
        if (EstaLlena()) {
            //System.out.println("Lista llena, no puede agregar el elemento");
        } else {
            if (EstaVacia()) {
                _primero = nodo;
                _ultimo = nodo;
            } else {
                nodo.setSiguiente(_primero);
                _primero = nodo;
            }
            _contadorNodos++;
        }
    }
    
    public boolean AgregarFinal(Nodo nodo){
        boolean operacion = true;
        if(EstaVacia()){
            _primero = nodo;
            _ultimo = nodo;
            _contadorNodos++;
        }else if(!EstaLlena()){
            _ultimo.setSiguiente(nodo);
            _ultimo = nodo;
            _contadorNodos++;
        }else{
            //System.out.println("Metodo.Error: La lista esta llena\n");
            operacion = false;
        }
        return operacion;
    }
    
    public boolean EliminarElemento(String clave) {
        Nodo aux = _primero;
        boolean operacion = false;
        if (aux.Iguales(clave)) {
            operacion = true;
            this.EliminarInicio();
        } else {
            while (aux != null && aux.getSiguiente() != null && !operacion) {
                if (aux.getSiguiente().Iguales(clave)) {
                    aux.setSiguiente(aux.getSiguiente().getSiguiente());
                    operacion = true;
                    _contadorNodos --;
                }
                aux = aux.getSiguiente();
            }
        }
        if(!operacion){
            //System.out.println("Metodo.Error: No se pudo eliminar el elemento\n");
        }
        return operacion;
    }
    
    public boolean EliminarInicio(){
        boolean operacion = false;
        if (!this.EstaVacia()) {
            operacion = true;
            if(this._contadorNodos == 1){
                _primero.setSiguiente(null);                
                _primero = null;
                _ultimo = null;
                this._contadorNodos=0;
            }else{
                Nodo nodoEliminado = _primero;
                this.setPrimero(this._primero.getSiguiente());
                nodoEliminado.setSiguiente(null);
                this._contadorNodos--;
            }
        }else{
            //System.out.println("Metodo.Error: Lista vacia, no hay elementos para borrar\n");
        }
        return operacion;
    }
    public boolean EstaVacia(){
        return _primero == null;
    }
    
    public boolean EstaLlena(){
        return _contadorNodos == _limite;
    }
    
    public boolean Existe(Nodo nodo){
        boolean operacion = false;
        if(!EstaVacia()){
            Nodo aux = _primero;
            while(aux != null && !operacion){
                if(aux.Iguales(nodo)){
                    operacion = true;
                }
                aux = aux.getSiguiente();
            }    
        }
        return operacion;
    }
    
    public boolean Existe(String clave){
        boolean operacion = false;
        if(!EstaVacia()){
            Nodo aux = _primero;
            while(aux != null && !operacion){
                if(aux.Iguales(clave)){
                    operacion = true;
                }
                aux = aux.getSiguiente();
            }    
        }
        return operacion;
    }
    
    public void Mostrar(){
        if(!EstaVacia()){
            Nodo aux = _primero;
            while(aux != null){
                System.out.println(aux.getObjeto().toString());
                aux = aux.getSiguiente();
            }
        }else{
            System.out.println("Metodo.Error: La lista esta vacia\n");
        }
    }
    
    public String MostrarString(){
        if(!EstaVacia()){
            String lista = "";
            Nodo aux = _primero;
            while(aux != null){
                lista += aux.getObjeto().toString() + "\n";
                aux = aux.getSiguiente();
            }
            return lista;
        }else{
            return "La lista esta vacia\n";
        }
    }
    
    public Nodo DevolverElemento(String clave){
        Nodo aux = _primero;
        Nodo elemento = null;
        if(!EstaVacia()){
            while(aux != null && elemento == null){
                if(aux.Iguales(clave)){
                    elemento = aux;
                    return elemento;
                }
                aux = aux.getSiguiente();
            }
        }
        return elemento;
    }
    //Metodo Esclusivo Aerolinea
    public boolean AgregarOrdenadoAerolinea(Nodo nodo) {
        boolean operacion = true;
        if(EstaLlena()){
            System.out.println("La lista esta llena");
            operacion = false;
        }else if(!(nodo.getObjeto() instanceof Aerolinea))
        {
            System.out.println("El metodo insertar ordenado esta implementado unicamente para trabajar con Aerolineas");
            operacion = false;
        }
        else{
            Aerolinea aero = (Aerolinea) nodo.getObjeto();
            if(EstaVacia()){
                this.AgregarInicio(nodo);
            }else if(Existe(nodo)){ 
                operacion = false;
            }
            else{
                Aerolinea aeroPrimera = (Aerolinea) _primero.getObjeto();
                Aerolinea aeroUltima = (Aerolinea) _ultimo.getObjeto();
                if(aero.compareTo(aeroPrimera) <= 0){
                    AgregarInicio(nodo);
                }
                else if(aero.compareTo(aeroUltima) >= 0){
                    this.AgregarFinal(nodo);
                }else {
                    Nodo aux = _primero;
                    while (aux.getSiguiente() != null && ((Aerolinea)aux.getSiguiente().getObjeto()) != null && aero.compareTo((Aerolinea)aux.getSiguiente().getObjeto()) > 0) {
                        aux = aux.getSiguiente();
                    }
                    nodo.setSiguiente(aux.getSiguiente());
                    aux.setSiguiente(nodo);
                    _contadorNodos++;
                }
            }
        }
        return operacion;
    }
    
    //Metodo Esclusivo Aerolinea
//    public Nodo DevolverNodoAerolinea(String nombreAerolinea) {        
//        if(!(_primero.getObjeto() instanceof Aerolinea))
//        {
//            System.out.println("El metodo insertar ordenado esta implementado unicamente para trabajar con Aerolineas");
//            return null;
//        }
//        else{
//            Nodo aux = _primero;
//            while(aux != null){
//                Aerolinea aero = (Aerolinea) aux.getObjeto();
//                String nombreAero = aero.getNombre();
//                if(nombreAero.equals(nombreAerolinea)){
//                    return aux;
//                } 
//            }
//            return null;
//        }
//    }
    
    // PROPERTIES
    public Nodo getPrimero() {
        return _primero;
    }

    public void setPrimero(Nodo _primero) {
        this._primero = _primero;
    }

    public Nodo getUltimo() {
        return _ultimo;
    }

    public void setUltimo(Nodo _ultimo) {
        this._ultimo = _ultimo;
    }

    public int getContadorNodos() {
        return _contadorNodos;
    }

    public void setContadorNodos(int _contadorNodos) {
        this._contadorNodos = _contadorNodos;
    }

    public int getLimite() {
        return _limite;
    }

    public void setLimite(int _limite) {
        this._limite = _limite;
    }

}
