package algorithms.maze3D;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MyMaze3DGenerator extends AMaze3DGenerator{

    @Override
    public Maze3D generate(int depth, int row, int column) {
        //        if(depth < 2 || row < 2 || column < 2){
//            throw new Exception("depth, row and cols must be positive ints greater than 2");
//        }
        Stack<Position3D> stack = new Stack<>();
        Random rand = new Random();

        Position3D start = new Position3D(depth/2,row/2, 0);
        Position3D goal = new Position3D(depth/2, row/2,column-1);

        Maze3D maze = new Maze3D(depth,row,column,start,goal);

        for(int k = 0; k < depth; k++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (start.toString().equals(k+ "," + i + "," + j )) {
                        maze.maze[k][i][j] = 0;
                    } else {
                        maze.maze[k][i][j] = 1;
                    }
                }
            }
        }

        stack.push(start);

        while(!stack.empty()){
            Position3D current = stack.pop();
            ArrayList<Position3D> c_neighbors = new ArrayList<>();
            // check for visited neighbors
            checkUnvisitedNeighbors(current, c_neighbors, row, column,depth, maze);
            if(c_neighbors.size() > 0) {
                stack.push(current);
                Position3D to_visit = c_neighbors.get(rand.nextInt(c_neighbors.size()));
                breakWall(current, to_visit, maze);
                maze.maze[to_visit.getDepthIndex()][to_visit.getRowIndex()][to_visit.getColumnIndex()] = 0;
                if (to_visit.getRowIndex() != goal.getRowIndex() || to_visit.getColumnIndex() != goal.getColumnIndex() || to_visit.getDepthIndex() != goal.getDepthIndex()){

                    stack.push(to_visit);
                }
            }
        }

        maze.maze[goal.getDepthIndex()][goal.getRowIndex()][goal.getColumnIndex()-1] = 0;  // open route for ending point- left
        maze.maze[goal.getDepthIndex()-1][goal.getRowIndex()][goal.getColumnIndex()] = 0;  // open route for ending point - up
        maze.maze[goal.getDepthIndex()][goal.getRowIndex()][goal.getColumnIndex()] = 0;  // ending point.
        return maze;
    }

    private void checkUnvisitedNeighbors(Position3D current, ArrayList<Position3D> c_neighbors, int row, int column, int depth,  Maze3D maze) {
        if (current.getRowIndex() + 2 < row) {
            if (maze.maze[current.getDepthIndex() ][current.getRowIndex() + 2][current.getColumnIndex()] == 1) {
                c_neighbors.add(new Position3D(current.getDepthIndex(),current.getRowIndex() + 2, current.getColumnIndex()));
            }
        }
        if (current.getRowIndex() - 2 >=0) {
            if (maze.maze[current.getDepthIndex() ][current.getRowIndex() - 2][current.getColumnIndex()] == 1) {
                c_neighbors.add(new Position3D(current.getDepthIndex(), current.getRowIndex() - 2, current.getColumnIndex()));
            }
        }
        if (current.getColumnIndex() + 2 < column) {
            if (maze.maze[current.getDepthIndex() ][current.getRowIndex()][current.getColumnIndex() + 2] == 1) {
                c_neighbors.add(new Position3D(current.getDepthIndex(), current.getRowIndex() , current.getColumnIndex() + 2));
            }
        }
        if (current.getColumnIndex() - 2 >= 0) {
            if (maze.maze[current.getDepthIndex() ][current.getRowIndex()][current.getColumnIndex() - 2] == 1) {
                c_neighbors.add(new Position3D(current.getDepthIndex(), current.getRowIndex() , current.getColumnIndex() - 2 ));
            }
        }
        if(current.getDepthIndex() - 2 >=0){
            if(maze.maze[current.getDepthIndex()-2][current.getRowIndex()][current.getColumnIndex()] == 1){
                c_neighbors.add(new Position3D(current.getDepthIndex() - 2, current.getRowIndex(), current.getColumnIndex()));
            }

        }
        if(current.getDepthIndex() + 2 < depth){
            if(maze.maze[current.getDepthIndex()+2][current.getRowIndex()][current.getColumnIndex()] == 1){
                c_neighbors.add(new Position3D(current.getDepthIndex() + 2, current.getRowIndex(), current.getColumnIndex()));
            }

        }



    }
    private void breakWall(Position3D current, Position3D to_visit, Maze3D maze) {
        if(current.getRowIndex() - to_visit.getRowIndex() == 2){
            maze.maze[current.getDepthIndex()][current.getRowIndex()-1][current.getColumnIndex()] = 0;
        }
        else if(current.getRowIndex() - to_visit.getRowIndex() == -2){
            maze.maze[current.getDepthIndex()][current.getRowIndex()+1][current.getColumnIndex()] = 0;
        }
        else if(current.getColumnIndex() - to_visit.getColumnIndex() == 2){
            maze.maze[current.getDepthIndex()][current.getRowIndex()][current.getColumnIndex() - 1] = 0;
        }
        else if(current.getColumnIndex() - to_visit.getColumnIndex() == -2){
            maze.maze[current.getDepthIndex()][current.getRowIndex()][current.getColumnIndex() + 1] = 0;
        }
        else if(current.getDepthIndex() - to_visit.getDepthIndex() == -2){
            maze.maze[current.getDepthIndex()+1][current.getRowIndex()][current.getColumnIndex()] = 0;
        }
        else if(current.getDepthIndex() - to_visit.getDepthIndex() == 2){
            maze.maze[current.getDepthIndex()-1][current.getRowIndex()][current.getColumnIndex()] = 0;
        }

    }
}
