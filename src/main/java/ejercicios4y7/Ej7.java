/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios4y7;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

        try (Scanner datosFichero = new Scanner(new FileReader(idFichero))) {

            //elimino la primera linea (cabecera)
            datosFichero.nextLine();

            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine();

                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador coma
                tokens = linea.split(":");

                switch (tokens[0]) {

                    case "0":
                        Vehiculo tmp = new Turismo();

                        tmp.setBastidor(Long.valueOf(tokens[1]));
                        tmp.setMatricula(tokens[2]);
                        tmp.setMarca(tokens[3]);
                        tmp.setModelo(tokens[4]);
                        tmp.setColor(tokens[5]);
                        tmp.setTarifa(Double.parseDouble(tokens[6]));
                        tmp.setDisponible(Boolean.parseBoolean(tokens[7]));
                        ((Turismo) tmp).setPuertas(Integer.parseInt(tokens[8]));
                        ((Turismo) tmp).setMarchaAutomatica(Boolean.parseBoolean(tokens[9]));

                        vehiculos.add(tmp);
                        break;

                    case "1":

                        Vehiculo tmp2 = new Deportivo();

                        tmp2.setBastidor(Long.valueOf(tokens[1]));
                        tmp2.setMatricula(tokens[2]);
                        tmp2.setMarca(tokens[3]);
                        tmp2.setModelo(tokens[4]);
                        tmp2.setColor(tokens[5]);
                        tmp2.setTarifa(Double.parseDouble(tokens[6]));
                        tmp2.setDisponible(Boolean.parseBoolean(tokens[7]));
                        ((Deportivo) tmp2).setCilindrada(Integer.parseInt(tokens[8]));

                        vehiculos.add(tmp2);
                        break;

                    case "2":

                        Vehiculo tmp3 = new Furgoneta();

                        tmp3.setBastidor(Long.valueOf(tokens[1]));
                        tmp3.setMatricula(tokens[2]);
                        tmp3.setMarca(tokens[3]);
                        tmp3.setModelo(tokens[4]);
                        tmp3.setColor(tokens[5]);
                        tmp3.setTarifa(Double.parseDouble(tokens[6]));
                        tmp3.setDisponible(Boolean.parseBoolean(tokens[7]));

                        ((Furgoneta) tmp3).setCarga(Integer.parseInt(tokens[8]));
                        ((Furgoneta) tmp3).setVolumen(Integer.parseInt(tokens[9]));

                        vehiculos.add(tmp3);
                        break;

                }

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Vehiculos ordenados por marca:");
        Collections.sort(vehiculos);

        for (Vehiculo veh : vehiculos) {
            System.out.println(veh);
        }

        generaDocTurismo(vehiculos);
        generaDocDeportivo(vehiculos);
        generaDocFurgoneta(vehiculos);

    }

    //EJERCICIO 9B
    public static void generaDocTurismo(ArrayList<Vehiculo> lista) {

        String idFichero = "listaTurismos.csv";

        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            flujo.write("TipoVehiculo:Bastidor:Matricula:Marca:Modelo:Color:Tarifa:Disponible:"
                    + "Puertas:MarchaAutomatica");
            flujo.newLine();

            for (Vehiculo veh : lista) {

                if (veh instanceof Turismo) {
                    flujo.write("Turismo:" + veh.toString());
                    flujo.newLine();
                }

            }
            System.out.println(idFichero + " se ha creado");
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }

    public static void generaDocDeportivo(ArrayList<Vehiculo> lista) {

        String idFichero = "listaDeportivos.csv";

        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            flujo.write("TipoVehiculo:Bastidor:Matricula:Marca:Modelo:Color:Tarifa:Disponible:"
                    + "Cilindrada");
            flujo.newLine();

            for (Vehiculo veh : lista) {

                if (veh instanceof Deportivo) {
                    flujo.write("Deportivo:" + veh.toString());
                    flujo.newLine();
                }

            }
            System.out.println(idFichero + " se ha creado");
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }

    public static void generaDocFurgoneta(ArrayList<Vehiculo> lista) {

        String idFichero = "listaFurgonetas.csv";

        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            flujo.write("TipoVehiculo:Bastidor:Matricula:Marca:Modelo:Color:Tarifa:Disponible:"
                    + "Carga:Volumen");
            flujo.newLine();

            for (Vehiculo veh : lista) {

                if (veh instanceof Furgoneta) {
                    flujo.write("Furgoneta:" + veh.toString());
                    flujo.newLine();
                }

            }
            System.out.println(idFichero + " se ha creado");
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }

}
