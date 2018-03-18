package TCPFile;

import java.io.*;
import java.net.*;

public class TCPFileServer{
	public static void main(String argv[]) throws Exception
	{
		String ClientFilePath;
		String information;
		ServerSocket welcomeSocket = new ServerSocket(6789);
		while(true){
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader infromClient = new BufferedReader(
					new InputStreamReader(connectionSocket. getInputStream()));
			DataOutputStream outToClient =
					new DataOutputStream(connectionSocket.getOutputStream());
			ClientFilePath = infromClient.readLine();
			System.out.println("FilePath receied from client: "+ ClientFilePath);
			try{
				RandomAccessFile in=new RandomAccessFile(ClientFilePath,"r");
				String s;
				String total=" ";
				while((s=in.readLine())!=null){
					total=total+s;
				}
				System.out.println("File send to client..." + '\n');
				outToClient.writeBytes(total + '\n');
				in.close();
			}
			catch(FileNotFoundException e){
				information = "The file doesn't exist!";
				System.out.println("The file doesn't exist!" + '\n');
				outToClient.writeBytes(information + '\n');
			}
		}
	}
}
