package org.example.navalbattle.model;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Boat {

    private Group boatGroup;

    public Boat() {
        boatGroup = new Group();

        // Create a polygon for the flag
        Polygon flag = new Polygon(
                50.0, 40.0,
                60.0, 45.0,
                50.0, 50.0);
        flag.setFill(Color.RED);
        flag.setStroke(Color.BLACK);

        Line line = new Line(50, 40, 50, 60);

        Arc arc = new Arc(50, 50, 50, 30, -25, -135);
        arc.setType(ArcType.CHORD);
        arc.setFill(Color.BROWN);
        arc.setStroke(Color.BLACK);

        // Add shapes to the boatGroup
        boatGroup.getChildren().addAll(arc, line, flag);
    }

    public Group getBoatGroup() {
        return boatGroup;
    }
}
