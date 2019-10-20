

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Server {
    public static final int port = 4444;
    private ServerSocket ss = null;
    private int result;

    public void  runServer() throws IOException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        ss = new ServerSocket(port);
        System.out.println("Server is waiting...");
        Socket socket = ss.accept();
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());

        Adder m = (Adder) is.readObject();
//        doSomething(m);
        doTheTask(m);

        os.writeObject(m);
        socket.close(); 
    }

    private void doTheTask(Adder m) {
    	result = m.add(m.getA(), m.getB());
    	System.out.println(result);
    	    	
    }
    
    // Not Needed Here, But Works too!
    private void doSomething(Adder m) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	

    	Method[] methods = m.getClass().getMethods();
    	for(int i =0; i< methods.length; i++) {
    		  
    		System.out.println(i + " : " + methods[i].getName());
    	}
    	
    	methods[1].invoke(m);
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        new Server().runServer();
    }
}