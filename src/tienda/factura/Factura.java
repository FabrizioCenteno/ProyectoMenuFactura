package tienda.factura;

import tienda.stock.Producto;

import java.time.LocalDate;
import java.util.*;

public class Factura {
    private String cif;
    private String numero;
    private LocalDate fechaFactura;
    private List<LineaFactura> lineas;
    private static double IVA = 0.21;
    private Set<String> numerosGenerados = new HashSet<>();

    public Factura(String cif, String numero) {
        this.lineas = new ArrayList<>();
        this.setCif(cif);
        this.setNumero(numero);
        this.fechaFactura = LocalDate.now();
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif){this.cif=cif;}

    public static double getIVA() {
        return IVA;
    }

    public static void setIVA(double IVA) {
        Factura.IVA = IVA;
    }

    public String getNumero() {
        return numero;
    }


    public void setNumero(String numero) {
        if (validarFormatoNumero(numero)) {
            if (numerosGenerados.add(numero)) {
                this.numero = numero;
            } else {
                // Lanzar una excepción si el número ya ha sido generado previamente
                throw new IllegalArgumentException("Error: El número ya ha sido generado previamente.");
            }
        } else {
            // Lanzar una excepción si el formato del número no es válido
            throw new IllegalArgumentException("Error: El número debe seguir el patrón \"3 digitos-3 digitos\"");
        }
    }

    public LocalDate getFechaFactura() {
        return fechaFactura;
    }

    private boolean validarFormatoNumero(String numero) {

        return numero.matches("\\d{3}-\\d{3}");
    }

    public void  anadirLinea(Producto p, int cantidad) {
        LineaFactura lf = new LineaFactura(p, cantidad);
        this.lineas.add(lf);
        p.getLineas().add(lf);
        //   System.out.println(lf.aCadena());

    }

    public List<LineaFactura> getLineas() {
        return lineas;
    }

    public void listadoProductos() {
        for (LineaFactura lf : this.getLineas()) {
            System.out.println(lf.getProducto());
        }
    }

    public double getSubtotal() {
        double subTotal = 0;
        for (LineaFactura lf : lineas) {
            subTotal += lf.getImportelinea();
        }

        return subTotal;
    }

    public double getImporteIva() {
        return this.getSubtotal() * IVA;
    }

    public double getTotal() {
        return this.getSubtotal() + this.getImporteIva();
    }

    public void imprimirFactura() {
        for (int i = 0; i < 30; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.println("CIF: " + this.getCif());
        System.out.println("FECHA: " + this.getFechaFactura() + "\t\tFACTURA NUM: " + this.getNumero());
        System.out.println("REF\t\tDESCRIPCION\t\tCANT\t\tPRECIOU\t\tIMPORTE");
        for (int i = 0; i < 70; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (LineaFactura lf : lineas) {
            System.out.println(lf.aCadena());
            System.out.println();
        }
        System.out.printf("\t\t\t\tSUBTOTAL: " + "%.2f",this.getSubtotal());
        System.out.println();
        System.out.printf("\tIVA: " + IVA + "\tIMPORTE IVA: " + "%.2f",this.getImporteIva());
        System.out.println();
        System.out.printf("\t\t\t\tTOTAL: %.2f",this.getTotal());
        System.out.println();

        for (int i = 0; i < 70; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

}