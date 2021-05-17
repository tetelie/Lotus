package fr.elie.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSock {

    Socket socket;
    String host;
    int port;

    public ClientSock(String host, int port)
    {
        this.host = host;
        this.port = port;
    }

    public void sendRequestToServer(String request) throws IOException, ClassNotFoundException
    {
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        socket = new Socket(host, port);
        //write to socket using ObjectOutputStream
        oos = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Sending request to Socket Server");
        oos.writeObject(request);

        ois = new ObjectInputStream(socket.getInputStream());
        String message = (String) ois.readObject();
        System.out.println("Message: " + message);
        //close resources
        ois.close();
        oos.close();
        socket.close();
    }

}
