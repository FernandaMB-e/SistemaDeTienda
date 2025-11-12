
import java.util.*;
public class Producto {
    String nombre;
    String tipo;
    int cantidadA;
    int cantidadM; 
    double Pbase;
    int Cvendidas;
    String nuevoN;
    //contron de exepciones, no puede haber dos productos con el mismmo nombre 
private static Set<String> nombresProductos = new HashSet<>();

    public Producto(String nombre, String tipo, int cantidadA, int cantidadM, double Pbase)throws Exception{
        if (nombresProductos.contains(nombre)) {
            throw new Exception("El producto '" + nombre + "' ya existe.");
        }
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidadA = cantidadA;
        this.cantidadM = cantidadM;
        this.Pbase = Pbase;
        this.Cvendidas = 0;
        nombresProductos.add(nombre);
    }
 
    
    public Producto(String nombre,String nuevoNombre ,String tipo, int cantidadA, int cantidadM, double Pbase)throws Exception {
        if (nombresProductos.contains(nuevoNombre)) {
            throw new Exception("El producto '" + nombre + "' ya existe.");
        }
        this.nuevoN=nombre;
        this.nombre = nuevoNombre;
        this.tipo = tipo;
        this.cantidadA = cantidadA;
        this.cantidadM = cantidadM;
        this.Pbase = Pbase;
        this.Cvendidas = 0;
        nombresProductos.add(nombre);
    }

    public String getNuevoN() {
        return nuevoN;
    }

    public void setNuevoN(String nuevoN) {
        this.nuevoN = nuevoN;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidadA() {
        return cantidadA;
    }

    public void setCantidadA(int cantidadA) {
        this.cantidadA = cantidadA;
    }

    public int getCantidadM() {
        return cantidadM;
    }

    public void setCantidadM(int cantidadM) {
        this.cantidadM = cantidadM;
    }

    public double getPbase() {
        return Pbase;
    }

    public void setPbase(double Pbase) {
        this.Pbase = Pbase;
    }

    public int getCvendidas() {
        return Cvendidas;
    }

    public void setCvendidas(int Cvendidas) {
        this.Cvendidas = Cvendidas;
    }
    
 
    // metodo sobrecargado para las ventas, en el primer caso resive tanto la cantidad como el nombre, en el segundo caso solo la cantidad 
    //vender 
    public int venta(String nom, int c) {
        
            if (c <= cantidadA) {
                cantidadA -= c;
                Cvendidas += c;
                return c;
            } else if (c > cantidadA) {
                int aux=cantidadA;
                cantidadA=0;
                Cvendidas += aux;
                return aux;
            } else if (cantidadA == 0) {
                return 0;
            }
        return -1;

    }

    //abastecer
    public void venta(int uni) {
        if (cantidadA <= cantidadM) {
            cantidadA += uni;
        }
    }
    
    public String Datos(){
    return "\nNombre :"+nombre+"Canttidad en tienda: "+cantidadA;
    }

  
}
