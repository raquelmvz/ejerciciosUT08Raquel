/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

/**
 *
 * @author raque
 */
public class Turismo extends Vehiculo {

    private int puertas;
    private boolean marchaAutomatica;

    public Turismo(int puertas, boolean marchaAutomatica, Long bastidor, String matricula, String marca, String modelo, String color, double tarifa, boolean disponible) {
        super(bastidor, matricula, marca, modelo, color, tarifa, disponible);
        this.puertas = puertas;
        this.marchaAutomatica = marchaAutomatica;
    }

    public Turismo() {
        super();
        this.marchaAutomatica = devuelveTrueoFalse();
        this.puertas = devuelveAleatorio(1, 5);
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public boolean isMarchaAutomatica() {
        return marchaAutomatica;
    }

    public void setMarchaAutomatica(boolean marchaAutomatica) {
        this.marchaAutomatica = marchaAutomatica;
    }

    @Override
    public String toString() {
        return super.toString() + puertas + ":" + marchaAutomatica;
    }

}
