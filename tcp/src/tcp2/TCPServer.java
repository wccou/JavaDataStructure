package tcp2;

import java.io.*;
import java.net.*;

class TCPServer {
	public static void main(String argv[]) throws Exception {
		String ClientSentence;
		ServerSocket welcomeSocket = new ServerSocket(6789);
		while (true) {
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader infromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			ClientSentence = infromClient.readLine();
			try {
				RandomAccessFile in = new RandomAccessFile(ClientSentence, "r");
				String s;
				String total = "";
				while ((s = in.readLine()) != null)
					total = total + s;
				outToClient.writeBytes(total + '\n');
				in.close();
			} catch (Exception e) {
				outToClient.writeBytes("文件不存在！");
			}
			welcomeSocket.close();
		}
		
	}
}
