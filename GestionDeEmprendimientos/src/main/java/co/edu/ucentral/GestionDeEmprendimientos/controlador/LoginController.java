package co.edu.ucentral.GestionDeEmprendimientos.controlador;



import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Usuario;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@AllArgsConstructor

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService; // Supongamos que tienes un servicio para manejar la lógica de usuarios

    @GetMapping("/login")
    public String loginPage(Model model) {
        return "login"; // La vista que contiene el formulario de login
    }

    @PostMapping("/login")
    public String login(@RequestParam("correo") String correo,
                        @RequestParam("contrasena") String contrasena,
                        Model model) {
        boolean isAuthenticated = usuarioService.authenticate(correo, contrasena);

        if (!isAuthenticated) {
            model.addAttribute("error", "Correo o contraseña incorrectos.");
            return "login"; // Regresar a la página de login
        }else{
            // Lógica para iniciar sesión y redirigir a la página deseada
            return "redirect:/"; // O la ruta que desees
        }


    }
}
    /*
    @PostMapping({"/login"})
    public String login(
            @RequestParam("numeroDocumento") Integer numeroDocumento,
            @RequestParam("contrasena") String contrasena,
            Model model) {

        Optional<Usuario> usuario = usuarioService.authenticate(numeroDocumento, contrasena);

        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "redirect:/welcome"; // Redirige a la página de bienvenida o dashboard
        } else {
            model.addAttribute("error", "Credenciales incorrectas. Inténtalo de nuevo.");
            return "login"; // Regresa al formulario de login con el mensaje de error
        }
    }

    @GetMapping("/welcome")
    public String showWelcomePage(Model model) {
        return "welcome"; // Esta es la página de bienvenida o menú principal después del login exitoso
    }*/
