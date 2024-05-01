package org.example.navalbattle;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.navalbattle.view.GameNavalBattleStage;

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
        // Launches the JavaFX application
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
        // Creates and initializes the main game stage
        GameNavalBattleStage.getInstance();
    }
}