
package Modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AsignarEspacios {
  private static final int TOTAL_SPACES = 20;
    
  private List<Vehiculo> spaces;

    public AsignarEspacios() {
        spaces = new ArrayList<>(TOTAL_SPACES);
        for (int i = 0; i < TOTAL_SPACES; i++) {
            spaces.add(new Vehiculo());
        }
    }

    public boolean assignSpace(int spaceNumber, String vehiclePlate, String ownerName) {
        if (spaceNumber < 1 || spaceNumber > TOTAL_SPACES) {
            System.out.println("Número de espacio inválido.");
            return false;
        }
        Vehiculo space = spaces.get(spaceNumber - 1);
        if (space.isOccupied()) {
            System.out.println("El espacio ya está ocupado.");
            return false;
        }
        space.assign(vehiclePlate, ownerName, LocalDateTime.now());
        System.out.println("Espacio " + spaceNumber + " asignado al vehículo " + vehiclePlate + " de " + ownerName + ".");
        return true;
    }

    public boolean releaseSpace(int spaceNumber) {
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

    public void displayStatus() {
        System.out.println("Estado de los espacios:");
        for (int i = 0; i < spaces.size(); i++) {
            System.out.println("Espacio " + (i + 1) + ": " + spaces.get(i));
        }
    }
 

    
}
