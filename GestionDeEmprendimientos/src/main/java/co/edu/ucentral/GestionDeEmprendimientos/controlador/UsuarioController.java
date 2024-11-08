package co.edu.ucentral.GestionDeEmprendimientos.controlador;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Emprendimiento;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Usuario;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.RolRepository;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.UsuarioRepository;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios.UsuarioService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        // Obtener la lista de todos los usuarios
        List<Usuario> listaUsuarios = usuarioRepository.findAll();

        // Agregar la lista de usuarios al modelo para que Thymeleaf pueda acceder a ella
        model.addAttribute("usuarios", listaUsuarios);

        // Retorna el nombre de la vista (por ejemplo, usuarios.html)
        return "usuarios";
    }
    @GetMapping("/emprendedor/micuenta")
    public String mostrarMicuenta(Model model, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            // Redirige a la página de inicio de sesión o muestra un mensaje de error
            return "redirect:../login";
        }
        model.addAttribute("emprendimiento", new Emprendimiento());
        model.addAttribute("usuario", usuario);
        return "Emprendedor/micuenta";
    }
    //Mostrar Informacion del usuario logueado
    @GetMapping("/emprendedor/micuenta/datos-personales")
    public String informacionUsuarioLogueado(Model model,HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            // Redirige a la página de inicio de sesión o muestra un mensaje de error
            return "redirect:/login";
        }

        model.addAttribute("emprendimiento", new Emprendimiento());
        model.addAttribute("usuario", usuario);
        model.addAttribute("mostrarDiv2", true); // Indicador para mostrar div1
        return "Emprendedor/micuenta";
    }
    //Actualizar Informacion
    @PostMapping("/emprendedor/micuenta/datos-personales/actualizar")
    public String actualizarInformacion(@Valid @ModelAttribute("usuario") Usuario usuario,
                                        BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("error", result);
            return "/Emprendedor/micuenta/datos-personales";

        }
        try {
            usuarioService.actualizarUsuario(usuario);
            model.addAttribute("successMessage", "Usuario actualizado Correctamente");
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        model.addAttribute("emprendimiento", new Emprendimiento());
        model.addAttribute("usuario", usuario);
        model.addAttribute("mostrarDiv2", true); // Indicador para mostrar div1
        return "/Emprendedor/micuenta";
    }
/*
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

*/
}
