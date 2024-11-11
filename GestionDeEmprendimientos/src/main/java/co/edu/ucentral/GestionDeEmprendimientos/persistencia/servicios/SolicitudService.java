package co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Emprendimiento;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Solicitudes;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.EmprendimientoRepository;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.SolicitudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;
   // private final RolRepository rolRepository;

    public SolicitudService(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    @Transactional
    public Solicitudes registrarSolicitud(Solicitudes solicitud) {
            return solicitudRepository.save(solicitud);
    }

}
