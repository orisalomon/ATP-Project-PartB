package maze3D;


import algorithms.search.AState;

public class Maze3DState extends AState {

    private Position3D currState;




    public Maze3DState(Position3D currState, AState parent, int price) {
        super(parent, price);
        this.currState=currState;

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

    @Override
    public Object getState() {
        return currState;
    }

    public Position3D getPosition(){
        return (Position3D)this.currState;
    }

    public int getPrice(){return this.price;}

}