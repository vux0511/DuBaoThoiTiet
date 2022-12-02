import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
	public static void main(String[] args) {
			
			Handle hd = new Handle();
			
//			Scanner sc = new Scanner(System.in);
			byte[] byte_read = new byte[9999];
			try {	
				ServerSocket serverSocket = new ServerSocket(6868);
				Socket socket = serverSocket.accept();
				System.out.println("Client accepted");
				
				DataInputStream input = new DataInputStream(socket.getInputStream());
				ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
				
				do {
					String a = input.readUTF();
					System.out.println("Client say : " +(a));
				
					City city = hd.Search(a);
					System.out.println(city.getNameCity());

					output.writeObject((Object)city);
					output.flush();
				} while (true);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}		
}
