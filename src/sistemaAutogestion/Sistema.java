package sistemaAutogestion;

import sistemaAutogestion.Entidades.Aerolinea;
import sistemaAutogestion.Entidades.Avion;
import sistemaAutogestion.Entidades.Cliente;
import sistemaAutogestion.Entidades.Pasaje;
import sistemaAutogestion.Entidades.Vuelo;

public class Sistema implements IObligatorio {
    private Lista _listaAerolineas;
    private Lista _listaClientes;
    private Lista _listaVuelos;

    
    public Sistema(){
        //No se especifica tope para cantidad de aerolineas ni de clientes 
        _listaAerolineas = new Lista(-1);
        _listaClientes = new Lista(-1);
        _listaVuelos = new Lista(-1);                
    }

    public Lista getListaAerolineas() {
        return _listaAerolineas;
    }

    public void setListaAerolineas(Lista _listaAerolineas) {
        this._listaAerolineas = _listaAerolineas;
    }

    public Lista getListaClientes() {
        return _listaClientes;
    }

    public void setListaClientes(Lista _listaClientes) {
        this._listaClientes = _listaClientes;
    }
    
        public Lista getListaVuelos() {
        return _listaVuelos;
    }

    public void setListaVuelos(Lista _listaVuelos) {
        this._listaVuelos = _listaVuelos;
    }

