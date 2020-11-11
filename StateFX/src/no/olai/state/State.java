package no.olai.state;

public abstract class State {

    protected GamePane gamePane;


    public State(GamePane gamePane) {
        this.gamePane = gamePane;
        
    }

    abstract String onPlay();
    abstract String onTurbo();
    abstract String onPause();
    abstract String onReset();
}
