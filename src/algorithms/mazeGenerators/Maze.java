package algorithms.mazeGenerators;

import java.util.Arrays;

public class Maze {

    private int rows;
    private int cols;
    private Position startPosition;

    public Position getStartPosition() {
        return startPosition;
    }

    public Position getGoalPosition() {
        return goalPosition;
    }

    private Position goalPosition;
    protected int[][] maze;

    public Maze(int rows, int cols, Position startPosition, Position goalPosition) {
        this.rows = rows;
        this.cols = cols;
        this.startPosition = startPosition;
        this.goalPosition = goalPosition;
        maze = new int[rows][cols];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    @Override
    public String toString() {
        String ret = "";
        for (int i = 0; i<rows; i++){
            ret = ret + "{ ";
            for (int j=0; j<cols; j++) {
                if (startPosition.toString().equals(i + "," + j)) {
                    ret = ret + "S" + " ";
                } else if (goalPosition.toString().equals(i + "," + j)) {
                    ret = ret + "E" + " ";
                } else {
                    ret = ret + maze[i][j] + " ";

                }
            }
            ret = ret + "}\n";
        }

        return ret;
    }


    public void print() {
        System.out.println(toString());
    }
}
