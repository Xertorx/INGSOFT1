package co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades;

import java.util.Date;

public class Usuario {
    // Atributos
    private int numeroDocumento;
    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String numeroTelefono;
    private Date fechaNacimiento;
    private String estado;
    private String contrasena;

    // Constructor
    public Usuario(int numeroDocumento, String nombres, String apellidos, String tipoDocumento,
                   String numeroTelefono, Date fechaNacimiento, String estado, String contrasena) {
        this.numeroDocumento = numeroDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.numeroTelefono = numeroTelefono;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
        this.contrasena = contrasena;
    }

    // Getters y Setters
    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // Método para mostrar detalles del usuario
    @Override
    public String toString() {
        return "Usuario{" +
                "numeroDocumento=" + numeroDocumento +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", estado='" + estado + '\'' +
                '}';
    }

    // Método para validar el estado
    public boolean esActivo() {
        return "Activo".equalsIgnoreCase(this.estado);
    }
}
