package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable {

    // field
    private Maze maze;

    /**
     * -- Constructor --
     * @param maze - Maze - maze to set as searchable.
     */
    public SearchableMaze(Maze maze) {
        this.maze = maze;
    }

    /**
     * -- getMaze --
     * @return Maze
     */
    public Maze getMaze() {
        return maze;
    }

    /**
     * -- getStartState --
     * start state have no father and it price is 0.
     * @return AState
     */
    @Override
    public AState getStartState() throws Exception {
        return new MazeState(maze.getStartPosition(),null,0);
    }

    /**
     * -- getGoalState --
     * goal state have no father at the beginning only and it price is 0.
     * @return AState
     */
    @Override
    public AState getGoalState() throws Exception {return new MazeState(maze.getGoalPosition(),null,0);}


    /**
     * -- getAllSuccessors --
     * gets AState s and returns all the possible successors of s.
     * @param s - AState - the state to search all the successors from.
     * @return ArrayList<AState> - List of all the possible AStates.
     */
    @Override
    public ArrayList<AState> getAllSuccessors(AState s) throws Exception {
        if(s == null ){
            throw new Exception("current state must not be null");
        }
        MazeState mState = (MazeState) s;           // the given state is MazeState
        Position p = (Position) mState.getPosition();   // position of the state
        ArrayList<AState> posStates = new ArrayList<>(); // possible states array for the ans.

        int pRow = p.getRowIndex();    // get the curr state row
        int pCol = p.getColumnIndex();  // get the curr state col
        int[][] tMaze = maze.getMaze();  // get the maze.

        /// check all the diagonals
        /// only legal if it is on the board and there is path of zeros to it. the price for diagonal state is the sum of the curr state +15.
        if (pCol-1 >= 0 && pRow-1 >= 0 && (tMaze[pRow-1][pCol] == 0 || tMaze[pRow][pCol-1] == 0)  && tMaze[pRow-1][pCol-1] == 0){
            posStates.add(new MazeState(new Position(pRow-1,pCol-1),mState,s.price+15));
        }

        if (pCol+1 < maze.getCols() && pRow-1 >= 0 && (tMaze[pRow][pCol+1] == 0 || tMaze[pRow-1][pCol] == 0)  && tMaze[pRow-1][pCol+1]== 0 ){
            posStates.add(new MazeState(new Position(pRow-1,pCol+1),mState,s.price+15));
        }

        if (pCol+1 < maze.getCols() && pRow+1 < maze.getRows() && (tMaze[pRow+1][pCol] == 0 || tMaze[pRow][pCol+1] == 0)  && tMaze[pRow+1][pCol+1]== 0 ){
            posStates.add(new MazeState(new Position(pRow+1,pCol+1),mState,s.price+15));
        }

        if (pCol-1 >= 0 && pRow+1 < maze.getRows() && (tMaze[pRow+1][pCol] == 0 || tMaze[pRow][pCol-1] == 0)  && tMaze[pRow+1][pCol-1]== 0 ){
            posStates.add(new MazeState(new Position(pRow+1,pCol-1),mState,s.price+15));
        }

        // check up
        // only legal if it is on the board and the value of the cell is zero. the price is the sum of the curr state + 10.
        if (pRow-1 >= 0){
            if(tMaze[pRow-1][pCol] == 0){
                posStates.add(new MazeState(new Position(pRow-1,pCol),mState,s.price+10));
            }
        }

        // check down
        // only legal if it is on the board and the value of the cell is zero. the price is the sum of the curr state + 10.
        if (pRow+1 < maze.getRows()){
            if(tMaze[pRow+1][pCol] == 0){
                posStates.add(new MazeState(new Position(pRow+1,pCol),mState,s.price+10));
            }
        }

        // check left
        // only legal if it is on the board and the value of the cell is zero. the price is the sum of the curr state + 10.
        if (pCol-1 >= 0){
            if(tMaze[pRow][pCol-1] == 0){
                posStates.add(new MazeState(new Position(pRow,pCol-1),mState,s.price+10));
            }
        }

        // check right
        // only legal if it is on the board and the value of the cell is zero. the price is the sum of the curr state + 10.
        if (pCol+1 < maze.getCols()){
            if(tMaze[pRow][pCol+1] == 0){
                posStates.add(new MazeState(new Position(pRow,pCol+1),mState,s.price+10));
            }
        }

        return posStates;
    }
}
