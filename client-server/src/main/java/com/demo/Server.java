package com.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	ServerSocket ss;
	Socket s;
	BufferedReader in,keyin;
	PrintWriter out;
	
	public Server() {
		try {
			ss = new ServerSocket(2000);
			while(true) {
				System.out.println("Server Ready on : " + ss.getLocalPort());
				s = ss.accept();
				keyin = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Write a Message for the client : ");
				String msgToClient = keyin.readLine();
				
				out = new PrintWriter(s.getOutputStream(), true);
				out.println(msgToClient);
				
				in =  new BufferedReader(new InputStreamReader(s.getInputStream()));
				String msgFromClient = in.readLine();
				System.out.println("Message from client : " + msgFromClient);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Server();
	}
}
