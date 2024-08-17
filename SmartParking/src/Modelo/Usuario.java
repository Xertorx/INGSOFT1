/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author roy-j
 */
public class Usuario {
    public String Usuario;
    public String Password;

 

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
   public boolean loguearse() {
    if (this.Usuario == null || this.Password == null) {
        return false;
    }
    if (this.Usuario.isEmpty() || this.Password.isEmpty()) {
        return false;
    }
    if (this.Usuario.equals("Administrador") && this.Password.equals("Administrador1")) {
        return true;
    } else {
        return false;
    }
}
        
    
}
