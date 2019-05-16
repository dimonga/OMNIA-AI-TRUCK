package gamemaster.util;

import javafx.scene.control.Alert;

public class AlertUtil {

    public static final String EMPT_HINT_FIELD_TITLE = "EMPTY HINT FIELD";
    public static final String EMPT_HINT_FIELD_MSG = "Hint field cannot be empty!";

    public static Alert displayInfoAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);

        return alert;
    }
}
