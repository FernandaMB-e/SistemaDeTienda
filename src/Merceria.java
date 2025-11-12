/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shoyo
 */
public class Merceria extends Papeleria{

    public static double getIva() {
        return iva;
    }

    public Merceria(String nombre, String tipo, int cantidadA, int cantidadM, double Pbase) throws Exception {
        super(nombre, tipo, cantidadA, cantidadM, Pbase);
    }

    public Merceria(String nombre, String nuevoNombre, String tipo, int cantidadA, int cantidadM, double Pbase) throws Exception {
        super(nombre, nuevoNombre, tipo, cantidadA, cantidadM, Pbase);
    }
    
    @Override
    public String Datos(){
        if(cantidadA>0){
            return super.toString()+" Disponible en tida"+"El iva del producto es de: "+iva;
        }
       return super.toString()+" Disponible en tida"+"El iva del producto es de: "+iva;
    }
    
    
}
