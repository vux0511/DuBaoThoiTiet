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
			byte[] byte_read = new byte[9999];
			
			try {	
				ServerSocket serverSocket = new ServerSocket(6868);
				Socket socket = serverSocket.accept();
				
				DataInputStream input = new DataInputStream(socket.getInputStream());
				ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
				
				Handle setDaNang = new Handle(); 
				
				do {
					
					String inputThoiTietView = input.readUTF();
					
					//Set Main
					if (inputThoiTietView.equalsIgnoreCase("setMain") ) {
						System.out.println("setMain");
						ListCity cityArray = new ListCity();
						for (int i=0; i<8; i++) {
							City citySetMain = hd.getCityWeather(i);
							cityArray.addCityArray(citySetMain, i);
						}
						output.writeObject((Object)cityArray);
						output.flush();
					
					//Set MainRight
					} else if (inputThoiTietView.equalsIgnoreCase("setMainRight") ) {
						System.out.println(inputThoiTietView);
						City citySetMainRight = hd.getDaNang();
						output.writeObject((Object)citySetMainRight);
						output.flush();
						
					//Set Search
					} else {
						City citySearch = hd.Search(inputThoiTietView);
						output.writeObject((Object)citySearch);
						output.flush();
					}

				} while (true);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}		
}
