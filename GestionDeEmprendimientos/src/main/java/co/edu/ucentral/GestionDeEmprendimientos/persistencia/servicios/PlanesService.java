package co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Planes;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.PlanesRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PlanesService {

    private final PlanesRepository planesRepository;

    public PlanesService(PlanesRepository planesRepository) {
        this.planesRepository = planesRepository;
    }

    @Transactional
    public Planes registrarPlan(Planes plan) {
        Optional<Planes> planExistente = planesRepository.findBynombrePlan(plan.getNombrePlan());
        if (planExistente.isPresent()) {
            throw new IllegalArgumentException("El plan con el nombre " + plan.getNombrePlan() + " ya existe.");
        } else {
            return planesRepository.save(plan);
        }
    }
    @Transactional(readOnly = true)
    public List<Planes> listarPlanes() {
        return planesRepository.findAll();
    }
    @Transactional
    public Planes buscarPlanPorId(Integer id) {
        return planesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El plan con ID " + id + " no existe."));
    }


}
