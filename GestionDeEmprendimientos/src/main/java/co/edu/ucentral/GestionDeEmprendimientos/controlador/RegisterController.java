package co.edu.ucentral.GestionDeEmprendimientos.controlador;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Usuario;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.RolRepository;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class RegisterController {


    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private RolRepository rolRepository;

    @GetMapping("/registro")
    public String registarPage(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario,
                                   BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", result);
            return "registro";

        }
        try {
            usuarioService.registrarUsuario(usuario);
            model.addAttribute("successMessage", "Usuario Registrado Correctamente");
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }

        return "redirect:/login";
    }
    @PostMapping("/registroAdmin")
    public String registrarUsuarioAdmin(@Valid @ModelAttribute("usuario") Usuario usuario,
                                        BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", result);
            return "Administrador/registroAdmin";
        }

        try {
            usuarioService.registrarUsuarioAdmin(usuario);
            model.addAttribute("successMessage", "Usuario Registrado Correctamente");
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "Administrador/registroAdmin";
        }

        return "redirect:/Administrador/registroAdmin";
    }


}