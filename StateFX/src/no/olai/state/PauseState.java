package no.olai.state;

public class PauseState extends State {


    public PauseState(GamePane gamePane) {
        super(gamePane);
        gamePane.setPlaying(false);
    }

    @Override
    String onPause() {
        if (gamePane.isPlaying()) {
            gamePane.changeState(new PauseState(gamePane));
        }
        return "Already paused";
    }

    @Override
    String onPlay() {
        gamePane.changeState(new PlayingState(gamePane));
        return "Resume game";
    }

    @Override
    String onReset() {
        gamePane.changeState(new PlayingState(gamePane));
        gamePane.resetGame();
        return "Reset from paused game (Normal game)";
    }


    @Override
    String onTurbo() {
        return "Resume game and then activate turbo mode!";
    }

}
