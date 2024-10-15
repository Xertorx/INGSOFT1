package co.edu.ucentral.GestionDeEmprendimientos.controlador;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Vehiculo;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios.VehiculoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class VehiculoControlador {

    VehiculoServicio vehiculoServicio;

    @GetMapping({"/vehiculos"})
    public String obtenerTodos(Model model){
        List<Vehiculo> listado = vehiculoServicio.obtenerTodos();
        model.addAttribute("misvehiculos",listado);
        return "vehiculos";
    }
}
