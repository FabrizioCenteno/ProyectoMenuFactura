
package tienda.bd;

import tienda.stock.Producto;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class BD_Productos {
    Producto producto;
    private List<Producto> bdProductos = new ArrayList<>();

    public BD_Productos() {


    }

    public void añadirProductoBase() {
        while (true) {
            System.out.println("---- INTRO PARA TERMINAR ---");
            Scanner sn = new Scanner(System.in);
            System.out.print("Descripción del producto:");
            String descrip = sn.nextLine();
            // sn.nextLine();
            // Verificar si se presionó Enter
            if (descrip.isEmpty()) {
                break; // Terminar la ejecución del método
            }
            System.out.print("Añadir el Precio:");
            double precio = sn.nextDouble();
            sn.nextLine();
            if (Double.isNaN(precio)) {
                break; // Terminar la ejecución del método
            }
            producto = new Producto(descrip, precio);

            bdProductos.add(producto);

        }

    }

    public void añadirProductoBase(String descrip, double precio) {

        producto = new Producto(descrip, precio);

        bdProductos.add(producto);


    }

    public Producto buscarProducto(String referencia) {
        for (Producto productoo : bdProductos) {
            if (productoo.getRef().equals(referencia)) {
                //System.out.println(productoo.aCadena());
                return productoo;
            }
        }

        return null;
    }

    public void listarProductos() {
        for (Producto bd : this.bdProductos) {
            System.out.println(bd.aCadena());

        }

    }
}
