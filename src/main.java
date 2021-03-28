import algorithms.mazeGenerators.*;

public class main {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        Maze newMaze = new MyMazeGenerator().generate(6,5);
        long end = System.currentTimeMillis();

        System.out.println(newMaze);
        System.out.println(end-start);


    }
}
