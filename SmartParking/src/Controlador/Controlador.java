/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Usuario;
import Vista.Login;
import static Vista.Login.Password;
import static Vista.Login.Usuario;
import Vista.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static smartparking.SmartParking.Login;

/**
 *
 * @author roy-j
 */
public class Controlador  {
    
    private Login login;
    private Usuario ModelUsuario;
    private Menu menu;

    public Controlador(Login login, Usuario ModelUsuario) {
        this.login = login;
        this.ModelUsuario = ModelUsuario;
    }

  
    public void iniciar(){
       login.setLocationRelativeTo(null);
       login.setVisible(true);
    }
    
    public boolean loguearse(){
        ModelUsuario.setUsuario(Usuario.getText());
        ModelUsuario.setPassword(String.valueOf(Password.getPassword()));
        
        if(!ModelUsuario.loguearse()){
            return false;
        }else{
            return true;
        }
    }
   
}
