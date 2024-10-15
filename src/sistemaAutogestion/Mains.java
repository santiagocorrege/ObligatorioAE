/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaAutogestion;

import sistemaAutogestion.Entidades.Vuelo;

/**
 *
 * @author Ryzen
 */
public class Mains {

    public static void main(String[] args) {
        Sistema s = new Sistema();
        Prueba p = new Prueba();
        JuegoDePrueba(s,p);
        
//        
//        Sistema sys = new Sistema();
//        sys.crearAerolinea("Aerolinea-21", "Uruguay", 50);
//        sys.crearAerolinea("Aerolinea-21", "Uruguay", 50);
//        sys.crearAerolinea("Aerolinea-22", "Uruguay", 50);
//        sys.eliminarAerolinea("Aerolinea-22");
//        sys.getListaAerolineas().Mostrar();
//        sys.registrarAvion("ZX-212", 24, "Aerolinea-21");
//        sys.registrarAvion("ZX-212", 12, "Aerolinea-21");
//        sys.registrarAvion("ZX-213", 270, "Aerolinea-21");
//        
//        //Nuevo vuelo: AEROLINEA Aero-21 , Avion ZX-212
//        sys.crearVuelo("000-A01", "Aerolinea-21", "ZX-212", "Portugal", 21, 2, 2024, 9, 9);
//        //Error: La aerolinea no se puede eliminar porque posee aviones registrados
//        sys.eliminarAerolinea("Aerolinea-21");
//        //Error: No se puede eliminar el avion, tiene pasajes vendidos
//        sys.eliminarAvion("Aerolinea-21", "ZX-212");
//        //Error: No existe ninguna aerolinea con ese nombre
//        sys.eliminarAvion("Aerolinea-22", "ZX-212");
//        //Error: No existe ningun avion con ese codigo
//        sys.eliminarAvion("Aerolinea-21", "ZX-213");
//        //Nueva Aerolinea: AEROLINEA Aerolinea-Metro
//        sys.crearAerolinea("Aerolinea-Metro", "Chile", 100);
//        sys.listarAerolineas();
//        sys.crearVuelo("000-A02", "Aerolinea-21", "ZX-212", "Portugal", 22, 2, 2024, 9, 9);
//        sys.listarAvionesDeAerolinea("Aerolinea-Metro");
//        sys.crearAerolinea("Zerolinea-21", "Uruguay", 50);
//        sys.crearAerolinea("Herolinea-21", "Uruguay", 50);
//        sys.crearAerolinea("Berolinea-21", "Uruguay", 50);
//        sys.listarAerolineas();
    }
    
