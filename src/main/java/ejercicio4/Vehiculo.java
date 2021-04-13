/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.util.Random;

/**
 *
 * @author raque
 */
public class Vehiculo {

    private Long bastidor;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private double tarifa;
    private boolean disponible;

    public Vehiculo(Long bastidor, String matricula, String marca, String modelo, String color, double tarifa, boolean disponible) {
        this.bastidor = bastidor;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tarifa = tarifa;
        this.disponible = disponible;
    }
    
    public Vehiculo() {
        String[] marcas = {"Mercedes", "Toyota", "Volkswagen", "BMW", "Honda","Hyundai", "Audi"};
        String marca = marcas[devuelveAleatorio(0, marcas.length-1)];
        String[] modelos = {"Megane", "Astra", "Clio", "Leon", "Corsa","Serie 3"};
        String modelo = modelos[devuelveAleatorio(0, modelos.length-1)];
        String[] colores = {"Rojo", "Gris", "Negro", "Blanco", "Azul","Amarillo"};
        String color = colores[devuelveAleatorio(0, colores.length-1)];
        double tarifa = (double)devuelveAleatorio(0, 1000);
        boolean disponible;
        if (devuelveAleatorio(0, 1) == 1) {
            disponible = true;
        } else {
            disponible = false;
        }
        
        this.bastidor = devuelveBastidor();
        this.matricula = devuelveMatricula();
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tarifa = tarifa;
        this.disponible = disponible;
    }
    
    

    public Long getBastidor() {
        return bastidor;
    }

    public void setBastidor(Long bastidor) {
        this.bastidor = bastidor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    //metodo para generar valores aleatorios entre dos numeros
    private int devuelveAleatorio(int n, int m) {
        Random random = new Random();
        return random.nextInt(m - n + 1) + n;
    }

    @Override
    public String toString() {
        return bastidor + ":" + matricula + ":" + marca + ":" + modelo + ":" + color + ":" + tarifa + ":" + disponible + ":";
    }
    
    private Long devuelveBastidor() {
        return Long.valueOf(String.valueOf(devuelveAleatorio(1, 50000)));
    }
    
    private String devuelveMatricula() {
        return String.valueOf(devuelveAleatorio(1, 50000));
    }
    
    

}
