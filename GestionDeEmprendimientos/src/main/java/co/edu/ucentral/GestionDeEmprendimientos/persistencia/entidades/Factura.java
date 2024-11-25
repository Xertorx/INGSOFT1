package co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "factura")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Factura {

    @Id
    @Column(name = "id_factura")
    private Integer idFactura;

    @Column(name = "monto")
    private Float monto;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_plan")
    private Planes plan;

    @ManyToOne
    @JoinColumn(name = "id_metodo")
    private MetodoPago metodoPago;
}

