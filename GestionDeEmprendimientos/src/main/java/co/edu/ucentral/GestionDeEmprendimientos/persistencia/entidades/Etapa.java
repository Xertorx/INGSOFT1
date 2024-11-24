package co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "etapas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etapa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ETAPA")
    @SequenceGenerator(name = "SEQ_ETAPA", sequenceName = "SEQ_ETAPA", allocationSize = 1)
    @Column(name = "id_etapa", updatable = false, nullable = false)
    private Integer idEtapa;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    public void setNombre(String inicio) {

    }
}
