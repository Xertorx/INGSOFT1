package co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "emprendimiento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Emprendimientos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMP")
    @SequenceGenerator(name = "SEQ_EMP", sequenceName = "SEQ_EMP", allocationSize = 1)
    @Column(name = "codigo_emp", updatable = false, nullable = false)
    private Integer codigoEmp;

    @Column(name = "nombre_emp")
    private String nombreEmp;

    @Column(name = "nit")
    private String nit;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "fecha_fundacion")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaFundacion;

    @Column(name = "estado_emp")
    private String estadoEmp;

    @Column(name = "redes_sociales")
    private String redesSociales;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "plan_id", referencedColumnName = "id_plan")
    private Planes plan;

    @ManyToOne
    @JoinColumn(name = "workflow_id", referencedColumnName = "id_workflow")
    private WorkFlow workFlow;

    @ManyToOne
    @JoinColumn(name = "usuario",referencedColumnName = "numero_documento" , nullable = false)
    private Usuario usuario;

    @Embedded
    private Imagenes imagenes;
}

