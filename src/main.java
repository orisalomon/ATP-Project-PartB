import algorithms.mazeGenerators.*;

public class main {
    public static void main(String[] args) {
        Maze m = new SimpleMazeGenerator().generate(5,7);
        System.out.println(m);
    }
}
