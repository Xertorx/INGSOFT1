package co.edu.ucentral.GestionDeEmprendimientos.controlador;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Emprendimientos;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;
import java.util.Optional;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private RolRepository rolRepository;

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        List<Usuario> listaUsuarios = usuarioRepository.findAll();

        model.addAttribute("usuarios", listaUsuarios);

        return "usuarios";
    }
    @GetMapping("/emprendedor/micuenta")
    public String mostrarMicuenta(Model model, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:../login";
        }
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

        model.addAttribute("usuario",usuario);
        return "Emprendedor/datos";
    }
    //Actualizar Informacion
    @PostMapping("/emprendedor/micuenta/datos-personales/actualizar")
    public String actualizarInformacion(@Valid @ModelAttribute("usuario") Usuario usuario,
                                        BindingResult result, Model model, HttpSession session) {

        Usuario usuarioLogueado = (Usuario) session.getAttribute("usuario");
        if (result.hasErrors()) {
            model.addAttribute("error", result);
            return "Emprendedor/datos";
        }
        usuario.setCodigo_rol(usuarioLogueado.getCodigo_rol());
        usuario.setContrasena(usuarioLogueado.getContrasena());
        usuario.setEstado(usuarioLogueado.getEstado());
        try {
            usuarioService.actualizarUsuario(usuario);
            model.addAttribute("successMessage", "Usuario actualizado Correctamente");
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        model.addAttribute("usuario", usuario);
        return "Emprendedor/datos";
    }

    //Registro

    @GetMapping("/registro")
    public String registarPage(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario,
                                   BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", result);
            return "registro";

        }
        try {
            usuario.setCodigo_rol(rolRepository.findByCodigoRol(1));
            usuarioService.registrarUsuario(usuario);
            model.addAttribute("successMessage", "Usuario Registrado Correctamente");
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }

        return "redirect:/login";
    }

    @GetMapping("/registroAdmin")
    public String registrarAdminPage(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "Administrador/registro";
    }
    @PostMapping("/registroAdmin")
    public String registrarUsuarioAdmin(@Valid @ModelAttribute("usuario") Usuario usuario,
                                        BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("usuario", usuario); // Asegúrate de que el objeto usuario esté en el modelo
            model.addAttribute("errorMessage", result);
            return "Administrador/registro";
        }

        try {
            usuario.setCodigo_rol(rolRepository.findByCodigoRol(2));
            usuarioService.registrarUsuarioAdmin(usuario);
            model.addAttribute("successMessage", "Usuario Registrado Correctamente");
        } catch (IllegalArgumentException e) {
            model.addAttribute("usuario", usuario); // Asegúrate de que el objeto usuario esté en el modelo si ocurre una excepción
            model.addAttribute("errorMessage", e.getMessage());
            return "Administrador/registro";
        }

        // Redirigir a una vista de confirmación o lista de usuarios
        return "redirect:/{registroAdmin}";
    }


    //Login


    @GetMapping("/login")
    public String loginPage(Model model) {
        return "login";
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
            return "redirect:/LayoutAdmin"; // Redirige a la página para rol 2
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
    @GetMapping("/administrador/verAdministradores")
    public String listarUsuariosRol2(Model model) {
        List<Usuario> usuariosRol2 = usuarioService.obtenerUsuariosConRol2();
        model.addAttribute("usuarios", usuariosRol2);
        return "Administrador/Emprendedores/verAdministradores";
    }
}
