package co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rol")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rol {

    @Id
    @Column(name = "codigo_rol")
    private Integer codigo_rol;

    @Column(name = "rol")
    private String rol;

    @OneToMany(mappedBy = "codigo_rol")
    private List<Usuario> usuarios;


}

