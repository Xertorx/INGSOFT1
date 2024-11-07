package co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Emprendimiento;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Usuario;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.EmprendimientoRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmprendimientoService {

    private final EmprendimientoRepository emprendimientoRepository;
   // private final RolRepository rolRepository;

    public EmprendimientoService(EmprendimientoRepository emprendimientoRepository) {
        this.emprendimientoRepository = emprendimientoRepository;
    }

    @Transactional
    public Emprendimiento registrarEmprendimiento(Emprendimiento emprendimiento) {

            return emprendimientoRepository.save(emprendimiento);
    }

}
