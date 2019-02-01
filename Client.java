import java.net.*;
import java.io.*;

public class Client{

	private Client(String ip,int port){
		Socket socket;
		DataInputStream input;
		DataOutputStream output;

		try{
			socket = new Socket(ip,port);
			System.out.println("Client created.");

			input = new DataInputStream(System.in);
			output = new DataOutputStream(socket.getOutputStream());

			String line = "";
			try{
				while(!line.equals("Over"))
				{
					line = input.readLine();
					output.writeUTF(line);
				}
			}catch (Exception e1) {
				e1.printStackTrace();
			}

				socket.close();
				input.close();
				output.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public static void main(String args[]){
		new Client("127.0.0.1",5022);
	}
}