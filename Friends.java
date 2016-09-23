package BC_1;

import BC_1.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Friends extends Frame{

	static String buf;
	Friends(String buf)
	{
		//clientFriendrequest.FriendRequesting.clear();	
        //refreshthe friend request 

		try {
			new ReceiveImages();
		} catch (Exception e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		
		
		try {
			new clientFrinedrequestReceives();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		try {
				new clientSendOracle().clientSendOracles();
				//new RemovingDuplicates("bar_client");
				
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 
		addWindowListener(new Close_c());
		
		this.buf = buf;
		setBounds(900,0,500,755);
		setLayout(null);
		
		Panel newfriends = new Panel();
		
		
		Panel havefriends = new Panel();
	
		newfriends.setBounds(0,20,500,350);
		newfriends.setLayout(null);
		
		
		Label TopBanner = new Label("Search for your New Friends");
		TopBanner.setForeground(Color.white);
		TopBanner.setBackground(new Color(217,68,68));
		TopBanner.setBounds(0,0,500,60);

		Panel Body = new Panel();
		Body.setBounds(20,80,460,250);
		Body.setLayout(new GridLayout(4,0));
		
		
		
		JButton [] friendin = new JButton[10];
		String []tempid = new String[10];
		int i = 0;
	
		Iterator it = client1.clients.entrySet().iterator();	
		String [][] newclientsinfo = new String[10][6];		
		Panel[] boxy = new Panel[10];
		
		
		while(it.hasNext())
		{
			Map.Entry e = (Entry) it.next();
			client1input bufitem = (client1input) e.getValue();
			boxy[i] = new Panel();
			boxy[i].setLayout(null);

			
		if(!e.getKey().equals(buf))
		{
			ImageIcon bufimage = new ImageIcon("BC_1_image/"+e.getKey()+"_1.png"); //taking out the images
			Image img = bufimage.getImage();
			Image newimg = img.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);	
			bufimage = new ImageIcon(newimg);
			
			
			tempid[i] = (String) e.getKey();
			friendin[i]=new JButton(bufimage);
			
			friendin[i].addActionListener(new friendRequest(""+tempid[i], buf));
	
			friendin[i].setBounds(0,0,60,60);
			boxy[i].add(friendin[i]);
			
			
			Label Name = new Label(""+e.getKey());
			Name.setBounds(70,0,60,60);
			Name.setBackground(Color.LIGHT_GRAY);
			boxy[i].add(Name);
			
			
			Label Email = new Label((String) bufitem.email);
			Email.setBounds(140,0,60,60);
			Email.setBackground(Color.LIGHT_GRAY);
			boxy[i].add(Email);
			
			
			Label Job = new Label(bufitem.job);
			Job.setBounds(210,0,60,60);
			Job.setBackground(Color.LIGHT_GRAY);			
			boxy[i].add(Job);
	
			
			Label Juso = new Label(bufitem.juso);
			Juso.setBounds(280,0,60,60);
			Juso.setBackground(Color.LIGHT_GRAY);			
			boxy[i].add(Juso);
			
			
			Label Region = new Label(bufitem.region);
			Region.setBounds(350,0,120,60);
			Region.setBackground(Color.LIGHT_GRAY);
			boxy[i].add(Region);

			
			Body.add(boxy[i]);
			i++;
			
			if(i==4)
			{
				break;
			}
		}
	}	
		
		newfriends.add(TopBanner);
		newfriends.add(Body);
		
		
		havefriends.setBounds(0,370,500,300);
		havefriends.setBackground(Color.LIGHT_GRAY);
		havefriends.setLayout(null);

		Button FriendChecker = new Button("Check your Friends");
		FriendChecker.setBounds(0,670,500,80);
		FriendChecker.addActionListener(new realCheck(buf));
		

	
		Iterator it2 = clientFriendrequestDemo.FriendRequestingDemo.entrySet().iterator();
	
		
		int f = 0;		
		JButton [] friendname = new JButton[10];
		
		
		while(it2.hasNext())
		{
			Map.Entry ee = (Entry) it2.next();
		
			if(ee.getValue().equals(buf))
			{
			ImageIcon bufferPhoto = new ImageIcon("BC_1_image/"+ee.getKey()+"_1.png");
			System.out.println(ee.getKey()+" from the photo input");
			
			friendname[f] = new JButton(bufferPhoto);
			friendname[f].setBounds(0+110*f,0,100,100);	
			havefriends.add(friendname[f]);		
			
			f++;
			}
		}
		
		
	
		add(FriendChecker);
		add(havefriends);
		add(newfriends);
		
		setVisible(true);
	}

	class friendbox extends Frame
	{
		Iterator it2 = clientFriend.clientFriends.entrySet().iterator();

		friendbox()
		{
			setBounds(0,300,400,300);
			setLayout(new GridLayout(10,1));
			
			add(new Label("My Friends"));
			
			Button []friendchat = new Button[5];
			
			int i = 0;
			while(it2.hasNext())
			{
				Map.Entry e3 = (Entry) it2.next();			
				friendchat[i]= new Button((String) e3.getKey());
				
				friendchat[i].addActionListener(new chatboxopen(Main_Users.IDflag[Main_Users.IDnum], (String) e3.getKey()));
				
				add(friendchat[i]);
				i++;
			}
			
			
			setVisible(true);
		}
	}
	
	class OnlyForRequests implements ActionListener
	{
		String ids;
		String urid;
		
		OnlyForRequests(String urid, String ids)
		{
			this.ids=ids;
			this.urid=urid;
			
			System.out.println(ids); // test 
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			client1.Requested.add(ids);
		}
	}
	
	
	class chatboxopen implements ActionListener
	{
		String ids;
		String urid;
		chatboxopen(String urid, String ids)
		{
			this.ids=ids;
			this.urid=urid;
			System.out.println("chat box : "+ids+"  "+urid);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		
			try {
				new clientChatRequest(ids,urid).clientSendOracles();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
			new ChatboxClient(urid);
		}
	}
	
	class friendinvite implements ActionListener
	{
		String buf;
		Iterator it2 = client1.clients.entrySet().iterator();

		
		friendinvite(String buf)
		{
			this.buf = buf;
		}
		
		
		public void actionPerformed(ActionEvent e) {
			
			while(it2.hasNext())
			{
				Map.Entry e2 = (Entry) it2.next();
			
				String buf1 = (String) e2.getKey();
			//	String buf2 = (String) e2.getValue();
				
				if(buf.equals(e2.getKey()))
				{
					//System.out.println(e2.getKey()+" thats a friend");
					//dispose();
					new clientFriend(buf1,"test");
					System.out.println("from the Data : "+clientFriend.clientFriends.keySet());
					new friendbox();
				}
			}
		}
	}
	
	
	class friendRequest implements ActionListener
	{
		String urid;
		String buf2;

		friendRequest(String buf2, String urid)
		{
			this.buf2=buf2;
			this.urid=urid;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			dispose();

			System.out.println("Requesting for friends "+urid+"  "+buf2);
			new clientFriendrequest(urid,buf2);
			new clientFriendrequestDemo(urid,buf2);
			

			new Friends(buf);
			
			try {
				new clientFrinedrequestSend().clientFrinedrequestSends();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
	class realCheck implements ActionListener
	{
		String urid;
		boolean chatstarter = false;

		realCheck(String urid)
		{		
			this.urid=urid;
		}

	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			Frame RealFriendys = new Frame();
			RealFriendys.setBounds(785,0,120,755);
			RealFriendys.setLayout(null);
			RealFriendys.addWindowListener(new Close_c());
			
		
			
			Iterator it = clientRealFriends.realfriends.entrySet().iterator();
			JButton [] chatbutton = new JButton[clientRealFriends.realfriends.size()];
			Label [] chatName = new Label[clientRealFriends.realfriends.size()];

			
			
			int i= 0; 
			while(it.hasNext())
			{
				Map.Entry eee = (Entry) it.next();
				
				if(eee.getKey().equals(buf))
				{
					
					ImageIcon buffingImage = new ImageIcon("BC_1_image/"+eee.getValue()+"_1.png");
					chatbutton[i]=new JButton(buffingImage);
					chatbutton[i].setBounds(10,35+i*80,100,90);
					
					chatName[i]=new Label(""+eee.getValue());
					chatName[i].setBounds(40,135+i*80,100,30);
					
					
					if(chatstarter==false)
					{
						chatbutton[i].addActionListener(new chatboxopen(buf, (String) eee.getValue()));
						chatstarter=true;
					}
						
					if(chatstarter==true)
					{
						chatbutton[i].addActionListener(new OnlyForRequests(buf, (String) eee.getValue()));
					}
					
						RealFriendys.add(chatbutton[i]);
						RealFriendys.add(chatName[i]);
				}
				
				i++;
			}
			
			
			RealFriendys.setVisible(true);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
