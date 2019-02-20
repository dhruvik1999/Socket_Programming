import java.io.*;
import java.net.*;

public class FTPServer{

	ServerSocket server;
	Socket socket;


	public FTPServer(int port){
		try{

			server = new ServerSocket(port);
			socket = server.accept();

			byte[] data = new byte[1024];
			FileInputStream file = new FileInputStream("/home/dhruvik/Desktop/Attendance.java");
			file.read(data,0,1024);
			OutputStream os = socket.getOutputStream();
			os.write(data,0,1024);


		}catch(Exception e){
			System.out.println(e);
		}

	}


	public static void main(String args[]){

		new FTPServer(5001);
	}
}