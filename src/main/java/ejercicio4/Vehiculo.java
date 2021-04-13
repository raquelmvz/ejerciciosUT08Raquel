/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.util.ArrayList;
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
    private ArrayList<String> matriculasAnadidas = new ArrayList<>();
    
    public Vehiculo(Long bastidor, String matricula, String marca, String modelo, String color, double tarifa, boolean disponible) {
        this.bastidor = Long.valueOf(devuelveCadenaNumerica());
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tarifa = tarifa;
        this.disponible = disponible;
    }
    
    public Vehiculo() {
        this.bastidor = devuelveBastidor();
        this.matricula = devuelveMatricula();
        this.marca = devuelveMarca();
        this.modelo = devuelveModelo();
        this.color = devuelveColor();
        this.tarifa = devuelveTarifa();
        this.disponible = devuelveTrueoFalse();
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
    public int devuelveAleatorio(int n, int m) {
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

//    private String devuelveMatricula() {
//        return String.valueOf(devuelveAleatorio(1, 50000));
//    }
    private String devuelveMarca() {
        String[] marcas = {"Mercedes", "Toyota", "Volkswagen", "BMW", "Honda", "Hyundai", "Audi"};
        return marcas[devuelveAleatorio(0, marcas.length - 1)];
    }
    
    private String devuelveModelo() {
        String[] modelos = {"Megane", "Astra", "Clio", "Leon", "Corsa", "Serie 3"};
        return modelos[devuelveAleatorio(0, modelos.length - 1)];
    }
    
    private String devuelveColor() {
        String[] colores = {"Rojo", "Gris", "Negro", "Blanco", "Azul", "Amarillo"};
        return colores[devuelveAleatorio(0, colores.length - 1)];
    }
    
    private double devuelveTarifa() {
        return (double) devuelveAleatorio(0, 1000);
    }
    
    public boolean devuelveTrueoFalse() {
        return (devuelveAleatorio(0, 1) == 1);
    }
    
    private String generaMatricula() {
        
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        Random random = new Random();
        
        StringBuilder sb = new StringBuilder(3);
        for (int i = 0; i < 3; i++) {
            sb.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        
        return devuelveCadenaNumerica() + sb;
        
    }
    
    private String devuelveCadenaNumerica() {
        
        String numAFormatear = Integer.toString(devuelveAleatorio(0, 99999));
        
        String numFormateado = "00000".substring(numAFormatear.length()) + numAFormatear;
        
        return numFormateado;
        
    }
    
    private String devuelveMatricula() {
        
        String matricula = generaMatricula();
        
        while (!matriculasAnadidas.contains(matricula)) {
            matriculasAnadidas.add(matricula);
        }
        
        return matricula;
    }
    
}
