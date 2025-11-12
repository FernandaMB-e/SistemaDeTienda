/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shoyo
 */
import java.util.*;

public class tienda1 {

    public List<Producto> inventario = new ArrayList();
    public static double dinero; //variable estatica que se usa para almacenar el dinero obtenido
    public static String tip; //variable estaica que se usa para poder obtener el tipo de producto el cual se esta manejando 
    public static int Cbodega;

    //metodo para agregar un producto
    public void agregarP(Producto p) {//resive un objeto de tipo producto y lo añade a nuestra lista
        inventario.add(p);
    }
    
    public static boolean hayInventarioDisponible(Producto p) {
    return p.cantidadA > 0;
}

    //metodo para cambiar un producto 
    public void Cambio(Producto p) {
        int i;
        if (!p.getNuevoN().equalsIgnoreCase(p.nombre)) {
            inventario.add(p);
        }

        for (i = 0; i < inventario.size(); i++) {
            Producto p2 = inventario.get(i);
            if (p2.getNombre().equalsIgnoreCase(p.nuevoN)) {
                inventario.remove(p2);
            }
        }
    }
    //metodo para vender un producto
    public  int venderp(String n, int c) {
        int i;
        double total = 0.0;
        for (i = 0; i < inventario.size(); i++) {
            Producto p = inventario.get(i);
            if (p.getNombre().equalsIgnoreCase(n)) {
                int cabtidadv = p.venta(n, c);
                if(cabtidadv==-1){
                  return -2;
                }
                System.out.println(cabtidadv);
                double precioF = 0.0;
                if (p instanceof Papeleria) {
                    precioF = p.getPbase()*Papeleria.iva;
                } else if (p instanceof Supermercado) {
                    precioF = p.getPbase()*Supermercado.iva;
                } else if (p instanceof Drogeria) {
                    precioF = p.getPbase()*Drogeria.iva;
                }else if (p instanceof Merceria ){
                    precioF = p.getPbase()*Merceria.getIva();
                }

                total = precioF * cabtidadv;
                System.out.println(total);
                dinero += total;
                tip = p.tipo;
                Cbodega = p.cantidadA;
                return cabtidadv;
            }
        }
        return -1;
    }
    //metodo para abastecer un produco
    public int abastecer(String n, int c) {
        int i;
        for (i = 0; i < inventario.size(); i++) {
            Producto p = inventario.get(i);
            if (p.getNombre().equalsIgnoreCase(n)) {
                p.venta(c);
                p.cantidadA=p.cantidadA+c;
                return p.cantidadA;
            }

        }
        return 0;
    }

    //clase anidada para controlar las estadisticas de la tienda
    public class estadisticas {

        //metodo para obtener el producto mas vendido
        public String MasVendido() {

            if (inventario.isEmpty()) {
                return "No hay productos vendidos.";
            }
            int i;
            Producto p = inventario.get(0);
            int may = p.Cvendidas;
            String nom = p.nombre;

            for (i = 1; i < inventario.size(); i++) {
                p = inventario.get(i);
                if (may < p.Cvendidas) {
                    may = p.Cvendidas;
                    nom = p.nombre;
                }

            }

            return "El producto mas vendido es " + nom;
        }
        //metodo para obtener el producto menos vendido
        public String MenosVendido() {
            if (inventario.isEmpty()) {
                return "No hay productos vendidos.";
            }

            int i;
            Producto p = inventario.get(0);
            int men = p.Cvendidas;
            String nom = p.nombre;
            for (i = 1; i < inventario.size(); i++) {
                p = inventario.get(i);
                if (men > p.Cvendidas) {
                    men = p.Cvendidas;
                    nom = p.nombre;
                }

            }

            return "El producto menos vendido es " + nom;
        }
        //metodo para obtener el promedio de las ventas 
        public double promedioV() {
            int cantidad = 0;
            int i;
            for (i = 0; i < inventario.size(); i++) {
                Producto p = inventario.get(i);
                cantidad += p.Cvendidas;
            }
            double din = dinero;
            double promedio = din / cantidad;
            return promedio;
        }

    }

}
