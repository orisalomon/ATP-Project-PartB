package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState{

    private Position source;
    private Position target;

    public MazeState(Object currState) {
        super(currState);
    }
}
