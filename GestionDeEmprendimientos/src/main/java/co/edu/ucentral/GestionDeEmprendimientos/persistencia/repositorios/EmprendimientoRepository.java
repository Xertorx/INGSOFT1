package co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Emprendimientos;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmprendimientoRepository extends JpaRepository<Emprendimientos, Integer> {
    Emprendimientos findByUsuario(Usuario usuario);
}
