package org.example.navalbattle.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import org.example.navalbattle.model.Boat;

/**
 * Controller class for the Naval Battle game interface.
 * This class handles the initialization of the game interface.
 */
public class GameNavalBattleController {
    @FXML
    private GridPane gridPane;


    /**
     * Initializes the game interface.
     * This method is automatically called when the corresponding FXML file is loaded.
     * It can be used to initialize the UI components and set up event handlers.
     */
    @FXML
    public void initialize() {
        gridPane.add(new Boat().getBoatGroup(), 2, 1);
    }
}
