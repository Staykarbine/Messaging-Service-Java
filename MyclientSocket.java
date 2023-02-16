package finalproject;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;



public class MyclientSocket {

public MyclientSocket() {

}

public static void main(String args[]) throws UnknownHostException, IOException {
Socket socket = new Socket("localhost", 6000);
DataInputStream inStream = new DataInputStream(socket.getInputStream());
DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
BufferedReader inputFromUser = new BufferedReader(new InputStreamReader(System.in));

  

while (true) {
String msg = inputFromUser.readLine();
if(msg!=null && !msg.isEmpty()) {

outStream.writeUTF(msg);

outStream.flush();

}

//If msg is end means client is ending the session then need to exit

if(msg.equalsIgnoreCase("end")) {

break;

}

  

//Reading response from server

String response = inStream.readUTF();

if(!response.isEmpty()) {

//printing the response to the console

System.out.println("Server:"+ response);

}

}

//closing the socket at the end.

socket.close();

}

}