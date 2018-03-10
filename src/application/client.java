package application;

import java.net.*;
import java.io.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class client extends Application{
	
	public void start(Stage stage) {
		try{
			Socket s=new Socket("localhost",1201);
			DataInputStream  din=new DataInputStream(s.getInputStream());
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String msgin="",msgout="";
			while(!msgin.equals("end")){
				//System.out.print("Enter Something Client:");
				msgout=br.readLine();
				dout.writeUTF("\nserver:\t"+msgout);
				msgin=din.readUTF();
				System.out.println(msgin);
			}
		}catch(Exception e){
			
		}
	}
	public static void main(String[] args){
		launch(args);
	}

}
