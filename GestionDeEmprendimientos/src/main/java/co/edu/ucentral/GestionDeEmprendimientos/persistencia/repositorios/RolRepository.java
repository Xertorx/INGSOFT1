package co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    @Query("SELECT r FROM Rol r WHERE r.codigo_rol = :codigoRol")
    Rol findByCodigoRol(@Param("codigoRol") int codigoRol);
}