package co.edu.ucentral.GestionDeEmprendimientos.controlador;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Herramientas;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Vehiculo;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios.HerramientasServicio;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios.VehiculoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class HerramientasControlador {

    HerramientasServicio herramientasServicio;

    @GetMapping({"/herramientas"})
    public String obtenerTodos(Model model){
        List<Herramientas> listado = herramientasServicio.obtenerTodos();
        model.addAttribute("misherramientas",listado);
        return "herramientas";
    }
}
