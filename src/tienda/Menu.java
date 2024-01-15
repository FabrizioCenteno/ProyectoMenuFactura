package tienda;

import tienda.bd.BD_Productos;
import tienda.factura.Factura;

import java.util.Scanner;

public class Menu {
    private final BD_Productos bd;
    private final Factura factura;

    public Menu(BD_Productos bd, Factura f) {
        this.bd = bd;
        this.factura = f;
    }

    public BD_Productos getBd() {
        return bd;
    }

    public Factura getFactura() {
        return factura;
    }

    public void anadirLinea() {
        Scanner sn = new Scanner(System.in);
        while (true) {
            System.out.println("---- INTRO PARA TERMINAR ---");
            System.out.println("ref del producto ?");
            String ref = sn.nextLine();

            // Verificar si se presionó Enter
            if (ref.isEmpty()) {
                System.out.println("---- INTRO PARA TERMINAR ---");
                break; // Terminar la ejecución del método
            }

            System.out.println("Cantidad del producto ?");
            String cantidad = sn.nextLine();
            int cantidadI = Integer.parseInt(cantidad);
            if (cantidad.isEmpty()) {
                break;
            }

            this.getFactura().anadirLinea(getBd().buscarProducto(ref), cantidadI);
        }
    }

    public void BuscarProducto() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Ingresa la referencia: ");
        String ref = sn.nextLine();
        System.out.println(this.bd.buscarProducto(ref).aCadena());

    }

    public void iniciar() {
        Scanner sn = new Scanner(System.in);
        //      String bd="";
        boolean salir = false;
        int opcion;
        //    bd = conectarBd();
        while (!salir) {

            System.out.println("MENU FACTURA");
            System.out.println("***************************************");
            System.out.println("1.- Añadir linea");
            System.out.println("2.- Imprimir factura");
            System.out.println("3.- Listar productos");
            System.out.println("4.- Añadir productos");
            System.out.println("5.- Buscar producto(ref)");
            System.out.println("6.- Salir");
            System.out.print("Elige una opción: ");
            opcion = sn.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Añadiendo linea(s)..");
                    this.anadirLinea();
                }
                case 2 -> {
                    System.out.println("Imprimiendo factura...");
                    this.getFactura().imprimirFactura();
                }
                case 3 -> {
                    System.out.println("Listado de productos...");
                    this.bd.listarProductos();
                }
                case 4 -> {
                    System.out.println("Añadiendo productos...");
                    this.bd.añadirProductoBase();

                }
                case 5 -> this.BuscarProducto();
                case 6 -> salir = true;
            }
        }
    }
}