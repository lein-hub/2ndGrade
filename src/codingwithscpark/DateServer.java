package codingwithscpark;

import java.net.*;
import java.io.*;
import java.util.*;

public class DateServer {

	public static void main(String[] args) {
		Socket socket = null;
		try (ServerSocket serverSocket = new ServerSocket(9100)) {
			while (true) {
				try {
					System.out.println("클라이언트의 요청을 기다립니다...");
					// 클라이언트의 요청을 기다린다.
					socket = serverSocket.accept();
					System.out.println("클라이언트가 접속되었습니다... ["+socket.getRemoteSocketAddress()+"]");
					
					
					// 클라이언트와 요청이 성립되면 새로운 socket을 생성해
					// 그 클라이언트와 통신한다
					Thread thread = new NewSocket(socket);
					thread.start();
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					socket.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("클라이언트와의 연결을 종료합니다.");
		}
	}
}

class NewSocket extends Thread {
	Socket socket;
	
	public NewSocket(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			OutputStream ostream = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(ostream, true);
			writer.println(Calendar.getInstance().getTime());
			Thread.sleep(1000*10);
			socket.close();
			System.out.println("클라이언트와의 연결을 종료합니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (Exception ignore) {
				
			}
		}
	}
}