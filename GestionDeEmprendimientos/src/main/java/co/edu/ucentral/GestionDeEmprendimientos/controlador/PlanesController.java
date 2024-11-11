package co.edu.ucentral.GestionDeEmprendimientos.controlador;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Planes;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Usuario;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.RolRepository;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios.PlanesService;
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
public class PlanesController {


    @Autowired
    private PlanesService planesService;

    @GetMapping("planes/registrar")
    public String cargarPage(Model model) {
        model.addAttribute("planes", new Planes());
        return "Administrador/Planes/registrarPlan";
    }
    @GetMapping("planes/ver")
    public String cargarPlanes(Model model) {
        model.addAttribute("planes", planesService.listarPlanes());
        return "Administrador/Planes/verPlanes";
    }

    @PostMapping("/registroPlan")
    public String registrarPlan(@Valid @ModelAttribute("planes") Planes planes,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Error en los datos del formulario");
            return "Administrador/Planes/registrarPlan";
        }
        try {
            planesService.registrarPlan(planes);
            model.addAttribute("successMessage", "Plan Registrado Correctamente");
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "Administrador/Planes/registrarPlan";
        }
        return "redirect:/planes/registrar";
    }

}