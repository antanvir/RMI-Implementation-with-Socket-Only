

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


// Organize imports     

public class Client {

    public static void main(String[] args) throws UnknownHostException,
            IOException, ClassNotFoundException {
        System.out.println("== Welcome to Client Side =="); 

        Socket socket = new Socket("localhost", 4444);
        System.out.println("Client connected");

        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());

        // Message message = new Message(new Integer(15), new Integer(32));

        os.writeObject(new Adder(5, 18));
//        os.writeObject(new Adder().add(5, 16));

        System.out.println("Message sent to server");

        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        
        Adder returnMessage = (Adder) is.readObject();
        System.out.println("Return Message From SERVER is = " + returnMessage.getResult());

        socket.close();
    }
}