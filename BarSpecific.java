package BC_1;
import BC_1.*;
import BC_1.Main.Specific;
import BC_1.Main_Users.UseCoupon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

class Gathering
{
	static String[] SpecificBarInfo = new String[10];
	static String temp;
	static int [] totalSum = new int[4];
	
	public Gathering(String temp)  //used while opening the specifics 
	{
		this.temp=temp;
		int total = 0;

		System.out.println(temp+" test");
		
		Iterator its2 = BarComment.commentbox.entrySet().iterator();
		
				
		while(its2.hasNext())
		{
			Map.Entry ee = (Entry) its2.next();
			
			System.out.println(ee.getKey().equals(temp+"_"+Main_Users.loggedID)+" before going tin");
		
			if(ee.getKey().equals(temp+"_"+Main_Users.loggedID))
			{
				BarCommentInput temp3 = (BarCommentInput) ee.getValue();
				total+=temp3.stars;
				new	BarTotalScore(temp+"_"+Main_Users.loggedID, total); //adding the sums 
			}
		}
		
		
		Iterator its = Bar.Bars2.entrySet().iterator();
		
		while(its.hasNext())
		{
			Map.Entry e = (Entry) its.next();
			BarInfo temp2 = (BarInfo) e.getValue();	
			
			if(e.getKey().equals(temp))
			{		
				SpecificBarInfo[0]=(String)e.getKey();
				SpecificBarInfo[1]=temp2.photo;
				SpecificBarInfo[2]=temp2.explain;
				SpecificBarInfo[3]=temp2.phone;
				SpecificBarInfo[4]=temp2.address;
				SpecificBarInfo[5]=temp2.smoke;
				SpecificBarInfo[6]=temp2.time;
				SpecificBarInfo[7]=temp2.typeofBar;
				SpecificBarInfo[8]=temp2.name;
				
				break;
			}
		}
	}
}



public class BarSpecific extends Frame {

	static String buf;
	TextField summit;
	TextField summit2;
	
