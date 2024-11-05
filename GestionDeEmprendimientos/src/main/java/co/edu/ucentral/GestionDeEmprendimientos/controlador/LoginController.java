package co.edu.ucentral.GestionDeEmprendimientos.controlador;



import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Usuario;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios.UsuarioService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

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
                        Model model, HttpSession session) {
        Optional<Usuario> optionalUsuario = usuarioService.authenticate(correo, contrasena);

        if (optionalUsuario.isEmpty()) {
            model.addAttribute("error", "Correo o contraseña incorrectos.");
            return "login";
        }
        Usuario usuario = optionalUsuario.get();

        Integer rolCodigo = usuario.getCodigo_rol().getCodigo_rol();

        session.setAttribute("usuario", usuario);
        if (rolCodigo == 1) {
            return "redirect:/"; // Redirige a la página para rol 1
        } else if (rolCodigo == 2) {
            return "redirect:/"; // Redirige a la página para rol 2
        } else {
            model.addAttribute("error", "Rol no reconocido.");
            return "login";
        }
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session, SessionStatus status) {
        session.invalidate();
        status.setComplete();
        return "redirect:/";
    }
}