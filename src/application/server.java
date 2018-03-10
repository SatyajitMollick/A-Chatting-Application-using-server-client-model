package application;
import java.net.*;
import java.io.*; 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class server extends Application{
	
	public void start(Stage stage){
		try{
			ServerSocket ss=new ServerSocket(1201);
			Socket s=ss.accept();
			DataInputStream din=new DataInputStream(s.getInputStream());
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String msgin="",msgout="";
			while(!msgin.equals("end")){
				msgin=din.readUTF();
				System.out.println("\nclient:\t"+msgin);
				msgout=br.readLine();
				dout.writeUTF(msgout);
				dout.flush();
			}
			s.close();
		}catch(Exception e){
		}
	}
	public static void main(String[] args) {
		launch(args);
	}

}
