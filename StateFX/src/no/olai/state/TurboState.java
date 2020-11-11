package no.olai.state;

public class TurboState extends State {

    public TurboState(GamePane gamePane) {
        super(gamePane);
        gamePane.setTurbo(true);
    }

    @Override
    String onPlay() {
        return "Turbo is on!";
    }

    @Override
    String onPause() {
        return "Can't pause turbo!";
    }

    @Override
    String onReset() {
        gamePane.changeState(new PlayingState(gamePane));
        gamePane.resetGame();
        return "Reset (Normal game)";
    }

    @Override
    String onTurbo() {
        return "Turbo already activated!";
    }

}
