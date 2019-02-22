import java.net.*;
import java.io.*;

/*

@author Dhruvik Navadiya


*/
public class Client{

	private Client(String ip,int port){
		Socket socket;
		DataInputStream input,input_server;
		DataOutputStream output;

		try{
			socket = new Socket(ip,port);
			System.out.println("Client created.");

			input = new DataInputStream(System.in);
			output = new DataOutputStream(socket.getOutputStream());

			input_server = new DataInputStream(socket.getInputStream());

			String line = "";
			try{
					line = input.readLine();
					output.writeUTF(line);
				
			}catch (Exception e1) {
				e1.printStackTrace();
			}

			System.out.println("Website : " + line + "\n" +"IP : "  + input_server.readUTF());

				socket.close();
				input.close();
				output.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public static void main(String args[]){
		new Client("127.0.0.1",5000);
	}
}