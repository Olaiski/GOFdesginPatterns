package no.olai.state;

public class PlayingState extends State {

    public PlayingState(GamePane gamePane) {
        super(gamePane);
        gamePane.setPlaying(true);
    }

    @Override
    String onPause() {
        gamePane.changeState(new PauseState(gamePane));
        return "Paused";
    }

    @Override
    String onPlay() {
        return "Playing";
    }

    @Override
    String onReset() {
        gamePane.resetGame();
        return "Reset normal game";
    }


    @Override
    String onTurbo() {
        gamePane.changeState(new TurboState(gamePane));
        return "Turbo activated";
    }

}
