package co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades;

public class Metodopago {
    // Atributos
    private int idMetodo;
    private String tipoMetodo;
    private String descripcion;

    // Constructor
    public Metodopago(int idMetodo, String tipoMetodo, String descripcion) {
        this.idMetodo = idMetodo;
        this.tipoMetodo = tipoMetodo;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(int idMetodo) {
        this.idMetodo = idMetodo;
    }

    public String getTipoMetodo() {
        return tipoMetodo;
    }

    public void setTipoMetodo(String tipoMetodo) {
        this.tipoMetodo = tipoMetodo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Métodos adicionales
    public void cambiarTipoMetodo(String nuevoTipo) {
        if (nuevoTipo != null && !nuevoTipo.isEmpty()) {
            this.tipoMetodo = nuevoTipo;
        } else {
            System.out.println("El nuevo tipo de método no es válido.");
        }
    }

    public void actualizarDescripcion(String nuevaDescripcion) {
        if (nuevaDescripcion != null && !nuevaDescripcion.isEmpty()) {
            this.descripcion = nuevaDescripcion;
        } else {
            System.out.println("La nueva descripción no es válida.");
        }
    }

    // Método para mostrar los detalles del método de pago
    @Override
    public String toString() {
        return "Metodo_Pago{" +
                "idMetodo=" + idMetodo +
                ", tipoMetodo='" + tipoMetodo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    // Validación del método de pago (puedes personalizar esto según tu lógica)
    public boolean esValido() {
        return tipoMetodo != null && !tipoMetodo.isEmpty() && descripcion != null && !descripcion.isEmpty();
    }
}

