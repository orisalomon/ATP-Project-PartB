package algorithms.mazeGenerators;


public class EmptyMazeGenerator extends AMazeGenerator{

    @Override
    public Maze generate(int rows, int cols) {
        Maze new_maze = new Maze(rows,cols,new Position(0,0),new Position(rows-1,cols-1));
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                new_maze.maze[i][j] = 0;
            }
        }
        return new_maze;
    }
}
