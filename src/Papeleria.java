
public class Papeleria extends Producto{

    static double iva= 1.16;

    public Papeleria(String nombre, String tipo, int cantidadA, int cantidadM, double Pbase) throws Exception {
        super(nombre, tipo, cantidadA, cantidadM, Pbase);
    }

 
    public Papeleria(String nombre, String nuevoNombre, String tipo, int cantidadA, int cantidadM, double Pbase) throws Exception {
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
