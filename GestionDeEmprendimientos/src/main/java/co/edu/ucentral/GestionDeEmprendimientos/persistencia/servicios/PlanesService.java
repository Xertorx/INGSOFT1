package co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Planes;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Rol;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Usuario;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.PlanesRepository;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.RolRepository;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PlanesService {

    private final PlanesRepository planesRepository;
   // private final RolRepository rolRepository;

    public PlanesService(PlanesRepository planesRepository) {
        this.planesRepository = planesRepository;
    }

    @Transactional
    public Planes registrarPlan(Planes plan) {
        //Rol rolPredeterminado = rolRepository.findByCodigoRol(1);

        Optional<Planes> planExistente = planesRepository.findBynombrePlan(plan.getNombrePlan());

        if (planExistente.isPresent()) {
            throw new IllegalArgumentException("El plan con el nombre " + plan.getNombrePlan() + " ya existe.");
        } else {

            return planesRepository.save(plan);
        }
    }

}
