import java.io.*;
import java.net.*;

public class FTPClient{

	Socket socket;

	public FTPClient(String ip,int port){
		try{

			byte[] b = new byte[2000];

			socket = new Socket(ip,port);
			FileOutputStream fi = new FileOutputStream("/home/dhruvik/NNNNNNNNNNNNNN.java");
			InputStream is = socket.getInputStream();
			is.read(b,0,1024);
			fi.write(b,0,1024);

		}catch(Exception e){


		}
	}

	public static void main(String args[]){
		new FTPClient("127.0.0.1",5001);

	}
}