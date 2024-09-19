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
    
        
    }
        
        
    
}
