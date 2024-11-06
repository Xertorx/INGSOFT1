package co.edu.ucentral.GestionDeEmprendimientos.controlador;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Usuario;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        // Obtener la lista de todos los usuarios
        List<Usuario> listaUsuarios = usuarioRepository.findAll();

        // Agregar la lista de usuarios al modelo para que Thymeleaf pueda acceder a ella
        model.addAttribute("usuarios", listaUsuarios);

        // Retorna el nombre de la vista (por ejemplo, usuarios.html)
        return "usuarios";
    }

}
