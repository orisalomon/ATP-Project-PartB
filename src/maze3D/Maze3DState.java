package maze3D;


import algorithms.mazeGenerators.Position;
import algorithms.search.AState;


public class Maze3DState extends AState {

    public Maze3DState(Object currState, AState parent, int price) {
        super(currState, parent, price);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return ((Position3D)this.currState).equals(((Maze3DState) obj).currState);
    }

    @Override
    public String toString() {
        return ((Position3D)this.currState).toString();
    }

    public Position3D getPosition(){
        return (Position3D)this.currState;
    }

    public int getPrice(){return this.price;}
}
