package co.edu.ucentral.GestionDeEmprendimientos.persistencia.servicios;

import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Herramientas;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.entidades.Vehiculo;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.HerramientasRepositorio;
import co.edu.ucentral.GestionDeEmprendimientos.persistencia.repositorios.VehiculoRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class HerramientasServicio {

    HerramientasRepositorio herramientasRepositorio;
    public List<Herramientas> obtenerTodos(){
        List<Herramientas> listado =(List<Herramientas>)herramientasRepositorio.findAll();
        return listado;
    }
    /*public boolean borrar(Vehiculo vehiculo){
        try{
            vehiculoRepositorio.delete(vehiculo);

        }catch (Exception e){
            return false;
        }

        return true;

    }*/
}
