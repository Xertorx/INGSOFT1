package co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Planes;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PlanesRepository extends JpaRepository<Planes, Integer> {
    Optional<Planes> findBynombrePlan(String Plan);
}
