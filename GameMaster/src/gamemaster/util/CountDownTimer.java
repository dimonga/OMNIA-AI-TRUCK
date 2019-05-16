package gamemaster.util;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class CountDownTimer {

    private static final long COUNT_DOWN_START = 20 * 60 * 1000; // IN MILLI SECONDS
    private static final int ONE_SECOND_IN_MILLISECONDS = 1000; // IN MILLI SECONDS
    private static final long TWO_MINS = 2 * 60 * 1000; // IN MILLI SECONDS

    private long currentTime = COUNT_DOWN_START;

    private Timeline timeline;
    private CountDownTimerListener countDownTimerListener;

    public CountDownTimer(CountDownTimerListener countDownTimerListener) {
        this.countDownTimerListener = countDownTimerListener;
        setUpCountDown();
    }

    public void startCountDown() {
        timeline.playFromStart();
    }

    public void stopCountDown() {
        timeline.stop();
    }

    public void resetCountDown() {
        timeline.stop();
        currentTime = COUNT_DOWN_START;
        countDownTimerListener.onCountDownReset(getTimeStringFromMilliSeconds(currentTime));
    }

    private void setUpCountDown() {
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), event -> {

            countDownTimerListener.onCountDown(getTimeStringFromMilliSeconds(currentTime));

            currentTime = currentTime - ONE_SECOND_IN_MILLISECONDS;

            if (currentTime < TWO_MINS) {
                countDownTimerListener.onTwoMinuteWarning();
            }

            if (currentTime < -1) {
                timeline.stop();
                countDownTimerListener.onCountDownCompleted();
            }
        });

        timeline.getKeyFrames().add(keyFrame);
    }

    private String getTimeStringFromMilliSeconds(long milliseconds) {
        long seconds = (milliseconds / ONE_SECOND_IN_MILLISECONDS) % 60;
        long minutes = (milliseconds / ONE_SECOND_IN_MILLISECONDS) / 60;

        String secondsString = Long.toString(seconds);

        if (seconds < 10) {
            secondsString = "0" + secondsString;
        }

        String currentTimeString;

        if (minutes < 1) {
            currentTimeString = "Time remaining: " + secondsString + " seconds";
        } else {
            currentTimeString = String.format("Time remaining: %d:" + secondsString, minutes);
        }

        return currentTimeString;
    }

    public interface CountDownTimerListener {
        void onCountDown(String currentTimeText);

        void onTwoMinuteWarning();

        void onCountDownCompleted();

        void onCountDownReset(String countDownStartText);
    }
}
