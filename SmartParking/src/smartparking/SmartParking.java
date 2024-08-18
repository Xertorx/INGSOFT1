/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package smartparking;

import Modelo.AsignarEspacios;
import Vista.Login;

import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author roy-j
 */
public class SmartParking {

    /**
     * @param args the command line arguments
     */
    public static final Login Login =new Login();
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
      /* FlatLightLaf.setup();
       UIManager.setLookAndFeel(new FlatLightLaf());
       UIManager.put( "TextComponent.arc", 50);
       SwingUtilities.updateComponentTreeUI(Login);
*/
      
       Login.setVisible(true);
        
         AsignarEspacios asignarEspacios = new AsignarEspacios();
         // Mostrar el estado inicial de los espacios
   
        // Mostrar el estado final
        System.out.println("\nDespués de asignar otro vehículo:");
        asignarEspacios.mostrarEstado();
        
      /*
      AsignarEspacios asignador = new AsignarEspacios();

        // Asignar algunos espacios
        asignador.asignarEspacio("ABC123", "Juan Pérez");
        asignador.asignarEspacio("DEF456", "María López");
        asignador.asignarEspacio("GHI789", "Carlos Rodríguez");

        // Mostrar el estado de los espacios
        System.out.println("\nEstado inicial de los espacios:");
        asignador.mostrarEstado();

        // Liberar un espacio por número de espacio
        System.out.println("\nLiberando el espacio 2:");
        asignador.liberarEspacio(2);

        // Mostrar el estado de los espacios después de liberar
        System.out.println("\nEstado después de liberar el espacio 2:");
        asignador.mostrarEstado();

        // Liberar un espacio por placa
        System.out.println("\nLiberando el espacio del vehículo con placa ABC123:");
        asignador.liberarEspacioPorPlaca("ABC123");

        // Mostrar el estado de los espacios después de liberar por placa
        System.out.println("\nEstado después de liberar el vehículo con placa ABC123:");
        asignador.mostrarEstado();

        // Intentar liberar un espacio que no existe
        System.out.println("\nIntentando liberar un espacio con una placa que no está asignada:");
        asignador.liberarEspacioPorPlaca("XYZ000");

        // Mostrar el estado final de los espacios
        System.out.println("\nEstado final de los espacios:");
        asignador.mostrarEstado();
        */
        
    }
        
        
    
}
