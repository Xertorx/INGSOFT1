package co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Vehiculo;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.VehiculoRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

@AllArgsConstructor
@Service
public class VehiculoServicio {

    VehiculoRepositorio vehiculoRepositorio;
    public List<Vehiculo> obtenerTodos(){
        List<Vehiculo> listado =(List<Vehiculo>)vehiculoRepositorio.findAll();
        return listado;
    }
    public boolean borrar(Vehiculo vehiculo){
        try{
            vehiculoRepositorio.delete(vehiculo);

        }catch (Exception e){
            return false;
        }

        return true;

    }
}
