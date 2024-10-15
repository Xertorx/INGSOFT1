package co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Propietario;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Vehiculo;
import org.springframework.data.repository.CrudRepository;

public interface PropietarioRepositorio extends CrudRepository<Propietario, Long> {
}
