package algorithms.maze3D;


import algorithms.search.AState;

import java.util.Objects;


public class Maze3DState extends AState {
    private Position3D currState;

    /**
     *
     * @param currState - represents the current position in the maze
     * @param parent - represents the previous position in the maze
     * @param price - each AState have price. some algorithms like "BESTFirstSearch" using it.
     */
    public Maze3DState(Position3D currState, AState parent, int price) throws Exception {
        super(parent, price);
        if(currState == null ){
            throw new Exception("current state must not be null");
        }

        this.currState=currState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currState);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return (this.currState).equals(((Maze3DState) obj).currState);
    }

    @Override
    public String toString() {
        return (this.currState).toString();
    }

    /**
     *
     * @return the position that is represented by the state
     */
    public Position3D getPosition(){
        return this.currState;
    }
}
