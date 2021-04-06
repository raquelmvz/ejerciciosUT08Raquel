/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosUT08Raquel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author raquel
 */
public class Ejercicio2 {

    /* Metodo que pide una linea de texto por teclado */
    public static String pideLineaTexto() {
        Scanner entradaTeclado = new Scanner(System.in);
        String cadena = "";

        //entradaTeclado.nextLine(); //Limpiar el buffer
        System.out.println("Introduce una cadena de texto: ");
        
        cadena = entradaTeclado.nextLine();

        return cadena;
    }

    public static void main(String[] args) {

        /* Fichero a crear - ruta relativa a la carpeta
        raiz del proyecto */
        String idFichero = "teclado.txt";
        String tmp;

        /* Estructura try-with-resources
        Instancia el objeto con el fichero a escribir
        y se encarga de cerrar el recurso flujo una vez
        finalizadas las operaciones */
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            tmp = pideLineaTexto();

            while (!tmp.equalsIgnoreCase("EOF")) {
                flujo.write(tmp);
                flujo.newLine();
                tmp = pideLineaTexto();
            }
            /* Metodo flush guarda cambios en el disco */
            flujo.flush();
            System.out.println("El fichero se ha creado en la carpeta raiz");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