	BarSpecific(String buf)
	{
		

		try {
			new bartotalreceive();
		} catch (Exception e9) {
			// TODO Auto-generated catch block
			e9.printStackTrace();
		}
		
		
		try {
			new couponboothreceive();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		this.buf=buf;
		setBounds(900,0,500,755);
		setLayout(null);
		new Gathering(buf);
	
		addWindowListener(new Close_c());
		
		Button goback = new Button("go back");
		goback.setBounds(405,30,85,40);
		goback.setBackground(new Color(217,68,68));
		goback.addActionListener(new Btnaction());
		add(goback);
		
		
		Label BarBanner = new Label(Gathering.SpecificBarInfo[8]);
		BarBanner.setBounds(0,20,500,60);
		BarBanner.setBackground(new Color(217,68,68));
		BarBanner.setForeground(Color.white);
		add(BarBanner);
		
		Button Menus = new Button("Menus");
		Menus.setBounds(25,260,90,40);
		Menus.addActionListener(new MenuSee(Gathering.SpecificBarInfo[0]));
		add(Menus);
		
		Label Owner = new Label("Owner : "+Gathering.SpecificBarInfo[0]);
		Owner.setBounds(220,100,150,30);
		add(Owner);

		Label Phone = new Label("Phone : "+Gathering.SpecificBarInfo[3]);
		Phone.setBounds(220,150,150,30);
		add(Phone);
		
		Label Address = new Label("Address : "+Gathering.SpecificBarInfo[4]);
		Address.setBounds(220,200,150,30);
		add(Address);
		
		Label Smoke = new Label("Smoke : "+Gathering.SpecificBarInfo[5]);
		Smoke.setBounds(220,250,150,30);
		add(Smoke);
		
		Label Time = new Label("Time : "+Gathering.SpecificBarInfo[6]);
		Time.setBounds(220,300,150,30);
		add(Time);
		
		TextArea Expl = new TextArea(Gathering.SpecificBarInfo[2]);
		Expl.setBounds(220,350,250,100);
		add(Expl);
			
		
		ImageIcon ImgCon = new ImageIcon(Gathering.SpecificBarInfo[1]);
		JLabel photoBar = new JLabel(ImgCon);
		photoBar.setBounds(20,100,150,150);
		add(photoBar);
		
	
		Label commentline = new Label("Comments");
		commentline.setBackground(Color.LIGHT_GRAY);
		commentline.setBounds(0,470,150,40);
		
		summit = new TextField();
		summit.setBounds(0,520,500,50);			
		add(commentline);
		
    	Label commentline2 = new Label("Star Score (1 ~ 5)");
    	commentline2.setBackground(Color.LIGHT_GRAY);
    	commentline2.setBounds(150,470,150,40);
    	add(commentline2);
    	
    	summit2 = new TextField();
    	summit2.setBounds(300,470,250,40);
    	add(summit2);
    	
    	
    	Button insert = new Button("Comments");
    	insert.setBounds(110,580,100,50);
    	insert.addActionListener(new insertComments());
    	add(insert);
    	
    	Button insert2 = new Button("Others");
    	insert2.setBounds(270,580,100,50);
    	insert2.addActionListener(new otherComments());
    	
    	add(insert2);
    	
    	
    	Iterator it4 = BarTotalScore.bartotalbox.entrySet().iterator();
    	
    	Label scorelist;
    	
		ImageIcon starImg = new ImageIcon("images/star.png");
    	
		////


		
		////
		
    	while(it4.hasNext())
    	{
    		Map.Entry eee = (Entry) it4.next();
    		String bufid = (String) eee.getKey();
    		int bufslash = bufid.lastIndexOf('_');
    		String bufid2=bufid.substring(0,bufslash);
    		
    		if(bufid2.equals(Gathering.temp))
    		{
	    	 
    	    	int bufscore = (int) eee.getValue(); 
    	    
    	    if(bufscore>10)
			{
			JLabel star = new JLabel(starImg);
			star.setBounds(100,650,100,100);
			add(star);
			
			if(bufscore>20)
			{
			JLabel star2 = new JLabel(starImg);
			star2.setBounds(150,650,100,100);
			add(star2);
			
			if(bufscore>50)
			{
			JLabel star3 = new JLabel(starImg);
			star3.setBounds(200,650,100,100);
			add(star3);
			
			if(bufscore>70)
			{
			JLabel star4 = new JLabel(starImg);
			star4.setBounds(250,650,100,100);
			add(star4);
			
			if(bufscore>90)
			{
			JLabel star5 = new JLabel(starImg);
			star5.setBounds(300,650,100,100);
			add(star5);
			}
			}
			}
			}
			}	    	
    		}
    	}
    	
    	
    	int i=0;
    	Iterator it2 = BarCouponbooth.BarCoupons.entrySet().iterator();
		String bufCouponID[] = new String[BarCouponbooth.BarCoupons.size()];
    	
		Button []CouponClicker = new Button[4];
		
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
			
			
			if(Gathering.temp.equals(Couponlistid))
			{						
				BarCouponbooth.CouponNumbers[i]++;	
				bufCouponID[i]=Couponid.substring(0,slash+1);
			}
		}
    	
    	
		ImageIcon couponImg = new ImageIcon("images/couponicon.png");
		JLabel CouponSee = new JLabel(couponImg);
		CouponSee.setBounds(20,300,50,50);
		
		CouponClicker[i] = new Button(""+BarCouponbooth.CouponNumbers[i]);
		CouponClicker[i].setBounds(80,315,30,30);
		CouponClicker[i].addActionListener(new UseCoupon(bufCouponID[i],BarCouponbooth.CouponNumbers[i]));
		
		add(CouponSee);
		add(CouponClicker[i]);

		
		add(commentline);
		add(summit);
		add(commentline2);
		add(summit2);
		
             
		setVisible(true);
	
	}
	
	
	class otherComments implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new otherCommentsFrame();
		}

	}
	
	class otherCommentsFrame extends Frame
	{
		otherCommentsFrame()
		{
			
			try {
				new BarComentRecieve();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println(Gathering.temp+" Gatheringtemp");
			
			try {
				new CommentCollector(Gathering.temp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(SpecificComments.tempcomment.entrySet()+" from the barcomment oracle");
			
			
			addWindowListener(new Close_c());
			setBounds(400,0,500,500);
			setLayout(null);
			
			Label BarBanner2 = new Label("Other Comments");
			
			BarBanner2.setBounds(0,20,500,60);
			BarBanner2.setBackground(new Color(217,68,68));
			BarBanner2.setForeground(Color.white);
		
			ScrollPane sp = new ScrollPane();
			sp.setBounds(0,80,520,350);
			
			Iterator it = SpecificComments.tempcomment.entrySet().iterator();
			
			Panel commentbox = new Panel();
			commentbox.setBounds(0,80,500,1000);
			commentbox.setLayout(null);
			commentbox.setBackground(Color.LIGHT_GRAY);
		
			JLabel [] photo = new JLabel[SpecificComments.tempcomment.size()];
			Label [] Person= new Label[SpecificComments.tempcomment.size()];
			Label [] commentline= new Label[SpecificComments.tempcomment.size()];
			Label [] Stars= new Label[SpecificComments.tempcomment.size()];
			ImageIcon starImg = new ImageIcon("images/star.png");

			int i = 0;
			
			while(it.hasNext())
			{

				Map.Entry eee = (Entry) it.next();
				SpecificCommentsinput ee = (SpecificCommentsinput) eee.getValue();
	
				String buf = (String) eee.getKey();
				int bufking = buf.lastIndexOf('_');
				String buf2 = buf.substring(bufking+1);
				String buf3 = buf.substring(0,bufking);
				
				if(buf3.equals(Gathering.temp))
				{
				
				
				ImageIcon buffing = new ImageIcon("BC_1_image/"+buf2+"_1.png");
				Image img = buffing.getImage();
				Image newImg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
				buffing = new ImageIcon(newImg);
				
				
				photo[i]=new JLabel(buffing);
			    photo[i].setBounds(10,10+i*100,50,50);
				
				Person[i] = new Label(buf2);
				Person[i].setBounds(70,10+i*100,50,50);
			
				commentline[i] =  new Label(ee.comments);
				commentline[i].setBounds(90,10+i*100,200,50);
						
				
				
				Stars[i] = new Label(""+ee.stars);
				if(ee.stars>10)
				{
				JLabel star = new JLabel(starImg);
				star.setBounds(240,0+i*100,100,100);
				commentbox.add(star);
				
				if(ee.stars>20)
				{
				JLabel star2 = new JLabel(starImg);
				star2.setBounds(280,0+i*100,100,100);
				commentbox.add(star2);
				
				if(ee.stars>50)
				{
				JLabel star3 = new JLabel(starImg);
				star3.setBounds(320,0+i*100,100,100);
				commentbox.add(star3);
				
				if(ee.stars>70)
				{
				JLabel star4 = new JLabel(starImg);
				star4.setBounds(360,0+i*100,100,100);
				commentbox.add(star4);
				
				if(ee.stars>90)
				{
				JLabel star5 = new JLabel(starImg);
				star5.setBounds(400,0+i*100,100,100);
				commentbox.add(star5);
				}
				}
				}
				}
				}		
				
								
				
				commentbox.add(photo[i]);
				commentbox.add(Person[i]);
				commentbox.add(commentline[i]);
				commentbox.add(Stars[i]);
				
				i++;
				}
			}
			
			
			
			Panel mycomments = new Panel();
			mycomments.setBounds(0,400,500,100);
			mycomments.setLayout(new FlowLayout());
		
			

			
			
		
			add(mycomments);

			
			sp.add(commentbox);
			add(sp);
			add(BarBanner2);
			setVisible(true);
		};
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
						
			try {
				new removeBoothOracle(buf+num).CouponDestroy();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			};			
			
			
			BarCouponbooth.BarCoupons.remove(buf+num);
		
			
		
			
			new clientCoupon(Main_Users.loggedID+"*"+buf+num, "Coupons");
			
			System.out.println(clientCoupon.clientCoupons+" inserted Coupons to Customers");
			System.out.println(buf+num+" trying to remove");
			System.out.println(BarCouponbooth.BarCoupons+"  leftovers");

			dispose();	
			  new BarSpecific(Gathering.temp);
		}
	}
	
	
	class insertComments implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
	
			
			int buffer = Integer.parseInt(summit2.getText());
			
			new BarComment(Gathering.temp+"_"+Main_Users.loggedID, summit.getText(), buffer);
	
			System.out.println(Gathering.temp+"_"+Main_Users.loggedID+" point going to the database");
			System.out.println(buffer+" point going to the database");
			System.out.println(summit.getText()+" point going to the database");
				
			dispose();
			
			new BarSpecific(buf);
		}
	}
	

	
	
	class Btnaction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(Main.loginFlag==false)
			{
				dispose();
				new Main();
			}
			
			if(Main.loginFlag==true)
			{
				dispose();
				new Main_Users(Main_Users.loggedID);
			}
		}
	}
	
	
	class MenuSee implements ActionListener
	{
		String barname;

		public MenuSee(String barname) {
			this.barname = barname;		
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			new Menus(barname);

		}		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  new Bar("Oracle","SuperBar", "Bar_Image/Oracle.png", "010-231-2312", "1location","TypeofBar",50,20,"asdf","no","rest","explain", 
		    		"hisbar dfajsdflsadjfljsdlakjfsdfasdfjasdjflsdjlfjaslkdjflkjsaiteofdjfsdkjfaiwejtjsdfjsdfjaoeitjadsfjsadf");
		    
		  new BarSpecific("Oracle");
	}

}
