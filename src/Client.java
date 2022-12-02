//import java.io.ObjectInputStream;
//import java.io.OutputStream;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class Client {
//	try {
//		byte[] byte_read = new byte[9999];
//		Scanner sc = new Scanner(System.in);
//		Socket socket = new Socket("localhost", 6868);
//		System.out.println("Connected" + socket);
//		
//		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
//		OutputStream output = socket.getOutputStream();
//		
//		do {
//			System.out.print("Client : ");
//			String s = sc.nextLine();
//			output.write(s.getBytes());
//			output.flush();
//			
//			City city = (City) input.readObject();
//			System.out.println("Server say : " + city.getNameCity());
//			
//		} while (true);
//	} catch (Exception e) {
//		System.out.println(e.getMessage()); 
//	}
//}
