/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaAutogestion;

import sistemaAutogestion.Entidades.Pasaje;

/**
 *
 * @author Ryzen
 */
public class MatrizAsientos {
    private final int _cantidadAsientosEconomicos;
    private final int _cantidadAsientosPrimeraClase;
    private String [][] mat;
    private final int elementos;    
    private final int filas;
    private final int columnas = 3;
    
    public MatrizAsientos(int cantidadAsientosEconomicos, int cantidadAsientosPrimeraClase){
        _cantidadAsientosEconomicos = cantidadAsientosEconomicos;
        _cantidadAsientosPrimeraClase = cantidadAsientosPrimeraClase;
        elementos = cantidadAsientosEconomicos + cantidadAsientosPrimeraClase;
        filas = elementos / columnas;
        mat = new String [filas][columnas];
    }
    
    //La clase vuelo se encarga de verificar la disponibilidad de los asientos, por eso no verificamos aqui nuevamente
    public void AgregarAsiento(Pasaje pasaje){ 
        int filasP = _cantidadAsientosPrimeraClase / 3;
        if(pasaje.getCategoriaPasaje() == 1){                                               
            for(int f=0; f<filasP; f++){
                for(int c=0; c<columnas; c++){
                    if(mat[f][c] == null){                    
                        mat[f][c] = pasaje.getCliente().getPasaporte();
                        return;
                    }
                }
            }
        }
        else if(pasaje.getCategoriaPasaje() == 2){                        
            for(int f=filasP; f<filas; f++){
                for(int c=0; c<columnas; c++){
                    if(mat[f][c] == null){                    
                        mat[f][c] = pasaje.getCliente().getPasaporte();
                        return;
                    }
                }
            }   
        }
        
    }
    //Version 2 Ejercicio 1 : Tratar de recorrer la matriz como si fuera un vector, con una sola interaccion.    
    public void mostrarMatriz() {
        int cantidadFilasPrimera = _cantidadAsientosPrimeraClase / 3;
        int cantidadFilasEconomico = _cantidadAsientosEconomicos / 3;
        System.out.println("**********************************");
        System.out.println("      *       PRIMERA       *     ");      
        for (int f=0; f<cantidadFilasPrimera; f++){
            System.out.println("**********************************");
            for(int c=0; c<columnas; c++){
                if(c==0){
                    System.out.print("    ");
                }
                if(mat[f][c] != null){
                    System.out.print(mat[f][c]);
                }else{
                    System.out.print("XXXXXXX");
                }

                if(c < columnas - 1){ //custom
                System.out.print(" * ");    
                }   
        }
        System.out.println();
        }
        System.out.println("**********************************");
        System.out.println("      *      ECONOMICA      *     ");    
        for (int f2=0; f2<cantidadFilasEconomico; f2++){
            System.out.println("**********************************");
            for(int c=0; c<columnas; c++){
                if(c==0){
                    System.out.print("    ");
                }
                if(mat[cantidadFilasPrimera + f2][c] != null){
                    System.out.print(mat[cantidadFilasPrimera + f2][c]);
                }else{
                    System.out.print("XXXXXXX");
                }

                if(c < columnas - 1){ //custom
                System.out.print(" * ");    
                }   
        }
        System.out.println();
        }
        System.out.println("**********************************");
    }

       public String mostrarMatrizString() {
        int cantidadFilasPrimera = _cantidadAsientosPrimeraClase / 3;
        int cantidadFilasEconomico = _cantidadAsientosEconomicos / 3;
        String str = "";
        str += "**********************************\n";
        str += "      *       PRIMERA       *     \n";      
        for (int f=0; f<cantidadFilasPrimera; f++){
            str += "**********************************\n";
            for(int c=0; c<columnas; c++){
                if(c==0){
                    str += "    ";
                }
                if(mat[f][c] != null){
                    str += mat[f][c];
                }else{
                    str += "XXXXXXX";
                }

                if(c < columnas - 1){ //custom
                str += " * ";    
                }   
        }
        str += "\n";
        }
        str += "**********************************\n";
        str += "      *      ECONOMICA      *     \n";    
        for (int f2=0; f2<cantidadFilasEconomico; f2++){
            str += "**********************************\n";
            for(int c=0; c<columnas; c++){
                if(c==0){
                    str += "    ";
                }
                if(mat[cantidadFilasPrimera + f2][c] != null){
                    str += mat[cantidadFilasPrimera + f2][c];
                }else{
                    str += "XXXXXXX";
                }

                if(c < columnas - 1){ //custom
                str += " * ";    
                }   
        }
        str += "\n";
        }
        str += "**********************************\n";
        return str;
    }
       

    public boolean buscarElementoEnMatriz(String elemento) {
        System.out.println("Buscar elemento en matriz, elemento: " + elemento);
        for(int f=0; f<filas; f++){
            for(int c=0; c<columnas; c++){
                if(elemento.equals(mat[f][c])){
                    return true;
                }
            }
        }
        return false;
    }

    
    public boolean eliminarElemntoMatriz(String elemento) {
        System.out.println("Buscar elemento en matriz, elemento: " + elemento);
        for(int f=0; f<filas; f++){
            for(int c=0; c<columnas; c++){
                if(elemento.equals(mat[f][c])){
                    mat[f][c] = null;
                    return true;
                }
            }
        }
        return false;
    }
    
    
}
