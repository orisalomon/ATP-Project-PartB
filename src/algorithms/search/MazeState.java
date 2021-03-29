package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState{

    public MazeState(Position currPos, MazeState father) {
        super(currPos,father);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return ((Position)this.currState).equals(((MazeState) obj).currState);
    }

    @Override
    public String toString() {
        return ((Position)currState).toString();
    }
}
