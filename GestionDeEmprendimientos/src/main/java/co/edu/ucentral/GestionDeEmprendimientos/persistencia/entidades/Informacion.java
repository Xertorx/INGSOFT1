package co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Informacion {


    @Column(name = "informacion1")
    private String informacion1;

    @Column(name = "informacion2")
    private String informacion2;
    @Column(name = "informacion3")
    private String informacion3;
    @Column(name = "informacion4")
    private String informacion4;

}
