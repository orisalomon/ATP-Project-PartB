package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState{

    private Position currPos;
    private boolean wall;
    public MazeState(Position currPos, boolean wall, MazeState father, int price) {
        super(father,price);
        this.currPos = currPos;
        this.wall = wall;
    }

    public boolean isWall() {
        return wall;
    }

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

    @Override
    public Object getState() {
        return currPos;
    }


}
