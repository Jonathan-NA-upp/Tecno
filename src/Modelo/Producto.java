package Modelo;

public class Producto {
    private int idtbProducto;
    private String producto;
    private String descripcion;
    private int cantidad;
    private int precioContado;
    private int precioMensualidad;

    public int getIdtbProducto() {
        return idtbProducto;
    }

    public String getProducto() {
        return producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getPrecioContado() {
        return precioContado;
    }

    public int getPrecioMensualidad() {
        return precioMensualidad;
    }

    public void setIdtbProducto(int idtbProducto) {
        this.idtbProducto = idtbProducto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioContado(int precioContado) {
        this.precioContado = precioContado;
    }

    public void setPrecioMensualidad(int precioMensualidad) {
        this.precioMensualidad = precioMensualidad;
    }
}
