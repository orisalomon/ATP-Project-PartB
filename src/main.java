import algorithms.mazeGenerators.*;

public class main {
    public static void main(String[] args) {
        Maze m = new MyMazeGenerator().generate(20,20);
        System.out.println(m);
    }
}
