package co.edu.ucentral.GestionDeEmprendimientos.controlador;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Vehiculo;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios.VehiculoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@AllArgsConstructor
@Controller
public class VehiculoControlador {

    VehiculoServicio vehiculoServicio;

    public List<Vehiculo> obtenerTodos(){
        return vehiculoServicio.obtenerTodos();
    }
}
