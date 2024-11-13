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

    @Column(name = "etapa")
    private Integer etapa;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "workFlow")
    private List<Emprendimientos> emprendimientos;
}
