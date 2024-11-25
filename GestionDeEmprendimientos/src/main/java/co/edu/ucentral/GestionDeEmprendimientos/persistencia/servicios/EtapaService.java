package co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Etapa;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.EtapaRepository;
import org.springframework.stereotype.Service;

@Service
public class EtapaService {


    private final EtapaRepository etapaRepository;

    public EtapaService( EtapaRepository etapaRepository) {
        this.etapaRepository = etapaRepository;

    }
    public Etapa obtenerEtapaPorId(Integer idEtapa) {
        return etapaRepository.findById(idEtapa)
                .orElseThrow(() -> new RuntimeException("La etapa con el id '" + idEtapa + "' no fue encontrada."));
    }

}
