package Modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class InformeVehiculosCSV {

    private static final DateTimeFormatter HOUR_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public void generarInformeCSV(List<Vehiculo> vehiculos, String archivoDestino) throws IOException {
        try (FileWriter writer = new FileWriter(archivoDestino)) {
            // Escribir la fila de encabezado
            writer.write("Placa,Nombre Propietario,Hora de Entrada,Estado\n");
            
            // Escribir los datos de los vehículos
            for (Vehiculo vehiculo : vehiculos) {
               if (vehiculo.isOccupied()){
                   String linea = String.format("%s,%s,%s,%s\n",
                        vehiculo.getPlaca(),
                        vehiculo.getNombre(),
                        vehiculo.getHora_entrada().format(HOUR_FORMATTER),
                        vehiculo.isOccupied() ? "Ocupado" : "Libre"
                );
                writer.write(linea);
               }
                
            }
        }
        
    }
}
