import java.io.*;
import java.net.*;

public class DNS_Server{

	String website_name[]={"www.google.com","www.youtube.com","www.facebook.com","www.twitter.com","www.amazone.com"};
	String ip[]={"10.12.13.14","10.125.133.142","10.120.137.184","10.128.134.164","10.126.135.145"};

	private DNS_Server(int port){
			Socket socket;
			ServerSocket server;
			DataInputStream input;
			DataOutputStream output;

		try{
			server = new ServerSocket(port);
			System.out.println("Server is crerated.");

			System.out.println("Waitting for client.");
			socket = server.accept();

			String line = "";
			input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			output = new DataOutputStream(socket.getOutputStream());

			line = input.readUTF();

			boolean lock = true;

			for(int i=0;i<website_name.length;i++){
				if(website_name[i].equals(line)){
					lock=false;
					output.writeUTF(ip[i]);
					break;
				}
			}

			if(lock){
				output.writeUTF("Not Found");
			}

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
		new DNS_Server(5022);
	}
}