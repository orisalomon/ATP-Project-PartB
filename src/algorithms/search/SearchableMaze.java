package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable {

    private Maze maze;
    private MazeState[][] mazeStates;


    public SearchableMaze(Maze maze) {
        this.maze = maze;
        mazeStates = new MazeState[maze.getRows()][maze.getCols()];
        setDefault();
    }

    public Maze getMaze() {
        return maze;
    }

    @Override
    public AState getStartState() {
        return new MazeState(maze.getStartPosition(), false, null,0);
    }

    @Override
    public AState getGoalState() {return new MazeState(maze.getGoalPosition(), false, null,0);}



    @Override
    public ArrayList<AState> getAllSuccessors(AState s) {
        MazeState mState = (MazeState) s;
        Position p = (Position)s.getState();
        ArrayList<AState> posStates = new ArrayList<>();

        int pRow = p.getRowIndex();
        int pCol = p.getColumnIndex();
        // int[][] tMaze = maze.getMaze();

        if (pCol-1 >= 0 && pRow-1 >= 0 && (!mazeStates[pRow-1][pCol].isWall() || !mazeStates[pRow][pCol-1].isWall())  && !mazeStates[pRow-1][pCol-1].isWall()){
            mazeStates[pRow-1][pCol-1].setPrice(s.price+15);
            // posStates.add(new MazeState(new Position(pRow-1,pCol-1), wall, null,s.price+15));
            posStates.add(mazeStates[pRow-1][pCol-1]);
        }

        if (pCol+1 < maze.getCols() && pRow-1 >= 0 && (!mazeStates[pRow][pCol+1].isWall() || !mazeStates[pRow-1][pCol].isWall())  && !mazeStates[pRow-1][pCol+1].isWall() ){
            mazeStates[pRow-1][pCol+1].setPrice(s.price+15);
            // posStates.add(new MazeState(new Position(pRow-1,pCol+1), wall, null,s.price+15));
            posStates.add(mazeStates[pRow-1][pCol+1]);
        }

        if (pCol+1 < maze.getCols() && pRow+1 < maze.getRows() && (!mazeStates[pRow+1][pCol].isWall() || !mazeStates[pRow][pCol+1].isWall())  && !mazeStates[pRow+1][pCol+1].isWall()){
            mazeStates[pRow+1][pCol+1].setPrice(s.price+15);
            // posStates.add(new MazeState(new Position(pRow+1,pCol+1), wall, null,s.price+15));
            posStates.add(mazeStates[pRow+1][pCol+1]);
        }

        if (pCol-1 >= 0 && pRow+1 < maze.getRows() && (!mazeStates[pRow+1][pCol].isWall() || !mazeStates[pRow][pCol-1].isWall())  && !mazeStates[pRow+1][pCol-1].isWall() ){
            mazeStates[pRow+1][pCol-1].setPrice(s.price+15);
            // posStates.add(new MazeState(new Position(pRow+1,pCol-1), wall, null,s.price+15));
            posStates.add(mazeStates[pRow+1][pCol-1]);
        }

        if (pRow-1 >= 0){
            if(!mazeStates[pRow-1][pCol].isWall()){

                //posStates.add(new MazeState(new Position(pRow-1,pCol), wall, null,s.price+10));
                posStates.add(mazeStates[pRow-1][pCol]);
            }
        }

        if (pRow+1 < maze.getRows()){
            if(!mazeStates[pRow+1][pCol].isWall()){

                // posStates.add(new MazeState(new Position(pRow+1,pCol), wall, null,s.price+10));
                posStates.add(mazeStates[pRow+1][pCol]);
            }
        }

        if (pCol-1 >= 0){
            if(!mazeStates[pRow][pCol-1].isWall()){

                //posStates.add(new MazeState(new Position(pRow,pCol-1), wall, null,s.price+10));
                posStates.add(mazeStates[pRow][pCol-1]);
            }
        }

        if (pCol+1 < maze.getCols()){
            if(!mazeStates[pRow][pCol+1].isWall()){

                //posStates.add(new MazeState(new Position(pRow,pCol+1), wall, null,s.price+10));
                posStates.add(mazeStates[pRow][pCol+1]);
            }
        }

        return posStates;
    }

    @Override
    public void setDefault() {
        for(int i = 0; i< maze.getRows();++i){
            for (int j=0;j< maze.getCols();++j){
                boolean wall = false;
                if (maze.getMaze()[i][j] == 1){wall = true;}

                if ("{"+i+j+"}" == maze.getStartPosition().toString()){mazeStates[i][j] = new MazeState(new Position(i,j),wall,null,0);}
                else{mazeStates[i][j] = new MazeState(new Position(i,j),wall,null,10);}

            }
        }
    }
}
