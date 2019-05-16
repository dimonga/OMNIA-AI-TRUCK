package gamemaster.admin;

import gamemaster.Main;
import gamemaster.display.DisplayController;
import gamemaster.modal.HintList;
import gamemaster.util.AlertUtil;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AdminController {

    private final Alert emptyHintFieldAlert;
    private final HintList hintList;
    private final DisplayController displayController;

    public AdminController() {
        emptyHintFieldAlert = AlertUtil.displayInfoAlert(
                AlertUtil.EMPT_HINT_FIELD_TITLE,
                AlertUtil.EMPT_HINT_FIELD_MSG
        );

        hintList = new HintList();

        this.displayController = Main.getDisplayController();
    }

    @FXML
    private TextField hintInputText;
    @FXML
    private Button hintButton;
    @FXML
    private Button petRobotButton;
    @FXML
    private Button neuralNetworkButton;
    @FXML
    private Button hint3Button;
    @FXML
    private Button hint4Button;
    @FXML
    private Button hint5Button;
    @FXML
    private Button hint6Button;
    @FXML
    private Button hint7Button;
    @FXML
    private Button hint8Button;
    @FXML
    private Button hint9Button;
    @FXML
    private Button displayImageButton;
    @FXML
    private Button hideImageButton;
    @FXML
    private Button goFullScreenButton;
    @FXML
    private Button exitFullScreenButton;
    @FXML
    private Button startCountDownTimerButton;
    @FXML
    private Button stopCountDownTimerButton;
    @FXML
    private Button resetCountDownTimerButton;

    @FXML
    private void sendHint() {
        String customHint = hintInputText.getText();

        if (customHint != null && !customHint.isEmpty()) {
            displayController.setHint(customHint);
        } else {
            emptyHintFieldAlert.show();
        }
    }

    @FXML
    public void sendPetRobotHint() {
        setPreDefinedHint(HintList.FIRST_PRE_DEFINED_TEXT_INDEX);
    }

    @FXML
    public void sendNeuralNetworkHint() {
        setPreDefinedHint(HintList.SECOND_PRE_DEFINED_TEXT_INDEX);
    }

    @FXML
    public void sendThirdPreDefinedHint() {
        setPreDefinedHint(HintList.THIRD_PRE_DEFINED_TEXT_INDEX);
    }

    @FXML
    public void sendFourthPreDefinedHint() {
        setPreDefinedHint(HintList.FOURTH_PRE_DEFINED_TEXT_INDEX);
    }

    @FXML
    public void sendFifthPreDefinedHint() {
        setPreDefinedHint(HintList.FIFTH_PRE_DEFINED_TEXT_INDEX);
    }

    @FXML
    public void sendSixthPreDefinedHint() {
        setPreDefinedHint(HintList.SIXTH_PRE_DEFINED_TEXT_INDEX);
    }

    @FXML
    public void sendSeventhPreDefinedHint() {
        setPreDefinedHint(HintList.SEVENTH_PRE_DEFINED_TEXT_INDEX);
    }

    @FXML
    public void sendEighthPreDefinedHint() {
        setPreDefinedHint(HintList.EIGHTH_PRE_DEFINED_TEXT_INDEX);
    }

    @FXML
    public void sendNinthPreDefinedHint() {
        setPreDefinedHint(HintList.NINTH_PRE_DEFINED_TEXT_INDEX);
    }

    @FXML
    public void displayCongratsContent() {
        displayController.displayCongratsContent(hintList.getPreDefinedHints()[HintList.CONGRATS_TEXT_INDEX]);
    }

    @FXML
    public void stopCongratsSound() {
        displayController.stopCongratsSound();
    }

    @FXML
    public void clearHint() {
        displayController.clearHint();
    }

    @FXML
    public void goFullScreen() {
        Main.getDisplayHintStage().setFullScreen(true);
        goFullScreenButton.setDisable(true);
        exitFullScreenButton.setDisable(false);
    }

    @FXML
    public void exitFullScreen() {
        Main.getDisplayHintStage().setFullScreen(false);
        goFullScreenButton.setDisable(false);
        exitFullScreenButton.setDisable(true);
    }

    @FXML
    public void exitApp() {
        Platform.exit();
        System.exit(0);
    }

    public void startCountDownTimer() {
        displayController.getCountDownTimer().startCountDown();
        startCountDownTimerButton.setDisable(true);
        stopCountDownTimerButton.setDisable(false);
        resetCountDownTimerButton.setDisable(false);
    }

    public void stopCountDownTimer() {
        displayController.getCountDownTimer().stopCountDown();
        startCountDownTimerButton.setDisable(false);
        stopCountDownTimerButton.setDisable(true);
    }

    public void resetCountDownTimer() {
        displayController.getCountDownTimer().resetCountDown();
        startCountDownTimerButton.setDisable(false);
        stopCountDownTimerButton.setDisable(true);
        resetCountDownTimerButton.setDisable(true);
    }

    public void displayImage() {
        displayController.displayImage();
        hintButton.setDisable(true);
        petRobotButton.setDisable(true);
        neuralNetworkButton.setDisable(true);
        hint3Button.setDisable(true);
        hint4Button.setDisable(true);
        hint5Button.setDisable(true);
        hint6Button.setDisable(true);
        hint7Button.setDisable(true);
        hint8Button.setDisable(true);
        hint9Button.setDisable(true);
        displayImageButton.setDisable(true);
        hideImageButton.setDisable(false);
    }

    public void hideImage() {
        displayController.hideImage();
        hintButton.setDisable(false);
        petRobotButton.setDisable(false);
        neuralNetworkButton.setDisable(false);
        hint3Button.setDisable(false);
        hint4Button.setDisable(false);
        hint5Button.setDisable(false);
        hint6Button.setDisable(false);
        hint7Button.setDisable(false);
        hint8Button.setDisable(false);
        hint9Button.setDisable(false);
        displayImageButton.setDisable(false);
        hideImageButton.setDisable(true);
    }

    private void setPreDefinedHint(int preDefinedHintIndex) {
        displayController.setHint(hintList.getPreDefinedHints()[preDefinedHintIndex]);
    }
}
