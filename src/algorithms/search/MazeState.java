package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.Comparator;

public class MazeState extends AState{

    private Position currPos;
    public MazeState(Position currPos, MazeState father, int price) {
        super(father,price);
        this.currPos = currPos;
    } //

    @Override
    public int hashCode() {
        return 0;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        return currState.equals(((MazeState) obj).currState);
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return currPos.equals(((MazeState) obj).currPos);
    }

    @Override
    public String toString() {
        return ((Position)currPos).toString();
    }


    public Position getPosition() {
        return currPos;
    }


}
