package co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades;

public class Planes {

    private int idPlan;
    private String nombrePlan;
    private String descripcion;
    private float precio;

    public Planes(int idPlan, String nombrePlan, String descripcion, float precio) {
        this.idPlan = idPlan;
        this.nombrePlan = nombrePlan;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(int idPlan) {
        this.idPlan = idPlan;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    // Método para mostrar detalles del plan
    @Override
    public String toString() {
        return "Planes{" +
                "idPlan=" + idPlan +
                ", nombrePlan='" + nombrePlan + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }
}
