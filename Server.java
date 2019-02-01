import java.io.*;
import java.net.*;

public class Server{

	private Server(int port){
			Socket socket;
			ServerSocket server;
			DataInputStream input;

		try{
			server = new ServerSocket(port);
			System.out.println("Server is crerated.");

			System.out.println("Waitting for client.");
			socket = server.accept();

			String line = null;

			input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			line = input.readUTF();

			System.out.println("Client : " + line);

				try{
					socket.close();
					input.close();
				}catch(Exception e){
					e.printStackTrace();
				}

		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public static void main(String args[]){
		new Server(5001);
	}
}