package co.edu.ucentral.GestionDeEmprendimientos.controlador;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.*;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.EtapaRepository;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.workFlowRepository;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios.WorkFlowService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;




@Controller
public class WorkFlowControlador {

    @Autowired
    private EtapaRepository etapaRepositorio;

    @Autowired
    private WorkFlowService wkService;
    @Autowired
    private workFlowRepository wkRepository;

    private final String UPLOAD_DIR = "src/main/resources/static/assets/workflow-archivos/";

    @GetMapping("/workflow/etapa/{id}")
    public String mostrarEtapa(Model model, @PathVariable Integer id,HttpSession session) {
        Etapa etapa = etapaRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Etapa no encontrada"));
        WorkFlow wk = (WorkFlow) session.getAttribute("workflow");
        // Verificar el estado del workflow
        if ("Espera".equals(wk.getEstado())) {
            model.addAttribute("mensaje", "Proceso su respuesta, espera hasta que un administrador apruebe tu información.");
            model.addAttribute("estadoEspera", true); // Indicamos que el estado es "Espera"
        }else{
            model.addAttribute("estadoEspera", false); // Indicamos que el estado es "Espera"

        }

        model.addAttribute("etapa", etapa);
        model.addAttribute("workflow", new WorkFlow());
        return "Emprendedor/workflow"; // La vista donde se encuentra el HTML del formulario
    }



    @PostMapping("/workflow/guardar")
    public String guardarWorkFlow(@RequestParam("archivo") MultipartFile archivo,
                                  @RequestParam("informacionCliente") String informacionCliente,
                                  Model model, HttpSession session) {
        if (archivo.isEmpty()) {
            System.out.println("El archivo está vacío.");
            throw new RuntimeException("Debe seleccionar un archivo.");
        } else {
            System.out.println("Archivo recibido: " + archivo.getOriginalFilename());
        }

        try {
            if (archivo.isEmpty()) {
                throw new RuntimeException("Debe seleccionar un archivo.");
            }

            Usuario usuario = (Usuario) session.getAttribute("usuario");
            WorkFlow wk = (WorkFlow) session.getAttribute("workflow");
            System.out.println("Valor del workflow:   " + wk.getIdWorkFlow());
            System.out.println("Valor de informacion:  " + informacionCliente);
            int cedula = usuario.getNumeroDocumento();
            int idEtapa = Integer.parseInt(wk.getEtapa().getIdEtapa().toString().trim());

            String archivoUrl = guardarArchivoYObtenerUrl(archivo, idEtapa, "archivos", cedula);
            System.out.println("Ruta del archivo  :   " + archivoUrl);
            System.out.println("Id de la etapa: " + idEtapa);
            if (wk.getArchivos() == null) {
                wk.setArchivos(new Archivos());
            }

            if (wk.getInformacion() == null) {
                wk.setInformacion(new Informacion());
            }

            if (idEtapa == 1) {
                System.out.println("Entró al caso 1");
                wk.getArchivos().setArchivo1(archivoUrl);
                wk.getInformacion().setInformacion1(informacionCliente);
                wk.setEstado("Espera");
                System.out.println("Workflow antes de guardar: " + wk);
                wkService.guardarInformacion(wk);
            } else if (idEtapa == 2) {
                System.out.println("Entró al caso 2");
                wk.getArchivos().setArchivo2(archivoUrl);
                wk.getInformacion().setInformacion2(informacionCliente);
                wk.setEstado("Espera");
                wkService.guardarInformacion(wk);
            }
            else if (idEtapa == 3) {
                System.out.println("Entró al caso 3");
                wk.getArchivos().setArchivo3(archivoUrl);
                wk.getInformacion().setInformacion3(informacionCliente);
                wk.setEstado("Espera");
                wkService.guardarInformacion(wk);
            }
            else if (idEtapa == 4) {
                System.out.println("Entró al caso 4");
                wk.getArchivos().setArchivo4(archivoUrl);
                wk.getInformacion().setInformacion4(informacionCliente);
                wk.setEstado("Espera");
                wkService.guardarInformacion(wk);
            }else {
                System.out.println("Etapa no soportada: " + idEtapa);
            }


            model.addAttribute("successMessage", "Archivo subido correctamente.");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error al subir el archivo: " + e.getMessage());
        }


        return "redirect:/emprendedor/micuenta";
    }


    private String guardarArchivoYObtenerUrl(MultipartFile file, Integer idEtapa, String carpetaEspecifica, int cedula) {
        String carpetaDestino = UPLOAD_DIR + cedula + "/" + idEtapa + "/" + carpetaEspecifica + "/";
        String nombreArchivo = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        try {
            Path rutaCarpeta = Paths.get(carpetaDestino);
            Files.createDirectories(rutaCarpeta); // Crear la carpeta si no existe

            Path rutaArchivo = rutaCarpeta.resolve(nombreArchivo);
            Files.copy(file.getInputStream(), rutaArchivo); // Guardar archivo

            // Retornar URL relativa para usar en tu sistema
            return "/assets/workflow-archivos/" + cedula + "/" + idEtapa + "/" + carpetaEspecifica + "/" + nombreArchivo;
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar el archivo", e);
        }
    }
}
