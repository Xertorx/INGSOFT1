package co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "workflow")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkFlow {

    @Id
    @Column(name = "id_workflow")
    private Integer idWorkFlow;

    @Column(name = "etapa")
    private Integer etapa;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "codigo_emp")
    private Emprendimiento emprendimiento;
}
