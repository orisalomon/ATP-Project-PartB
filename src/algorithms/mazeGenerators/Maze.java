package algorithms.mazeGenerators;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Maze  implements Serializable{

    private int rows;
    private int cols;
    private Position startPosition;
    private Position goalPosition;
    protected int[][] maze;


    /**
     * -- Constructor --
     * @param rows - int - rows number of maze
     * @param cols - int - columns number of maze
     * @param startPosition - Position - the start position of the maze
     * @param goalPosition - Position - the goal position of the maze
     */
    public Maze(int rows, int cols, Position startPosition, Position goalPosition) throws Exception {
        if(rows < 2 || cols < 2 || startPosition == null || goalPosition == null){
            throw new Exception("row and cols must be positive ints greater than 2, Positions must not be null");
        }
        this.rows = rows;
        this.cols = cols;
        this.startPosition = startPosition;
        this.goalPosition = goalPosition;
        maze = new int[rows][cols];
    }

    public Maze(byte[] savedMazeBytes) throws Exception {
        rows=0;
        cols=0;
        int start_row = 0;
        int start_col = 0;
        int goal_row = 0;
        int goal_col = 0;

        int i;
        for(i=0; i<24;i++){
            if(i<4){
                rows+= savedMazeBytes[i]<0?savedMazeBytes[i]+256:savedMazeBytes[i];
            }
            else if(i<8){
                cols+=savedMazeBytes[i]<0?savedMazeBytes[i]+256:savedMazeBytes[i];
            }
            else if(i<12){
                start_row+=savedMazeBytes[i]<0?savedMazeBytes[i]+256:savedMazeBytes[i];
            }
            else if(i<16){
                start_col+=savedMazeBytes[i]<0?savedMazeBytes[i]+256:savedMazeBytes[i];
            }
            else if(i<20){
                goal_row+=savedMazeBytes[i]<0?savedMazeBytes[i]+256:savedMazeBytes[i];
            }
            else if (i<24){
                goal_col+=savedMazeBytes[i]<0?savedMazeBytes[i]+256:savedMazeBytes[i];
            }
        }
        i=24;
        maze = new int[rows][cols];
        startPosition = new Position(start_row,start_col);
        goalPosition = new Position(goal_row,goal_col);
        for(int j=0;j<rows;j++){
            for (int k = 0; k < cols; k++) {
                maze[j][k] = savedMazeBytes[i++];
            }
        }
    }

    /**
     *
     * @return the startPosition of the maze
     */
    public Position getStartPosition() {
        return startPosition;
    }
    /**
     *
     * @return the goalPosition of the maze
     */
    public Position getGoalPosition() {
        return goalPosition;
    }

    /**
     *
     * @return number of rows of the maze
     */
    public int getRows() {
        return rows;
    }

    /**
     *
     * @return number of columns of the maze
     */
    public int getCols() {
        return cols;
    }

    /**
     *
     * @return the maze in a int[][] format
     */
    public int[][] getMaze() {
        return maze;
    }

    @Override
    public String toString() {
        String ret = "";
        for (int i = 0; i<rows; i++){
            ret = ret + "{ ";
            for (int j=0; j<cols; j++) {
                if (startPosition.toString().equals("{"+i + "," + j+"}")){
                    ret = ret + "S" + " ";
                } else if (goalPosition.toString().equals("{"+i + "," + j+"}")) {
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

    public byte[] toByteArray() {
        byte[] mazeByteArray = new byte[24+rows*cols];
        int i = 0;

        int r = rows;
        int c = cols;
        int start_row = startPosition.getRowIndex();
        int start_col = startPosition.getColumnIndex();
        int end_row = goalPosition.getRowIndex();
        int end_col = goalPosition.getColumnIndex();

        // insert maze data
        while (i<4){
            mazeByteArray[i] = (byte) Math.min(255,r);
            mazeByteArray[i+4] = (byte) Math.min(255,c);
            mazeByteArray[i+8] = (byte) Math.min(255,start_row);
            mazeByteArray[i+12] = (byte) Math.min(255,start_col);
            mazeByteArray[i+16] = (byte) Math.min(255,end_row);
            mazeByteArray[i+20] = (byte) Math.min(255,end_col);
            r = r - Math.min(255,r);
            c = c - Math.min(255,c);
            start_row = start_row - Math.min(255,start_row);
            start_col = start_col - Math.min(255,start_col);
            end_row = end_row - Math.min(255,end_row);
            end_col = end_col - Math.min(255,end_col);
            i++;
        }

        // insert maze map
        int k=24; // current index in mazeByteArray.
        for(i=0;i<rows;i++){
            for(int j=0;j<cols; j++){
                mazeByteArray[k++] = (byte) maze[i][j];
            }
        }

        return mazeByteArray;
    }
}
