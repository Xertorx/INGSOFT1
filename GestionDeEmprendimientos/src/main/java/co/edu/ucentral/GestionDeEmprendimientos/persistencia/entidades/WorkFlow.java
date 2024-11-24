package co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "workflow")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkFlow {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_WORK")
    @SequenceGenerator(name = "SEQ_WORK", sequenceName = "SEQ_WORK", allocationSize = 1)
    @Column(name = "id_workflow", updatable = false, nullable = false)
    private Integer idWorkFlow;

    @Column(name = "estado")
    private String estado;

    @OneToOne(mappedBy = "workFlow")
    private Emprendimientos emprendimiento;

    @ManyToOne
    @JoinColumn(name = "etapa",referencedColumnName = "id_etapa" , nullable = false)
    private Etapa etapa;

    @Embedded
    private Archivos archivos;
    @Embedded
    private Informacion informacion;

}
