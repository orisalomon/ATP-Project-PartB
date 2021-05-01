package Client;

import Client.IClientStrategy;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    IClientStrategy strategy;
    InetAddress serverIP;
    int serverPort;


    public Client(InetAddress serverIP, int serverPort,IClientStrategy strategy) {
        this.strategy = strategy;
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    public void communicateWithServer(){
        try(Socket serverSocket = new Socket(serverIP,serverPort)) {
            strategy.clientStrategy(serverSocket.getInputStream(),serverSocket.getOutputStream());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
