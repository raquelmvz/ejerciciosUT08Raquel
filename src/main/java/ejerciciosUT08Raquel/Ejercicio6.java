/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosUT08Raquel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author raquel
 */
public class Ejercicio6 {

    public static void main(String[] args) {

        //fichero a leer
        String idFichero = "ej3.txt";

        //variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        int posicion = -1;
        int poslinea = -1;
        int contador = 0;

        System.out.println("Leyendo el fichero " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split("\n");
                for (String string : tokens) {

                    contador++;

                    if (posicion == -1) {
                        posicion = string.indexOf("jv");
                        poslinea = contador;

                    }

                    System.out.print(string);
                }
                System.out.println();
            }

            System.out.println("La primera aparicion de jv se encuentra"
                    + " en la posicion " + posicion + " de la linea " + poslinea);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
