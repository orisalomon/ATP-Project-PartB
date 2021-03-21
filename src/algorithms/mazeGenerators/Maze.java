package algorithms.mazeGenerators;

import java.util.Arrays;

public class Maze {

    private int rows;
    private int cols;
    protected int[][] maze;

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        maze = new int[rows][cols];
    }

    @Override
    public String toString() {
        String ret = "";
        for (int i = 0; i<rows; i++){
            ret = ret + "[";
            for (int j=0; j<cols; j++){
                ret = ret + maze[i][j] + " ";
            }
            ret = ret + "]\n";
        }
        return ret;
    }
}
