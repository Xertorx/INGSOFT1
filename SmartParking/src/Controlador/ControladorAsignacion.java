/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.AsignarEspacios;
import Modelo.GuardarInformacion;

import Modelo.Vehiculo;
import Vista.Menu;
import static Vista.Paneles.Liberacion.*;
import Vista.Paneles.Asignacion;
import static Vista.Paneles.Asignacion.*;
import Vista.Paneles.Liberacion;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author roy-j
 */
public class ControladorAsignacion {

    public Vehiculo vehiculo;
    private AsignarEspacios asignarEspacios;

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    // Constructor privado para evitar la creación de nuevas instancias
    public ControladorAsignacion(Vehiculo vehiculo, AsignarEspacios asignarEspacios) {
        this.vehiculo = vehiculo;
        this.asignarEspacios = asignarEspacios;
        asignarEspacios.CargarDatos();
    }

    public String AsigarEspacio() {
        String placa = Placa.getText();
        String nombre = User.getText();
        System.out.println("" + Placa.getText());
        System.out.println("" + User.getText());
        Vehiculo vh = asignarEspacios.buscarPorPlaca(placa);

        if (placa.isEmpty() || nombre.isEmpty() ) {
            return "Los campos se encuentran vacios";
        }else{if (vh==null) {
            // Asigna el espacio directamente usando el modelo del vehículo
            System.out.println("Asignando vehículo con placa: " + placa);
            asignarEspacios.asignarEspacio(placa, nombre);
            actualizarData();
            return "Vehiculo registrado con existo";
        } else if (vh.getPlaca().equalsIgnoreCase(placa)) {
            return "La placa del vehiculo ya se encuentra registrada";
        }else{
            return "Error Desconocido";
        }
    }
    }

    public boolean LiberarEspacio() {
        String placa = consultarPlaca.getText();

        // Verifica si el espacio puede ser liberado
        if (asignarEspacios.liberarEspacioPorPlaca(placa)) {
            System.out.println("Espacio liberado para el vehículo con placa: " + placa);
            actualizarData();
            return true;
        } else {
            System.out.println("No se encontró un vehículo con la placa: " + placa);
            return false;
        }
    }

    public Vehiculo BuscarPlaca(String PlacaVehiculo) {
        Vehiculo vh = asignarEspacios.buscarPorPlaca(PlacaVehiculo);
        vh = calcularFactura(vh);
        if (vh == null) {
            return null;
        }
        return vh;
    }

    public Vehiculo calcularFactura(Vehiculo vh) {
        Vehiculo veh = vh;
        //Traer solo la hora 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String fechaHoraComoString = veh.getHora_entrada().format(formatter);
        // Convertir el String a LocalTime
        LocalTime horaEntrada = LocalTime.parse(fechaHoraComoString, formatter);
        LocalTime horaActual = LocalTime.now();

        //Duracion entre la hora de entrada y la hora actual
        Duration duracion = Duration.between(horaEntrada, horaActual);
        // Convertir la duración a horas, minutos y segundos
        long horas = duracion.toHours();
        long minutos = duracion.toMinutes() % 60;
        long segundos = duracion.getSeconds() % 60;
        String diferenciaExactaStr = String.format("%02d:%02d:%02d", horas, minutos, segundos);

        //SEGUNDOS 
        double minutosDiferencia = duracion.toSeconds() / 60.0;
        //REDONDEO DE MINUTOS
        int minutosRedondeados = (int) Math.ceil(minutosDiferencia);
        long precioRedondeado = (long) Math.ceil(minutosRedondeados * 100);

        String total = String.valueOf(precioRedondeado);
        veh.setTiempo_transcurrido(diferenciaExactaStr + "   " + minutosRedondeados + "  Minutos");
        veh.setTotal(total);
        return veh;
    }

    public void mostrar() {
        asignarEspacios.mostrarEstado();
    }

    public void actualizarData() {
        GuardarInformacion guardar = new GuardarInformacion();
        guardar.GuardarInformacionVehiculos(asignarEspacios.getSpaces());
    }

    public ArrayList<Vehiculo> getSpaces() {
        return asignarEspacios.getSpaces();
    }

}