    public Retorno eliminarCliente(String pasaporte) {
        if(pasaporte == null){
            System.out.println("El pasaporte del cliente a eliminar no puede ser nulo\n");
            return Retorno.error1();
        }
        if(_listaClientes.EliminarElemento(pasaporte)){
            System.out.println("==CLIENTE " + pasaporte + " ELIMINADO==\n");
            return Retorno.ok();
        }else{
            System.out.println("Error: No existe un cliente con ese pasaporte\n");
            return new Retorno(Retorno.Resultado.ERROR_1);
        }
    }
    @Override
    public Retorno crearSistemaDeGestion() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorSistema = new Sistema();
        return ret;
    }

    @Override
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones) {
      Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
      if(nombre == null || pais == null || cantMaxAviones <= 0){
          ret.valorString = "Error 2: Los datos de la aerolinea no pueden ser nulos y la cantidada maxima de aviones debe ser superior a 0\n";
          ret.resultado = Retorno.Resultado.ERROR_2;
      }
      else if(!_listaAerolineas.AgregarOrdenadoAerolinea(new Nodo(new Aerolinea(nombre, pais, cantMaxAviones), nombre)))
      {
          ret.valorString = "Error 1: Ya existe un avion registrado con ese nombre";
          ret.resultado = Retorno.Resultado.ERROR_1;
      }
      else
      {
        ret.valorString = "==AEROLINEA " + nombre + " CREADA==\n";
        ret.resultado = Retorno.Resultado.OK;
      }
      return ret;
    }

    @Override
    public Retorno eliminarAerolinea(String nombre) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Nodo nodoAerolinea = _listaAerolineas.DevolverElemento(nombre);
        if(nodoAerolinea != null){
            Aerolinea aero = (Aerolinea) nodoAerolinea.getObjeto();
            if(aero.getListaAviones().getContadorNodos() == 0){
                _listaAerolineas.EliminarElemento(nombre);
                ret.valorString = "===AEROLINEA " + nombre + " ELIMINADA ===\n";
                ret.resultado = Retorno.Resultado.OK;
            }else{
                ret.valorString = "Error: La aerolinea no se puede eliminar porque posee aviones registrados\n";
                ret.resultado = Retorno.Resultado.ERROR_2;
            }
        }else{
            ret.valorString = "Error: la aerolinea que se intenta eliminar no existe\n";
            ret.resultado = Retorno.Resultado.ERROR_1;
        }
        return ret;
    }

    @Override
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if(!Avion.Validar(capacidadMax) || codigo == null || nomAerolinea == null){
            ret.valorString = "Error: La capacidad maxima del avion debe al menos igualar los 9 pasajeros y ser multiplo de 3\n";
            ret.resultado = Retorno.Resultado.ERROR_2;
            return ret;
        }
        Nodo nodoAerolinea = _listaAerolineas.DevolverElemento(nomAerolinea);
        if(nodoAerolinea != null){
            Aerolinea aeroLinea = (Aerolinea) nodoAerolinea.getObjeto();
            //CAMBIO
            if(aeroLinea.getListaAviones().getContadorNodos() == aeroLinea.getListaAviones().getLimite()){
                ret.valorString = "Error: La capacidad maxima del avion no puede superar el limite de la aerolinea\n";
                ret.resultado = Retorno.Resultado.ERROR_4;
                return ret;
            }
            if(aeroLinea.getListaAviones().Agregar(new Nodo(new Avion(codigo, capacidadMax), codigo))){
                ret.valorString = "===AVION " + codigo + " AGREGADO ===\n";
                ret.resultado = Retorno.Resultado.OK;
                return ret;
            }else{
                ret.valorString = "Error: Ya existe un avion con ese codigo\n";
                ret.resultado = Retorno.Resultado.ERROR_1;
                return ret;
            }
        }else{
            ret.valorString = "Error: No existe ninguna aerolinea con ese nombre\n";
            ret.resultado = Retorno.Resultado.ERROR_3;
        }
        return ret;
    }
    //CUIDADO AL RECORRER VACIA

    @Override
    public Retorno eliminarAvion(String nomAerolinea, String codAvion) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Nodo nodoAerolinea = _listaAerolineas.DevolverElemento(nomAerolinea);
        if(nodoAerolinea != null){
            Aerolinea aeroLinea = (Aerolinea) nodoAerolinea.getObjeto();
            Nodo nodoAvion = aeroLinea.getListaAviones().DevolverElemento(codAvion);
            if(nodoAvion != null){
                Lista vuelosAerolinea = aeroLinea.getListaVuelos();
                Nodo aux = vuelosAerolinea.getPrimero();
                while(aux != null){
                    Vuelo vuelo = (Vuelo) aux.getObjeto();
                    if(vuelo.getAvion().getCodigo().equals(codAvion) && vuelo.getListaPasajes().getContadorNodos() > 0){
                        ret.valorString = "Error: No se puede eliminar el avion, tiene pasajes vendidos\n";
                        ret.resultado = Retorno.Resultado.ERROR_3;
                        return ret;
                    }
                    aux = aux.getSiguiente();
                }
                aeroLinea.getListaAviones().EliminarElemento(codAvion);
                ret.valorString = "==AVION " + codAvion + " ELIMINADO==\n";
                ret.resultado = Retorno.Resultado.OK;
            }else{
                ret.valorString = "Error: No existe ningun avion con ese codigo\n";
                ret.resultado = Retorno.Resultado.ERROR_2;
            }
        }else{
            ret.valorString = "Error: No existe ninguna aerolinea con ese nombre\n";
            ret.resultado = Retorno.Resultado.ERROR_1;
        }
        return ret;
    }
    
    @Override
    public Retorno registrarCliente(String pasaporte, String nombre, int edad) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Cliente cliente = new Cliente(pasaporte, nombre, edad);
        Nodo nodoCliente = new Nodo(cliente, pasaporte);
        if(edad < 0){
            ret.valorString = "Error: La edad no puede ser menor a 0\n";
            ret.resultado = Retorno.Resultado.ERROR_1;
        }else if(pasaporte != null && pasaporte.length() != 7){
            ret.valorString = "Error: El pasaporte debe poseer 7 digitos\n";
            ret.resultado = Retorno.Resultado.ERROR_2;
        }else if(_listaClientes.Agregar(nodoCliente)){
            ret.valorString = "==CLIENTE " + nombre + " AGREGADO==\n";
            ret.resultado = Retorno.Resultado.OK;
        }else{
            ret.valorString = "Error: Ya existe un cliente con ese pasaporte\n";
            ret.resultado = Retorno.Resultado.ERROR_3;
            }
        return ret;
        }

    @Override
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if(cantPasajesEcon < 3 || cantPasajesEcon % 3 != 0 || cantPasajesPClase < 3 || cantPasajesPClase % 3 != 0){
            ret.valorString = "Error: la cantidad de pasajes en ambas clase debe ser al menos de 3 y multiplo de 3 inclusive\n";
            ret.resultado = Retorno.Resultado.ERROR_5;
            return ret;
        }
        Nodo nodoAeroLinea = _listaAerolineas.DevolverElemento(aerolinea);
        if(nodoAeroLinea == null){
            ret.valorString = "Error: no existe la aerolinea a la que se desea agregar el vuelo\n";
            ret.resultado = Retorno.Resultado.ERROR_2;
            return ret;
        }
        
        Aerolinea aeroLineaInstancia = (Aerolinea) nodoAeroLinea.getObjeto();
        Nodo nodoAvion = aeroLineaInstancia.getListaAviones().DevolverElemento(codAvion);
        if(nodoAvion == null){
            ret.valorString = "Error: no existe el avion a el que se desea agregar el vuelo\n";
            ret.resultado = Retorno.Resultado.ERROR_3;
            return ret;
        }
        Avion avion = (Avion) nodoAvion.getObjeto();
        if(avion.getCapacidadMax() < cantPasajesEcon + cantPasajesPClase){
            ret.valorString = "Error: la suma de los pasajes no puede superar la capacidad maxima del avion\n";
            ret.resultado = Retorno.Resultado.ERROR_6;
            return ret;
        }
        
        Lista listaVuelosAerolinea = aeroLineaInstancia.getListaVuelos();
        Nodo aux = _listaVuelos.getPrimero();
        while(aux != null){
            Vuelo vuelo = (Vuelo) aux.getObjeto();
            if(vuelo.getCodigoVuelo().equals(codigoVuelo)){
                ret.valorString = "Error: ya existe un vuelo con ese codigo en el sistema\n";
                ret.resultado = Retorno.Resultado.ERROR_1;
                return ret;
            }else if(vuelo.getDia() == dia && vuelo.getMes() == mes && vuelo.getAno() == año && vuelo.getAvion().getCodigo().equals(codAvion)){
                ret.valorString = "Error: el avion tiene un vuelo registrado para la fecha\n";
                ret.resultado = Retorno.Resultado.ERROR_4;
                return ret;
            }
            aux = aux.getSiguiente();
        }
        Vuelo vuelo = new Vuelo(codigoVuelo, aerolinea, avion, paisDestino, dia, mes, año, cantPasajesEcon, cantPasajesPClase);
        Nodo nodoVuelo = new Nodo(vuelo, codigoVuelo);
        listaVuelosAerolinea.Agregar(nodoVuelo);
        _listaVuelos.Agregar(nodoVuelo);
        ret.valorString = "==VUELO " + codigoVuelo + " AGREGADO==\n";
        ret.resultado = Retorno.Resultado.OK;
        return ret;
    }

    @Override
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoriaPasaje) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Nodo nodoCliente = _listaClientes.DevolverElemento(pasaporteCliente);
        if(nodoCliente == null){
            ret.valorString = "Error: el pasaporte ingresado no existe en el sistema \n";
            ret.resultado = Retorno.Resultado.ERROR_1;
            return ret;
        }
        Nodo nodoVuelo = _listaVuelos.DevolverElemento(codigoVuelo);
        if(nodoVuelo == null){
            ret.valorString = "Error: el vuelo ingresado no existe en el sistema \n";
            ret.resultado = Retorno.Resultado.ERROR_2;
            return ret;
        }else{
            Vuelo vuelo = (Vuelo) nodoVuelo.getObjeto();
            Cliente cliente = (Cliente) nodoCliente.getObjeto();
            //Nota: Comprar pasaje tiene la lista de espera y automaticamente encola los pasajes que exeden los disponibles.
            Nodo nodoPasajeComprado = vuelo.ComprarPasaje(cliente, codigoVuelo, categoriaPasaje);
            if(nodoPasajeComprado == null){                                
                ret.valorString = "==LISTA DE ESPERA PASAJE AGREGADO A LISTA DE ESPERA==\n";               
                ret.resultado = Retorno.Resultado.OK;                                          
                return ret;
            }else{                
                ret.valorString = "==PASAJE " + nodoPasajeComprado.getClave() + " AGREGADO==\n"; 
                ret.resultado = Retorno.Resultado.OK;
                //Se hace para que no tenga las referencias del nodo en la otra lista
                Nodo nodoNuevoPasajeComprado = new Nodo(nodoPasajeComprado.getObjeto(), nodoPasajeComprado.getClave());
                cliente.getListaPasajes().Agregar(nodoNuevoPasajeComprado);
                Nodo nodoNuevoVueloComprado = new Nodo(nodoVuelo.getObjeto(), nodoVuelo.getClave());
                cliente.getListaVuelos().Agregar(nodoNuevoVueloComprado);
                //_listaPasajes
                return ret;
            }                  
        }
    }

    @Override
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Nodo nodoCliente = _listaClientes.DevolverElemento(pasaporteCliente);
        if(nodoCliente == null){
            ret.resultado = Retorno.Resultado.ERROR_1;
            ret.valorString = "Error: El pasaporte ingresado no existe en el sistema";
            return ret;
        }
        Nodo nodoVuelo = _listaVuelos.DevolverElemento(codigoVuelo);
        if(nodoVuelo == null){
            ret.resultado = Retorno.Resultado.ERROR_2;
            ret.valorString = "Error: El codigo de vuelo ingresado no existe en el sistema";
            return ret;
        }
        Vuelo vuelo = (Vuelo) nodoVuelo.getObjeto();        
        String clave = pasaporteCliente + codigoVuelo;
        Nodo nodoPasajeComprado = vuelo.getListaPasajes().DevolverElemento(clave);
        if(nodoPasajeComprado == null){
            ret.resultado = Retorno.Resultado.ERROR_3;
            ret.valorString = "Error: No existe un pasaje comprado por ese cliente en el vuelo ingresado";
            return ret;
        }
        ret.resultado = Retorno.Resultado.OK;
        ret.valorString = "==PASAJE " + clave + " DEVUELTO ==\n";
        Pasaje pasaje = (Pasaje) nodoPasajeComprado.getObjeto();
        Cliente cliente = (Cliente) nodoCliente.getObjeto(); 
        cliente.getListaVuelos().EliminarElemento(codigoVuelo);
        cliente.getListaPasajes().EliminarElemento(clave);

        //Nuevo nodo -> Para la lista Cliente
        Nodo nodoNuevoPasajeDevuetoCliente = new Nodo(nodoPasajeComprado.getObjeto(), nodoPasajeComprado.getClave());
        cliente.getListaPasajesDevueltos().Agregar(nodoNuevoPasajeDevuetoCliente);  

        //Nuevo nodo -> Para la lista Aerolinea -> Se que la aerolinea no es null porque si no no se hubiese podido crear el vuelo
        NodoCola nodoNuevoPasajeDevueltoAeroliena = new NodoCola(nodoPasajeComprado.getObjeto(), nodoPasajeComprado.getClave());
        Aerolinea aerolinea = (Aerolinea) _listaAerolineas.DevolverElemento(vuelo.getAerolinea()).getObjeto();
        aerolinea.getColaPasajesDevueltos().encolar(nodoNuevoPasajeDevueltoAeroliena);
        
        vuelo.DevolverPasaje(clave, pasaporteCliente,pasaje.getCategoriaPasaje(), nodoVuelo);               
        return ret;
    }

    @Override
    public Retorno listarAerolineas() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = _listaAerolineas.MostrarString();
        return ret;
    }

    @Override
    public Retorno listarAvionesDeAerolinea(String nombre) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Nodo nodoAerolinea = _listaAerolineas.DevolverElemento(nombre);
        if(nodoAerolinea == null){
            ret.valorString = "Error: La Aerolinea no existe";
            ret.resultado = Retorno.Resultado.ERROR_1;
        }else{
            Aerolinea aero = (Aerolinea) nodoAerolinea.getObjeto();
            ret.valorString = aero.getListaAviones().MostrarString();
            ret.resultado = Retorno.Resultado.OK;
        }
        return ret;
    }

    @Override
    public Retorno listarClientes() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = _listaClientes.MostrarString();
        return ret;
    }

    @Override
    public Retorno listarVuelos() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = _listaVuelos.MostrarString();
        return ret;
    }

    @Override
    public Retorno vuelosDeCliente(String pasaporte) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);    
        Nodo nodoCliente = _listaClientes.DevolverElemento(pasaporte);
        if(nodoCliente == null){
            ret = new Retorno(Retorno.Resultado.ERROR_1);
            ret.valorString = "Error: No existe ese pasaporte registrado en el sistema";            
        }else{
            ret = new Retorno(Retorno.Resultado.OK);
            Cliente cliente = (Cliente) nodoCliente.getObjeto();
            ret.valorString = cliente.listarVuelos();            
        }
        return ret;
    }

    @Override
    public Retorno pasajesDevueltos(String nombreAerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Nodo nodoAerolinea = _listaAerolineas.DevolverElemento(nombreAerolinea);
        if(nodoAerolinea == null){
            ret.resultado = Retorno.Resultado.ERROR_1;
            ret.valorString = "Error: No existe una aerolinea registrada con ese nombre en el sistema";
        }else{
            ret.resultado = Retorno.Resultado.OK;
            ret.valorString = "==Vuelos devueltos aerolinea" + nombreAerolinea + " ==\n" ;
            Aerolinea aero = (Aerolinea) nodoAerolinea.getObjeto();
            ret.valorString += aero.getColaPasajesDevueltos().toString();            
        }
        return ret;
    }

    @Override
    public Retorno vistaDeVuelo(String codigoVuelo) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Nodo nodoVuelo = _listaVuelos.DevolverElemento(codigoVuelo);
        if(nodoVuelo == null){
            ret.resultado = Retorno.Resultado.ERROR_1;
            ret.valorString = "Error: No existe el vuelo ingresado";
        }else{
            ret.resultado = Retorno.Resultado.OK;
            ret.valorString = "==Vuelo " + nodoVuelo.getClave() + " MOSTRADO==\n\n"; 
            Vuelo vuelo = (Vuelo) nodoVuelo.getObjeto();
            ret.valorString += vuelo.getMatrizAsientos().mostrarMatrizString();
            //vuelo.getMatrizAsientos().mostrarMatriz();
        }
        return ret;
    }

}
