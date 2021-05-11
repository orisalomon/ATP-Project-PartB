package Server;


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
        Configurations conf = Configurations.getInstance();
        this.threadPool = Executors.newFixedThreadPool(conf.getThreadPoolSize() /* reading from config */);

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
                    threadPool.submit(()-> handleClient(clientSocket));
                }
                catch (SocketTimeoutException e) {
                    // do nothing - catch with LOG later
                }

            }
            threadPool.shutdown();
        }
        catch (IOException e) {e.printStackTrace();}

    }

    private void handleClient(Socket clientSocket) {
        try {
            strategy.ServerStrategy(clientSocket.getInputStream(), clientSocket.getOutputStream());
            clientSocket.close();
        }
        catch (IOException e) {e.printStackTrace();}
    }

    public void stop(){
        stop = true;
    }

}