    public static void JuegoDePrueba(Sistema s, Prueba p){
        //==================================================================1.1 Crear Sistema de Gestion-==================================================================
        //Prueba 1.1 - Crear Sistema de Gestion - Prueba
        p.ver(s.crearSistemaDeGestion().resultado, Retorno.Resultado.OK, "Prueba 1.1 - Crear Sistema de Gestion: " + s.crearSistemaDeGestion().valorSistema.toString());
        
        
        
        //==================================================================1.2 Crear Aerolinea-==================================================================
        //Prueba 1.2 - Crear Aerolinea - OK
        Retorno unodos = s.crearAerolinea("Aerolinea-21", "Uruguay", 50);
        p.ver(unodos.resultado, Retorno.Resultado.OK, "1.2 - Prueba: Agregar - Datos: (Aerolinea-21, Uruguay, 50) \n  Resultado: " + unodos.valorString);
        
        //Prueba 1.2 - Crear Duplicado - ERROR 1
        Retorno unodosE1 = s.crearAerolinea("Aerolinea-21", "Uruguay", 50);
        p.ver(unodosE1.resultado, Retorno.Resultado.ERROR_1, "1.2 - Prueba: Agregar Duplicado - Datos: (Aerolinea-21, Uruguay, 50) \n  Resultado: " + unodosE1.valorString);
        
        //Prueba 1.2 - Cantidad Aviones <= 0 - ERROR 2
        Retorno unodosE2 = s.crearAerolinea("Aerolinea-22", "Uruguay", 0);
        p.ver(unodosE2.resultado, Retorno.Resultado.ERROR_2, "1.2 - Prueba: Cantidad Aviones <= 0 - Datos: (Aerolinea-22, Uruguay, 0) \n  Resultado: " + unodosE2.valorString);
        
        
        
        //==================================================================1.3 Eliminar Aerolinea-==================================================================
        //Prueba 1.3 - Eliminar Aerolinea - OK
        Retorno unotres = s.eliminarAerolinea("Aerolinea-21");
        p.ver(unodos.resultado, Retorno.Resultado.OK, "1.3 - Prueba: Eliminar - Datos: (Aerolinea-21) \n  Resultado: " + unotres.valorString);
        
        //Prueba 1.3 - Eliminar Aerolinea inexistente - ERROR 1
        Retorno unotresE1 = s.eliminarAerolinea("Aerolinea-Inexistente");
        p.ver(unotresE1.resultado, Retorno.Resultado.ERROR_1, "1.3 - Prueba: Eliminar inexistente - Datos: (Aerolinea-Inexistente) \n  Resultado: " + unotresE1.valorString);
        
        //Prueba 1.3 - Eliminar Aerolinea con aviones registrados - ERROR 2 - (Queda la aerolinea y el avion registrados porque no se pueden elimianr)
        s.crearAerolinea("Aerolinea-21", "Uruguay", 50);
        s.registrarAvion("ZX-212", 24, "Aerolinea-21");
        Retorno unotresE2 = s.eliminarAerolinea("Aerolinea-21");
        p.ver(unotresE2.resultado, Retorno.Resultado.ERROR_2, "1.3 - Prueba: Eliminar con aviones registrados - Datos: (Aerolinea-21) \n  Resultado: " + unotresE2.valorString);
        
        
        
        //==================================================================1.4 Registrar Avion-==================================================================
        //Prueba 1.4 - Registrar Avion - OK (Uso Aerolinea 1.3 Eliminar Aerolinea con aviones registrados)
        Retorno unocuatro = s.registrarAvion("OK-233", 24, "Aerolinea-21");
        p.ver(unocuatro.resultado, Retorno.Resultado.OK, "1.4 - Prueba: Registrar Avion - Datos: (OK-233, 24, Aerolinea-21) \n  Resultado: " + unocuatro.valorString);
        
        //Prueba 1.4 - Registrar Avion Duplicado - ERROR 1  
        Retorno unocuatroE1 = s.registrarAvion("OK-233", 24, "Aerolinea-21");
        p.ver(unocuatroE1.resultado, Retorno.Resultado.ERROR_1, "1.4 - Prueba: Registrar Avion duplicado - Datos: (OK-233, 24, Aerolinea-21) \n  Resultado: " + unocuatroE1.valorString);
        
        //Prueba 1.4 - Registrar Avion capacidad maxima < 9 o no es multiplo de 3 - ERROR 2 - MENOR
        Retorno unocuatroE2 = s.registrarAvion("ER2-233", 6, "Aerolinea-21");
        p.ver(unocuatroE2.resultado, Retorno.Resultado.ERROR_2, "1.4 - Prueba: Registrar Avion capacidad maxima <9 - Datos: (ER2-233, 6, Aerolinea-21) \n  Resultado: " + unocuatroE2.valorString);
        
        //Prueba 1.4 - Registrar Avion capacidad maxima < 9 o no es multiplo de 3 - ERROR 2 - ALT MULTIPLO
        Retorno unocuatroE2v2 = s.registrarAvion("ER3-233", 14, "Aerolinea-21");
        p.ver(unocuatroE2v2.resultado, Retorno.Resultado.ERROR_2, "1.4 - Prueba: Registrar Avion capacidad maxima no es multiplo  - Datos: (ER3-233, 14, Aerolinea-21) \n  Resultado: " + unocuatroE2v2.valorString);
        
        //Prueba 1.4 - Registrar Avion aerolinea inexistente - ERROR 3
        Retorno unocuatroE3 = s.registrarAvion("NU-233", 24, "Aerolinea-INEXISTENTE");
        p.ver(unocuatroE3.resultado, Retorno.Resultado.ERROR_3, "1.4 - Prueba: Registrar Avion aerolinea inexistente - Datos: (NU-233, 24, Aerolinea-INEXISTENTE) \n  Resultado: " + unocuatroE3.valorString);
        
        //PRUEBA 1.4 - Registrar avion aerolinea supera la cantidad maxima aviones - ERROR 4 -> Agregado
        s.crearAerolinea("Pluna", "Uruguay", 2);
        s.registrarAvion("AA21", 9, "Pluna");
        s.registrarAvion("AA22", 9, "Pluna");
        Retorno unocuatroE4 = s.registrarAvion("AA2X", 9, "Pluna");
        p.ver(unocuatroE4.resultado, Retorno.Resultado.ERROR_4, "1.4 - Prueba: Registrar avion aerolinea supera la cantidad maxima aviones - Datos: (AA2X, 6, Pluna) \n  Resultado: " + unocuatroE4.valorString);
        
        
        
        //==================================================================1.5 Eliminar Avion-==================================================================
        //Prueba 1.5 - Eliminar Avion - OK
        Retorno unocinco = s.eliminarAvion("Aerolinea-21", "OK-233");
        p.ver(unocinco.resultado, Retorno.Resultado.OK, "1.5 - Prueba: Eliminar Avion  - Datos: (Aerolinea-21, OK-233) \n  Resultado: " + unocinco.valorString);
        
        //Prueba 1.5 - Eliminar Avion aerolinea inexistente - ERROR_1
        Retorno unocincoE1 = s.eliminarAvion("Aerolinea-INEXISTENTE", "OK-233");
        p.ver(unocincoE1.resultado, Retorno.Resultado.ERROR_1, "1.5 - Prueba: Eliminar Avion aerolinea inexistente - Datos: (Aerolinea-INEXSITENTE, OK-233) \n  Resultado: " + unocincoE1.valorString);
        
        //Prueba 1.5 - Eliminar Avion inexistente - ERROR_2
        Retorno unocincoE2 = s.eliminarAvion("Aerolinea-21", "E2-233");
        p.ver(unocincoE2.resultado, Retorno.Resultado.ERROR_2, "1.5 - Prueba: Eliminar Avion inexistente - Datos: (Aerolinea-21, E2-233) \n  Resultado: " + unocincoE2.valorString);
        
        //Prueba 1.5 - Eliminar Avion pasajes vendidos - ERROR_3 -> LA PRUEBA SE HACE CON VUELOS PORQUE PARA LA ENTREGA NO SE PIDIO EL RF COMPRAR PASAJE
        s.registrarAvion("E3-233", 27, "Aerolinea-21");
        s.crearVuelo("V33-122", "Aerolinea-21", "E3-233", "Mundo utopico", 12, 5, 2024, 12, 12);
        s.registrarCliente("AAA-022", "Blanes", 22);
        s.comprarPasaje("AAA-022", "V33-122", 1);
        Retorno unocincoE3 = s.eliminarAvion("Aerolinea-21", "E3-233");
        p.ver(unocincoE3.resultado, Retorno.Resultado.ERROR_3, "1.5 - Prueba: Eliminar Avion pasajes vendidos - Datos: (Aerolinea-21, E3-233) \n  Resultado: " + unocincoE3.valorString);
        
        
        
        //==================================================================1.6 Registrar Cliente ==================================================================
        //Prueba 1.6 - Registrar Cliente - OK 
        Retorno unoseis = s.registrarCliente("1322123", "Juan", 25); 
        p.ver(unoseis.resultado, Retorno.Resultado.OK, "1.6 - Prueba: Registrar cliente - Datos: (43221235, Juan, 25) \n  Resultado: " + unoseis.valorString);
        
        //Prueba 1.6 - Registrar Cliente edad menor a 0 - ERROR 1
        Retorno unoseisE1 = s.registrarCliente("2527723", "Juan", -1); 
        p.ver(unoseisE1.resultado, Retorno.Resultado.ERROR_1, "1.6 - Prueba: Registrar cliente edad < 0 - Datos: (2527723, Juan, -1) \n  Resultado: " + unoseisE1.valorString);
        
        //Prueba 1.6 - Registrar Cliente pasaporte no tiene exactamente 7 digitos - ERROR 2
        Retorno unoseisE2 = s.registrarCliente("2527", "Juan", 25); 
        p.ver(unoseisE2.resultado, Retorno.Resultado.ERROR_2, "1.6 - Prueba: Registrar cliente pasaporte no tiene exactamente 7 digitos - Datos: (2527, Juan, 25) \n  Resultado: " + unoseisE2.valorString);
        
        //Prueba 1.6 - Registrar Cliente pasaporte no tiene exactamente 7 digitos - ERROR 2
        Retorno unoseisE3 = s.registrarCliente("1322123", "Pedro", 25); 
        p.ver(unoseisE3.resultado, Retorno.Resultado.ERROR_3, "1.6 - Prueba: Registrar cliente pasaporte existente - Datos: (1322123, Pedro, 25) \n  Resultado: " + unoseisE3.valorString);
        
        
        
        //==================================================================1.7 Crear Vuelo ==================================================================

        //Prueba 1.7 - Registrar Vuelo - OK 
        s.registrarAvion("AVION-PRUEBA-VUELO", 60, "Aerolinea-21");
        Retorno unosiete = s.crearVuelo("V-01", "Aerolinea-21", "AVION-PRUEBA-VUELO", "Wonderland", 12, 5, 2024, 24, 24);
        p.ver(unosiete.resultado, Retorno.Resultado.OK, "1.7 - Prueba: Crear vuelo - Datos: (V-01, Aerolinea-21, AVION-PRUEBA-VUELO, Wonderland, 12, 5, 2024, 24, 24) \n  Resultado: " + unosiete.valorString);
        
        //Prueba 1.7 - Registrar Vuelo codigo de vuelo existente en el sistema - ERROR 1      
        Retorno unosieteE1 = s.crearVuelo("V-01", "Aerolinea-21", "AVION-PRUEBA-VUELO", "Wonderland", 12, 5, 2024, 24, 24);
        p.ver(unosieteE1.resultado, Retorno.Resultado.ERROR_1, "1.7 - Prueba: Crear vuelo codigo existente misma Aerolinea - Datos: (V-01, Aerolinea-21, AVION-PRUEBA-VUELO, Wonderland, 12, 5, 2024, 24, 24) \n  Resultado: " + unosieteE1.valorString);

        //Prueba 1.7 - Registrar Vuelo aerolinea inexistente - ERROR 2
        Retorno unosieteE2 = s.crearVuelo("V-02", "Aerolinea-NoExistente", "AVION-PRUEBA-VUELO2", "Wonderland", 12, 5, 2024, 24, 24);
        p.ver(unosieteE2.resultado, Retorno.Resultado.ERROR_2, "1.7 - Prueba: Crear vuelo aerolinea inexistente - Datos: (V-02, Aerolinea-NoExistente, AVION-PRUEBA-VUELO, Wonderland, 12, 5, 2024, 24, 24) \n  Resultado: " + unosieteE2.valorString);

        //Prueba 1.7 - Registrar Vuelo avion inexistente - ERROR 3
        Retorno unosieteE3 = s.crearVuelo("V-03", "Aerolinea-21", "AVION-PRUEBA-INEXISTENTE", "Wonderland", 12, 5, 2024, 24, 24);
        p.ver(unosieteE3.resultado, Retorno.Resultado.ERROR_3, "1.7 - Prueba: Crear vuelo avion inexistente - Datos: (V-03, Aerolinea-21, AVION-PRUEBA-INEXISTENTE, Wonderland, 12, 5, 2024, 24, 24) \n  Resultado: " + unosieteE3.valorString);
        
        //Prueba 1.7 - Registrar Avion posee vuelo misma fecha - ERROR 4
        Retorno unosieteE4 = s.crearVuelo("V-04", "Aerolinea-21", "AVION-PRUEBA-VUELO", "Wonderland", 12, 5, 2024, 24, 24);  
        p.ver(unosieteE4.resultado, Retorno.Resultado.ERROR_4, "1.7 - Prueba: Crear vuelo existe vuelo para el avion misma fecha - Datos: (V-03, Aerolinea-21, AVION-PRUEBA-INEXISTENTE, Wonderland, 12, 5, 2024, 24, 24) \n  Resultado: " + unosieteE4.valorString);  
         
        //Prueba 1.7 - Registrar Avion cantidades de pasajes (de cualquiera de las categorías) no sea múltiplo de 3 - ERROR 5
        Retorno unosieteE5v1 = s.crearVuelo("V-05", "Aerolinea-21", "OK-233", "Wonderland", 12, 5, 2024, 23, 24);  
        Retorno unosieteE5v2 = s.crearVuelo("V-06", "Aerolinea-21", "OK-233", "Wonderland", 12, 5, 2024, 24, 23);  
        p.ver(unosieteE5v1.resultado, Retorno.Resultado.ERROR_5, "1.7 - Prueba: Crear vuelo cantidades de pasajes (de cualquiera de las categorias) no sea multiplo de 3 - Datos: (V-03, Aerolinea-21, OK-233, Wonderland, 12, 5, 2024, 23, 24) \n  Resultado: " + unosieteE5v1.valorString);  
        p.ver(unosieteE5v2.resultado, Retorno.Resultado.ERROR_5, "1.7 - Prueba: Crear vuelo cantidades de pasajes (de cualquiera de las categorias) no sea multiplo de 3 - Datos: (V-03, Aerolinea-21, OK-233, Wonderland, 12, 5, 2024, 24, 23) \n  Resultado: " + unosieteE5v2.valorString);  
        
        //Prueba 1.7 - Registrar Avion la suma de los pasajes de ambas categorías supere la cant. máxima permitida por el avión. - ERROR 6
        //s.registrarAvion("AVION-PRUEBA-VUELO", 60, "Aerolinea-21"); Nota: Ya fue creado cant. maxima 60
        Retorno unosieteE6 = s.crearVuelo("V-07", "Aerolinea-21", "AVION-PRUEBA-VUELO", "Wonderland", 12, 5, 2024, 33, 30);  
        p.ver(unosieteE6.resultado, Retorno.Resultado.ERROR_6, "1.7 - Prueba: Crear vuelo la suma de los pasajes de ambas categorias supere la cant. maxima permitida por el avion - Datos: (V-03, Aerolinea-21, AVION-PRUEBA-VUELO, Wonderland, 12, 5, 2024, 33, 30) \n  Resultado: " + unosieteE6.valorString);  


        
        //==================================================================1.8 Comprar Pasaje ==================================================================

        //Prueba 1.8 - Registrar Pasaje - OK  : Se crean 10 clientes - 1 Quedara fuera para comprobar el ERROR_3
        //ERROR_3 : Creado para cuando no existan pasajes del tipo de vuelo (El pasaje quedara en lista de espera)
        s.registrarCliente("AE-0312", "Santiago", 33);
        s.registrarCliente("BC-1243", "Lucía", 29);
        s.registrarCliente("DE-5678", "Mateo", 45);
        s.registrarCliente("FG-9101", "Valentina", 27);
        s.registrarCliente("HI-2134", "Miguel", 36);
        s.registrarCliente("JK-5467", "Isabella", 50);
        s.registrarCliente("LM-8790", "Juan", 40);
        s.registrarCliente("NO-1123", "Camila", 31);
        s.registrarCliente("TT-1123", "Pedrito", 31);
        s.registrarCliente("SH-4412", "Cliente que no puede comprar pasaje", 31);
        s.crearVuelo("V-02", "Aerolinea-21", "AVION-PRUEBA-VUELO", "Jamaica", 3, 8, 2024, 6, 3);        

        Retorno unoochoOK1 = s.comprarPasaje("BC-1243", "V-02", 1);
        p.ver(unoochoOK1.resultado, Retorno.Resultado.OK, "1.7 - Prueba: Comprar pasaje OK - Datos: (BC-1243, V-02, 1) \n  Resultado: " + unoochoOK1.valorString); 

        Retorno unoochoOK2 = s.comprarPasaje("DE-5678", "V-02", 1);
        p.ver(unoochoOK2.resultado, Retorno.Resultado.OK, "1.7 - Prueba: Comprar pasaje OK - Datos: (DE-5678, V-02, 1) \n  Resultado: " + unoochoOK2.valorString); 

        Retorno unoochoOK3 = s.comprarPasaje("FG-9101", "V-02", 1);
        p.ver(unoochoOK3.resultado, Retorno.Resultado.OK, "1.7 - Prueba: Comprar pasaje OK - Datos: (FG-9101, V-02, 1) \n  Resultado: " + unoochoOK3.valorString); 

        Retorno unoochoOK4 = s.comprarPasaje("HI-2134", "V-02", 2);
        p.ver(unoochoOK4.resultado, Retorno.Resultado.OK, "1.7 - Prueba: Comprar pasaje OK - Datos: (HI-2134, V-02, 2) \n  Resultado: " + unoochoOK4.valorString); 

        Retorno unoochoOK5 = s.comprarPasaje("JK-5467", "V-02", 2);
        p.ver(unoochoOK5.resultado, Retorno.Resultado.OK, "1.7 - Prueba: Comprar pasaje OK - Datos: (JK-5467, V-02, 2) \n  Resultado: " + unoochoOK5.valorString); 

        Retorno unoochoOK6 = s.comprarPasaje("LM-8790", "V-02", 2);
        p.ver(unoochoOK6.resultado, Retorno.Resultado.OK, "1.7 - Prueba: Comprar pasaje OK - Datos: (LM-8790, V-02, 2) \n  Resultado: " + unoochoOK6.valorString); 

        Retorno unoochoOK7 = s.comprarPasaje("NO-1123", "V-02", 2);
        p.ver(unoochoOK7.resultado, Retorno.Resultado.OK, "1.7 - Prueba: Comprar pasaje OK - Datos: (NO-1123, V-02, 2) \n  Resultado: " + unoochoOK7.valorString); 

        Retorno unoocho8 = s.comprarPasaje("AE-0312", "V-02", 2);
        p.ver(unoocho8.resultado, Retorno.Resultado.OK, "1.7 - Prueba: Comprar pasaje OK - Datos: (AE-0312, V-02, 2) \n  Resultado: " + unoocho8.valorString);

        Retorno unoocho9 = s.comprarPasaje("TT-1123", "V-02", 2);
        p.ver(unoocho9.resultado, Retorno.Resultado.OK, "1.7 - Prueba: Comprar pasaje OK - Datos: (TT-1123, V-02, 2) \n  Resultado: " + unoocho9.valorString);
                               
        //Prueba 1.8 - Registrar Pasaje el pasaporte del cliente no existe - ERROR_1
        Retorno unoochoE1 = s.comprarPasaje("NO-EXIS", "V-02", 2);
        p.ver(unoochoE1.resultado, Retorno.Resultado.ERROR_1, "1.7 - Prueba: Comprar Pasaje el pasaporte del cliente no existe - Datos: (NO-EXIS, V-02, 2) \n  Resultado: " + unoochoE1.valorString);
        
        //Prueba 1.8 - Registrar Pasaje el codigo de vuelo no existe - ERROR_2
        Retorno unoochoE2 = s.comprarPasaje("BC-1243", "CVUELO-INEX", 2);
        p.ver(unoochoE2.resultado, Retorno.Resultado.ERROR_2, "1.7 - Prueba: Comprar pasaje OK - Datos: (TT-1123, V-02, 2) \n  Resultado: " + unoochoE2.valorString);
        
        //Prueba 1.8 - Registrar Pasaje no existen pasajes disponibles para la categoria - OK - Lista de espera ("SH-4412", "V-02", 2)
        Retorno unoochoOKv2 = s.comprarPasaje("SH-4412", "V-02", 2);
        p.ver(unoochoOKv2.resultado, Retorno.Resultado.OK, "1.7 - Prueba: Comprar pasaje agregado a lsita de espera - Datos: (SH-4412, V-02, 2) \n  Resultado: " + unoochoOKv2.valorString);
       
        s.vistaDeVuelo("V-02");        
        
        
        
        //==================================================================1.9 Devolver Pasaje ================================================================== 
        s.vistaDeVuelo("V-02");
        //s.getListaVuelos().Mostrar();
        //Prueba 1.9 - Devolver Pasaje - OK  : Se utilizan los pasajes creados en 1.8
        Retorno unonueveOK = s.devolverPasaje("AE-0312", "V-02");
        p.ver(unonueveOK.resultado, Retorno.Resultado.OK, "Prueba 1.8 - Devolver Pasaje - OK - Datos: (AE-0312, V-02) \n  Resultado: " + unonueveOK.valorString);
               


        //Prueba 1.9 - Devolver Pasaje no existe el pasaporte del cliente - ERROR_1
        Retorno unonueveE1 = s.devolverPasaje("NO-Exis", "V-02");
        p.ver(unonueveE1.resultado, Retorno.Resultado.ERROR_1, "Prueba 1.9 - Devolver Pasaje no existe el pasaporte del cliente Datos: (NO-Exis, V-02)\n  Resultado: " + unonueveE1.valorString);

        //Prueba 1.9 - Devolver Pasaje no existe el código de vuelo - ERROR_2
        Retorno unonueveE2 = s.devolverPasaje("TT-1123", "V-NOEXISTE");
        p.ver(unonueveE2.resultado, Retorno.Resultado.ERROR_2, "Prueba 1.9 - Devolver Pasaje no existe el codigo de vuelo Datos: (TT-1123, V-NOEXISTE)\n  Resultado: " + unonueveE2.valorString);

        //Prueba 1.9 - Devolver Pasaje no exista una compra del cliente para dicho vuelo - ERROR_3
        s.registrarCliente("NU-3355", "PedritoNuevo", 21);
        Retorno unonueveE3 = s.devolverPasaje("NU-3355", "V-02");
        p.ver(unonueveE3.resultado, Retorno.Resultado.ERROR_3, "Prueba 1.9 - Devolver Pasaje no exista una compra del cliente para dicho vuelo Datos: (NU-3355, V-02)\n  Resultado: " + unonueveE3.valorString);
         
        //==================================================================2.1 Listar Aerolineas ==================================================================
        
        //Prueba 2.1 - Listar Aerolineas - OK
        s.crearAerolinea("Xairolinea-40", "Uganda", 70);
        s.crearAerolinea("Hairolinea-40", "Uganda", 70);
        s.crearAerolinea("Bairolinea-40", "Uganda", 70);
        s.crearAerolinea("Aairolinea-40", "Uganda", 70);
        Retorno dosuno = s.listarAerolineas();
        p.ver(dosuno.resultado, Retorno.Resultado.OK, "2.1 - Listado de aerolineas \n  Resultado: \n\n" + dosuno.valorString);
        
        
        
        //==================================================================2.2 Listar Aviones ==================================================================
        
        //Prueba 2.2 - Listar Aviones - OK
        Retorno dosdos = s.listarAvionesDeAerolinea("Aerolinea-21");
        p.ver(dosdos.resultado, Retorno.Resultado.OK, "2.2 - Listado de Aviones - Datos (Aerolinea-21) \n  Resultado: \n\n" + dosdos.valorString);
        
        
        
        //==================================================================2.3 Listar Clientes ==================================================================
        
        //Prueba 2.3 - Listar Clientes - OK
        s.registrarCliente("A21451K", "Pedro", 25);
        s.registrarCliente("T73451K", "Nicolas", 30);
        s.registrarCliente("HH1181K", "Santiago", 16);
        Retorno dostres = s.listarClientes();
        p.ver(dostres.resultado, Retorno.Resultado.OK, "2.3 - Listado de Clientes \n  Resultado: \n\n" + dostres.valorString);
        
       
        
        //==================================================================2.4 Listar Vuelos ==================================================================
        
        //Prueba 2.4 - Listar Vuelos - OK
        Retorno doscuatro = s.listarVuelos();
        p.ver(doscuatro.resultado, Retorno.Resultado.OK, "2.4 - Listado de Vuelos \n  Resultado: \n\n" + doscuatro.valorString);      
        
        
        
        //==================================================================2.5 Listar Vuelos Cliente ==================================================================
        s.vistaDeVuelo("V-02");
        //Prueba 2.5 - Listar Vuelos Clientes Datos: ("NO-1123) - OK
        //Notas: Se crea un nuevo, Vuelo para verificar que el ultimo agregado sea el primero mostrado
        s.registrarAvion("AV-01", 60, "Aerolinea-21");
        s.crearVuelo("V-07", "Aerolinea-21", "AV-01", "Dinamarca", 4, 7, 2024, 24, 24);
        s.comprarPasaje("NO-1123", "V-07", 1);    
        s.vistaDeVuelo("V-02");
        s.devolverPasaje("NO-1123", "V-02");
        Retorno doscinco = s.vuelosDeCliente("NO-1123");
        p.ver(doscinco.resultado, Retorno.Resultado.OK, "2.5 - Listado de Vuelos cliente Datos: (NO-1123)\n  Resultado: \n\n" + doscinco.valorString);
        
        //Prueba 2.5 - Listar Vuelos Clientes no existe el pasaporte en el sistema Datos: (NO-ESST) - ERROR_1
        Retorno doscincoE1 = s.vuelosDeCliente("NO-ESST");
        p.ver(doscincoE1.resultado, Retorno.Resultado.ERROR_1, "2.5 - Listado de Vuelos cliente no existe el pasaporte en el sistema Datos: (NO-1123)\n  Resultado: \n\n" + doscincoE1.valorString);
        
        
        
        //==================================================================2.6 Reporte Pasajes Devueltos ==================================================================
        //Prueba 2.6 - Reporte Pasajes Devueltos Datos: (Aerolinea-21) - OK
        Retorno dosseisOK = s.pasajesDevueltos("Aerolinea-21");
        p.ver(dosseisOK.resultado, Retorno.Resultado.OK, "2.6 - Reporte Pasajes Devueltos Datos: (Aerolinea-21)\n  Resultado: \n\n" + dosseisOK.valorString);
        
        
        //==================================================================2.7 Vista Distribucion vuelo ==================================================================
        //Prueba 2.5 - Vista Distribucion Vuelo Datos: (v-02) - OK
        Retorno dossieteOK1 = s.vistaDeVuelo("V-02");
        p.ver(dossieteOK1.resultado, Retorno.Resultado.OK, "2.7 - Vista Distribucion vuelo - OK1 -  Datos: (V-02)\n  Resultado: \n\n" + dossieteOK1.valorString);
        
        //Prueba 2.5 - Vista Distribucion Vuelo Datos: (v-07) - OK | Notas: Agrego Pasajes al vuelo cambiando el orden de las categorias para verificar el correcto funcionamiento
        s.comprarPasaje("A21451K", "V-07", 2);
        s.comprarPasaje("T73451K", "V-07", 1);
        s.comprarPasaje("HH1181K", "V-07", 2);
        Retorno dossieteOK2 = s.vistaDeVuelo("V-07");
        p.ver(dossieteOK2.resultado, Retorno.Resultado.OK, "2.7 - Vista Distribucion vuelo - OK2 -  Datos: (V-07)\n  Resultado: \n\n" + dossieteOK2.valorString);
    }
}

