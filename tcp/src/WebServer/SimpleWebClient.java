package WebServer;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SimpleWebClient {
	public static void main(String argv[]) throws Exception
	{
		while(true){
			String sentence;
			String ServerSentence;
			BufferedReader inFromUser = new BufferedReader(
					new InputStreamReader(System.in));
			Socket clientSocket = new Socket("localhost",6789);//hostname is server domainame
			DataOutputStream outToServer =
					new DataOutputStream(clientSocket.getOutputStream());
			BufferedReader inFromServer = new BufferedReader(
					new InputStreamReader(clientSocket.getInputStream()));
			System.out.println("Please Enter File Name:");
			
			sentence = inFromUser.readLine();
			outToServer.writeBytes(sentence + '\n');
			ServerSentence = inFromServer.readLine();
			System.out.println("From Server:" + ServerSentence);
			clientSocket.close();

			Thread.sleep(500);
		}
	}

}
