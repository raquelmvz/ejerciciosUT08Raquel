/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios4y7;

/**
 *
 * @author raque
 */
public class Furgoneta extends Vehiculo {

    // Atributos específicos
    private int carga;
    private int volumen;

    public Furgoneta(int carga, int volumen, Long bastidor, String matricula, String marca, String modelo, String color, double tarifa, boolean disponible) {
        super(bastidor, matricula, marca, modelo, color, tarifa, disponible);
        this.carga = carga;
        this.volumen = volumen;
    }

    public Furgoneta() {
        super();
        this.carga = devuelveAleatorio(50, 5000);
        this.volumen = devuelveAleatorio(50, 3000);
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    @Override
    public String toString() {
        return super.toString() + carga + ":" + volumen;
    }

}
