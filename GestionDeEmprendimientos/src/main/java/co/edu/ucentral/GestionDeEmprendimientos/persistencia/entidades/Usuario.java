package co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @Column(name = "numero_documento")
    private Integer numeroDocumento;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "correo")
    private String correo;


    @Column(name = "numero_telefono")
    private String numeroTelefono;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "estado")
    private String estado;

    @Column(name = "contrasena")
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "rol",referencedColumnName = "codigo_rol")
    private Rol codigo_rol;

}

