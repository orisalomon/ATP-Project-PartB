package Server;

import IO.MyCompressorOutputStream;
import algorithms.mazeGenerators.EmptyMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.SimpleMazeGenerator;
import algorithms.search.*;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ServerStrategySolveSearchProblem implements IServerStrategy{
    static Semaphore mutex = new Semaphore(1);

    @Override
    public void ServerStrategy(InputStream inFromClient, OutputStream outToClient){
        try {
            ObjectInputStream fromClient = new ObjectInputStream(inFromClient);
            ObjectOutputStream toClient = new ObjectOutputStream(outToClient);


            String tempDirectoryPath = System.getProperty("java.io.tmpdir"); // out to save

            boolean foundSol = false;

            Maze fromClientMaze = (Maze)fromClient.readObject();
            if(fromClientMaze==null){throw new Exception("Input must not be null");}

            String[] pathNames; // Creates an array in which we will store the names of files and directories
            String mazeName = "maze-" + fromClientMaze.getRows() + "," + fromClientMaze.getCols();
            String solName = "sol-" + fromClientMaze.getRows() + "," + fromClientMaze.getCols();
            AtomicInteger fileIndex = new AtomicInteger(0);
            // Creates a new File instance by converting the given pathname string
            // into an abstract pathname

            mutex.acquire();  // enter the cs


            File f = new File(tempDirectoryPath);

            // Populates the array with names of files and directories
            pathNames = f.list();

            // For each pathname in the pathnames array
            for (String pathname : pathNames) {
                // Print the names of files and directories
                if(pathname.contains(mazeName)){
                    fileIndex = new AtomicInteger(Math.max(fileIndex.get(),new AtomicInteger(Integer.parseInt(pathname.substring(pathname.indexOf("(")+1,pathname.indexOf(")")))).get()));
                    ObjectInputStream fromSavedMazes = new ObjectInputStream(new FileInputStream(tempDirectoryPath+"\\"+pathname));
                    Maze savedMaze = (Maze) fromSavedMazes.readObject();
                    if(Arrays.equals(savedMaze.toByteArray(), fromClientMaze.toByteArray())){
                        // if found maze in files, return its solution to the client without solving again.
                        ObjectInputStream savedSol = new ObjectInputStream(new FileInputStream(tempDirectoryPath+"\\"+solName+"("+fileIndex+")"+".solution"));
                        Thread.sleep(100); // TODO: check why its work with sleep and not without
                        Solution sol = (Solution) savedSol.readObject();
                        toClient.writeObject(sol);
                        toClient.flush();
                        foundSol = true;
                        break;
                    }
                }
            }

            if(foundSol){
                mutex.release();  // if found, exit cs.
                return;} // if found solution, we finished.
            fileIndex.getAndIncrement();



            ObjectOutputStream toSaveMaze = new ObjectOutputStream(new FileOutputStream(tempDirectoryPath+"\\"+mazeName+"("+fileIndex+")"+".maze"));
            ObjectOutputStream toSaveSolution = new ObjectOutputStream(new FileOutputStream(tempDirectoryPath+"\\"+solName+"("+fileIndex+")"+".solution"));
            toSaveMaze.writeObject(fromClientMaze); // write maze in new file
            toSaveMaze.flush();

            mutex.release(); // exit the cs
            Configurations conf = Configurations.getInstance();
            String solver = conf.getSolverAlgorithm();
            ASearchingAlgorithm searcher = null;
            switch (solver) {
                case "BFS" -> searcher = new BreadthFirstSearch();
                case "DFS" -> searcher = new DepthFirstSearch();
                case "BEST" -> searcher = new BestFirstSearch();
            }
            SearchableMaze searchableMaze = new SearchableMaze(fromClientMaze);

            assert searcher != null; // searcher must not be null.
            Solution solution = searcher.solve(searchableMaze);
            toSaveSolution.writeObject(solution); // write solution in new file
            toSaveSolution.flush();

            toClient.writeObject(solution);
            toClient.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}