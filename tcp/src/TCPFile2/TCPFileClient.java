package TCPFile2;

import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

public class TCPFileClient{
	public static void main(String argv[]) throws Exception
	{
		while(true){
			String sentence;
			String ServerSentence;
			String tmp;
			int ObjectNum;
			BufferedReader inFromUser = new BufferedReader(
					new InputStreamReader(System.in));
			Socket clientSocket = new Socket("localhost",6789);//hostname is server domainame
			DataOutputStream outToServer =
					new DataOutputStream(clientSocket.getOutputStream());
			BufferedReader inFromServer = new BufferedReader(
					new InputStreamReader(clientSocket.getInputStream()));
			System.out.println("知道确切路径吗? (y/n)");
			sentence = inFromUser.readLine();
			if (sentence.equals("n")){
				System.out.println("请输入路径(以 \\结尾):");
				sentence = inFromUser.readLine();
				outToServer.writeBytes(sentence + '\n');
				ServerSentence = inFromServer.readLine();
				System.out.println("From Server: " + ServerSentence);
				StringTokenizer tokenizedLine = 
						new StringTokenizer(ServerSentence);
				tmp = tokenizedLine.nextToken();
				ObjectNum = Integer.parseInt(tmp); 
				System.out.println("ObjectNum: " + ObjectNum);
				for (int i = 0; i < ObjectNum; i++) {
					ServerSentence = inFromServer.readLine();
					System.out.println("From Server:" + ServerSentence);
				}
			}
			else if(sentence.equals("y")){
				System.out.println("请输入确切路径和文件名:");
				
				sentence = inFromUser.readLine();
				outToServer.writeBytes(sentence + '\n');
				ServerSentence = inFromServer.readLine();
				System.out.println("From Server:" + ServerSentence);
			
			}
			else
				System.out.println("Bad Message.");
			clientSocket.close();
			Thread.sleep(500);
		}
	}
}

