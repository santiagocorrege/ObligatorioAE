/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaAutogestion.Entidades;

/**
 *
 * @author Ryzen
 */
public class Avion {
    private String _codigo;
    private int _capacidadMax;
    
    public Avion(String codigo, int capacidadMax){
        _codigo = codigo;
        _capacidadMax = capacidadMax;
    }
    
    public static boolean Validar(int numero){
        return numero >= 9 && numero % 3 == 0;
    }
    @Override
    public String toString(){
        return "==Avion==\nCodigo:" + _codigo + "\nCapacidad maxima: " + _capacidadMax + "\n\n";
    }
    
    public String getCodigo() {
        return _codigo;
    }

    public void setCodigo(String _codigo) {
        this._codigo = _codigo;
    }

    public int getCapacidadMax() {
        return _capacidadMax;
    }

    public void setCapacidadMax(int _capacidadMax) {
        this._capacidadMax = _capacidadMax;
    }

    
    
}
