package algorithms.maze3D;

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
