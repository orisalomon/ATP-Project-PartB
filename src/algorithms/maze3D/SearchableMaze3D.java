package algorithms.maze3D;

import algorithms.search.AState;
import algorithms.search.ISearchable;

import java.util.ArrayList;

public class SearchableMaze3D implements ISearchable {

    private Maze3D maze;


    public SearchableMaze3D(Maze3D maze) {
        // if(maze == null){throw new Exception("maze must not be null");}
        this.maze = maze;
    }

    @Override
    public AState getStartState() {
        return new Maze3DState(maze.getStartPosition(),null,0);
    }

    @Override
    public AState getGoalState() {
        return new Maze3DState(maze.getGoalPosition(),null,0);
    }

    @Override
    public ArrayList<AState> getAllSuccessors(AState s) {
        // if(s == null){throw new Exception("parameter must not be null");}
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
            if(tMaze[pDepth][pRow+1][pCol] == 0){
                newP=new Position3D(pDepth,pRow+1,pCol);
                newMState = new Maze3DState(newP,mState,mState.getPrice()+10);
                posStates.add(newMState);
            }
        }
        if (pRow-1 >= 0){
            if(tMaze[pDepth][pRow-1][pCol] == 0){
                newP=new Position3D(pDepth,pRow-1,pCol);
                newMState = new Maze3DState(newP,mState,mState.getPrice()+10);
                posStates.add(newMState);
            }
        }
        if (pCol-1 >= 0){
            if(tMaze[pDepth][pRow][pCol-1] == 0){
                newP=new Position3D(pDepth,pRow,pCol-1);
                newMState = new Maze3DState(newP,mState,mState.getPrice()+10);
                posStates.add(newMState);
            }
        }
        if (pCol+1 < maze.getCols()){
            if(tMaze[pDepth][pRow][pCol+1] == 0){
                newP=new Position3D(pDepth,pRow,pCol+1);
                newMState =new Maze3DState(newP,mState,mState.getPrice()+10);
                posStates.add(newMState);
            }
        }
        if (pDepth+1 < maze.getDepth()){
            if(tMaze[pDepth+1][pRow][pCol] == 0){
                newP=new Position3D(pDepth+1,pRow,pCol);
                newMState =new Maze3DState(newP,mState,mState.getPrice()+10);
                posStates.add(newMState);
            }
        }
        if (pDepth-1 >=0){
            if(tMaze[pDepth-1][pRow][pCol] == 0){
                newP=new Position3D(pDepth-1,pRow,pCol);
                newMState =new Maze3DState(newP,mState,mState.getPrice()+10);
                posStates.add(newMState);
            }
        }
        return posStates;
    }
}
