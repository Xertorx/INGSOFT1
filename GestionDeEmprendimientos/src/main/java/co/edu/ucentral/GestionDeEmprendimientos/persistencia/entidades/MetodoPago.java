package co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "metodo_pago")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MetodoPago {

    @Id
    @Column(name = "id_metodo")
    private Integer idMetodo;

    @Column(name = "tipo_metodo")
    private String tipoMetodo;

    @Column(name = "descripcion")
    private String descripcion;
}
