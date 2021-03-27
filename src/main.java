import algorithms.mazeGenerators.*;

public class main {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        Maze newMaze = new MyMazeGenerator().generate(1000,1000);
        long end = System.currentTimeMillis();



    }
}
