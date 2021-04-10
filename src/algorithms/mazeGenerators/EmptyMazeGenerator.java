package algorithms.mazeGenerators;


public class EmptyMazeGenerator extends AMazeGenerator{

    /**
     * creates an empty rows X cols maze (with no walls)
     * @param rows - rows number of generated maze
     * @param cols - columns number of generated maze
     * @return maze object
     */
    @Override
    public Maze generate(int rows, int cols) {
        //        if(rows < 2 || cols < 2){
//            throw new Exception("row and cols must be positive ints greater than 2");
//        }
        Maze new_maze = new Maze(rows,cols,new Position(0,0),new Position(rows-1,cols-1));
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                new_maze.maze[i][j] = 0;
            }
        }
        return new_maze;
    }
}
