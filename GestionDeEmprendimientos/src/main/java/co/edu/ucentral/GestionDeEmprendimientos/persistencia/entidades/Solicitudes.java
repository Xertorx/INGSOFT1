package co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "solicitudes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Solicitudes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SOLICITUDES")
    @SequenceGenerator(name = "SEQ_SOLICITUDES", sequenceName = "SEQ_SOLICITUDES", allocationSize = 1)
    @Column(name = "id_solicitud", updatable = false, nullable = false)
    private Integer idSolicitud;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "numero_documento", nullable = false)
    private Usuario usuario;

}

