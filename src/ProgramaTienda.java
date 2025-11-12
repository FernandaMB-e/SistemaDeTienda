/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shoyo
 */
import java.util.Scanner;
public class ProgramaTienda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tienda1 tienda = new tienda1();
        tienda1.estadisticas estadisticas = tienda.new estadisticas();

        try {
            while (true) {
                System.out.println("\n=== Menú de Tienda ===");
                System.out.println("\n1. Agregar producto");
                System.out.println("\n2. Vender producto");
                System.out.println("\n3. Mostrar dinero en caja");
                System.out.println("\n4. ver el promedio de ventas");
                System.out.println("\n5. Cambiar producto");
                System.out.println("\n6. Abastecer");
                System.out.println("\n7. Ver el producto mas vendido");
                System.out.println("\n8. Ver el producto menos vendido:");
                System.out.print("\nElige una opción: ");
                int opcion = sc.nextInt();

                OUTER:
                switch (opcion) {
                    case 1:
                        System.out.print("Nombre del producto: ");
                        String nombre = sc.next();
                        System.out.print("\nTipo (papeleria, supermercado, drogueria): ");
                        String tipo = sc.next().toLowerCase();
                        System.out.print("\nCantidad actual: ");
                        int cantidadActual = sc.nextInt();
                        System.out.print("\nCantidad mínima: ");
                        int cantidadMinima = sc.nextInt();
                        System.out.print("\nPrecio base: ");
                        double precioBase = sc.nextDouble();
                        Producto producto = null;
                        if (tipo.equals("papeleria")) {
                            producto = new Papeleria(nombre,tipo, cantidadActual, cantidadMinima, precioBase);
                        } else if (tipo.equals("supermercado")) {
                            producto = new Supermercado(nombre,tipo, cantidadActual, cantidadMinima, precioBase);
                        } else if (tipo.equals("drogueria")) {
                            producto = new Drogeria(nombre,tipo, cantidadActual, cantidadMinima, precioBase);
                        } else {
                            System.out.println("\nTipo de producto no válido.");
                            break;
                        }
                        
                        tienda.agregarP(producto);
                        
                        System.out.println("Producto agregado correctamente.");
                        break;
                    case 2:
                        System.out.print("\nNombre del producto: ");
                        String nombreVenta = sc.next();
                        System.out.print("\nCantidad a vender: ");
                        int cantidadVenta = sc.nextInt();
                        int c=tienda.venderp(nombreVenta, cantidadVenta);
                        System.out.print("\nCantidad vendida "+c);
                        break;
                    case 3:
                        double dinero=tienda.dinero;
                        System.out.print("\nTotal en caja "+dinero);
                        
                        break;
                    case 4:
                        double prom= estadisticas.promedioV();
                        System.out.print("\nPromedio de ventas"+prom);
                        return;
                    case 5:
                        System.out.print("Nombre Actual del producto:");
                        String nombre1 = sc.next();
                        System.out.println("Nuevo nombre del producto:");
                        String nombre2 = sc.next();
                        System.out.print("\nTipo (papeleria, supermercado, drogueria): ");
                        String tipo1 = sc.next().toLowerCase();
                        System.out.print("\nCantidad actual: ");
                        int cantidadActual1 = sc.nextInt();
                        System.out.print("\nCantidad mínima: ");
                        int cantidadMinima1 = sc.nextInt();
                        System.out.print("\nPrecio base: ");
                        double precioBase1 = sc.nextDouble();
                        Producto producto1 = null;
                        switch (tipo1) {
                            case "papeleria":
                                producto= new Papeleria(nombre1,nombre2,tipo1, cantidadActual1, cantidadMinima1, precioBase1);
                                break;
                            case "supermercado":
                                producto = new Supermercado(nombre1,nombre2,tipo1, cantidadActual1, cantidadMinima1, precioBase1);
                                break;
                            case "drogueria":
                                producto = new Drogeria(nombre1,tipo1,nombre2, cantidadActual1, cantidadMinima1, precioBase1);
                                break;
                            default:
                                System.out.println("\nTipo de producto no válido.");
                                break OUTER;
                        }
                        System.out.println("Producto agregado correctamente.");
                        break;
                    case 6:
                        System.out.print("\nNombre del producto: ");
                        String nombrea= sc.next();
                        System.out.print("\nCantidad a abastecer: ");
                        int abastecer = sc.nextInt();
                        int op=tienda.abastecer(nombrea,abastecer);
                        if(op ==0){
                            System.out.print("no se encontro ningun producto con ese nombre");
                        }else{
                            System.out.print("Cantidad actual: "+ op);
                        }
                        break;
                    case 7:
                        System.out.println("El producto mas vendido es:"+estadisticas.MasVendido());
                        break;
                    case 8:
                        System.out.println("El producto menos vendido es:"+estadisticas.MenosVendido());
                        break; 
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}