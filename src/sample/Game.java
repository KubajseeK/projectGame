package sample;


import static sample.State.READY;
import static sample.State.RUNNING;

public class Game {
    private Field field;
    private State state;

    public Game() {
        state = READY;
    }
    public void start() {
        if (state == READY) {
            state = State.RUNNING;
            field = new Field();
            //field.shuffle();
        }
    }
    public void end() {
        if (state == RUNNING) {
            state = State.FINISHED;
            field = null;
        }
    }
    public void reset() {
        if(state != READY) {
            state = READY;
            field = null;
        }
    }

    public Field getField() {
        return field;
    }

    public void nextMove(int code) {
        if(state == RUNNING) {
            field.toggleTiles(code);

            if(field.isWinner()) {
                end();
            }
        }
    }
}
