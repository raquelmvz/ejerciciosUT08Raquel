/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios4y7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author raque
 */
public class Ej4 {
    
    public static void main(String[] args) {
        
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        
        for (int i = 0; i < 30; i++) {
            
            vehiculos.add(new Turismo());
            vehiculos.add(new Furgoneta());
            vehiculos.add(new Deportivo());
        }
        
        String idFichero = "vehiculos.csv";

        // Si se utiliza el constructor FileWriter(idFichero, true) entonces se anexa información
        // al final del fichero idFichero
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            
            flujo.write("TipoVehiculo:Bastidor:Matricula:Marca:Modelo:Color:Tarifa:Disponible");
            flujo.newLine();
            
            for (Vehiculo veh : vehiculos) {
                
                if (veh instanceof Turismo) {
                    flujo.write("0:" + ((Turismo)veh).toString());
                    // Metodo newLine() añade salto de línea después de cada fila
                    flujo.newLine();
                }
                
                if (veh instanceof Deportivo) {
                    flujo.write("1:" + ((Deportivo)veh).toString());
                    // Metodo newLine() añade salto de línea después de cada fila
                    flujo.newLine();
                }
                
                if (veh instanceof Furgoneta) {
                    flujo.write("2:" + ((Furgoneta)veh).toString());
                    // Metodo newLine() añade salto de línea después de cada fila
                    flujo.newLine();
                }
            }

            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
