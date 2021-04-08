package algorithms.mazeGenerators;

public class Maze {

    private int rows;
    private int cols;
    private Position startPosition;
    private Position goalPosition;
    protected int[][] maze;



    public Maze(int rows, int cols, Position startPosition, Position goalPosition) {
//        if(rows < 2 || cols < 2 || startPosition == null || goalPosition == null){
//            throw new Exception("row and cols must be positive ints greater than 2, Positions must not be null");
//        }
        this.rows = rows;
        this.cols = cols;
        this.startPosition = startPosition;
        this.goalPosition = goalPosition;
        maze = new int[rows][cols];
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public Position getGoalPosition() {
        return goalPosition;
    }

    public int getRows() {
        return rows;
    }


    public int getCols() {
        return cols;
    }

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
}
