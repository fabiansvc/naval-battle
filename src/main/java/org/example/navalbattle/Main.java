package org.example.navalbattle;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.navalbattle.model.Game;
import org.example.navalbattle.model.GameException;
import org.example.navalbattle.view.GameNavalBattleStage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Main class of the Naval Battle game application.
 */
public class Main extends Application {

    /**
     * The main method, launches the JavaFX application.
     *
     * @param args the command-line arguments passed to the application. They are not used in this application.
     */
    public static void main(String[] args) {
        int x = 10, y = 0, z;
        try {
            z = x / y;
            System.out.println("z = " + z);
        } catch (ArithmeticException e) {
            // Get the description of the exception
            String msg = e.getMessage();
            // Print a custom error message
            System.out.println("An error has occurred. The error is: " + msg);
        }
        System.out.println("At the end of the program.");

        Object game = new Game();

        try {
            // Ejemplo de uso de getMessage()
            throw new GameException("Este es un mensaje detallado de la excepción");
        } catch (GameException e) {
            System.out.println("Mensaje de la excepción: " + e.getMessage());
        }

        try {
            // Ejemplo de uso de getCause()
            Exception causa = new Exception("Causa de la excepción");
            throw new GameException("Excepción con causa", causa);
        } catch (GameException e) {
            System.out.println("Causa de la excepción: " + e.getCause());
        }

        try {
            // Ejemplo de uso de getStackTrace()
            throw new GameException("Este es un mensaje detallado de la excepción");
        } catch (GameException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement elemento : stackTrace) {
                System.out.println("Clase: " + elemento.getClassName() +
                        ", Método: " + elemento.getMethodName() +
                        ", Línea: " + elemento.getLineNumber());
            }
        }

        try {
            // Ejemplo de uso de initCause()
            Exception causa = new Exception("Causa de la excepción");
            GameException excepcion = new GameException("Excepción con causa");
            excepcion.initCause(causa);
            throw excepcion;
        } catch (GameException e) {
            System.out.println("Causa de la excepción: " + e.getCause());
        }

        try {
            // Ejemplo de uso de printStackTrace()
            throw new GameException("Este es un mensaje detallado de la excepción");
        } catch (GameException e) {
            e.printStackTrace();
        }

        try {
            // Ejemplo de uso de toString()
            throw new GameException("Este es un mensaje detallado de la excepción");
        } catch (GameException e) {
            System.out.println("Descripción de la excepción: " + e.toString());
        }
        // Launches the JavaFX application
        //launch();

        try {
            // Set-1: Ejecutar algunas operaciones que pueden lanzar una excepción
            System.out.println("Set-1: Iniciando operaciones...");
            int resultado = 10 / 0; // Esta operación lanza una excepción ArithmeticException
            System.out.println("Resultado: " + resultado); // Esta línea no se ejecutará debido a la excepción
        } catch (ArithmeticException e) {
            // Manejar la excepción ArithmeticException
            System.out.println("Se ha producido una excepción: " + e.getMessage());
        } finally {
            // Set-2: Ejecutar las operaciones que deben realizarse sin importar qué suceda en set-1
            System.out.println("Set-2: Realizando limpieza o tareas finales...");
        }

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("archivo.txt"));
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.err.println("El archivo no se encontró: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } finally {
            // Cerrar el BufferedReader en el bloque finally
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el BufferedReader: " + e.getMessage());
                }
            }
        }

    }

    /**
     * The entry point of the application. Launches the JavaFX application.
     *
     * @param stage the primary stage for this application, onto which
     *              the application scene can be set.
     *              Applications may create other stages, if needed, but they will not be
     *              primary stages.
     * @throws IOException if an error occurs while loading the game stage.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Creates and initializes the main game stage
        GameNavalBattleStage.getInstance();
    }
}