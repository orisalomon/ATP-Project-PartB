package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.Comparator;
import java.util.Objects;

public class MazeState extends AState{

    // field
    private Position currPos;

    /**
     * -- Constructor --
     * @param currPos - Position - maze State defined by position.
     * @param father - MazeState - to create the solution path. (mazeState is node in searching problem)
     * @param price - int - cost of each state
     */
    public MazeState(Position currPos, MazeState father, int price) {
        //        if(currState == null ){
//            throw new Exception("current state must not be null");
//        }
        super(father,price);
        this.currPos = currPos;
    }

    /**
     * -- hashCode --
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(currPos);
    }

    /**
     * -- equals --
     * @param obj - other object.
     * @return boolean - true if the object is equals to this object.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return currPos.equals(((MazeState) obj).currPos);
    }

    /**
     * -- toString --
     * the toString of MazeState defined by the position of it.
     * @return String
     */
    @Override
    public String toString() {
        return ((Position)currPos).toString();
    }

    /**
     * -- getPosition --
     * @return Position
     */
    public Position getPosition() {
        return currPos;
    }


}
