package co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.*;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.EtapaRepository;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.workFlowRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class WorkFlowService {

    private final workFlowRepository workflowRepository;
    private final EtapaRepository etapaRepository;

    public WorkFlowService(workFlowRepository workflowRepository, EtapaRepository etapaRepository) {
        this.workflowRepository = workflowRepository;
        this.etapaRepository = etapaRepository;
    }

    public WorkFlow crearWorkflowInicial() {
        // Buscar la etapa inicial en la base de datos
        Optional<Etapa> etapaInicialOpt = etapaRepository.findById(1);

        if (etapaInicialOpt.isEmpty()) {
            throw new RuntimeException("La etapa inicial no está configurada en la base de datos.");
        }

        // Crear el Workflow y asignar la etapa inicial
        WorkFlow workflow = new WorkFlow();
        workflow.setEtapa(etapaInicialOpt.get());

        // Guardar el Workflow
        return workflowRepository.save(workflow);
    }
    public WorkFlow buscarPorEmprendimineto(Emprendimientos emprendimiento){
        return workflowRepository.findByEmprendimiento(emprendimiento);
    }
    @Transactional
    public WorkFlow guardarInformacion(WorkFlow workFlow){
        return workflowRepository.save(workFlow);
    }
}

