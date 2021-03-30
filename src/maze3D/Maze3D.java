package maze3D;

import algorithms.mazeGenerators.Position;

public class Maze3D {


    private int depth;
    private int row;
    private int col;
    private Position3D startPosition;
    private Position3D goalPosition;
    protected int[][][] maze;


    public Maze3D(int depth, int row, int col, Position3D startPosition, Position3D goalPosition) {
        this.row = row;
        this.col = col;
        this.depth = depth;
        this.startPosition = startPosition;
        this.goalPosition = goalPosition;
        maze = new int[depth][row][col];
    }


    public Position3D getStartPosition() {
        return startPosition;
    }

    public Position3D getGoalPosition() {
        return goalPosition;
    }


    public int getRows() {
        return row;
    }

    public int getCols() {
        return col;
    }

    public int getDepth() {
        return depth;
    }

    public int[][][] getMap(){return maze;}


    @Override
    public String toString() {
        String ret = "{\n";
        for (int i = 0; i<depth; i++){

            for (int j=0; j<row; j++) {
                ret = ret + "{ ";

                for (int k=0; k<col; k++){

                    if (startPosition.toString().equals(i + "," + j+","+k)) {
                        ret = ret + "S" + " ";
                    } else if (goalPosition.toString().equals(i + "," + j+","+k)) {
                        ret = ret + "E" + " ";
                    } else {
                        ret = ret + maze[i][j][k] + " ";

                    }
                }
                ret = ret + "}\n";
            }
            if(i!=depth-1) {ret = ret +"-".repeat(col*2+3)+ "\n";}

        }
        ret = ret + "}";
        return ret;
    }


    public void print() {
        System.out.println(toString());
    }
}
