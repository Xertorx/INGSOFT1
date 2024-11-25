package co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Archivos {

    // Archivo principal (por ejemplo, un logo)
    @Column(name = "archivo1")
    private String archivo1;

    // Segundo archivo
    @Column(name = "archivo2")
    private String archivo2;

    // Tercer archivo
    @Column(name = "archivo3")
    private String archivo3;

    // Cuarto archivo
    @Column(name = "archivo4")
    private String archivo4;

}
