package co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name =  "herramientas")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Herramientas {
    @Id
    @Column (name= "her_codigo")
    public int codigo;
    @Column (name= "her_nombre")
    public String nombre;
    @Column (name= "her_precio")
    public String precio;
}
