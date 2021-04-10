package algorithms.maze3D;

public class Maze3D {


    private int depth;
    private int row;
    private int col;
    private Position3D startPosition;
    private Position3D goalPosition;
    protected int[][][] maze;


    /**
     * -- Constructor --
     * @param depth - int - depth size of maze
     * @param row - int - rows number of maze
     * @param col - int - columns number of maze
     * @param startPosition - Position3D - the start position of the maze
     * @param goalPosition - Position3D - the goal position of the maze
     */
    public Maze3D(int depth, int row, int col, Position3D startPosition, Position3D goalPosition) {
        //        if(depth < 2 || rows < 2 || cols < 2 || startPosition==null || goalPosition == null){
//            throw new Exception("depth, row and cols must be positive ints greater than 2, Position must not be null");
//        }
        this.row = row;
        this.col = col;
        this.depth = depth;
        this.startPosition = startPosition;
        this.goalPosition = goalPosition;
        maze = new int[depth][row][col];
    }

    /**
     *
     * @return the startPosition of the maze
     */
    public Position3D getStartPosition() {
        return startPosition;
    }
    /**
     *
     * @return the goalPosition of the maze
     */
    public Position3D getGoalPosition() {
        return goalPosition;
    }

    /**
     *
     * @return number of rows of the maze
     */
    public int getRows() {
        return row;
    }
    /**
     *
     * @return number of columns of the maze
     */
    public int getCols() {
        return col;
    }
    /**
     *
     * @return depth of the maze
     */
    public int getDepth() {
        return depth;
    }

    /**
     *
     * @return the maze in a int[][][] format
     */
    public int[][][] getMap(){return maze;}

    /**
     * prints the maze
     */
    public void print() {
        System.out.println("{");
        for(int depth = 0; depth< maze.length; depth++){
            for (int row=0; row<maze[0].length; row++) {
                System.out.print("{ ");
                for (int col = 0; col < maze[0][0].length; col++) {
                    if (depth == startPosition.getDepthIndex() && row == startPosition.getRowIndex() && col == startPosition.getColumnIndex()) {
                        System.out.print("S ");
                    }
                    else {
                        if (depth == goalPosition.getDepthIndex() && row == goalPosition.getRowIndex() && col == goalPosition.getColumnIndex()) {
                            System.out.print("E ");
                        }
                        else {
                            System.out.print(maze[depth][row][col] + " ");
                        }
                    }
                }
                System.out.println("}");
            }
            if(depth<maze.length-1){
                System.out.print("---");
                for (int i = 0; i<maze[0][0].length;i++){
                    System.out.print("--");
                }
                System.out.println();
            }

        }
        System.out.println("}");
    }

}
