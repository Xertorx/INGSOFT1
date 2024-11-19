package co.edu.ucentral.GestionDeEmprendimientos.controlador;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Emprendimientos;
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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@AllArgsConstructor
@Controller
public class EmprendimientoController {


    @Autowired
    private EmprendimientoService emprendimientoService;


    @GetMapping("/emprendedor/micuenta/registrar-emprendimientos")
    public String registrarEmprendimientoDiv(Model model) {
        model.addAttribute("emprendimientos", new Emprendimientos());
        return "Emprendedor/registrarEmp";
    }

    @PostMapping("/emprendedor/micuenta/registrar-emprendimientos")
    public String registrarDatos(@Valid @ModelAttribute("emprendimientos") Emprendimientos emprendimientos,
                                 BindingResult result,
                                 Model model, HttpSession session) throws IOException {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        emprendimientos.setUsuario(usuario);

        // Guardar el archivo del logo inmediatamente
        if (emprendimientos.getImagenes().getLogoFile() != null ) {
            String bannerUrl = guardarArchivoYObtenerUrl(emprendimientos.getImagenes().getLogoFile(), usuario.getNumeroDocumento(), "logo");
            emprendimientos.getImagenes().setLogo(bannerUrl);
        }
        session.setAttribute("emprendimientoPendiente", emprendimientos);

        if (result.hasErrors()) {
            model.addAttribute("emprendimientos", emprendimientos);
            model.addAttribute("errorMessage", result);
            return "Emprendedor/registrarEmp";
        }

        return "redirect:/emprendedor/micuenta/registrar-emprendimientos/seleccionarPlan";
    }

    @GetMapping("/emprendimiento/ver")
    public String cargarPlanes(Model model) {
        model.addAttribute("emprendimientos", emprendimientoService.listarEmprendimientos());
        return "Administrador/Emprendimientos/verEmprendimientos";
    }

    @GetMapping("/emprendedor/micuenta/registrar-emprendimientos/imagenes-adicionales")
    public String cargarImagenes(Model model) {
        return "/Emprendedor/imagenesAdicionales";
    }


    @PostMapping("/emprendedor/micuenta/registrar-emprendimientos/imagenes-adicionales")
    public String registrarImagenesAdicionales(
            @Valid @ModelAttribute("emprendimientos") Emprendimientos emprendimientos,
            BindingResult result,
            @RequestParam("banner") MultipartFile bannerFile,
            @RequestParam("image1") MultipartFile image1File,
            @RequestParam("image2") MultipartFile image2File,
            @RequestParam("image3") MultipartFile image3File,
            Model model, HttpSession session) {

        Emprendimientos emprendimiento = (Emprendimientos) session.getAttribute("emprendimiento");
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (result.hasErrors()) {
            model.addAttribute("emprendimientos", emprendimientos);
            model.addAttribute("errorMessage", result);
            return "Emprendedor/registrarEmp";
        }


        try {

            // Guardar el banner en su propia carpeta
            if (bannerFile != null && !bannerFile.isEmpty()) {
                String bannerUrl = guardarArchivoYObtenerUrl(bannerFile, usuario.getNumeroDocumento(), "banner");
                emprendimiento.getImagenes().setBanner(bannerUrl);
            }

            // Guardar imagen 1 en su propia carpeta
            if (image1File != null && !image1File.isEmpty()) {
                String image1Url = guardarArchivoYObtenerUrl(image1File, usuario.getNumeroDocumento(), "img1");
                emprendimiento.getImagenes().setImagen1(image1Url);
            }

            // Guardar imagen 2 en su propia carpeta
            if (image2File != null && !image2File.isEmpty()) {
                String image2Url = guardarArchivoYObtenerUrl(image2File, usuario.getNumeroDocumento(), "img2");
                emprendimiento.getImagenes().setImagen2(image2Url);
            }

            // Guardar imagen 3 en su propia carpeta
            if (image3File != null && !image3File.isEmpty()) {
                String image3Url = guardarArchivoYObtenerUrl(image3File, usuario.getNumeroDocumento(), "img3");
                emprendimiento.getImagenes().setImagen3(image3Url);
            }

            emprendimientoService.registrarEmprendimiento(emprendimiento);
            model.addAttribute("successMessage", "Imágenes cargadas correctamente.");
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", "Error al cargar las imágenes: " + e.getMessage());
            return "Emprendedor/registrarEmp";
        }

        return "redirect:/emprendedor/micuenta/registrar-emprendimientos";
    }

    private String guardarArchivoYObtenerUrl(MultipartFile file, Integer documento, String carpetaEspecifica) {
        // Crear carpeta específica para cada tipo de imagen
        String carpetaDestino = "src/main/resources/static/assets/imagenes-emprendimientos/" + documento + "/" + carpetaEspecifica + "/";
        String nombreArchivo = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        try {
            Path rutaCarpeta = Paths.get(carpetaDestino);
            Files.createDirectories(rutaCarpeta);  // Crea la carpeta si no existe

            Path rutaArchivo = rutaCarpeta.resolve(nombreArchivo);
            Files.copy(file.getInputStream(), rutaArchivo, StandardCopyOption.REPLACE_EXISTING);

            // Retorna la URL relativa
            return "/assets/imagenes-emprendimientos/" +documento  + "/" + carpetaEspecifica + "/" + nombreArchivo;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al guardar el archivo", e);
        }
    }

}

