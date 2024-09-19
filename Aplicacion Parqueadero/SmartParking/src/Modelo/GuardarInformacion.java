package Modelo;

import co.vinni.gestor.UtilArchivos;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GuardarInformacion {

    public static int size;

    public void GuardarInformacionVehiculos(ArrayList<Vehiculo> Vh) {

       /* ArrayList<String> lineas = new ArrayList<>();
        this.size = Vh.size();
        for (int i = 0; i < Vh.size(); i++) {
            lineas.add(Vh.get(i).toString());
            System.out.println(Vh.get(i).toString());
        }
*/
        ArrayList<Vehiculo> vehiculos = Vh;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Recursos/Informes/Espacios.bin"))) {
            oos.writeObject(vehiculos);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Vehiculo> leerInformacion() {
        /*ArrayList<Vehiculo> listado = new ArrayList<>();

        listado = (ArrayList<Vehiculo>) UtilArchivos.leerBinario("src/Recursos/Informes/Espacios.bin");
        for (int i = 0; i < size; i++) {
            System.out.println("\n" + listado.get(i));
        }
        
*/
        ArrayList<Vehiculo> vehiculos = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Recursos/Informes/Espacios.bin"))) {
            vehiculos = (ArrayList<Vehiculo>) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return vehiculos;
    }

}
