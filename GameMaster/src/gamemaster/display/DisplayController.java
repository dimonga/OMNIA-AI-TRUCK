

package gamemaster.display;

import gamemaster.Main;
import gamemaster.util.CountDownTimer;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import java.net.URISyntaxException;

import static gamemaster.util.CountDownTimer.CountDownTimerListener;

public class DisplayController implements CountDownTimerListener {

    private static final String ROBOTIC_SOUND_PATH = "/resources/sounds/robotic-sound.mp3";
    private static final String TWO_MINS_WARNING_SOUND_PATH = "/resources/sounds/time-is-running-out.mp3";
    private static final String TIME_UP_SOUND_PATH = "/resources/sounds/time-up.mp3";
    private static final String CONGRATS_SOUND_PATH = "/resources/sounds/congrats.mp3";

    private final MediaPlayer roboticSoundPlayer;
    private final MediaPlayer twoMinsWarningSoundPlayer;
    private final MediaPlayer timeUpSoundPlayer;
    private final MediaPlayer congratsSoundPlayer;
    private final CountDownTimer countDownTimer;

    @FXML
    public VBox container;

    @FXML
    private Label hintLbl;

    @FXML
    private Label timeLbl;

    public DisplayController() throws URISyntaxException {
        Media roboticSound = new Media(Main.class.getResource(ROBOTIC_SOUND_PATH).toURI().toString());
        Media twoMinsWarningSoundSound = new Media(Main.class.getResource(TWO_MINS_WARNING_SOUND_PATH).toURI().toString());
        Media timeUpSound = new Media(Main.class.getResource(TIME_UP_SOUND_PATH).toURI().toString());
        Media congratsSound = new Media(Main.class.getResource(CONGRATS_SOUND_PATH).toURI().toString());

        roboticSoundPlayer = new MediaPlayer(roboticSound);
        twoMinsWarningSoundPlayer = new MediaPlayer(twoMinsWarningSoundSound);
        timeUpSoundPlayer = new MediaPlayer(timeUpSound);
        congratsSoundPlayer = new MediaPlayer(congratsSound);

        countDownTimer = new CountDownTimer(this);
    }

    @FXML
    public void initialize() {
        timeLbl.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(timeLbl, 0.0);
        AnchorPane.setRightAnchor(timeLbl, 0.0);
        timeLbl.setAlignment(Pos.CENTER);

        hintLbl.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(hintLbl, 0.0);
        AnchorPane.setRightAnchor(hintLbl, 0.0);
        hintLbl.setAlignment(Pos.CENTER);
        hintLbl.setTextAlignment(TextAlignment.CENTER);
    }

    // TODO handle animation speed
    public void setHint(String hint) {

        roboticSoundPlayer.play();

        final Animation animation = new Transition() {
            {
                setCycleDuration(Duration.millis(8500));
            }

            protected void interpolate(double frac) {
                final int length = hint.length();
                final int n = Math.round(length * (float) frac);
                hintLbl.setText(hint.substring(0, n));
            }
        };

        animation.setOnFinished(event -> roboticSoundPlayer.stop());
        animation.play();
    }

    public void displayCongratsContent(String congratsContent) {
        congratsSoundPlayer.play();
        hintLbl.setText(congratsContent);
    }

    public void stopCongratsSound() {
        congratsSoundPlayer.stop();
    }

    public void clearHint() {
        hintLbl.setText("");
    }

    @Override
    public void onCountDown(String currentTimeText) {
        timeLbl.setText(currentTimeText);
    }

    @Override
    public void onTwoMinuteWarning() {
        twoMinsWarningSoundPlayer.play();
    }

    @Override
    public void onCountDownCompleted() {
        timeLbl.setText("TIME IS UP!");
        timeUpSoundPlayer.play();
    }

    @Override
    public void onCountDownReset(String countDownStartText) {
        timeLbl.setText(countDownStartText);
    }

    public CountDownTimer getCountDownTimer() {
        return countDownTimer;
    }

    public void displayImage() {
        container.setStyle(
                "-fx-padding: 15;" +
                        "-fx-border-style: solid inside;" +
                        "-fx-border-width: 7;" +
                        " -fx-border-radius: 5;" +
                        "-fx-border-color: #32CD32;" +
                        "-fx-background-image:url('/resources/images/ai.jpg');" +
                        "-fx-background-size: 100% 100%;" +
                        "-fx-background-repeat: no-repeat;"
        );

        hintLbl.setVisible(false);
        timeLbl.setVisible(false);
    }

    public void hideImage() {
        container.setStyle(
                "-fx-padding: 15;" +
                        "-fx-border-style: solid inside;" +
                        "-fx-border-width: 7;" +
                        " -fx-border-radius: 5;" +
                        "-fx-border-color: #32CD32;" +
                        "-fx-background-color: black;"
        );

        hintLbl.setVisible(true);
        timeLbl.setVisible(true);
    }
}

