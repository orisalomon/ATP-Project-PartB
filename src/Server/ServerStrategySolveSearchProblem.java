package Server;

import IO.MyCompressorOutputStream;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.search.BreadthFirstSearch;
import algorithms.search.SearchableMaze;
import algorithms.search.Solution;

import java.io.*;

public class ServerStrategySolveSearchProblem implements IServerStrategy{
    @Override
    public void applyStrategy(InputStream inFromClient, OutputStream outToClient) throws IOException {
        ObjectInputStream fromClient = new ObjectInputStream(inFromClient);
        ObjectOutputStream toClient = new ObjectOutputStream(outToClient);
        try {
            Maze fromClientMaze = (Maze) fromClient.readObject();
            if(fromClientMaze==null){throw new Exception("Input must not be null");}

            BreadthFirstSearch bfs = new BreadthFirstSearch();
            SearchableMaze searchableMaze = new SearchableMaze(fromClientMaze);

            Solution solution = bfs.solve(searchableMaze);

            toClient.writeObject(solution);
            toClient.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}