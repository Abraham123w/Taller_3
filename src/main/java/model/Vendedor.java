package model;

public class Vendedor {

    private String nombre;
    private String rut;
    private  String   direccion;
    private String titulo;
    private String estadoCivil;

    public Vendedor(String nombre, String rut, String direccion, String titulo, String estadoCivil) {
        this.nombre = nombre;
        this.rut = rut;
        this.direccion = direccion;
        this.titulo = titulo;
        this.estadoCivil = estadoCivil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "nombre='" + nombre + '\'' +
                ", rut='" + rut + '\'' +
                ", direccion='" + direccion + '\'' +
                ", titulo='" + titulo + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                '}';
    }
}
