package Modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AsignarEspacios {

    private static final int TOTAL_SPACES = 20;

 
    private List<Vehiculo> spaces;
    private static final DateTimeFormatter HOUR_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    
    public AsignarEspacios() {
        spaces = new ArrayList<>(TOTAL_SPACES);
        for (int i = 0; i < TOTAL_SPACES; i++) {
            spaces.add(new Vehiculo());
        }
    }

    // Asigna el primer espacio disponible de forma ordenada
    public boolean asignarEspacio(String vehiclePlate, String ownerName) {
        for (int i = 0; i < TOTAL_SPACES; i++) {
            Vehiculo space = spaces.get(i);
            if (!space.isOccupied()) {
                LocalDateTime horaEntrada = LocalDateTime.now();
                space.assign(vehiclePlate, ownerName, horaEntrada);
                String formattedTime = horaEntrada.format(HOUR_FORMATTER);
                System.out.println("Espacio " + (i + 1) + " asignado al vehículo " + vehiclePlate + " de " + ownerName
                        + " a las " + formattedTime + ".");
                return true;
            }
        }
        System.out.println("No hay espacios disponibles.");
        return false;
    }

    public boolean liberarEspacio(int spaceNumber) {
        if (spaceNumber < 1 || spaceNumber > TOTAL_SPACES) {
            System.out.println("Número de espacio inválido.");
            return false;
        }
        Vehiculo space = spaces.get(spaceNumber - 1);
        if (!space.isOccupied()) {
            System.out.println("El espacio ya está libre.");
            return false;
        }
        space.release();
        System.out.println("Espacio " + spaceNumber + " liberado.");
        return true;
    }

    // Libera un espacio buscando por la placa del vehículo
    public boolean liberarEspacioPorPlaca(String vehiclePlate) {
        System.out.println("" + vehiclePlate);
        for (int i = 0; i < TOTAL_SPACES; i++) {
            Vehiculo space = spaces.get(i);
            System.out.println("\n placa del vehiculo verificada");
            System.out.println("" + space.getPlaca());
            if (space.isOccupied() && space.getPlaca().equalsIgnoreCase(vehiclePlate)) {
                space.release();
                System.out.println("Espacio " + (i + 1) + " ocupado por el vehículo con placa " + vehiclePlate + " ha sido liberado.");
                return true;
            }
        }
        System.out.println("No se encontró un vehículo con la placa " + vehiclePlate + " en ningún espacio.");
        return false;
    }

    // Muestra el estado de los espacios
    public void mostrarEstado() {
        System.out.println("Estado de los espacios:");
        for (int i = 0; i < spaces.size(); i++) {
            String estado = spaces.get(i).isOccupied() ? "Ocupado por " + spaces.get(i).getPlaca() + " desde " + spaces.get(i).getHora_entrada().format(HOUR_FORMATTER) : "Libre";
            System.out.println("Espacio " + (i + 1) + ": " + estado);
        }
    }
       public List<Vehiculo> getSpaces() {
        return spaces;
    }
}
