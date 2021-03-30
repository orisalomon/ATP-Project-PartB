package maze3D;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;
import algorithms.search.AState;
import algorithms.search.ISearchable;
import algorithms.search.MazeState;

import java.util.ArrayList;

public class SearchableMaze3D implements ISearchable {

    private Maze3D maze;


    public SearchableMaze3D(Maze3D maze) {
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
        Maze3DState mState = (Maze3DState) s;
        Position3D p = mState.getPosition();
        ArrayList<AState> posStates = new ArrayList<>();

        int pDepth = p.getDepthIndex();
        int pRow = p.getRowIndex();
        int pCol = p.getColumnIndex();
        int[][][] tMaze = maze.getMap();

        if (pRow+1 < maze.getRows()){
            if(tMaze[pDepth][pRow+1][pCol] == 0){
                posStates.add(new Maze3DState(new Position3D(pDepth,pRow+1,pCol),mState,mState.getPrice()+10));
            }
        }
        if (pRow-1 >= 0){
            if(tMaze[pDepth][pRow-1][pCol] == 0){
                posStates.add(new Maze3DState(new Position3D(pDepth,pRow-1,pCol),mState,mState.getPrice()+10));
            }
        }
        if (pCol-1 >= 0){
            if(tMaze[pDepth][pRow][pCol-1] == 0){
                posStates.add(new Maze3DState(new Position3D(pDepth,pRow,pCol-1),mState,mState.getPrice()+10));
            }
        }
        if (pCol+1 < maze.getCols()){
            if(tMaze[pDepth][pRow][pCol+1] == 0){
                posStates.add(new Maze3DState(new Position3D(pDepth,pRow,pCol+1),mState,mState.getPrice()+10));
            }
        }
        if (pDepth+1 < maze.getDepth()){
            if(tMaze[pDepth+1][pRow][pCol] == 0){
                posStates.add(new Maze3DState(new Position3D(pDepth+1,pRow,pCol),mState,mState.getPrice()+10));
            }
        }
        if (pDepth-1 >=0){
            if(tMaze[pDepth-1][pRow][pCol] == 0){
                posStates.add(new Maze3DState(new Position3D(pDepth-1,pRow,pCol),mState,mState.getPrice()+10));
            }
        }
        return posStates;
    }
}
