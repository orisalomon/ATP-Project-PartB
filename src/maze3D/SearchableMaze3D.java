package maze3D;

import algorithms.mazeGenerators.Position;
import algorithms.search.AState;
import algorithms.search.ISearchable;
import algorithms.search.MazeState;

import java.util.ArrayList;

public class SearchableMaze3D implements ISearchable {

    private Maze3D maze;
    private Maze3DState[][][] mazeStates;

    public SearchableMaze3D(Maze3D maze) {
        this.maze = maze;
        mazeStates = new Maze3DState[maze.getDepth()][maze.getRows()][maze.getCols()];
        setDefault();
    }

    @Override
    public AState getStartState() {
        return new Maze3DState(maze.getStartPosition(), null,0);
    }

    @Override
    public AState getGoalState() {
        return new Maze3DState(maze.getGoalPosition(), null,0);
    }

    @Override
    public ArrayList<AState> getAllSuccessors(AState s) {
        Maze3DState mState = (Maze3DState) s;
        Maze3DState newMState;
        Position3D p = mState.getPosition();
        Position3D newP;
        ArrayList<AState> posStates = new ArrayList<>();

        int pDepth = p.getDepthIndex();
        int pRow = p.getRowIndex();
        int pCol = p.getColumnIndex();
        int[][][] tMaze = maze.getMap();

        if (pRow+1 < maze.getRows()){
            if(mazeStates[pDepth][pRow+1][pCol] != null ){
                // newP=new Position3D(pDepth,pRow+1,pCol);
                // newMState = new Maze3DState(newP, wall, mState,mState.getPrice()+10);
                mazeStates[pDepth][pRow+1][pCol].setPrice(s.getPrice()+10);
                posStates.add(mazeStates[pDepth][pRow+1][pCol]);
            }
        }
        if (pRow-1 >= 0){
            if(mazeStates[pDepth][pRow-1][pCol]!= null){
//                newP=new Position3D(pDepth,pRow-1,pCol);
//                newMState = new Maze3DState(newP, wall, mState,mState.getPrice()+10);
//                posStates.add(newMState);
                mazeStates[pDepth][pRow-1][pCol].setPrice(s.getPrice()+10);
                posStates.add(mazeStates[pDepth][pRow-1][pCol]);
            }
        }
        if (pCol-1 >= 0){
            if(mazeStates[pDepth][pRow][pCol-1]!= null){
//                newP=new Position3D(pDepth,pRow,pCol-1);
//                newMState = new Maze3DState(newP, wall, mState,mState.getPrice()+10);
//                posStates.add(newMState);
                mazeStates[pDepth][pRow][pCol-1].setPrice(s.getPrice()+10);
                posStates.add(mazeStates[pDepth][pRow][pCol-1]);
            }
        }
        if (pCol+1 < maze.getCols()){
            if(mazeStates[pDepth][pRow][pCol+1]!= null){
//                newP=new Position3D(pDepth,pRow,pCol+1);
//                newMState =new Maze3DState(newP, wall, mState,mState.getPrice()+10);
//                posStates.add(newMState);
                mazeStates[pDepth][pRow][pCol+1].setPrice(s.getPrice()+10);
                posStates.add(mazeStates[pDepth][pRow][pCol+1]);
            }
        }
        if (pDepth+1 < maze.getDepth()){
            if(mazeStates[pDepth+1][pRow][pCol]!= null){
//                newP=new Position3D(pDepth+1,pRow,pCol);
//                newMState =new Maze3DState(newP, wall, mState,mState.getPrice()+10);
//                posStates.add(newMState);
                mazeStates[pDepth+1][pRow][pCol].setPrice(s.getPrice()+10);
                posStates.add(mazeStates[pDepth+1][pRow][pCol]);
            }
        }
        if (pDepth-1 >=0){
            if(mazeStates[pDepth-1][pRow][pCol]!= null){
//                newP=new Position3D(pDepth-1,pRow,pCol);
//                newMState =new Maze3DState(newP, wall, mState,mState.getPrice()+10);
//                posStates.add(newMState);
                mazeStates[pDepth-1][pRow][pCol].setPrice(s.getPrice()+10);
                posStates.add(mazeStates[pDepth-1][pRow][pCol]);
            }
        }
        return posStates;
    }

    @Override
    public void setDefault() {
        for(int i = 0; i< maze.getDepth();++i) {
            for (int j = 0; j < maze.getRows(); ++j) {
                for (int k = 0; k < maze.getCols(); ++k) {
                    boolean wall = false;
                    if (maze.getMap()[i][j][k] == 0) {

                        if (i== maze.getDepth()/2 && j == 0 && k == maze.getRows()/2) {
                            mazeStates[i][j][k] = new Maze3DState(maze.getStartPosition(), null, 0);
                        }
                        else {
                            mazeStates[i][j][k] = new Maze3DState(new Position3D(i, j, k), null, 10);
                        }
                    }
                }
            }
        }
    }
}
