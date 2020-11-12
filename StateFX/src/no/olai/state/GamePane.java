package no.olai.state;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class GamePane extends Pane {

    private final double WINDOW_WIDTH = 500;
    private final double WINDOW_HEIGHT = 300;

    private State state;
    private boolean playing = false;
    private boolean turbo = false;

    private final int SCORE_GOAL = 1000;
    private int score;

    public final double radius = 10;

    private final double BALL_START_POS_X = 150;
    private final double BALL_START_POS_Y = 150;

    private double x = BALL_START_POS_X;
    private double y = BALL_START_POS_Y;
    private double dx = 1, dy = 1;

    private Circle ball = new Circle(radius);
    private Timeline animation;
    private Rectangle paddle = new Rectangle(70, 10);
    private Label lblScore = new Label();

    private final double PADDLE_START_X = (WINDOW_WIDTH / 2) - (paddle.getWidth() / 2);
    private final double PADDLE_START_Y = (WINDOW_HEIGHT) - (paddle.getHeight() + 50);




    public GamePane() {
        animation = new Timeline(new KeyFrame(Duration.millis(10), e -> moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);


        this.state = new PlayingState(this);
        setPlaying(true);

        ball.setFill(Color.RED);
        paddle.setFill(Color.BLACK);
        lblScore.setFont(new Font("consolas", 30));


        paddle.setX(PADDLE_START_X);
        paddle.setY(PADDLE_START_Y);

        this.getChildren().addAll(ball, paddle, lblScore);
    }

    public void resetGame() {

        paddle.setX(PADDLE_START_X);
        paddle.setY(PADDLE_START_Y);

        x = BALL_START_POS_X;
        y = BALL_START_POS_Y;
        dx = 1;
        dy = 1;

        score = 0;

        setPlaying(true);
    }

    public State getState() {
        return state;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        if (playing){
            animation.play();
            animation.setRate(1);
        }
        else
            animation.pause();

        this.playing = playing;
    }

    public void setTurbo(boolean turbo) {
        if (turbo){
            animation.setRate(animation.getRate() + 2);
            this.setBackground(new Background(new BackgroundFill(Color.LIME, CornerRadii.EMPTY, Insets.EMPTY)));
        }
        else {
            animation.setRate(1);
            this.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        }

        this.turbo = turbo;
    }

    public void changeState(State state) {
        this.state = state;
    }


    public void movePaddleLeft() {
        if (isPlaying())
            paddle.setX(paddle.getX() - 20);
    }

    public void movePaddleRight() {
        if (isPlaying())
            paddle.setX(paddle.getX() + 20);
    }


    private void moveBall() {
        if (x < radius || x > getWidth() - radius)
            dx *= -1;
        if (y < radius)
            dy *= -1;

        if (paddle.contains(ball.getCenterX() + radius, ball.getCenterY() + radius))
            dy *= -1;

        x += dx;
        y += dy;
        ball.setCenterX(x);
        ball.setCenterY(y);

        winCheck();

    }

    private boolean boundaryCheck() {
        return y > getHeight() - radius;
    }

    private void winCheck() {



        lblScore.setText("Score: " + score++);

        if (score == SCORE_GOAL && turbo && isPlaying()) {
            score += 2;
            lblScore.setText("YOU WON TURBO! Score: " + SCORE_GOAL);
            setPlaying(false);
            setTurbo(false);
        }

        if (score == SCORE_GOAL && isPlaying()) {
            lblScore.setText("YOU WON! Score: " + SCORE_GOAL);
            setPlaying(false);
        }


        if (boundaryCheck()) {
            lblScore.setText("Game over");
            setPlaying(false);
        }


    }


}
