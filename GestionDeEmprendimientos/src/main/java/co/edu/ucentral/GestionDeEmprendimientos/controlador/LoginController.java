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
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        return "login"; // Vista con el formulario de login
    }

    @PostMapping("/login")
    public String login(@RequestParam("correo") String correo,
                        @RequestParam("contrasena") String contrasena,
                        Model model) {
        Optional<Usuario> optionalUsuario = usuarioService.authenticate(correo, contrasena);

        if (optionalUsuario.isEmpty()) {
            model.addAttribute("error", "Correo o contraseña incorrectos.");
            return "login";
        }
        Usuario usuario = optionalUsuario.get();

        Integer rolCodigo = usuario.getCodigo_rol().getCodigo_rol();

        // Redirige según el rol del usuario
        if (rolCodigo == 1) {
            return "redirect:/paginaRol1"; // Redirige a la página para rol 1
        } else if (rolCodigo == 2) {
            return "redirect:/paginaRol2"; // Redirige a la página para rol 2
        } else {
            model.addAttribute("error", "Rol no reconocido.");
            return "login";
        }
    }
} /*
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
