package org.example.navalbattle.controller;

import javafx.fxml.FXML;
import org.example.navalbattle.model.FileCRUD;

import java.io.IOException;

/**
 * Controller class for the Naval Battle game interface.
 * This class handles the initialization of the game interface.
 */
public class GameNavalBattleController {
    private FileCRUD fc;
    /**
     * Initializes the game interface.
     * This method is automatically called when the corresponding FXML file is loaded.
     * It can be used to initialize the UI components and set up event handlers.
     */
    @FXML
    public void initialize() {
        fc = new FileCRUD("crud-player.txt");
        fc.create("fabian");
        //fc.update(0, "camila" );
        //fc.delete(0);
    }
}
