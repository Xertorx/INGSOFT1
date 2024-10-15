package co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Herramientas;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Vehiculo;
import org.springframework.data.repository.CrudRepository;

public interface HerramientasRepositorio extends CrudRepository<Herramientas, Integer> {
}
