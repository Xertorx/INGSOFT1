package co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "etapas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etapa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ETAPA")
    @SequenceGenerator(name = "SEQ_ETAPA", sequenceName = "SEQ_ETAPA", allocationSize = 1)
    @Column(name = "id_etapa", updatable = false, nullable = false)
    private Integer idEtapa;

    @ManyToOne
    @JoinColumn(name = "workflow_id", nullable = false)
    private WorkFlow workFlow;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "informacion")
    private String informacion;

    @Lob
    @Column(name = "archivo", columnDefinition = "BYTEA")
    private byte[] archivo;

    @Column(name = "tipo_archivo")
    private String tipoArchivo;
}
