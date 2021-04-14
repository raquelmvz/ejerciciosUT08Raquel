/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios4y7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author raquel
 */
public class Ej7 {

    public static void main(String[] args) {

        //fichero a leer
        String idFichero = "vehiculos.csv";

        //para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        try ( Scanner datosFichero = new Scanner(new FileReader(idFichero))) {

            //elimino la primera linea (cabecera)
            datosFichero.nextLine();

            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine();

                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador coma
                tokens = linea.split(":");

                Vehiculo tmp = new Vehiculo();

                for (String string : tokens) {

                    tmp.setBastidor(Long.valueOf(tokens[1]));
                    tmp.setMatricula(tokens[2]);
                    tmp.setMarca(tokens[3]);
                    tmp.setModelo(tokens[4]);
                    tmp.setColor(tokens[5]);
                    tmp.setTarifa(Double.parseDouble(tokens[6]));
                    tmp.setDisponible(Boolean.parseBoolean(tokens[7]));

                    if (tmp instanceof Turismo) {
                        ((Turismo) tmp).setPuertas(Integer.parseInt(tokens[8]));
                        ((Turismo) tmp).setMarchaAutomatica(Boolean.parseBoolean(tokens[9]));
                    }

                    if (tmp instanceof Deportivo) {
                        ((Deportivo) tmp).setCilindrada(Integer.parseInt(tokens[8]));

                    }

                    if (tmp instanceof Furgoneta) {
                        ((Furgoneta) tmp).setCarga(Integer.parseInt(tokens[8]));
                        ((Furgoneta) tmp).setVolumen(Integer.parseInt(tokens[9]));

                    }
                }

                vehiculos.add(tmp);

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Vehiculos ordenados por marca:");
        Collections.sort(vehiculos);

        for (Vehiculo veh : vehiculos) {
            System.out.println(veh);
        }

    }

}
