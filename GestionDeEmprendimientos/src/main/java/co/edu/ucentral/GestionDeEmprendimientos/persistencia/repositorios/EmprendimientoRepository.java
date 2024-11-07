package co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Emprendimiento;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Planes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EmprendimientoRepository extends JpaRepository<Emprendimiento, Integer> {

}
