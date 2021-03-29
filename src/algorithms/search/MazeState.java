package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState{

    public MazeState(Position currPos) {
        super(currPos);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Position)this.currState).equals(obj);
    }

    @Override
    public String toString() {
        return ((Position)currState).toString();
    }
}
