package BC_1;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class MultiChatReviseClient {

	static Label text = new Label("test"); 
	
	static class clientsend extends Thread
	{
		Socket socket;
		DataOutputStream out;
		String name;
		
		public clientsend(Socket socket, String name)
		{
			this.socket = socket;
			this.name=name;
			try{
			out = new DataOutputStream(socket.getOutputStream());
			}
			catch(IOException e)
			{
				
			}
			
		}
		
	public void run()
	{
		Scanner sc = new Scanner(System.in);
		
	
			try {
				if(out!=null)
				{
					out.writeUTF(name);
				}
				
				while(out!=null)
				{
					out.writeUTF(name+sc.nextLine());
				}	
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	}
		
		
		
	}
		
	
	static class clientreceive extends Thread
	{
		Socket socket;
		DataInputStream in;
		
		public clientreceive(Socket socket)
		{
			this.socket=socket;
			
			try {
				in=new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		public void run()
		{
			try {
				System.out.println(in.readUTF());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
			
	MultiChatReviseClient()
	{
		view tt = new view();
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Insert your name : ");
		
		text.setText("SoSOSOSO");

		
		String name = sc.nextLine();
		
		text.setText(name);
		
		String ip = "192.168.219.5";
		
		
		try {
			Socket socket = new Socket(ip,7777);
			System.out.println("Server has been connected");
			
			clientsend ss = new clientsend(socket, name);
			clientreceive rr = new clientreceive(socket);
			ss.start();
			rr.start();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MultiChatReviseClient();

	}

}

class view extends Frame
{
	view()
	{
		setBounds(0,0,500,500);
		setBackground(Color.cyan);
		setLayout(new FlowLayout());
		
		add(MultiChatReviseClient.text);
		setVisible(true);
	}
}
