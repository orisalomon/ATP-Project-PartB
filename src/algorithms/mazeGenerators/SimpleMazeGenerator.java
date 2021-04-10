package algorithms.mazeGenerators;
import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator{

    /**
     * creates a rows X cols maze randomly with at least one guaranteed solution
     * @param rows - rows number of generated maze
     * @param cols - columns number of generated maze
     * @return maze object
     */
    @Override
    public Maze generate(int rows, int cols) throws Exception {
        if(rows < 2 || cols < 2){
            throw new Exception("row and cols must be positive ints greater than 2");
        }
        Position start = new Position(0,0);
        Position goal = new Position(rows-1,cols-1);

        Maze maze = new Maze(rows,cols,start,goal);

        // create simple constant path
        for (int i = 0; i<cols; i++){
            maze.maze[0][i] = 0;
        }

        for (int i = 0; i<rows; i++){
            maze.maze[i][cols-1] = 0;
        }

        Random rand = new Random();

        for (int i = 1; i<rows; i++){
            for (int j = 0; j<cols-1; j++){
                maze.maze[i][j] = rand.nextInt(2);
            }
        }

        return maze;
    }
}
