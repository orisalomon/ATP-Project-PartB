package algorithms.maze3D;


import algorithms.search.AState;

import java.util.Objects;


public class Maze3DState extends AState {
    private Position3D currState;
    public Maze3DState(Position3D currState, AState parent, int price) {
        super(parent, price);
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



    public Position3D getPosition(){
        return this.currState;
    }
}
