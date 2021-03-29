package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable {

    private Maze maze;


    public SearchableMaze(Maze maze) {
        this.maze = maze;
    }

    public Maze getMaze() {
        return maze;
    }

    @Override
    public AState getStartState() {
        return new MazeState(maze.getStartPosition(),null);
    }

    @Override
    public AState getGoalState() {return new MazeState(maze.getGoalPosition(),null);}



    @Override
    public ArrayList<AState> getAllPossibleStates(AState s) {
        MazeState mState = (MazeState) s;
        Position p = (Position)s.currState;
        ArrayList<AState> posStates = new ArrayList<>();

        int pRow = p.getRowIndex();
        int pCol = p.getColumnIndex();
        int[][] tMaze = maze.getMaze();

        if (pRow-1 >= 0){
            if(tMaze[pRow-1][pCol] == 0){
                posStates.add(new MazeState(new Position(pRow-1,pCol),mState));
            }
        }

        if (pRow+1 < maze.getRows()){
            if(tMaze[pRow+1][pCol] == 0){
                posStates.add(new MazeState(new Position(pRow+1,pCol),mState));
            }
        }

        if (pCol-1 >= 0){
            if(tMaze[pRow][pCol-1] == 0){
                posStates.add(new MazeState(new Position(pRow,pCol-1),mState));
            }
        }

        if (pCol+1 < maze.getCols()){
            if(tMaze[pRow][pCol+1] == 0){
                posStates.add(new MazeState(new Position(pRow,pCol+1),mState));
            }
        }

        if (pCol-1 >= 0 && pRow-1 >= 0 && (tMaze[pRow-1][pCol] == 0 || tMaze[pRow][pCol-1] == 0)  && tMaze[pRow-1][pCol-1]== 0 ){
            posStates.add(new MazeState(new Position(pRow-1,pCol-1),mState));
        }

        if (pCol+1 < maze.getCols() && pRow-1 >= 0 && (tMaze[pRow][pCol+1] == 0 || tMaze[pRow-1][pCol] == 0)  && tMaze[pRow-1][pCol+1]== 0 ){
            posStates.add(new MazeState(new Position(pRow-1,pCol+1),mState));
        }

        if (pCol+1 < maze.getCols() && pRow+1 < maze.getRows() && (tMaze[pRow+1][pCol] == 0 || tMaze[pRow][pCol+1] == 0)  && tMaze[pRow+1][pCol+1]== 0 ){
            posStates.add(new MazeState(new Position(pRow+1,pCol+1),mState));
        }

        if (pCol-1 >= 0 && pRow+1 < maze.getRows() && (tMaze[pRow+1][pCol] == 0 || tMaze[pRow][pCol-1] == 0)  && tMaze[pRow+1][pCol-1]== 0 ){
            posStates.add(new MazeState(new Position(pRow+1,pCol-1),mState));
        }

        return posStates;
    }
}
