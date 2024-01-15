package tienda.factura;

import tienda.stock.Producto;

public class LineaFactura {
    private Producto producto;
    private int cantidad;
    private double importelinea;

    public LineaFactura(Producto p, int c) {
        this.setProducto(p);
        this.setCantidad(c);
        this.setImportelinea(this.getProducto().getPrecioUnitario() * c);
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getImportelinea() {
        return importelinea;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setImportelinea(double importelinea) {
        this.importelinea = importelinea;
    }


    public String aCadena() {
        return  this.getProducto().getRef() + "\t\t"
                + this.getProducto().getDescripcion() + "\t\t\t"
                + this.getCantidad() + "\t\t\t"
                + this.getProducto().getPrecioUnitario() + "\t\t"
                + this.getImportelinea();
    }
}