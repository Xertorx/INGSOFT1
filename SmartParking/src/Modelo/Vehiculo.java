/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;

/**
 *
 * @author roy-j
 */
public class Vehiculo {
    
    public String placa;
    public String nombre;
    public LocalDateTime  Hora_entrada;
    public String total;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getHora_entrada() {
        return Hora_entrada;
    }

    public void setHora_entrada(LocalDateTime Hora_entrada) {
        this.Hora_entrada = Hora_entrada;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public boolean isOccupied() {
        return placa != null;
    }

    public void assign(String placa, String nombre, LocalDateTime Hora_entrada) {
        this.placa = placa;
        this.nombre = nombre;
        this.Hora_entrada = Hora_entrada;
    }

    public void release() {
        this.placa = null;
        this.nombre = null;
        this.Hora_entrada = null;
    }

    @Override
    public String toString() {
        if (isOccupied()) {
            return "Ocupado por " + placa + " (Placa: " + placa + ") desde " + Hora_entrada;
        } else {
            return "Libre";
        }
    }                
}