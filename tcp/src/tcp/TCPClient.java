package tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
public class TCPClient {
	public static void main(String argv[]) throws Exception
	  {
	     String sentence;
	     String modifiedSentence;
	     System.out.println("请输入任意字符串:");
	     BufferedReader infromUser =
	        new BufferedReader(
	              new InputStreamReader(System.in));
	     Socket clientSocket = new Socket("localhost",6789);
	     DataOutputStream outToServer =
	        new DataOutputStream(
	               clientSocket.getOutputStream());
	     BufferedReader infromServer =
	        new BufferedReader(new InputStreamReader(
	               clientSocket.getInputStream()));
	     sentence = infromUser.readLine();
	     outToServer.writeBytes(sentence + '\n');
	     modifiedSentence = infromServer.readLine();
	     System.out.println("服务器返回:"+
	                           modifiedSentence);
	     clientSocket.close();
	     
	   }
}
