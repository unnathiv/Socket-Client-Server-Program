import java.io.DataInputStream;
import java.net.*;
import java.io.*;
public class Server {

    private Socket socket = null;
    private DataInputStream in = null;
    private ServerSocket server = null;

    public Server(int port)  {
      try{
        server = new ServerSocket(port);

        System.out.println("Server Started");
        System.out.println("Waiting for a client");
        socket = server.accept();
        System.out.println("Client accepted");

        in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        String line = "";
        while(!line.equals("Over")){
            try{
                line = in.readUTF();
                System.out.println(line);
            }
            catch(IOException i){
                System.out.println(i);
            }
        }
      }
      catch(IOException i){
          System.out.println(i);
      }
    }

    public static void main(String args[]) throws IOException {

        Server server = new Server(8080);
    }


}
