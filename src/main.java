import algorithms.mazeGenerators.*;

public class main {
    public static void main(String[] args) {
        Maze m = new EmptyMazeGenerator().generate(3,4);
        System.out.println(m);
    }
}
