package co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades;

import java.util.Date;

public class Factura {
    // Atributos
    private int idFactura;
    private float monto;
    private Date fecha;
    private String estado;

    // Constructor
    public Factura(int idFactura, float monto, Date fecha, String estado) {
        this.idFactura = idFactura;
        this.monto = monto;
        this.fecha = fecha;
        this.estado = estado;
    }
}
