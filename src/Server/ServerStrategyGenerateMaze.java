package Server;

import IO.MyCompressorOutputStream;
import algorithms.mazeGenerators.*;

import java.io.*;

public class ServerStrategyGenerateMaze implements IServerStrategy{
    @Override
    public void applyStrategy(InputStream inFromClient, OutputStream outToClient) throws IOException {
        ObjectInputStream fromClient = new ObjectInputStream(inFromClient);
        ObjectOutputStream toClient = new ObjectOutputStream(outToClient);
        try {
            int[] fromClientArray = (int[]) fromClient.readObject();
            if(fromClientArray.length != 2){throw new Exception("Array length must be 2.");}
            Configurations conf = Configurations.getInstance();
            String genAlgorithm = conf.getGenAlgorithm();
            Maze maze = null;
            switch (genAlgorithm) {
                case "Empty" -> maze = new EmptyMazeGenerator().generate(fromClientArray[0], fromClientArray[1]);
                case "Simple" -> maze = new SimpleMazeGenerator().generate(fromClientArray[0], fromClientArray[1]);
                case "My" -> maze = new MyMazeGenerator().generate(fromClientArray[0], fromClientArray[1]);
            }
            MyCompressorOutputStream compressor = new MyCompressorOutputStream(new ByteArrayOutputStream());
            assert maze != null; // maze must have algorithm.
            compressor.write(maze.toByteArray());
            compressor.flush();
            toClient.writeObject(((ByteArrayOutputStream)compressor.getOut()).toByteArray());
            toClient.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
