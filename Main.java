package BC_1;
import BC_1.*;
import BC_1.Main_Users.UseCoupon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;



public class Main extends Frame{
	Panel top1, top2, menu, list;
	TextField ID, PWDs;
	JButton Register, Login;
	static Label check;
	
	static boolean loginFlag=false;
	static String ipsource = "121.160.70.22";


	Main()
	{
		
		
		addWindowListener(new Close_c());


		try {
			new bartotalreceive();
		} catch (Exception e9) {
			// TODO Auto-generated catch block
			e9.printStackTrace();
		}
		
		
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
			new couponboothreceive();
		} catch (Exception e8) {
			// TODO Auto-generated catch block
			e8.printStackTrace();
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
			new clientReceiveOracle();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		setBounds(0,0,900,755);
		setLayout(null);
		
		top1=new Panel();
		top1.setBounds(0,23,236,218);
		top1.setBackground(new Color(217,68,68));
		top1.setLayout(null);

		ID = new TextField("ID insert");
		ID.setBounds(120,10,100,39);
		
		PWDs = new TextField("Pass");
		PWDs.setBounds(120,55,100,39);
		
		ImageIcon photos = new ImageIcon("images/photoing.png"); 
		JLabel boxphoto = new JLabel(photos);
		boxphoto.setBounds(10,0,100,100);

		
		Register = new JButton("Regis");
		Register.setForeground(Color.red);
		Register.setBounds(115,100,105,39);
		
		Login = new JButton("Login");
		Login.setBounds(9, 100, 105, 39);
		
		Register.addActionListener(new top1Action("Register"));
		Login.addActionListener(new top1Action("Login"));
		check = new Label("Checker");
		
		top1.add(boxphoto);
		
		top1.add(new Label("ID : "));
		top1.add(ID);
		
		top1.add(new Label("PWD :"));
		top1.add(PWDs);
		
		top1.add(Login);
		top1.add(Register);
		top1.add(check);
		
		Label band = new Label();
		band.setBounds(0, 180, 236, 20);
		band.setBackground(new Color(245,134,134));
		
		Label band2 = new Label();
		band2.setBounds(0, 200, 236, 20);
		band2.setBackground(new Color(255,175,175));
		
		
		top1.add(band);
		top1.add(band2);
		menu=new Panel();
		menu.setBounds(0,240,236,500);
		menu.setBackground(new Color(255,205,205));
		menu.setLayout(null);
		
		
		
		Button FindID = new Button("Find ID");
		FindID.setBounds(10,10,210,50);
		
		
		Button FindPW = new Button("Find PWD");
		FindPW.setBounds(10,70,210,50);
		
		FindID.addActionListener(new FindingID());
		FindPW.addActionListener(new FindingPW());
		
		menu.add(FindID);
		menu.add(FindPW);
		
	    new Bar("Wondad","LoveBar", "Bar_Image/Wondad.png", "010-231-2312", "Seoul","TypeofBar",1,1,"asdf","no","rest",""
	    		+ "tdfsd", 
	    		"hisbar dfajsdflsadjfljsdlakjfsdfasdfjasdjflsdjlfjaslkdjflkjsaiteofdjfsdkjfaiwejtjsdfjsdfjaoeitjadsfjsadf");
	    new Bar("Oracle","SuperBar", "Bar_Image/Oracle.png", "010-231-2312", "Busan","TypeofBar",0,2,"asdf","no","rest","explain", 
	    		"hisbar dfajsdflsadjfljsdlakjfsdfasdfjasdjflsdjlfjaslkdjflkjsaiteofdjfsdkjfaiwejtjsdfjsdfjaoeitjadsfjsadf");
	    new Bar("Sauda","FuckBar", "Bar_Image/Sauda.png", "010-231-2312", "Seoul","TypeofBar",1,2,"asdf","no","rest","explain", 
	    		"hisbar dfajsdflsadjfljsdlakjfsdfasdfjasdjflsdjlfjaslkdjflkjsaiteofdjfsdkjfaiwejtjsdfjsdfjaoeitjadsfjsadf");
	    new Bar("Norana","DumbBar", "Bar_Image/Norana.png", "010-231-2312", "Suwon","TypeofBar",2,1,"asdf","no","rest","explain", "title");
		
		
		list = new Panel();
		list.setBounds(240,0,600,700);
		list.setBackground(new Color(252,212,212));
		list.setLayout(new GridLayout(4,7));
		
		//default info//////////////////////
		
			//client defaults
			
			new client1("ToToro","123","SungHo","Busan","990509","jumin2","Worker","asdf","sdfsd","sdfsd","sdfsdf","dsfsdf",2,1,0);
			new client1("May","123","KimHa","Suwon","jumin1","jumin2","Worker","asdf","sdfsd","sdfsd","sdfsdf","dsfsdf",1,0,0);
			new client1("Nissan","123","Hanzo","Daegu","jumin1","jumin2","Worker","asdf","sdfsd","sdfsd","sdfsdf","dsfsdf",2,2,0);
			new client1("Vold2","123","Hanzo","Seoul","jumin1","jumin2","Worker","asdf","sdfsd","sdfsd","sdfsdf","dsfsdf",1,1,0);
			new client1("Sakura","123","Hanzo","Seoul","jumin1","jumin2","Worker","asdf","sdfsd","sdfsd","sdfsdf","dsfsdf",1,2,0);
				
			new Coupons("May_0","sdfsdf","Coupontest","Coupontest",20);
			new Coupons("May_0","sdfsdf","Coupontest","Coupontest",40);
			new Coupons("Toro_0","sdfsdf","Coupontest","Coupontest",10);
			new Coupons("Nissan_0","sdfsdf","Coupontest","Coupontest",10);
			
			//	System.out.println(Bar.names[i]+" "+Bar.photos[i]+" from the BarClass");		
			
		////////////////////////////////////
		
		Label[][] newbeeNames = new Label[4][5];
		JButton []newbeeNamePhoto = new JButton[4];
		Panel[] newbeebox = new Panel[4];
		TextArea[] explainbox = new TextArea[4];
		Button [] CouponClicker = new Button[4];
		String [] bufCouponID = new String[4];
		
		
		Iterator its = Bar.Bars2.entrySet().iterator();

		//String photo, score, coupon, location, date, name;
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
			newbeebox[i].add(CouponClicker[i]);

		
			newbeeNamePhoto[i].setBounds(0,0,180,180);
			newbeebox[i].add(newbeeNamePhoto[i]);
		
			JLabel coupons = new JLabel(couponImg);
			coupons.setBounds(150,105,130,50);
			newbeebox[i].add(coupons);
			
			
			
			Iterator it3 = BarTotalScore.bartotalbox.entrySet().iterator();
			int buffingsum = 0;
			
			while(it3.hasNext())
			{
				Map.Entry eee = (Entry) it3.next();
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
			}
	
		
		ScrollPane sp = new ScrollPane();
		sp.setBounds(250,35,635,700);
		sp.add(list);
		
		
		add(sp);
		add(menu);
		add(top1);
		setVisible(true);
	}


	
	class FindingID implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new FindingIDFrame();
			
		}
	
	}
	
	class FindingPW implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new FindingPWDFrame();
			
		}		
	}
	
	static	Label Checking = new Label("Findingyour ID"); 

	class FindingIDFrame extends Frame
	{
		TextField UrName;
		TextField Security;
		TextField Security2;
		
		FindingIDFrame()
		{
			setBounds(250,0,480,200);
			setBackground(new Color(255,205,205));
			
			 UrName = new TextField("Insert your Name");
			 Security = new TextField("Insert your Security");
			 Security2 = new TextField("Number");

			Button Insert = new Button("Insert");
			
			UrName.setBounds(20,50,300,50);
			Security.setBounds(20,120,140,50);
			Security2.setBounds(180,120,140,50);

			Insert.setBounds(350,45,100,100);
			Checking.setBounds(350,150,100,20);
			Checking.setBackground(Color.pink);
			
			Insert.addActionListener(new FindId());
			
			add(Security2);
		    add(Checking);
			add(Insert);
			add(UrName);
			add(Security);
			
			addWindowListener(new Close_c());
			
			setLayout(null);
			setVisible(true);
			
		}	
		
		class FindId implements ActionListener
		{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					clientPasswordFind tt =	new clientPasswordFind(UrName.getText(), Security.getText(), Security2.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dispose();
				new FindingIDFrame();
					
			}
		}
	}
		
	static	Label PWDChecking = new Label("Findingyour PWD"); 
	
	class FindingPWDFrame extends Frame
	{
		TextField Email;
		TextField Security;
		TextField Security2;
		
		FindingPWDFrame()
		{
			setBounds(250,0,480,200);
			setBackground(new Color(255,205,205));
			
			 Security = new TextField("Insert your Security");
			 Security2 = new TextField("Number");

			 Email = new TextField("Insert your Email");

			Button Insert = new Button("Insert");
			
			Security.setBounds(20,50,140,50);
			Security2.setBounds(180,50,140,50);

			Email.setBounds(20,120,300,50);

			Insert.setBounds(350,45,100,100);
			PWDChecking.setBounds(350,150,100,20);
			PWDChecking.setBackground(Color.pink);
			
			Insert.addActionListener(new FindPWD());
			
		    add(PWDChecking);
			add(Insert);
			add(Email);
			add(Security);
			add(Security2);

			
			addWindowListener(new Close_c());
			
			setLayout(null);
			setVisible(true);
			
		}	
		
		class FindPWD implements ActionListener
		{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
				
						new clientPWDFind(Security.getText(),Security2.getText(),Email.getText());
						
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dispose();
				new FindingPWDFrame();
					
			}
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
	
	
	
	class top1Action implements ActionListener
	{
		String choose;
		
		top1Action(String choose)
		{
			this.choose = choose;
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(choose.equals("Register"))
			{
				new Register();
			}
			
			if(choose.equals("Login"))
			{
				loginFlag=true;
				Iterator it = client1.clients.entrySet().iterator();
				
				while(it.hasNext())
				{
					Map.Entry e2 = (Entry) it.next();
					
					client1input bufinput = (client1input) e2.getValue();
					
					
					
					if(e2.getKey().equals(ID.getText())&&bufinput.pw.equals(PWDs.getText()))  // yet no password 
					{
						Main.check.setText("Valid ID");
						dispose();
						new Main_Users(ID.getText());
					}
			
					else
					{
						Main.check.setText("Invalid");
					}
				}				
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
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

		
		Main player1 = new Main();

	}

}
