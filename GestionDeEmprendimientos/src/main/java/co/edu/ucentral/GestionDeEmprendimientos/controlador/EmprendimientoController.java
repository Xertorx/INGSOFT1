package co.edu.ucentral.GestionDeEmprendimientos.controlador;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Emprendimiento;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Usuario;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios.EmprendimientoService;
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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@AllArgsConstructor
@Controller
public class EmprendimientoController {


    @Autowired
    private EmprendimientoService emprendimientoService;

    @GetMapping("/emprendedor/micuenta/registrar-emprendimiento")
    public String registrarEmprendimientoDiv(Model model) {
        model.addAttribute("emprendimiento", new Emprendimiento());
        model.addAttribute("mostrarDiv1", true); // Indicador para mostrar div1
        return "Emprendedor/micuenta";
    }

    @PostMapping("/emprendedor/micuenta/registrar-emprendimiento")
    public String registrarEmprendimiento(@Valid @ModelAttribute("emprendimiento") Emprendimiento emprendimiento,
                                          BindingResult result,
                                          Model model,HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        emprendimiento.setUsuario(usuario);
       // emprendimiento.set
        if (result.hasErrors()) {
            model.addAttribute("emprendimiento", emprendimiento); // Asegura que el objeto esté en el modelo en caso de error
            model.addAttribute("errorMessage", result);
            return "/Emprendedor/micuenta";
        }

        try {
            MultipartFile logoFile = emprendimiento.getImagenes().getLogoFile();
            if (logoFile != null && !logoFile.isEmpty()) {
                Integer documento = usuario.getNumeroDocumento();
                String logoUrl = guardarArchivoYObtenerUrl(logoFile,documento);
                emprendimiento.getImagenes().setLogo(logoUrl); // Asigna la URL del logo al campo de tipo String
            }

            emprendimientoService.registrarEmprendimiento(emprendimiento);
            model.addAttribute("successMessage", "Emprendimiento Registrado Correctamente");
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }

        return "redirect:/Emprendedor/micuenta";
    }




    private String guardarArchivoYObtenerUrl(MultipartFile file, Integer documento) {

        String carpetaDestino = "src/main/resources/static/assets/imagenes-emprendimientos/" + documento + "/";
        String nombreArchivo = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        try {
            Path rutaCarpeta = Paths.get(carpetaDestino);
            Files.createDirectories(rutaCarpeta);  // Crea la carpeta si no existe

            Path rutaArchivo = rutaCarpeta.resolve(nombreArchivo);
            Files.copy(file.getInputStream(), rutaArchivo, StandardCopyOption.REPLACE_EXISTING);

            // Retorna la URL relativa
            return "/assets/imagenes-emprendimientos/" + documento + "/" + nombreArchivo;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al guardar el archivo", e);
        }
    }




}