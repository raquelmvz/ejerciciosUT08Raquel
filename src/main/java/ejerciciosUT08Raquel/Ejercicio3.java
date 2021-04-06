/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosUT08Raquel;

import java.util.Random;

/**
 *
 * @author raquel
 */
public class Ejercicio3 {

    static Random random = new Random();

    /* Metodo que genera mayusculas aleatorias */
    public static char generaMayus() {
        return (char) (random.nextInt(26) + 'A');
    }

    /* Metodo que genera minusculas */
    public static char generaMinus() {
        return (char) (random.nextInt(26) + 'a');
    }

    /* Metodo que escribe la mayuscula o minuscula de manera aleatoria */
    public static char generaLetraRandom() {
        int aleatorio = random.nextInt(2);

        if (aleatorio == 0) {
            return generaMayus();

        } else {
            return generaMinus();
        }
    }

    public static void main(String[] args) {

    }

}
