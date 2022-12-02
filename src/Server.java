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
				
				Handle setDaNang = new Handle(); 
				
				do {
					String inputThoiTietView = input.readUTF();
					//Set MainRight
					if (inputThoiTietView.equalsIgnoreCase("setMain") ) {
						System.out.println("setMain");
						City citySetMain = null;
						for (int i=0; i<8; i++) {
							citySetMain = hd.getCityWeather(i);
						}
						output.writeObject((Object)citySetMain);
						output.flush();
					
					//Set Main
					} else if (inputThoiTietView.equalsIgnoreCase("setMainRight") ) {
						System.out.println(inputThoiTietView);
						City city = hd.getDaNang();
						output.writeObject((Object)city);
						output.flush();
						
					//Set Search
					} else {
						City city = hd.Search(inputThoiTietView);
						output.writeObject((Object)city);
						output.flush();
					}

				} while (true);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}		
}
