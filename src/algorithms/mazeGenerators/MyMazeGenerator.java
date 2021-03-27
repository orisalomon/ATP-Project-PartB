package algorithms.mazeGenerators;

import java.util.Random;
import java.util.Stack;
import java.util.ArrayList;

public class MyMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int rows, int cols) {
        Stack<Position> stack = new Stack<>();
        Random rand = new Random();

        Position start = new Position(rand.nextInt(rows), 0);
        Position goal = new Position(rand.nextInt(rows),cols-1);

        Maze maze = new Maze(rows,cols,start,goal);

        for (int i = 0; i<rows; i++){
            for (int j = 0; j<cols; j++){
                if (start.toString().equals(i + "," + j)) {
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
        return maze;
    }

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

    private void checkUnvisitedNeighbors(Position current, ArrayList<Position> c_neighbors, int rows, int cols, Maze maze) {
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
