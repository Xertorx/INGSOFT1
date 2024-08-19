/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author roy-j
 */
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    public String placa;
    public String nombre;
    public LocalDateTime Hora_entrada;
    public String Numero_factura;
    public String total;
    public String tiempo_transcurrido;

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

    public String getNumero_factura() {
        return Numero_factura;
    }

    public void setNumero_factura(String Numero_factura) {
        this.Numero_factura = Numero_factura;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTiempo_transcurrido() {
        return tiempo_transcurrido;
    }

    public void setTiempo_transcurrido(String tiempo_transcurrido) {
        this.tiempo_transcurrido = tiempo_transcurrido;
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
        return "Vehiculo{placa='" + placa + "', nombre='" + nombre + "', Hora_entrada=" + Hora_entrada + ", Numero_factura=" + Numero_factura + ", Numero_factura=" + total + ", Numero_factura=" + tiempo_transcurrido + "}";
    }

}
