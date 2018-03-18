package WebServer;

import java.io.*;
import java.net.*;
import java.util.*;

class SimpleWebServer {
	public static void main(String argv[]) throws Exception {
		String requestMessageLine;
		String filename;
		ServerSocket ListenSocket = new ServerSocket(6789);
		Socket connectionSocket = ListenSocket.accept();
		BufferedReader infromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
		requestMessageLine = infromClient.readLine();
		StringTokenizer tokenizedLine = new StringTokenizer(requestMessageLine);
		if (tokenizedLine.nextToken().equals("GET")) {
			filename = tokenizedLine.nextToken();
			if (filename.startsWith("/") == true)
				filename = filename.substring(1);
			File file = new File(filename);
			int numOfBytes = (int) file.length();
			FileInputStream inFile = new FileInputStream(filename);
			byte[] fileInBytes = new byte[numOfBytes];
			inFile.read(fileInBytes);
			outToClient.writeBytes("HTTP/1.0 200 Document Follows\r\n");
			if (filename.endsWith(".jpg"))
				outToClient.writeBytes("Content-Type:image/jpeg\r\n");
			if (filename.endsWith(".gif"))
				outToClient.writeBytes("Content-Type:image/gif\r\n");
			outToClient.writeBytes("Content-Length:”+numOfBytes+“\r\n");
			outToClient.writeBytes("\r\n");
			outToClient.write(fileInBytes, 0, numOfBytes);
			connectionSocket.close();
		} else
			System.out.println("Bad Request Message");
	}
}
