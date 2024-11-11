package co.edu.ucentral.GestionDeEmprendimientos.controlador;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Emprendimientos;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Solicitudes;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Usuario;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.UsuarioRepository;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios.SolicitudService;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios.UsuarioService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class SolicitudController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private SolicitudService solicitudService;


    //Actualizar Informacion
    @PostMapping("/emprendedor/micuenta/datos-personales/solicitud")
    public String solicitudDeshabilitar(@Valid @ModelAttribute("solicitud") Solicitudes solicitud,
                                        BindingResult result, Model model, HttpSession session) {

        Usuario usuarioLogueado = (Usuario) session.getAttribute("usuario");
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", result);
            return "/Emprendedor/micuenta/datos-personales";
        }
        //Llenar informacion de solicitud
        solicitud.setDescripcion("Solicitud para deshabilitar cuenta");
        solicitud.setFecha(new Date());
        solicitud.setEstado("Activo");
        solicitud.setUsuario(usuarioLogueado);

        try {
            solicitudService.registrarSolicitud(solicitud);
            model.addAttribute("successMessage", "Solicitud Registrada");
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        model.addAttribute("emprendimiento", new Emprendimientos());
        model.addAttribute("usuario", usuarioLogueado);
        model.addAttribute("mostrarDiv2", true); // Indicador para mostrar div1
        return "/Emprendedor/micuenta";
    }


}
