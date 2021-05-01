package Server;


import Server.IServerStrategy;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {

    private IServerStrategy strategy;
    private int port;
    private int listeningIntervalMS;
    private volatile boolean stop;  // volatile- do not put the variable in the cache. java will not do optimization on this variable.
    private ExecutorService threadPool;

    public Server(int port, int listeningIntervalMS,IServerStrategy strategy) {
        this.strategy = strategy;
        this.port = port;
        this.listeningIntervalMS = listeningIntervalMS;
        this.threadPool = Executors.newFixedThreadPool(2 /* reading from config */); // only 2 threads working parallel. TODO: change the threads num from config file

    }

    public void start() {
        new Thread(() -> {runServer();}).start();

    }
    public void runServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(listeningIntervalMS);
            while (!stop) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    threadPool.submit(()-> handleClient(clientSocket)); // TODO: change handleClient name??
                }
                catch (SocketTimeoutException e) { // TODO: need to print e.printStackTrace()?
                    System.out.println("Socket Timeout");
                }

            }
            threadPool.shutdownNow(); // TODO: need to shut down now immediately or just shut down without interrupts??
        }
        catch (IOException e) {e.printStackTrace();}

    }

    private void handleClient(Socket clientSocket) {
        try {
            strategy.applyStrategy(clientSocket.getInputStream(), clientSocket.getOutputStream());
            clientSocket.close(); // TODO: check if close client socket is needed.
        }
        catch (IOException e) {e.printStackTrace();}
    }

    public void stop(){
        stop = true;
    }

}

