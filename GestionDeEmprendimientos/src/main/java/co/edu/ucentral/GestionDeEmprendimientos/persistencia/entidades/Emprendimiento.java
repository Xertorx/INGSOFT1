package co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "emprendimiento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Emprendimiento {

    @Id
    @Column(name = "codigo_emp")
    private Integer codigoEmp;

    @Column(name = "nombre_emp")
    private String nombreEmp;

    @Column(name = "nit")
    private String nit;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "categoria")
    private Integer categoria;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "fecha_fundacion")
    @Temporal(TemporalType.DATE)
    private Date fechaFundacion;

    @Column(name = "id_estado_emp")
    private Integer idEstadoEmp;

    @Column(name = "logo")
    private String logo;

    @Column(name = "redes_sociales")
    private String redesSociales;

    @Column(name = "telefono")
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "numero_documento")
    private Usuario usuario;
}

