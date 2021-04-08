package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.Comparator;
import java.util.Objects;

public class MazeState extends AState{

    private Position currPos;
    public MazeState(Position currPos, MazeState father, int price) {
        //        if(currState == null ){
//            throw new Exception("current state must not be null");
//        }
        super(father,price);
        this.currPos = currPos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currPos);
    }

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
