package BC_1;
import BC_1.*;
import BC_1.Friends.chatboxopen;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.util.Iterator;


class ChatView extends Frame
{
	TextArea ta = new TextArea();
	TextField tf = new TextField();
	Button btn = new Button("Send");
	Button friendadd = new Button("Friend invite");
	
	
	public ChatView()
	{	
		setBounds(0,0,270,390);
		setLayout(null);
		addWindowListener(new WClose_c());
		
		ta.setBounds(10,30,250,300);
		tf.setBounds(10,330,200,50);
		btn.setBounds(210,330,50,50);		
		ta.setEditable(false);
		
		add(ta);
		add(tf);
		add(btn);
		
		setVisible(true);
	}
}

class Sender2 extends Thread implements ActionListener
{
	Socket socket;
	DataOutputStream dos;
	String name;
	ChatView cv;
	
	Sender2(Socket socket, ChatView cv, String name)
	{
		this.socket = socket;
		this.name = name;
		this.cv=cv;
		
		try {
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void run()
	{
		cv.tf.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		try{
		if(!cv.tf.getText().equals(""))
		{
			String msg = name+" : "+cv.tf.getText();
			dos.writeUTF(msg);
			cv.tf.setText("");
			cv.tf.setFocusable(true);
		}
		}
		catch(IOException e1)
		{
			
		}	
	}
}

class Reciever2 extends Thread
{
	Socket socket;
	DataInputStream dis;
	ChatView cv;
	String name;
	
	public Reciever2(Socket socket, ChatView cv)
	{
	this.socket = socket;
	this.cv = cv;
	this.name=name;
	
		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void run()
	{
		while(dis!=null)
		{
			try {
				cv.ta.append("\n"+dis.readUTF()+"\n");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
}



public class ChatboxClient {

	String id;
	ChatboxClient(String id)
	{		
		this.id=id;
		
		try{	
			ChatView cv = new ChatView();
			Socket client = new Socket("121.160.70.22",7777);
			cv.ta.setText("Server Connection Successful");
		
			Sender2 ss = new Sender2(client, cv, id);
			Reciever2 rr = new Reciever2(client,cv);
			
			ss.start();
			rr.start();
			
		}
		catch(IOException e)
		{
			
		}				
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	new ChatboxClient("Durai");
	}
}

