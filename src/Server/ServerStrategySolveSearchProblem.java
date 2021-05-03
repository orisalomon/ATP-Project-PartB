package Server;

import IO.MyCompressorOutputStream;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.search.BreadthFirstSearch;
import algorithms.search.SearchableMaze;
import algorithms.search.Solution;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class ServerStrategySolveSearchProblem implements IServerStrategy{

    static AtomicInteger numOfMaze = new AtomicInteger(0);

    @Override
    public void applyStrategy(InputStream inFromClient, OutputStream outToClient) throws IOException {
        ObjectInputStream fromClient = new ObjectInputStream(inFromClient);
        ObjectOutputStream toClient = new ObjectOutputStream(outToClient);

        String tempDirectoryPath = System.getProperty("java.io.tmpdir"); // out to save

        boolean foundSol = false;
        try {
            Maze fromClientMaze = (Maze)fromClient.readObject();
            if(fromClientMaze==null){throw new Exception("Input must not be null");}

            for (int i=0;i<numOfMaze.get();i++){
                ObjectInputStream fromSavedMazes = new ObjectInputStream(new FileInputStream(tempDirectoryPath+"\\maze"+i+".maze"));
                Maze savedMaze = (Maze) fromSavedMazes.readObject();
                if(Arrays.equals(savedMaze.toByteArray(), fromClientMaze.toByteArray())){
                    // if found maze in files, return its solution to the client without solving again.
                    ObjectInputStream savedSol = new ObjectInputStream(new FileInputStream(tempDirectoryPath+"\\sol"+i+".solution"));
                    Solution sol = (Solution) savedSol.readObject();
                    toClient.writeObject(sol);
                    toClient.flush();
                    foundSol = true;
                }
            }
            if(foundSol){return;} // if found solution, we finished.

            ObjectOutputStream toSaveMaze = new ObjectOutputStream(new FileOutputStream(tempDirectoryPath+"\\maze"+numOfMaze+".maze"));
            ObjectOutputStream toSaveSolution = new ObjectOutputStream(new FileOutputStream(tempDirectoryPath+"\\sol"+numOfMaze+".solution"));
            toSaveMaze.writeObject(fromClientMaze); // write maze in new file

            BreadthFirstSearch bfs = new BreadthFirstSearch();
            SearchableMaze searchableMaze = new SearchableMaze(fromClientMaze);

            Solution solution = bfs.solve(searchableMaze);
            toSaveSolution.writeObject(solution); // write solution in new file

            toSaveMaze.writeObject(fromClientMaze);
            toSaveMaze.flush();
            toSaveSolution.writeObject(solution);
            toSaveSolution.flush();

            numOfMaze.getAndIncrement(); // increment num of total mazes.

            toClient.writeObject(solution);
            toClient.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}