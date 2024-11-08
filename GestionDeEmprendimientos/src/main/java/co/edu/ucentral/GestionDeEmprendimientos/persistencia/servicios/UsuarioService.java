package co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Rol;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Usuario;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.RolRepository;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.UsuarioRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, RolRepository rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    public Optional<Usuario> authenticate(String correo, String contrasena) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(correo);

        if (usuarioOpt.isPresent() && usuarioOpt.get().getContrasena().equals(contrasena)) {
            return usuarioOpt;
        }
        return Optional.empty();
    }

    @Transactional
    public Usuario registrarUsuario(Usuario usuario) {
        Rol rolPredeterminado = rolRepository.findByCodigoRol(2);

        Optional<Usuario> usuarioExistente = usuarioRepository.findByCorreo(usuario.getCorreo());

        if (usuarioExistente.isPresent()) {
            throw new IllegalArgumentException("El usuario con el correo " + usuario.getCorreo() + " ya existe.");
        } else {
            usuario.setCodigo_rol(rolPredeterminado);
            usuario.setEstado("Activo");

            return usuarioRepository.save(usuario);
        }
    }
    @Transactional
    public Usuario actualizarUsuario(Usuario usuario) {

        long count = usuarioRepository.countByCorreo(usuario.getCorreo());

        if (count > 1) {
            throw new IllegalArgumentException("El correo " + usuario.getCorreo() + " ya está en uso por otro usuario.");
        } else {
            return usuarioRepository.save(usuario);
        }
    }

    @Transactional
    public Usuario registrarUsuarioAdmin(Usuario usuario) {
        Rol rolPredeterminado = rolRepository.findByCodigoRol(1);
        Optional<Usuario> usuarioExistente = usuarioRepository.findByCorreo(usuario.getCorreo());

        if (usuarioExistente.isPresent()) {
            throw new IllegalArgumentException("El usuario con el correo " + usuario.getCorreo() + " ya existe.");
        } else {
            usuario.setCodigo_rol(rolPredeterminado);
            usuario.setEstado("Activo");
            return usuarioRepository.save(usuario);
        }
    }

}
