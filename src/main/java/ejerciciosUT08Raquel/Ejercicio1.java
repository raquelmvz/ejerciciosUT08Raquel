/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosUT08Raquel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author raquel
 */
public class Ejercicio1 {

    public static void main(String[] args) {

        /* Fichero a crear - ruta relativa a la carpeta
        raiz del proyecto */
        String idFichero = "matrizej1.txt";
        String tmp;

        /* Array a escribir */
        int numeros[][] = {{100, 101, 102, 103},
        {200, 201, 202, 203},
        {300, 301, 302, 303},
        {400, 401, 402, 403}};

        /* Estructura try-with-resources
        Instancia el objeto con el fichero a escribir
        y se encarga de cerrar el recurso flujo una vez
        finalizadas las operaciones */
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            for (int i = 0; i < numeros.length; i++) {
                for (int j = 0; j < numeros[i].length; j++) {

                    /* Obtengo en un String el elemento de 
                    la matriz */
                    tmp = String.valueOf(numeros[i][j]);

                    /* En el ultimo no se pone tabulador */
                    if (j == numeros[i].length - 1) {
                        flujo.write(tmp);
                    } else {
                        flujo.write(tmp + "\t");
                    }

                }

                /* new line al acabar cada linea */
                flujo.newLine();

            }

            /* Metodo flush guarda cambios en el disco */
            flujo.flush();
            System.out.println("El fichero se ha creado en la carpeta raiz");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
