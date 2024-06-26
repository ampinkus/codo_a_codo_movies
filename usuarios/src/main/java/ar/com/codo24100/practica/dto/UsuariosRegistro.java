package ar.com.codo24100.practica.dto;

import java.time.LocalDate;

public class UsuariosRegistro {
    // Atributos
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private LocalDate fecha;
    private String pais;

    // Constructor
    public UsuariosRegistro(String nombre, String apellido, String email, String contrasena, LocalDate fecha, String pais) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
        this.fecha = fecha;
        this.pais = pais;
    }

    // Métodos (get/set u otros)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "MoviesRegistro [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
                + ", contrasena=" + contrasena + ", fecha=" + fecha + ", pais=" + pais + "]";
    }
}
