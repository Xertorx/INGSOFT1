package co.edu.ucentral.GestionDeEmprendimientos.controlador;



import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class RegisterController {

   /* private final UsuarioService usuarioService;

    @Autowired
    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }*/

    @GetMapping({"/register"})
    public String login() {
        return "register"; // nombre del archivo login.html
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
}