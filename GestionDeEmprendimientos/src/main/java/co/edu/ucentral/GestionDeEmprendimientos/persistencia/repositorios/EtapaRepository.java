package co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Etapa;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.WorkFlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EtapaRepository extends JpaRepository<Etapa, Integer> {

}
