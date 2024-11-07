package co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "planes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Planes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PLANES")
    @SequenceGenerator(name = "SEQ_PLANES", sequenceName = "SEQ_PLANES", allocationSize = 1)
    @Column(name = "id_plan", updatable = false, nullable = false)
    private Integer idPlan;

    @Column(name = "nombre_plan")
    private String nombrePlan;

    @Column(name = "tipo_plan")
    private String tipoPlan;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private Float precio;
}

