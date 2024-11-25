package co.edu.ucentral.GestionDeEmprendimientos.controlador;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Emprendimientos;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Planes;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Usuario;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.RolRepository;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios.EmprendimientoService;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios.PlanesService;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios.UsuarioService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@AllArgsConstructor
@Controller
public class PlanesController {


    @Autowired
    private PlanesService planesService;
    @Autowired
    private EmprendimientoService emprendimientoService;

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

    @GetMapping("/emprendedor/micuenta/registrar-emprendimientos/seleccionarPlan")
    public String listarPlanes(Model model) {
        List<Planes> planes = planesService.listarPlanes();
        model.addAttribute("planes", planes);
        return "/Emprendedor/seleccionarPlan";
    }

    @PostMapping("/emprendedor/micuenta/registrar-emprendimientos/seleccionarPlan")
    public String seleccionarPlan(@ModelAttribute("id") Integer id, HttpSession session, Model model) {


        Emprendimientos emprendimientoPendiente = (Emprendimientos) session.getAttribute("emprendimientoPendiente");
        if (emprendimientoPendiente == null) {
            return "redirect:/emprendedor/micuenta/registrar-emprendimientos";
        }

        // Buscar el plan seleccionado
        Planes planSeleccionado = planesService.buscarPlanPorId(id);
        if (planSeleccionado == null) {
            model.addAttribute("errorMessage", "El plan seleccionado no existe");
            return "redirect:/emprendedor/micuenta/registrar-emprendimientos";
        }
        emprendimientoPendiente.setPlan(planSeleccionado);

        session.setAttribute("emprendimiento",emprendimientoPendiente);

        return "redirect:/emprendedor/micuenta/registrar-emprendimientos/imagenes-adicionales";
    }

    @PostMapping("/administrador/planes/editar")
    public String editarPlan(@RequestParam("idPlan") Integer idPlan,
                             @RequestParam("nombrePlan") String nombrePlan,
                             @RequestParam("precio") Float precio,
                             @RequestParam("descripcion") String descripcion,
                             RedirectAttributes redirectAttributes) {
        Planes plan = planesService.buscarPlanPorId(idPlan);
        if (plan != null) {
            plan.setNombrePlan(nombrePlan);
            plan.setPrecio(precio);
            plan.setDescripcion(descripcion);
            planesService.save(plan);
            redirectAttributes.addFlashAttribute("successMessage", "Plan actualizado correctamente.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al actualizar el plan.");
        }
        return "redirect:/planes/ver";
    }



}