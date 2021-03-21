package algorithms.mazeGenerators;


public class EmptyMazeGenerator extends AMazeGenerator{

    @Override
    public Maze generate(int rows, int cols) {
        Maze new_maze = new Maze(rows,cols);
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                new_maze.maze[i][j] = 0;
            }
        }
        return new_maze;
    }
}
