package co.edu.ucentral.GestionDeEmprendimientos.controlador;



import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Emprendimientos;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios.EmprendimientoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class HomeController {




    @GetMapping({"/LayoutAdmin"})
    public String prueba() {
        return "LayoutAdmin"; // nombre del archivo login.html
    }
    @GetMapping({"/prueba3"})
    public String prueba3() {
        return "emprendimientoDetalles"; // nombre del archivo login.html
    }



}