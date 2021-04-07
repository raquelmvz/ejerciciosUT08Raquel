/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosUT08Raquel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

        /* Fichero a crear - ruta relativa a la carpeta
        raiz del proyecto */
        String idFichero = "ej3.txt";
        String tmp;
        int contador = 0;

        /* Estructura try-with-resources
        Instancia el objeto con el fichero a escribir
        y se encarga de cerrar el recurso flujo una vez
        finalizadas las operaciones */
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            do {

                tmp = String.valueOf(generaLetraRandom());

                if (!tmp.equalsIgnoreCase("x")) {
                    flujo.write(tmp);
                    tmp = String.valueOf(generaLetraRandom());
                } else {
                    flujo.write(tmp);
                    flujo.newLine();
                    contador++;
                }

            } while (contador < 50);

            /* Metodo flush guarda cambios en el disco */
            flujo.flush();
            System.out.println("El fichero se ha creado en la carpeta raiz");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
