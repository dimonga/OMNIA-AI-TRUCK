package gamemaster;

import gamemaster.display.DisplayController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static DisplayController displayController;
    private static Stage displayHintStage;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage adminPanelStage) throws IOException {

        displayHintStage = new Stage();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("display/game_master_display.fxml"));

        VBox displayHintVBox = loader.load();
        Scene displayHintScene = new Scene(displayHintVBox, Color.BLACK);

        displayController = loader.getController();

        displayHintStage.setScene(displayHintScene);

        GridPane root = FXMLLoader.load(getClass().getResource("admin/game_master_admin.fxml"));

        Scene scene = new Scene(root);
        adminPanelStage.setScene(scene);
        adminPanelStage.setTitle("GAME MASTER ADMIN PANEL");

        displayHintStage.initOwner(adminPanelStage);
        displayHintStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

        adminPanelStage.show();
        displayHintStage.show();
    }

    public static DisplayController getDisplayController() {
        return displayController;
    }

    public static Stage getDisplayHintStage() {
        return displayHintStage;
    }
}
