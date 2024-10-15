package sistemaAutogestion;


public interface IObligatorio {
    
    /*
    **************** REGISTROS **************************************
    */
    
    //pre:      post:
    public Retorno crearSistemaDeGestion();;
    

    //Pre: Los datos son ingresados y no son nulos, No existe una aerolinea con el mismo codigo, y la cantidad de aviones es mayor a 0
    //Post: Se agrega la aerolinea a la lista de aerolineas.
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones); 
    

    //Pre: El nombre que se ingresa no es nulo, existe una aerolinea registrada con ese nombre en la lista de aerolienas y no tiene aviones registrados
    //Pre: Vuelos/Pasajes
    //Post: La aerolinea con el nombre ingresado se elimina de la lista.
    public  Retorno eliminarAerolinea(String nombre);; 
    
    //Pre: Los datos ingresados no son nulos, Existe una aerolinea con el nombre aerolinea ingresado.
    //Pre: La aerolinea encontrada no posee un avion registrado con el codigo avion ingresado
    //Pre: La capacidad maxima de el avion es menor a la mayor capacidad soportada por la aerolinea
    //Pre: La capacidad maxima ingresada para el avion es mayor igual a 9 y multiplo de 3
    //Post: Se registra el avion ingresado a la lista de aviones de la aerolinea ingresada
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea);; 
   
    //Pre: Los datos ingresados no son nulos
    //Pre: El nombreAerolinea existe en una aerolinea de la lista de aerolineas del sistema
    //Pre: El codAvion existe en un avion que pertenece a la lista de aviones de la aerolinea buscada
    //Pre: No existen vuelos en la lista de vuelos de la aerolinea registrados con el avion encontrado
    //Post: El avion se elimina de la lista de aviones de la aerolinea buscada.
    public Retorno eliminarAvion(String nomAerolinea, String codAvion); 
    
    //Pre: Los datos ingresados no son nulos
    //Pre: La edad ingresada es mayor o igual a 0
    //Pre: El numero de pasaporte posee exactamente 7 caracteres
    //Pre: No existe un cliente registrado en la lista de clientes con el mismo pasaporte
    public Retorno registrarCliente(String pasaporte, String nombre, int edad);
    
      /*
    **************** GESTIÓN DE VUELOS Y PASAJES **************************************
    */
    
    //Pre: Los datos ingresados no son nulos
    //Pre: No existe un vuelo en la lista de vuelos de la aerolinea registrado con el mismo codigoVuelo
    //Pre: El nombreAerolinea ingresado existe en la lista de aerolineas registradas en el sistema
    //Pre: El codigoAvion existe en uno de los aviones de la lista de aviones de la aerolinea buscada
    //Pre: No existe un vuelo en la lista de vuelos de la aerolinea que tenga programado el mismo dia/mes/ano ingresado y coincida el codigoAvion registrado con el ingresado
    //Pre: La cantidad de pasajes de ambas categorias son multiplos de 3
    //Pre: La suma de los pasajes ingresados no supera la cantidad de pasajes maximos del avion encontrado
    //Post: Se registra un vuelo en la lista de vuelos de la aerolinea ingresada que incluye los datos ingresados
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase);
    
    //Pre: Los datos ingresados no son nulos
    //Pre: Existe un cliente en la lista de clientes que posee el pasaporteCliente ingresado
    //Pre: El codigo de vuelo ingresado existe en la lista de vuelos de la aerolinea a la que pertenece el vuelo
    //Post: En caso de que en el vuelo hayan disponibles pasajes de la categoria seleccionada se creara el vuelo con estado OK
    //Post: En caso de que en el vuelo no hayan disponibles pasajes de la categoria seleccionada se creara el vuelo con estado Oendiente
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje);
    
    //Pre: Existe un cliente en la lista de clientes con el pasaporteCliente ingresado
    //Pre: Existe un vuelo en la lista de vuelos con el codigoVuelo ingresado
    //Pre: Existe un pasaje con el pasaporteCliente ingresado y posee el codigoVuelo con el codigoVuelo ingresado
    //Post: Se realizara la devolucion del pasaje eliminandolo de la lista
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo);

     /*
    **************** REPORTES Y CONSULTAS **************************************
    */
    //Pre: La lista de aerolineas posee aerolineas registradas
    //Post: Se muestra la lista de Aerolineas
    public Retorno listarAerolineas();
    
    //Pre: Existe una aerolinea en la lista de aerolineas registrada con el nombre ingresado
    //Pre: La lista de aviones de la aerolinea encontrada no esta vacia
    //Post: Se muestra la lista de aviones de la aerolinea ingresadas ordenadas alfabeticamente
    public Retorno listarAvionesDeAerolinea(String nombre);
    
    //Pre: La lista de clientes posee clientes registrados
    //Post: Se muestra la lsita de clientes registrados
    public Retorno listarClientes();
    
    //Pre: La lista de vuelos posee vuelos registrados
    //Post: Se muestra el codigo de vuelo, aerolinea a la que pertenece, codigo de avion y pasajes de cada categoria de los vuelos registrados empezando por el ultimo en orden segun las categorias Economico y PrimeraClase
    public Retorno listarVuelos();
    
    //Pre: Existe un cliente en la lista de clientes con el pasaporte ingresado
    //Pre: El cliente posee al menos 1 vuelo registrado
    //Post: Se muestran los vuelos del cliente
    public Retorno vuelosDeCliente(String pasaporte);
    
    //Pre: Existe una aerolinea con el nombreAerolinea ingresado
    //Pre: La aerolinea encontrada posee al menos 1 vuelo devuelto
    //Post: Se muestra el pasaporte del cliente y vuelo de cada pasaje devuelto por la aerolinea encontrada
    public Retorno pasajesDevueltos(String nombreAerolinea);
    
    //Pre: Existe un vuelo con el codigoVuelo ingresado en la lista de Vuelos
    //Post: Se muestra la distribucion de pasajeros en el avion segun las diferentes categorias de pasajes ofrecidos y vendidos. 
    public Retorno vistaDeVuelo(String codigoVuelo);
    
    
    
}
