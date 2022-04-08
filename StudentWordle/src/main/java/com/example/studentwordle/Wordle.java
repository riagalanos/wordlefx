package com.example.studentwordle;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Represents the Wordle game. Notice Wordle is-a Application.
 */
public class Wordle extends Application {
    @Override
    public void start(Stage stage) throws IOException {
      // TODO Create a GridModel.
      GridModel gmodel = new GridModel();
      // TODO Create a DataModel.
      DataModel dmodel = new DataModel();
      // TODO Create a GameController with the the given GridModel and DataModel.
      GameController controller = new GameController(gmodel, dmodel);
      // TODO Create a GameView with the given GameController.
      GameView view = new GameView(controller);
      // TODO Create a Scene to hold the GameView.
      Scene scene = new Scene(view);
      // TODO Set the title of the stage, add scene to the stage, and display stage
      stage.setTitle("Fill In Your Name Version");
      stage.setScene(scene);
      stage.show();
    }
    public static void main(String[] args) {
      launch();
    }
  }

