package co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByCorreo(String correo);
    long countByCorreo(String correo);

    @Query("SELECT u FROM Usuario u WHERE u.codigo_rol.codigo_rol = :codigoRol")
    List<Usuario> findAllByCodigoRol(@Param("codigoRol") Integer codigoRol);


}
