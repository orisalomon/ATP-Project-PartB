import maze3D.Maze3D;
import maze3D.MyMaze3DGenerator;

public class main3D {

    public static void main(String[] args) {

        Maze3D maze = new MyMaze3DGenerator().generate(5,5,5);
        maze.print();
    }
}
