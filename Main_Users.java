package BC_1;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import BC_1.Main.Specific;
import BC_1.Main.top1Action;

public class Main_Users extends Frame{

	Panel top1, top2, menu, list;
	TextField ID, PWDs;
	Button Register, Login;
	JButton chatBtn;
	static Label check;
	static String[] IDflag=new String[5];
	static int IDnum=0;
	static String loggedID="";
	

	Main_Users(String temp)
	{
		loggedID=temp;
		
		addWindowListener(new Close_c());
		
		
		try {
			new BarCommentSend();
		} catch (Exception e9) {
			// TODO Auto-generated catch block
			e9.printStackTrace();
		} 
		
		
		try {
			new BarComentRecieve();
		} catch (Exception e9) {
			// TODO Auto-generated catch block
			e9.printStackTrace();
		}
		
		
		try {
			new totalScoresend();
		} catch (Exception e9) {
	// TODO Auto-generated catch block
			e9.printStackTrace();
		}
		

		try {
			new bartotalreceive();
		} catch (Exception e9) {
			// TODO Auto-generated catch block
			e9.printStackTrace();
		}
		
		
		try {
			new couponboothreceive();
		} catch (Exception e8) {
			// TODO Auto-generated catch block
			e8.printStackTrace();
		}
		
		try {
			new SendingBarImages(loggedID);
		} catch (Exception e7) {
			// TODO Auto-generated catch block
			e7.printStackTrace();
		}
		
		
		try {
			new ReceiveBarImages();
		} catch (Exception e7) {
			// TODO Auto-generated catch block
			e7.printStackTrace();
		}

		
		
		try {
			new BarRefresh().BarRefreshs();
		} catch (Exception e6) {
			// TODO Auto-generated catch block
			e6.printStackTrace();
		}

		
		try {
			new BarRecieveRefreshed();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			new ReceiveImages();
		} catch (Exception e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		
		
		try {
			new SendingImages(loggedID);
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		
		try {
			new clientSendOracle().clientSendOracles();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println("send successful");
		
		
		try {
			new clientFrinedrequestReceives();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Receive successful");

		
		
		
		
		IDnum++;
		
		setBounds(0,0,900,755);
		setLayout(null);
		
		top1=new Panel();
		top1.setBounds(0,23,236,218);
		top1.setBackground(new Color(217,68,68));
		top1.setLayout(null);
	
		File f = new File("BC_1_image/");   //photo image
		File [] files = f.listFiles();

		for(int i=0; i<files.length; i++)
		{		
      		 ImageIcon face2 = new ImageIcon("BC_1_image/"+files[i].getName());

			 String fn = files[i].getName();  //filenames 
			 int buffn= fn.lastIndexOf(".");
			 String filename = fn.substring(0,buffn);
			 String tempphoto = temp+"_1";
			
			 System.out.println("filename  "+filename);
			 System.out.println("tempphoto "+tempphoto);
			 
			 Image img = face2.getImage();
			 Image newImg = img.getScaledInstance(100, 90, java.awt.Image.SCALE_SMOOTH);
			 
			 face2 = new ImageIcon(newImg);
			 
			 JButton boxphoto = new JButton(face2);
			 boxphoto.setBounds(10,10,100,90);
		
			 boxphoto.addActionListener(new Refresh());
			 
			 if(filename.equals(tempphoto))
			 {
				 top1.add(boxphoto);    //your image which matches your id appears 
			 }
		}
		
		Login= new Button("Logout");
		Login.setBounds(8,110,105,39);

		Register = new Button("Register");
		Register.setBounds(115,110,105,39);
		Login.addActionListener(new LogoutAction());
		
		
		check = new Label("Checker");
	
		ImageIcon packets = new ImageIcon("images/packets.gif");
		
		JLabel packets1 = new JLabel(packets);
		packets1.setBounds(125,150,20,20);
		chatBtn = new JButton("Chat");
		
		chatBtn.setBounds(150,150,60,20);
		chatBtn.addActionListener(new ChatAction());
		
		
		try {
			new chatrequestInArray();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		Iterator it3 = client1.Requested.iterator();
		
		while(it3.hasNext())
		{		
			if(temp.equals((String)it3.next()))  //chating request button only signaled 
			{
				top1.add(packets1);
				top1.add(chatBtn);
			}	
		}
	
		top1.add(Login);
		top1.add(Register);
		
		Label textID = new Label(temp);
		textID.setBounds(120,10,100,39);
		Label textWel = new Label("Welcome");
		textWel.setBounds(120,55,100,39);
		
		top1.add(textID);
		top1.add(textWel);
		
		top1.add(new Label("PWD :"));
		top1.add(new Label("Welcome"));
		
	
		Label band = new Label();
		band.setBounds(0,180,236,20);
		band.setBackground(new Color(245,134,134));
		
		Label band2 = new Label();
		band2.setBounds(0,200,236,20);
		band2.setBackground(new Color(255,175,175));
	
		top1.add(band);
		top1.add(band2);
		
	
	
		menu=new Panel();
		menu.setBounds(0,240,236,500);
		menu.setBackground(new Color(255,205,205));
		
		menu.setLayout(null);
		
		Button Rankings = new Button("Rankings");
		Rankings.setBounds(10,10,210,50);
		
		Button Friends =new Button("Friends");
		Friends.setBounds(10,70,210,50);
		
		Button Coupons = new Button("Coupons");
		Coupons.setBounds(10, 130, 210, 50);
		
			
		Button Market = new Button("Market");
		Market.setBounds(10, 190, 210, 50);
		
		Button Owner = new Button("Bar Owner");
		Owner.setBounds(10, 190, 210, 50);

		Button Service = new Button("Note");
		Service.setBounds(10, 250, 210, 50);

		
		Friends.addActionListener(new listAction(temp));
		Rankings.addActionListener(new RankingsAction());
		Coupons.addActionListener(new CouponAction());
		Market.addActionListener(new BarAction());
		Owner.addActionListener(new BarOwnAction());
		Service.addActionListener(new Zeroboardopen());
		
		menu.add(Rankings);
		menu.add(Friends);
		menu.add(Coupons);
		menu.add(Service);
		
				

		Iterator it5 = client1.ClientRequestedDemo.entrySet().iterator();
	
		JButton [] friendRequest = new JButton[client1.ClientRequestedDemo.size()];
		Label [][] friendRequestInfo = new Label[client1.ClientRequestedDemo.size()][2];
		
		int s=0;
		
		while(it5.hasNext())
		{
			Map.Entry eee =  (Entry) it5.next();
			
			if(eee.getValue().equals(loggedID))
			{	
				ImageIcon buffingfriend = new ImageIcon("BC_1_image/"+eee.getKey()+"_1.png");				
				
				Image img = buffingfriend.getImage();
				Image newImg = img.getScaledInstance(100, 90, java.awt.Image.SCALE_SMOOTH);
				 
				buffingfriend = new ImageIcon(newImg);
				
				
				friendRequest[s] = new JButton(buffingfriend);
				friendRequest[s].addActionListener(new FriendAcceptance((String)eee.getKey()));
				friendRequestInfo[s][0]= new Label("Requested");
				friendRequestInfo[s][1]= new Label("ID : "+eee.getKey());
			
				
				friendRequest[s].setBounds(10,310+100*s,100,90);
				friendRequestInfo[s][0].setBounds(120,310+100*s,100,30);
				friendRequestInfo[s][1].setBounds(120,350+100*s,100,30);
				
				menu.add(friendRequest[s]);
				menu.add(friendRequestInfo[s][0]);
				menu.add(friendRequestInfo[s][1]);
				
				s++;
			}	
		}
		
		
		
		
	Iterator it = Bar.Bars2.entrySet().iterator();
		
		while(it.hasNext())
		{
			Map.Entry e = (Entry) it.next();
		
			if(temp.equals(e.getKey()))
			{
				menu.add(Owner);
			}
			
			else
				menu.add(Market);

		}
		
		
		Button Manage = new Button("Manage");
		Manage.setBounds(10, 310, 210, 50);
		
		
		if(loggedID.equals("Admin"))
		{
			menu.add(Manage);
		}
		
		Manage.addActionListener(new ManageAction());
				
		list = new Panel();
		list.setBounds(240,0,600,700);
		list.setBackground(new Color(252,212,212));
		list.setLayout(new GridLayout(4,7));
		
		
			
		//	System.out.println(Bar.names[i]+" "+Bar.photos[i]+" from the BarClass");		
			
		////////////////////////////////////
		
		
	
		Label[][] newbeeNames = new Label[5][5];
		JButton []newbeeNamePhoto = new JButton[4];
		Panel[] newbeebox = new Panel[4];
		TextArea[] explainbox = new TextArea[4];
		Button [] CouponClicker = new Button[4];
		String [] bufCouponID = new String[4];
		
		
	
		
	
		
		
	
		Iterator its = Bar.Bars2.entrySet().iterator();
		
	  
		for(int i=0; i<4; i++)
		{	
			Map.Entry e = (Entry) its.next();
			BarInfo temp2 = (BarInfo) e.getValue();	
			String nametemp = (String)e.getKey();
						
			
			ImageIcon bufphoto = new ImageIcon("Bar_Image/"+e.getKey()+".png"); //takeout the id for photo 
			
			Image img = bufphoto.getImage();
			Image newimg = img.getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
			
			ImageIcon couponImg = new ImageIcon("images/couponicon.png");
			ImageIcon starImg = new ImageIcon("images/star.png");
			
			bufphoto= new ImageIcon(newimg);
			
			//System.out.println(e.getKey());
			
			newbeebox[i] = new Panel();
			newbeeNamePhoto[i]=new JButton(bufphoto);
			
		
			list.add(newbeebox[i]);
			newbeebox[i].setLayout(null);
			

			
			Iterator it2 = BarCouponbooth.BarCoupons.entrySet().iterator();
			
			BarCouponbooth.CouponNumbers[i]=0;
			
			while(it2.hasNext())
			{
				Map.Entry ee =  (Entry) it2.next();
				
				String Couponid = (String) ee.getKey();
				
				
				int dots = Couponid.lastIndexOf('/');
				int slash = Couponid.lastIndexOf('_');
				
				String Couponlistid = Couponid.substring(0,dots);
				String CouponNumber = Couponid.substring(slash+1);
	
				System.out.println(Couponlistid+" "+CouponNumber + " from the CouponBooth");
				
				
				if(nametemp.equals(Couponlistid))
				{						
					BarCouponbooth.CouponNumbers[i]++;	
					bufCouponID[i]=Couponid.substring(0,slash+1);
				}
			}
			

			System.out.println(bufCouponID[i]+ " : "+BarCouponbooth.CouponNumbers[i]+" for each Coupons");

			
			CouponClicker[i] = new Button(""+BarCouponbooth.CouponNumbers[i]);
			CouponClicker[i].setBounds(245,117,40,38);
			CouponClicker[i].addActionListener(new UseCoupon(bufCouponID[i],BarCouponbooth.CouponNumbers[i]));
			
			newbeebox[i].add(CouponClicker[i]);

		
			newbeeNamePhoto[i].setBounds(0,0,180,180);
			newbeebox[i].add(newbeeNamePhoto[i]);
		
			JLabel coupons = new JLabel(couponImg);
			coupons.setBounds(150,105,130,50);
			newbeebox[i].add(coupons);
			
			Iterator it4 = BarTotalScore.bartotalbox.entrySet().iterator();
			int buffingsum = 0;
			
			while(it4.hasNext())
			{
				Map.Entry eee = (Entry) it4.next();
				String buffer = (String) eee.getKey();
				
				int bufnum = buffer.lastIndexOf('_');
				String buffer2 = buffer.substring(0,bufnum);
				int addsum = (int) eee.getValue();
				
				if(e.getKey().equals(buffer2))
				{
					buffingsum+=addsum;
				}
			}
			
			
			System.out.println("buffingsum Results : "+buffingsum);
			System.out.println("Rock this MotherFucker : "+e.getKey());
			System.out.println("Score from the DataBase : "+BarTotalScore.bartotalbox.entrySet());
		
			if(buffingsum>10)
			{
			JLabel star = new JLabel(starImg);
			star.setBounds(280,85,100,100);
			newbeebox[i].add(star);
			
			if(buffingsum>20)
			{
			JLabel star2 = new JLabel(starImg);
			star2.setBounds(320,85,100,100);
			newbeebox[i].add(star2);
			
			if(buffingsum>50)
			{
			JLabel star3 = new JLabel(starImg);
			star3.setBounds(360,85,100,100);
			newbeebox[i].add(star3);
			
			if(buffingsum>70)
			{
			JLabel star4 = new JLabel(starImg);
			star4.setBounds(400,85,100,100);
			newbeebox[i].add(star4);
			
			if(buffingsum>90)
			{
			JLabel star5 = new JLabel(starImg);
			star5.setBounds(440,85,100,100);
			newbeebox[i].add(star5);
			}
			}
			}
			}
			}
			
			
			newbeeNames[i][0]= new Label(temp2.name);
			newbeeNames[i][0].setBounds(180,0,100,40);
			newbeeNames[i][0].setForeground(Color.white);
			newbeeNames[i][0].setBackground(new Color(217,68,68));
			newbeebox[i].add(newbeeNames[i][0]);

			
			newbeeNames[i][1]=new Label(temp2.address);
			newbeeNames[i][1].setBounds(280,0,100,40);
			newbeeNames[i][1].setBackground(new Color(213,102,102));
			newbeeNames[i][1].setForeground(Color.white);
			newbeebox[i].add(newbeeNames[i][1]);

			newbeeNames[i][2]=new Label(temp2.phone);
			newbeeNames[i][2].setBounds(380,0,100,40);
			newbeeNames[i][2].setBackground(new Color(227,126,126));
			newbeeNames[i][2].setForeground(Color.white);
			newbeebox[i].add(newbeeNames[i][2]);
			
			newbeeNames[i][3]=new Label(temp2.typeofBar);
			newbeeNames[i][3].setBounds(480,0,200,40);
			newbeeNames[i][3].setBackground(new Color(253,180,180));
			newbeeNames[i][3].setForeground(Color.white);
			newbeebox[i].add(newbeeNames[i][3]);

			newbeeNames[i][4]=new Label(temp2.explain);
			newbeeNames[i][4].setBounds(200,60,400,100);
			newbeeNames[i][4].setForeground(new Color(217,68,68));
			newbeebox[i].add(newbeeNames[i][4]);
			
	
			System.out.println(temp2.name);	
		}
		
		
		Iterator its2 = Bar.Bars2.entrySet().iterator();
		
		for(int i=0; i<4; i++)
			{
				Map.Entry e = (Entry) its2.next();
				BarInfo temp2 = (BarInfo) e.getValue();	
			
				String buf = (String)e.getKey();
				newbeeNamePhoto[i].addActionListener(new Specific(buf)); //������������������ ������ 
			}
	
		
		ScrollPane sp = new ScrollPane();
		sp.setBounds(250,35,635,700);
		sp.add(list);
		
		
		add(sp);
		add(menu);
		add(top1);
		setVisible(true);
	}
	
	class Zeroboardopen implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new ZeroBoard();
			
		}
	}
	
	
	class Refresh implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			dispose();
			new Main_Users(loggedID);
			
		}
	}
	

	
	class FriendAcceptance implements ActionListener
	{
		String buffingid;
		
		FriendAcceptance(String buffingid)
		{
			this.buffingid=buffingid;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			client1.ClientRequestedDemo.remove(buffingid);
			
			clientFriendrequestDemo.FriendRequestingDemo.remove(buffingid);
			
			Iterator it5 = clientFriendrequest.FriendRequesting.iterator();
					
			while(it5.hasNext())
			{
				clientFriendrequestinput e5 = (clientFriendrequestinput) it5.next();
								
				if(buffingid.equals(e5.name)&&e5.friend.equals(loggedID))
				{
					try {
						new clientFriendrequestDestroy(loggedID).clientFriendrequestDestroys();
					
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					};
					
									
				
					new clientRealFriends(e5.name,loggedID);  ////the reason why friends are all accepted at once 
					new clientRealFriends(loggedID,e5.name);
					

				}
			}
		
			dispose();
			new Main_Users(loggedID);
			
			
///////////			
		}
		
	}
	
	
	class UseCoupon implements ActionListener
	{
		int num;
		String buf;
		
		UseCoupon(String buf, int num)
		{
			this.buf=buf;	
			this.num=num;
			
			
			System.out.println(buf + num+"  from UsingCoupon");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			System.out.println(loggedID+"*"+buf+num+" insert the Coupons in the client");
			new clientCoupon(loggedID+"*"+buf+num, "Coupons");

			
			try {
				new removeBoothOracle(buf+num).CouponDestroy();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			};				
		
			BarCouponbooth.BarCoupons.remove(buf+num);
			
			System.out.println(clientCoupon.clientCoupons+" inserted Coupons to Customers");
			System.out.println(buf+num+" trying to remove");
			
			
			System.out.println(BarCouponbooth.BarCoupons+"  leftovers");

			dispose();	
			new Main_Users(loggedID);
		}
	}
	
	class BarAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
			new Register1(loggedID);
			
		}
	}
	
	class BarOwnAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new BarOwner(loggedID);
			
		}
	}
	
	
	class CouponAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		

			new CouponBox(loggedID);
			
			
		}
	}
	
	
	class ChatAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			client1.Requested.remove(loggedID);
			new ChatboxClient(loggedID);		

			try {
				new chatrequestDestroy(loggedID).chatreDestroy();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
	
	class RankingsAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			new RankCal(loggedID);
		}
	}
	
	
	class listAction implements ActionListener
	{
		String buf;
		
		listAction(String buf)
		{
			this.buf = buf;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println(buf+"from listAction");
			new Friends(buf);
		}
	}
	
	
	class Specific implements ActionListener
	{
		String buf;
		
		Specific(String buf)
		{
			this.buf=buf;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			new BarSpecific(buf);
			
		}
	}
	
	class LogoutAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			dispose();
			new Main();		
		}
		
		
	}
	
	class ManageAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			new Manage();
			
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
	    new Bar("Wondad","LoveBar", "Bar_Image/Wondad.png", "010-231-2312", "Busan","TypeofBar",20,50,"asdf","no","rest",""
	    		+ "dfsd", 
	    		"fdsfjklasdkfkjsadlfsad");
	    new Bar("Oracle","SuperBar", "Bar_Image/Oracle.png", "010-231-2312", "1location","TypeofBar",50,20,"asdf","no","rest","explain", 
	    		"fjsdhjfhjaksdhjkfasjdkfhjhasjkdfhhsadjfasdfhjsakdhkfhasjdfkahsdfasdfsdf");
	    new Bar("Sauda","FuckBar", "Bar_Image/Sauda.png", "010-231-2312", "Seoul","TypeofBar",70,40,"asdf","no","rest","explain", 
	    		"hisbar");
	    new Bar("Norana","DumbBar", "Bar_Image/Norana.png", "010-231-2312", "SuWon","TypeofBar",90,100,"asdf","no","rest","explain", "title");
		
		
		
		//client defaults
		new client1("ToToro","123","SungHo","Busan","jumin1","jumin2","Worker","asdf","sdfsd","sdfsd","sdfsdf","dsfsdf",11,12,0);
		new client1("May","123","KimHa","Suwon","jumin1","jumin2","Worker","asdf","sdfsd","sdfsd","sdfsdf","dsfsdf",11,12,0);
		new client1("Nissan","123","Hanzo","Daegu","jumin1","jumin2","Worker","asdf","sdfsd","sdfsd","sdfsdf","dsfsdf",11,12,0);
		new client1("Vold2","123","Hanzo","Seoul","jumin1","jumin2","Worker","asdf","sdfsd","sdfsd","sdfsdf","dsfsdf",11,12,0);
		new client1("Sakura","123","Hanzo","Seoul","jumin1","jumin2","Worker","asdf","sdfsd","sdfsd","sdfsdf","dsfsdf",11,12,0);

		
			
		new Coupons("May_0","sdfsdf","Coupontest","Coupontest",12);
		new Coupons("Toro_0","sdfsdf","Coupontest","Coupontest",10);
		new Coupons("Nissan_0","sdfsdf","Coupontest","Coupontest",5);
		new Coupons("Nissan_0","sdfsdf","Coupontest","Coupontest",20);
		new Coupons("Oracle_0","sdfsdf","Coupontest","Coupontest",12);

		
		new BarCouponbooth("Oracle/LovelyCoupon_1","LovelyCoupon");
		new BarCouponbooth("Oracle/LovelyCoupon_2","LovelyCoupon");
		new BarCouponbooth("Oracle/LovelyCoupon_3","LovelyCoupon");
		new BarCouponbooth("Oracle/LovelyCoupon_4","LovelyCoupon");
		new BarCouponbooth("Oracle/LovelyCoupon_5","LovelyCoupon");
		new BarCouponbooth("Oracle/LovelyCoupon_6","LovelyCoupon");
		new BarCouponbooth("Oracle/LovelyCoupon_7","LovelyCoupon");
		new BarCouponbooth("Oracle/LovelyCoupon_8","LovelyCoupon");
		new BarCouponbooth("Oracle/LovelyCoupon_9","LovelyCoupon");
		new BarCouponbooth("Oracle/LovelyCoupon_10","LovelyCoupon");
		new BarCouponbooth("Oracle/LovelyCoupon_11","LovelyCoupon");
		new BarCouponbooth("Oracle/LovelyCoupon_12","LovelyCoupon");


		new BarCouponbooth("Sauda/LovelyCoupon_1","LovelyCoupon");
		new BarCouponbooth("Sauda/LovelyCoupon_2","LovelyCoupon");
		new BarCouponbooth("Sauda/LovelyCoupon_3","LovelyCoupon");
		new BarCouponbooth("Sauda/LovelyCoupon_4","LovelyCoupon");
		new BarCouponbooth("Sauda/LovelyCoupon_5","LovelyCoupon");

		try {
			new BarRefresh().BarRefreshs();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
		new Main_Users("Admin");
	}

}
