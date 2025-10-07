package com.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	Socket s;
	BufferedReader in, keyin;
	PrintWriter out;

	public Client() {
		try {
			while (true) {
				s = new Socket("localhost", 2000);
				keyin = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Write a message for server : ");
				String msgToServer = keyin.readLine();
				
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String msgFromServer = in.readLine();
				System.out.println("Message from server : " + msgFromServer);
				
				out = new PrintWriter(s.getOutputStream(), true);
				out.println(msgToServer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Client();
	}
}
