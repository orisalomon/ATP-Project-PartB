package test;

import Client.Client;
import Client.IClientStrategy;
import IO.MyDecompressorInputStream;
import Server.Server;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.search.AState;
import algorithms.search.Solution;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import Server.*;

public class RunCommunicateWithServers {
    public static void main(String[] args) throws Exception {
//Initializing servers
        //Server mazeGeneratingServer = new Server(5400, 1000, new ServerStrategyGenerateMaze());
        Server solveSearchProblemServer = new Server(5401, 1000, new ServerStrategySolveSearchProblem());

        //Starting servers
        solveSearchProblemServer.start();
        //mazeGeneratingServer.start();

        //Communicating with servers
        //CommunicateWithServer_MazeGenerating();

        Thread[] threads = new Thread[4];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()-> {
                try {
                    CommunicateWithServer_SolveSearchProblem();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }


        //Stopping all servers
        //mazeGeneratingServer.stop();
        solveSearchProblemServer.stop();
    }
    private static void CommunicateWithServer_MazeGenerating() {
        try {
            Client client = new Client(InetAddress.getLocalHost(), 5400, new IClientStrategy() {
                        @Override
                        public void clientStrategy(InputStream inFromServer, OutputStream outToServer) {
                            try {
                                ObjectOutputStream toServer = new ObjectOutputStream(outToServer);
                                ObjectInputStream fromServer = new ObjectInputStream(inFromServer);
                                toServer.flush();
                                int[] mazeDimensions = new int[]{50, 50};
                                toServer.writeObject(mazeDimensions); //send maze dimensions to server
                                toServer.flush();
                                byte[] compressedMaze = (byte[]) fromServer.readObject(); //read generated maze (compressed with MyCompressor) from server
                                InputStream is = new MyDecompressorInputStream(new ByteArrayInputStream(compressedMaze));
                                byte[] decompressedMaze = new byte[mazeDimensions[0]*mazeDimensions[1]+24 /*CHANGE SIZE ACCORDING TO YOU MAZE SIZE*/]; //allocating byte[] for the decompressed maze -
                                is.read(decompressedMaze); //Fill decompressedMaze with bytes
                                Maze maze = new Maze(decompressedMaze); maze.print();
                            } catch (Exception e) { e.printStackTrace();
                            }
                        }
                    });
            client.communicateWithServer();
        } catch (UnknownHostException e) { e.printStackTrace();
        }
    }
    private static void CommunicateWithServer_SolveSearchProblem() throws Exception {
        try {

            Client client = new Client(InetAddress.getLocalHost(), 5401, new
                    IClientStrategy() {

                        @Override
                        public void clientStrategy(InputStream inFromServer, OutputStream outToServer) {
                            try {
                                ObjectOutputStream toServer = new ObjectOutputStream(outToServer);

                                ObjectInputStream fromServer = new ObjectInputStream(inFromServer);

                                toServer.flush();

                                MyMazeGenerator mg = new MyMazeGenerator();
                                Maze maze = mg.generate(3, 3);
                                maze.print();
                                toServer.writeObject(maze); //send maze to server
                                toServer.flush();
                                Solution mazeSolution = (Solution) fromServer.readObject(); //read generated maze (compressed with MyCompressor) from server

                                System.out.println("SOLUTION--------------------------");
                                //Print Maze Solution retrieved from the server
                                System.out.println(String.format("Solution steps: %s", mazeSolution));
                                        ArrayList<AState> mazeSolutionSteps = mazeSolution.getSolutionPath();

                                for (int i = 0; i < mazeSolutionSteps.size(); i++) { System.out.println(String.format("%s. %s", i,
                                        mazeSolutionSteps.get(i).toString()));
                                }

                            } catch (Exception e) { e.printStackTrace();
                            }
                        }
                    });
            client.communicateWithServer();


        } catch (UnknownHostException e) { e.printStackTrace();
        }
    }
}