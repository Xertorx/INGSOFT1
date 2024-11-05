package co.edu.ucentral.GestionDeEmprendimientos.controlador;



import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class HomeController {



    @GetMapping({"/"})
       public String index() {
        return "index"; // nombre del archivo login.html
    }
    @GetMapping({"/prueba"})
    public String prueba() {
        return "LayoutAdmin"; // nombre del archivo login.html
    }
    @GetMapping({"/registroAdmin"})
    public String prueba2() {
        return "Administrador/registro"; // nombre del archivo login.html
    }

}