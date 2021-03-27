import algorithms.mazeGenerators.*;

public class main {
    public static void main(String[] args) {
        Maze m = new MyMazeGenerator().generate(14,15);
        System.out.println(m);
    }
}
