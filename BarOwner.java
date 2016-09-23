package BC_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BarOwner extends Frame{

	String tempid;
	JLabel Photo;
	static String CouponName="";
	static int CouponNum=0;
	static boolean flags = false;
	static String inuse="none";
	
	BarOwner(String tempid)
	{
		this.tempid=tempid;
	
		try {
			new CouponBoothSend().CouponBoothSend();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		setBounds(900,0,500,755);
		setLayout(null);
		
		addWindowListener(new Close_c());
		
		Label BarBanner = new Label(Gathering.SpecificBarInfo[8]);
		BarBanner.setBounds(0,20,500,60);
		BarBanner.setBackground(new Color(217,68,68));
		BarBanner.setForeground(Color.white);
		add(BarBanner);

		Iterator its = Bar.Bars2.entrySet().iterator();
	
		String bufferimage="Oracle";
		String []Labelset = new String[10];
		
		while(its.hasNext())
		{
			Map.Entry e = (Entry) its.next();
			BarInfo temp2 = (BarInfo) e.getValue();		
	
			if(tempid.equals(e.getKey()))
			{	
				bufferimage=tempid;
				Labelset[0]= temp2.name;
				Labelset[1]= temp2.address;
				Labelset[2]= temp2.phone;
				Labelset[3]= temp2.smoke;
				Labelset[4]= temp2.rest;
				Labelset[5]= temp2.time;
				Labelset[6]= temp2.explain;
			}
		}
		
		
		ImageIcon bufphoto = new ImageIcon("Bar_Image/"+bufferimage+".png"); //takeout the id for photo 
		Image img = bufphoto.getImage();
		Image newimg = img.getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
		
		bufphoto = new ImageIcon(newimg);
		Photo = new JLabel(bufphoto);
		Photo.setBounds(20,95,180,180);
		
		add(Photo);
		
		Label Name = new Label("Bar Name : "+Labelset[0]);
		Name.setBounds(220,100,200,30);
		add(Name);
		
		Label Address = new Label("Address : "+Labelset[1]);
		Address.setBounds(220,130,200,30);
		add(Address);
		
		Label Phone = new Label("Phone : "+Labelset[2]);
		Phone.setBounds(220,160,200,30);
		add(Phone);
		
		Label Smoke = new Label("Smoke : "+Labelset[3]);
		Smoke.setBounds(220,190,200,30);
		add(Smoke);
		
		Label Rest = new Label("Rest : "+Labelset[4]);
		Rest.setBounds(220,220,200,30);
		add(Rest);
		
		Label Time = new Label("Time : "+Labelset[5]);
		Time.setBounds(220,250,200,30);
		add(Time);
		
		TextArea Explain = new TextArea(Labelset[6]);
		Explain.setBounds(220,280,250,150);
		add(Explain);
		
		Button ChangeMenu = new Button("Change Menu");
		Button CheckCoupons = new Button("Check Coupons");
		ChangeMenu.setBounds(20,300,180,60);
		ChangeMenu.addActionListener(new ChangedMenu(bufferimage));
		CheckCoupons.setBounds(20,370,180,60);
		
		add(ChangeMenu);
		add(CheckCoupons);
		
		
		
		Iterator it = MenuInfo.MenuInfos.entrySet().iterator();
		add(new Label("Menus"));
		
		while(it.hasNext())
		{
			Map.Entry e = (Entry) it.next();
			String [] bufmenus 	=	(String[]) e.getValue();
		
			if(e.getKey().equals(tempid))
			{
				for(int i=0; i<4; i++)
				add(new Label(bufmenus[i]));
			}		
		}
		
		
		Label CouponLabel = new Label("CouponList : "+inuse);
		CouponLabel.setBackground(Color.lightGray);
		CouponLabel.setBounds(0,450,500,60);
		add(CouponLabel);

		
		Iterator it23 = Coupons.MyCoupon.entrySet().iterator();
		int numberofCoupons=0;	
		String buftext="Sex_0";
		String buftext2;
		String [][] buffer = new String[5][4];

		if(flags == false)
		{	
			System.out.println("Do Nothing");
		}
		
		
	else
	{
		while(it23.hasNext())
		{
			Map.Entry eee = (Entry) it23.next();
			
			System.out.println(eee.getKey()+ "from teiter");
			System.out.println(tempid + "tempid");
			
			CouponsInput ee = (CouponsInput) eee.getValue();
			
			
		    buftext = (String) eee.getKey();
			int bufnum = buftext.lastIndexOf("_");
			buftext2 = buftext.substring(0,bufnum);
			System.out.println(buftext2);
			
			
			if(tempid.equals(buftext2))
			{
				buffer[numberofCoupons][0]=ee.Cname;
				buffer[numberofCoupons][1]=ee.Cex;
				buffer[numberofCoupons][2]=ee.Clength;
				buffer[numberofCoupons][3]=""+ee.num;
			}
			
			if(tempid.equals(buftext2))
			{
				numberofCoupons++;
			}		
		}
	}

		Panel CouponsBeforeUse = new Panel();
		CouponsBeforeUse.setBackground(Color.gray);
		CouponsBeforeUse.setBounds(0,500,500,870);
		CouponsBeforeUse.setLayout(null);

		
		ScrollPane sp = new ScrollPane();
		sp.setBounds(0,500,520,170);
		sp.add(CouponsBeforeUse);
		
		
		Button[] tempButton = new Button[numberofCoupons];
		Label [][] tempLabel = new Label[numberofCoupons][4];
		
		
		for(int i=0; i<numberofCoupons; i++)
		{
			tempButton[i]=new Button(""+buffer[i][0]);
			tempButton[i].addActionListener(new CouponListOnBooth(i));
			
			tempButton[i].setBounds(20,20+80*i,180,50);
			
			tempLabel[i][1] = new Label(buffer[i][1]);
			tempLabel[i][1].setBounds(210, 35+80*i, 100, 50);
			
			tempLabel[i][2] = new Label(buffer[i][2]);
			tempLabel[i][2].setBounds(310,35+80*i,100,50);

			tempLabel[i][3] = new Label(buffer[i][3]);
			tempLabel[i][3].setBounds(410,35+80*i,100,50);

			
			CouponsBeforeUse.add(tempButton[i]);
			CouponsBeforeUse.add(tempLabel[i][1]);
			CouponsBeforeUse.add(tempLabel[i][2]);
			CouponsBeforeUse.add(tempLabel[i][3]);	
		
			CouponName = buffer[i][1];
			CouponNum=Integer.parseInt(buffer[i][3]);
		}
		
	
		
		Button couponBtn = new Button("Add more Coupon + ");
		couponBtn.addActionListener(new CouponAction());
		couponBtn.setBounds(130,680,250,60);
		
		add(sp);
		add(couponBtn);
		
		setVisible(true);
	}
	
	
	class ChangedMenu implements ActionListener
	{
		String buf;

		public ChangedMenu(String buf) {
			this.buf = buf;
		}

		public void actionPerformed(ActionEvent e) {

			new ChangingMenu(buf);
		}
	}
	
	class CouponListOnBooth implements ActionListener
	{
		int buf;
		CouponListOnBooth(int buf)
		{
			this.buf=buf;
		}

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			inuse="Currently "+CouponName;
			
			for(int i=1; i<CouponNum; i++)
			new BarCouponbooth(tempid+"/"+CouponName+"_"+i, CouponName);
			
			Coupons.MyCoupon.remove(tempid+"_"+buf);
			
			dispose();
			new BarOwner(tempid);
		}		
	}
	
	class CouponAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			new Couponbooky(tempid);
			
		}	
	}
	
	class Couponbooky
	{
	    String bufid;
	    TextField name3, expl3, length3, num3;
		
		Couponbooky(String bufid)
		{	
			this.bufid=bufid;
			
			Frame CouponOn = new Frame("For Coupons");
			

			CouponOn.setBounds(900, 0, 500, 500);
			CouponOn.setLayout(new GridLayout(10,2));
			
			addWindowListener(new Close_c());

			name3 = new TextField();
			expl3 = new TextField();
			length3 = new TextField();
			num3 = new TextField("0");
			
			CouponOn.add(new Label("Coupon Name"));
			CouponOn.add(name3);
			
			CouponOn.add(new Label("Coupon Expl"));
			CouponOn.add(expl3);
			
			CouponOn.add(new Label("Coupon Length"));
			CouponOn.add(length3);
			
			CouponOn.add(new Label("number"));
			CouponOn.add(num3);
				
			CouponOn.add(new Label(""));

			
			Button ButtonPress = new Button("press");
			ButtonPress.addActionListener(new CouponAdd());
		
			CouponOn.add(ButtonPress);
			CouponOn.setVisible(true);
		}
	

		class CouponAdd implements ActionListener
		{
			String name, expl, length;
			int bufnum;
		    			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				flags=true;
				
				name = name3.getText();
				expl = expl3.getText();
			    length = length3.getText();
				bufnum = Integer.parseInt(num3.getText());
							
				dispose();

				
				new Coupons(tempid+"_"+Coupons.CouponNum, name, expl, length, bufnum);	
				System.out.println(tempid+"_"+Coupons.CouponNum+" before adding the CouponNum");
				Coupons.CouponNum++;
				
				
				new BarOwner(tempid);
				
				
			}	
		}
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	    new Bar("Wondad","LoveBar", "WhontoPhoto", "010-231-2312", "1location","TypeofBar",20,40,"asdf","no","rest",""
	    		+ "tdfsd", 
	    		"hisbar dfajsdflsadjfljsdlakjfsdfasdfjasdjflsdjlfjaslkdjflkjsaiteofdjfsdkjfaiwejtjsdfjsdfjaoeitjadsfjsadf");
	    new Bar("Oracle","SuperBar", "WhontoPhoto", "010-231-2312", "1location","TypeofBar",50,20,"asdf","no","rest","explain", 
	    		"hisbar dfajsdflsadjfljsdlakjfsdfasdfjasdjflsdjlfjaslkdjflkjsaiteofdjfsdkjfaiwejtjsdfjsdfjaoeitjadsfjsadf");
	    new Bar("Sauda","FuckBar", "WhontoPhoto", "010-231-2312", "1location","TypeofBar",70,40,"asdf","no","rest","explain", 
	    		"hisbar dfajsdflsadjfljsdlakjfsdfasdfjasdjflsdjlfjaslkdjflkjsaiteofdjfsdkjfaiwejtjsdfjsdfjaoeitjadsfjsadf");
	    new Bar("Norana","DumbBar", "WhontoPhoto", "010-231-2312", "1location","TypeofBar",90,100,"asdf","no","rest","explain", "title");
		
		
		
			//client defaults
		new client1("ToToro","123","SungHo","region","jumin1","jumin2","Worker","asdf","sdfsd","sdfsd","sdfsdf","dsfsdf",11,12,0);
		new client1("May","123","KimHa","region","jumin1","jumin2","Worker","asdf","sdfsd","sdfsd","sdfsdf","dsfsdf",11,12,0);
		new client1("Nissan","123","Hanzo","region","jumin1","jumin2","Worker","asdf","sdfsd","sdfsd","sdfsdf","dsfsdf",11,12,0);

			
		new Coupons("May_0","sdfsdf","Coupontest","Coupontest",12);
		new Coupons("Toro_0","sdfsdf","Coupontest","Coupontest",10);
		new Coupons("Nissan_0","sdfsdf","Coupontest","Coupontest",10);
		new Coupons("Nissan_0","sdfsdf","Coupontest","Coupontest",20);
		new Coupons("Oracle_0","sdfsdf","Coupontest","Coupontest",20);

		
		new BarOwner("Oracle");

	}

}
