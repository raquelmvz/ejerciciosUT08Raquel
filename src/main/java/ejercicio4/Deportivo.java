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
public class Deportivo extends Vehiculo {
    
    private int cilindrada; // Atributo específico para Deportivo

    public Deportivo(int cilindrada, Long bastidor, String matricula, String marca, String modelo, String color, double tarifa, boolean disponible) {
        super(bastidor, matricula, marca, modelo, color, tarifa, disponible);
        this.cilindrada = cilindrada;
    }
    
    public Deportivo() {
        super();
        this.cilindrada = 500;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return super.toString() + cilindrada;
    }
    
    

    
    
    
}
