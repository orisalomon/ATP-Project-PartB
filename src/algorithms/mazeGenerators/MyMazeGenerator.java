package algorithms.mazeGenerators;

import java.util.Random;
import java.util.Stack;
import java.util.ArrayList;

public class MyMazeGenerator extends AMazeGenerator {

    /**
     * creates a rows X cols maze using DFS algorithm
     * @param rows - rows number of generated maze
     * @param cols - columns number of generated maze
     * @return maze object
     */
    @Override
    public Maze generate(int rows, int cols) throws Exception {
        if(rows < 2 || cols < 2){
            throw new Exception("row and cols must be positive ints greater than 2");
        }
        Stack<Position> stack = new Stack<>();
        Random rand = new Random();

        Position start = new Position(rows/2, 0);
        Position goal = new Position(rows/2,cols-1);

        Maze maze = new Maze(rows,cols,start,goal);

        for (int i = 0; i<rows; i++){
            for (int j = 0; j<cols; j++){
                if (start.toString().equals("{"+i + "," + j + "}")) {
                    maze.maze[i][j] = 0;
                } else {
                    maze.maze[i][j] = 1;
                }
            }
        }

        stack.push(start);

        while(!stack.empty()){
            Position current = stack.pop();
            ArrayList<Position> c_neighbors = new ArrayList<>();
            // check for visited neighbors
            checkUnvisitedNeighbors(current, c_neighbors, rows, cols, maze);
            if(c_neighbors.size() > 0) {
                stack.push(current);
                Position to_visit = c_neighbors.get(rand.nextInt(c_neighbors.size()));
                breakWall(current, to_visit, maze);
                maze.maze[to_visit.getRowIndex()][to_visit.getColumnIndex()] = 0;
                if (to_visit.getRowIndex() != goal.getRowIndex() || to_visit.getColumnIndex() != goal.getColumnIndex()){

                    stack.push(to_visit);
                }
            }
        }

        maze.maze[goal.getRowIndex()][goal.getColumnIndex()-1] = 0;  // open route for ending point.
        maze.maze[goal.getRowIndex()][goal.getColumnIndex()] = 0;  // ending point.
        return maze;
    }
    /**
     * breaks the wall between 2 positions in the maze, create path between them
     * @param current - current position in the maze
     * @param to_visit - the position which we want to break the wall between it and the current
     * @param maze - the maze itself
     */
    private void breakWall(Position current, Position to_visit, Maze maze) {
        if(current.getRowIndex() - to_visit.getRowIndex() == 2){
            maze.maze[current.getRowIndex()-1][current.getColumnIndex()] = 0;
        }
        else if(current.getRowIndex() - to_visit.getRowIndex() == -2){
            maze.maze[current.getRowIndex()+1][current.getColumnIndex()] = 0;
        }
        else if(current.getColumnIndex() - to_visit.getColumnIndex() == 2){
            maze.maze[current.getRowIndex()][current.getColumnIndex() - 1] = 0;
        }
        else if(current.getColumnIndex() - to_visit.getColumnIndex() == -2){
            maze.maze[current.getRowIndex()][current.getColumnIndex() + 1] = 0;
        }
    }
    /**
     * checks the unvisited neighbors of a specific position in the maze
     * @param current - current position which it's neighbors we want to check
     * @param c_neighbors - array of positions which will hold the unvisited neighbors
     * @param rows - number of rows in the maze
     * @param cols - number of columns in the maze
     * @param maze - the maze itself
     */
    private void checkUnvisitedNeighbors(Position current, ArrayList<Position> c_neighbors, int rows, int cols, Maze maze) throws Exception {
        if (current.getRowIndex() + 2 < rows) {
            if (maze.maze[current.getRowIndex() + 2][current.getColumnIndex()] == 1) {
                c_neighbors.add(new Position(current.getRowIndex() + 2, current.getColumnIndex()));
            }
        }
        if (current.getRowIndex() - 2 >=0) {
            if (maze.maze[current.getRowIndex() - 2][current.getColumnIndex()] == 1) {
                c_neighbors.add(new Position(current.getRowIndex() - 2, current.getColumnIndex()));
            }
        }
        if (current.getColumnIndex() + 2 < cols) {
            if (maze.maze[current.getRowIndex()][current.getColumnIndex() + 2] == 1) {
                c_neighbors.add(new Position(current.getRowIndex() , current.getColumnIndex() + 2));
            }
        }
        if (current.getColumnIndex() - 2 >= 0) {
            if (maze.maze[current.getRowIndex()][current.getColumnIndex() - 2] == 1) {
                c_neighbors.add(new Position(current.getRowIndex() , current.getColumnIndex() - 2 ));
            }
        }

    }
}
