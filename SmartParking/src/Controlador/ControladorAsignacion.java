/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.AsignarEspacios;

import Modelo.Vehiculo;
import static Vista.Paneles.Liberacion.*;
import Vista.Paneles.Asignacion;
import static Vista.Paneles.Asignacion.*;
import Vista.Paneles.Liberacion;


/**
 *
 * @author roy-j
 */
public class ControladorAsignacion  {
    
    private Asignacion asignacion;
    private Liberacion liberacion;
    private Vehiculo ModelVehiculo;

    private AsignarEspacios asignarEspacios;

    public ControladorAsignacion( Vehiculo ModelVehiculo, AsignarEspacios asignarEspacios) {
        this.ModelVehiculo = ModelVehiculo;
        this.asignarEspacios = asignarEspacios;
    }
     public ControladorAsignacion( AsignarEspacios asignarEspacios) {
        this.asignarEspacios = asignarEspacios;
    }
    
    public boolean AsigarEspacio() {
    String placa = Placa.getText();
    String nombre = User.getText();

    if (placa.isEmpty() || nombre.isEmpty()) {
        return false;
    } else {
        // Asigna el espacio directamente usando el modelo del vehículo
        System.out.println("Asignando vehículo con placa: " + placa);
        asignarEspacios.asignarEspacio(placa, nombre);
        return true;
    }
}
  public boolean LiberarEspacio() {
    String placa = consultarPlaca.getText();
    
    // Verifica si el espacio puede ser liberado
    if (asignarEspacios.liberarEspacioPorPlaca(placa)) {
        System.out.println("Espacio liberado para el vehículo con placa: " + placa);
        return true;
    } else {
        System.out.println("No se encontró un vehículo con la placa: " + placa);
        return false;
    }
}
   
    public void motrar(){
        asignarEspacios.mostrarEstado();
    }
}
