package model;

public class Inmueble {
private String tipo;
private String ubicacion;
private String   precio;

    public Inmueble(String tipo, String ubicacion, String precio) {
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Inmueble{" +
                "tipo='" + tipo + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }
}
