package co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades;

public class Administrador extends Usuario {
    // Atributo específico de Administrador
    private String topDocumento;

    public Administrador(int numeroDocumento, String nombres, String apellidos, String tipoDocumento,
                         String numeroTelefono, Date fechaNacimiento, String estado, String contrasena,
                         String topDocumento) {
        super(numeroDocumento, nombres, apellidos, tipoDocumento, numeroTelefono, fechaNacimiento, estado, contrasena);
        this.topDocumento = topDocumento;
    }
    public String getTopDocumento() {
        return topDocumento;
    }

    public void setTopDocumento(String topDocumento) {
        this.topDocumento = topDocumento;
    }
    @Override
    public String toString() {
        return super.toString() + ", Administrador{" + "topDocumento='" + topDocumento + '\'' + '}';
    }
}

