package org.example.navalbattle;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.navalbattle.model.Person;
import org.example.navalbattle.view.GameNavalBattleStage;

import java.io.*;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The Main class of the Naval Battle game application.
 */
public class Main extends Application {
    Path basePath = Paths.get("C:\\Users\\username\\Documents");
    Path combinedPath = basePath.resolve("example.txt");

    /**
     * The main method, launches the JavaFX application.
     *
     * @param args the command-line arguments passed to the application. They are not used in this application.
     */
    public static void main(String[] args) {
        launch();
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
        GameNavalBattleStage.getInstance();

        Person person = new Person("John", 30);

        try (FileOutputStream fileOut = new FileOutputStream("person.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(person);
        } catch (IOException i) {
            i.printStackTrace();
        }

        try (FileInputStream fileIn = new FileInputStream("person.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
             Person p = (Person) in.readObject();
             System.out.println("Name: " + p.getName());
             System.out.println("Age: " + p.getAge());
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
    }
}