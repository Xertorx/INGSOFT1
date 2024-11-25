package co.edu.ucentral.GestionDeEmprendimientos.config;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Rol;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Etapa;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.EtapaRepository;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.RolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private RolRepository rolRepositorio;
    private EtapaRepository etapaRepositorio;

    public DataInitializer(RolRepository rolRepositorio, EtapaRepository etapaRepositorio) {
        this.rolRepositorio = rolRepositorio;
        this.etapaRepositorio = etapaRepositorio;
    }

    @Override
    public void run(String... args) {
        // Inicializar datos en la tabla Rol
        if (rolRepositorio.count() == 0) {
            rolRepositorio.saveAll(List.of(
                new Rol(1, "Emprendedor", null),
                new Rol(2, "Administrador", null)
            ));
            System.out.println("Roles inicializados.");
        } else {
            System.out.println("Los roles ya están inicializados.");
        }

        // Inicializar datos en la tabla Etapa
        if (etapaRepositorio.count() == 0) {
            etapaRepositorio.saveAll(List.of(
                new Etapa(1, "Inicio del flujo de trabajo. Esta etapa marca el comienzo de las actividades.", "Inicio"),
                new Etapa(2, "Revisión inicial de los datos y requisitos proporcionados.", "Revisión de Datos"),
                new Etapa(3, "Ejecución de tareas relacionadas con el desarrollo del proyecto.", "Desarrollo"),
                new Etapa(4, "Etapa final donde se realiza la validación y cierre del proyecto.", "Cierre")
            ));
            System.out.println("Etapas inicializadas.");
        } else {
            System.out.println("Las etapas ya están inicializadas.");
        }
    }
}
