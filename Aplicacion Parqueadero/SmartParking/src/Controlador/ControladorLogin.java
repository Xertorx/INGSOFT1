/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.AsignarEspacios;
import Modelo.Usuario;
import Modelo.Vehiculo;
import Vista.Login;
import static Vista.Login.*;
import Vista.Menu;
import static Vista.Paneles.Asignacion.*;
/**
 *
 * @author roy-j
 */
public class ControladorLogin  {
    
    private Login login;
    private Usuario ModelUsuario;
    private Vehiculo ModelVehiculo;
    private Menu menu;
    private AsignarEspacios asignacion;

    public ControladorLogin(Login login, Usuario ModelUsuario) {
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
