package test;
import IO.SimpleCompressorOutputStream;
import IO.SimpleDecompressorInputStream;
import algorithms.mazeGenerators.AMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;

import java.io.*;
import java.util.Arrays;

public class SimpleCompressorTest {
    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\Ori\\Desktop\\test.txt";
        AMazeGenerator mazeGenerator = new MyMazeGenerator();
        Maze maze = mazeGenerator.generate(127, 127); //Generate new maze
//        maze.print();

        try {
// save maze to a file
            OutputStream out = new SimpleCompressorOutputStream(new FileOutputStream(path));
            out.write(maze.toByteArray());
            out.flush();
            out.close();
        } catch (IOException e) { e.printStackTrace();}
        byte[] savedMazeBytes = new byte[0];
        try {
            InputStream in = new SimpleDecompressorInputStream(new FileInputStream(path));
            savedMazeBytes = new byte[maze.toByteArray().length];
            in.read(savedMazeBytes);
            in.close();
        }
        catch (IOException e) { e.printStackTrace();}
        Maze loadedMaze = new Maze(savedMazeBytes);
        boolean areMazesEquals = Arrays.equals(loadedMaze.toByteArray(),maze.toByteArray());
//        System.out.println();
//        System.out.println("----------");
//        loadedMaze.print();
//        System.out.println("----------");
//        for (byte b: loadedMaze.toByteArray()
//             ) {
//            System.out.print(b);
//        }
//        System.out.println();
//        System.out.println();
//        for (byte b: maze.toByteArray()
//        ) {
//            System.out.print(b);
//        }
//        System.out.println();
//        System.out.println();
        System.out.println(String.format("Mazes equal: %s",areMazesEquals));
    //maze should be equal to loadedMaze
    }
}


