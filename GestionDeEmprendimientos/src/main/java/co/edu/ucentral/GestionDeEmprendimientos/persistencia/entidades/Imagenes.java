package co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Imagenes {

    @Column(name = "logo")
    private String logo;
    @Transient
    private MultipartFile logoFile;

    @Column(name = "imagen1")
    private String imagen1;

    @Column(name = "imagen2")
    private String imagen2;

    @Column(name = "imagen3")
    private String imagen3;

    @Column(name = "imagen4")
    private String imagen4;

    @Column(name = "imagen5")
    private String imagen5;


}
