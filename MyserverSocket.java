package finalproject;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyserverSocket {
public MyserverSocket() {

}

public static void main(String args[]) throws IOException {
ServerSocket serverSocket = new ServerSocket(6000);
Socket socket = serverSocket.accept();

try {

DataInputStream inStream = new DataInputStream(socket.getInputStream());
DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
BufferedReader inputFromUser = new BufferedReader(new InputStreamReader(System.in));

while (true) {
String inputMsg = inStream.readUTF();

if (!inputMsg.isEmpty()) {
System.out.println("Client:" + inputMsg);
}

if (inputMsg.equalsIgnoreCase("end")) {
System.out.println("The session has ended");
break;

}


String response = inputFromUser.readLine();

if (response != null && !response.isEmpty()) {
	
outStream.writeUTF(response);
outStream.flush();

}

}

} catch (IOException e) {

e.printStackTrace();

} finally {

try {

serverSocket.close();

socket.close();

} catch (IOException e) {

e.printStackTrace();

}

}

}

}