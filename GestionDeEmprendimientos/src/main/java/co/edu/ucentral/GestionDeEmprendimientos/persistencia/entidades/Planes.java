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
    @Column(name = "id_plan")
    private Integer idPlan;

    @Column(name = "nombre_plan")
    private String nombrePlan;

    @Column(name = "tipo_plan")
    private Integer tipoPlan;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private Float precio;
}

