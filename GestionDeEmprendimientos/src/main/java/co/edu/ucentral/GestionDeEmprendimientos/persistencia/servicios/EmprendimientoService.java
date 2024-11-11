package co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Emprendimientos;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Planes;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.EmprendimientoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmprendimientoService {

    private final EmprendimientoRepository emprendimientoRepository;
   // private final RolRepository rolRepository;

    public EmprendimientoService(EmprendimientoRepository emprendimientoRepository) {
        this.emprendimientoRepository = emprendimientoRepository;
    }

    @Transactional
    public Emprendimientos registrarEmprendimiento(Emprendimientos emprendimientos) {

            return emprendimientoRepository.save(emprendimientos);
    }
    @Transactional(readOnly = true)
    public List<Emprendimientos> listarEmprendimientos() {
        return emprendimientoRepository.findAll();
    }

}
