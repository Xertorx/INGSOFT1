package co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades;

import java.util.Date;

public class Emprendimiento {

    private String codigoEmp;
    private String nombreEmp;
    private String nit;
    private String descripcion;
    private String ubicacion;
    private Date fechaFundacion;
    private int estado;
    private String logotipo;
    private String redesSociales;
    private String telefono;


    public Emprendimiento(String codigoEmp, String nombreEmp, String nit, String descripcion,
                          String ubicacion, Date fechaFundacion, int estado, String logotipo,
                          String redesSociales, String telefono) {
        this.codigoEmp = codigoEmp;
        this.nombreEmp = nombreEmp;
        this.nit = nit;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.fechaFundacion = fechaFundacion;
        this.estado = estado;
        this.logotipo = logotipo;
        this.redesSociales = redesSociales;
        this.telefono = telefono;
    }

    // Getters y Setters
    public String getCodigoEmp() {
        return codigoEmp;
    }

    public void setCodigoEmp(String codigoEmp) {
        this.codigoEmp = codigoEmp;
    }

    public String getNombreEmp() {
        return nombreEmp;
    }

    public void setNombreEmp(String nombreEmp) {
        this.nombreEmp = nombreEmp;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(Date fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getLogotipo() {
        return logotipo;
    }

    public void setLogotipo(String logotipo) {
        this.logotipo = logotipo;
    }

    public String getRedesSociales() {
        return redesSociales;
    }

    public void setRedesSociales(String redesSociales) {
        this.redesSociales = redesSociales;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Emprendimiento{" +
                "codigoEmp='" + codigoEmp + '\'' +
                ", nombreEmp='" + nombreEmp + '\'' +
                ", nit='" + nit + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", fechaFundacion=" + fechaFundacion +
                ", estado=" + estado +
                ", logotipo='" + logotipo + '\'' +
                ", redesSociales='" + redesSociales + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    // Método para verificar si el emprendimiento está activo
    public boolean esActivo() {
        return estado == 1;
    }
}
