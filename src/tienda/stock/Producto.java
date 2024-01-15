
package tienda.stock;

import tienda.factura.LineaFactura;

import java.util.ArrayList;
import java.util.List;

public class Producto {
    private static int ultimaReferencia=0;
    private  String ref;
    public String descripcion;
    public double precioUnitario;
    private List<LineaFactura> lineas = new ArrayList<>();


    //Constructor
    public Producto(String descrp,double precio){

        this.setDescripcion(descrp);
        this.setPrecioUnitario(precio);
        this.ref=generarNuevaReferencia();

    }
    //Metodos get/set

    private String generarNuevaReferencia(){
        ultimaReferencia++;
        return String.format("REF%03d",ultimaReferencia);
    }
    public String getRef(){
        return ref;
    }

    public List<LineaFactura> getLineas() {
        return lineas;
    }

    //---------------------------------
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descrp){
        this.descripcion=descrp;

    }
    //--------------------------------------------
    public double getPrecioUnitario(){
        return precioUnitario;
    }
    public void setPrecioUnitario(double precio){
        this.precioUnitario=precio;
    }
    //--------------------------------------------


    public String aCadena(){

        return "--------------------------------------\n"+
                "Numero de referencia:\t"+ this.ref+"\n"+
                "Descripción\t"+ this.descripcion+"\n "+
                "Precio Unitario\t"+ this.precioUnitario+"\n"+
                "--------------------------------------------\n";

    }
}
