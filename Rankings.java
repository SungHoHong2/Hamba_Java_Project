package BC_1;
import BC_1.Database;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;



class RankCal extends Frame
{
	static String usersid= null;
	static String usersregion = null;
	static int usersbarm = 0;
	static int usersbarc = 0;
		
	static String clickerbeauty = "Nothing";
	
	int couponNum;
	int score;
	
	int []Rank = new int[10];
	String []Name=new String[10];
	Panel []bottomPan = new Panel[4];
	String tempid;
	
	
	RankCal(String tempid)
	{

		this.tempid=tempid;
		
		try {
			new FindRankingID(tempid);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		System.out.println(usersid+" "+usersregion+" from the database");
		
		addWindowListener(new Close_c());
		setBounds(900,0,500,755);
		setLayout(null);
		
		Panel YourStatus = new Panel();
		YourStatus.setBackground(Color.pink);
		YourStatus.setBounds(300,80,200,50);
		YourStatus.setLayout(new FlowLayout());
		
		Label region = new Label("Your Region");
		
		if(clickerbeauty.equals("Address"))
			region.setBackground(Color.yellow);
			
		YourStatus.add(region);
	
		
		Label price = new Label("Price");
	     
		if(clickerbeauty.equals("Price"))
			price.setBackground(Color.yellow);
	    	 
		YourStatus.add(price);
		
		Label Mood = new Label("Mood");
		
		if(clickerbeauty.equals("Mood"))
			Mood.setBackground(Color.yellow);
			
		YourStatus.add(Mood);

		YourStatus.add(new Label(usersregion));
		
		if(usersbarc==0)
		YourStatus.add(new Label("Cheap"));
		
		else if(usersbarc==1)
			YourStatus.add(new Label("Economic"));
		
		else if(usersbarc==2)
			YourStatus.add(new Label("Expensive"));
		
		if(usersbarm==0)
		YourStatus.add(new Label("Quiet"));
		
		else if(usersbarm==1)
			YourStatus.add(new Label("Normal"));
		
		else if(usersbarm==2)
			YourStatus.add(new Label("Noisy"));
		
		
		
		add(YourStatus);
		
		Panel top, bottom;
		top=new Panel();
		top.setBackground(new Color(217,68,68));
		top.setBounds(0,20,500,60);
		top.setLayout(null);
		
		
		Button Atmos = new Button("Atmos");
		Atmos.setBounds(50,20,100,50);
		
		Button Price = new Button("Price");
		Price.setBounds(150,20,100,50);

		Button Address = new Button("Address");
		Address.setBounds(250,20,100,50);

		Button smoking = new Button("Smoke");
		smoking.setBounds(350,20,100,50);

		
		Atmos.addActionListener(new AtmosWin());
		Price.addActionListener(new PriceWin());
		Address.addActionListener(new AddressWin());
		smoking.addActionListener(new SmokeWin());
		
		top.add(Atmos);
		top.add(Price);
		top.add(Address);
		top.add(smoking);
		
		
		
		bottom= new Panel();
		bottom.setLayout(new GridLayout(4,0));
		bottom.setBounds(0,100,650,650);

	
		Iterator it2 = Bar.ranking.entrySet().iterator();
		
		String [][] rankingtemp = new String[11][13]; //using for rankings straight up  
		int bufnum = Bar.ranking.entrySet().size()-1; 
	
		rankingtemp[0][0] = "Bar_Image/NoSearch.png";
		rankingtemp[1][0] = "Bar_Image/NoSearch.png";
		rankingtemp[2][0] = "Bar_Image/NoSearch.png";
		rankingtemp[3][0] = "Bar_Image/NoSearch.png";
		
		
		while(it2.hasNext())
		{
			Map.Entry e = (Entry) it2.next();
			int score = (int) e.getKey();
			BarInfo tt2 = (BarInfo) e.getValue();

			String buf = tt2.photo;
			int buf2 = buf.lastIndexOf('_');
			int buf4 = buf.lastIndexOf('/');
			int buf5 = buf.lastIndexOf('.');
			
			String buf3 = buf.substring(0,buf2);
			String buf6 = buf.substring(buf4+1,buf5);
			
			
			rankingtemp[bufnum][0] = tt2.photo;
			rankingtemp[bufnum][1] = ""+score;
			rankingtemp[bufnum][2] = tt2.name;
			rankingtemp[bufnum][3] = tt2.address;
			rankingtemp[bufnum][4] = tt2.typeofBar;
			rankingtemp[bufnum][5] = tt2.phone;
			rankingtemp[bufnum][6] = tt2.explain;
			rankingtemp[bufnum][7] = tt2.smoke;
			rankingtemp[bufnum][8] = tt2.rest;
			rankingtemp[bufnum][9] = tt2.restroom;
			
			if(tt2.Barprice==0)
			rankingtemp[bufnum][10] = "Cheap";
			
			else if(tt2.Barprice==1)
				rankingtemp[bufnum][10] = "Economic";
			
			else if(tt2.Barprice==2)
				rankingtemp[bufnum][10] = "Expensive";
			
			
			if(tt2.BarAtmos==0)
				rankingtemp[bufnum][11] = "Quiet";
			
			if(tt2.BarAtmos==1)
				rankingtemp[bufnum][11] = "Medium";
			
			if(tt2.BarAtmos==2)
				rankingtemp[bufnum][11] = "Noisy";

			
				
			rankingtemp[bufnum][12]= buf6;
			
			System.out.println(rankingtemp[bufnum][0]+ "information from rankingtemp Array");				
			bufnum--;
		}
		
		Bar.ranking.clear(); //reseting the map! 
		
		ImageIcon bufimage;
		JButton bufphoto;
		
		for(int i=0; i<4; i++)
		{
			bottomPan[i] = new Panel();	
			bottomPan[i].setLayout(null);
		    
			Font RedScore = new Font("AppleGothic",Font.PLAIN,20);
			
			Label score = new Label(rankingtemp[i][1]);
			score.setBounds(190,0,50,30);
			score.setFont(RedScore);
			score.setForeground(Color.RED);
			bottomPan[i].add(score);

			
			Label Region = new Label("Region");     ///
			Region.setBounds(190,35,100,30);
			bottomPan[i].add(Region);
			
			Label Address2 = new Label("Price");
			Address2.setBounds(190,70,100,30);
			bottomPan[i].add(Address2);
			
			Label TypeofBar = new Label("Mood");
			TypeofBar.setBounds(190,105,100,30);
			bottomPan[i].add(TypeofBar);
		
			
			Label Phone = new Label(rankingtemp[i][3]);  ///
			Phone.setBounds(300,35,100,30);
			bottomPan[i].add(Phone);
		
						
			Label Smoke = new Label(rankingtemp[i][10]);
			Smoke.setBounds(300,70,100,30);
			bottomPan[i].add(Smoke);
			
			Label Rest = new Label(rankingtemp[i][11]);
			Rest.setBounds(300,105,100,30);
			bottomPan[i].add(Rest);
		
	    	bufimage = new ImageIcon(rankingtemp[i][0]);
			bufphoto = new JButton(bufimage);
			bufphoto.addActionListener(new GoBarSpecific(rankingtemp[i][12]));
			bufphoto.setBounds(30,0,150,150);
		
			bottomPan[i].add(bufphoto);
				
			for(int s=1; s<12; s++)
			bottomPan[i].add(new Label(rankingtemp[i][s]));
			
			
			bottom.add(bottomPan[i]);
		}
		
		add(top);
		add(bottom);
		setVisible(true);		
	}

	
	
	
	class GoBarSpecific implements ActionListener
	{
		
		String buf;
		GoBarSpecific(String buf)
		{
			this.buf = buf;
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
	
			System.out.println(buf + " from the GoBarSpecific");
			new BarSpecific(buf);
		}	
	}
	
	
	
	class AtmosWin implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Iterator it = Bar.Bars2.entrySet().iterator();
			
			while(it.hasNext())
			{
				Map.Entry e2 = (Entry) it.next();
				BarInfo tt = (BarInfo) e2.getValue();
			
				clickerbeauty = "Mood";
				
				int temp;
				
				System.out.println(usersbarm+ " vs "+tt.BarAtmos);
				
				if(usersbarm == tt.BarAtmos) 
				{
					temp=90+(int)(Math.random()*10);
				}
				
				else if(usersbarm==2 && tt.BarAtmos==1)
				{
					temp=(int)(Math.random()*51);
				}
				
				else if(usersbarm==1 && tt.BarAtmos==0)
				{
					temp=(int)(Math.random()*51);
				}
				
				else if(usersbarm==0 && tt.BarAtmos==1)
				{
					temp=(int)(Math.random()*51);
				}
				
				else
					temp=(int) (Math.random()*20);
				
				Bar.ranking.put(temp, new BarInfo(tt.name, tt.photo, tt.phone, tt.address, tt.typeofBar, 
						tt.Barprice, tt.BarAtmos,
						tt.time, tt.rest, tt.smoke, tt.restroom, tt.explain));
		
				System.out.println(tt.photo+" : "+temp+" before going to the ranking TreeMap");
			}
			
			dispose();
			new RankCal(tempid);
			
		}
	}
	
	
	class PriceWin implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			clickerbeauty = "Price";

			
			Iterator it = Bar.Bars2.entrySet().iterator();
			
			while(it.hasNext())
			{
				Map.Entry e2 = (Entry) it.next();
				BarInfo tt = (BarInfo) e2.getValue();
											
				int temp;
				
				System.out.println(usersbarc+ " vs "+tt.Barprice);
				
				if(usersbarc == tt.Barprice) 
				{
					temp=90+(int)(Math.random()*10);
				}
				
				else if(usersbarc==2 && tt.Barprice==1)
				{
					temp=(int)(Math.random()*51);
				}
				
				else if(usersbarc==1 && tt.Barprice==0)
				{
					temp=(int)(Math.random()*51);
				}
				
				else if(usersbarc==0 && tt.Barprice==1)
				{
					temp=(int)(Math.random()*51);
				}
				
				else
					temp=(int) (Math.random()*20);
				
				Bar.ranking.put(temp, new BarInfo(tt.name, tt.photo, tt.phone, tt.address, tt.typeofBar, 
						tt.Barprice, tt.BarAtmos,
						tt.time, tt.rest, tt.smoke, tt.restroom, tt.explain));
		
				System.out.println(tt.photo+" : "+temp+" before going to the ranking TreeMap");
			}
			
			dispose();
			new RankCal(tempid);
			
		}
	}
	
	
	class AddressWin implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			clickerbeauty = "Address";

			
			Iterator it2 = client1.clients.entrySet().iterator();
			String clientAddress="";
			
			while(it2.hasNext())
			{
				Map.Entry e3 = (Entry) it2.next();
				
				System.out.println(tempid+" : "+e3.getKey()+ "matches int the AddressWin");

				if(tempid.equals(e3.getKey()))
				{
					client1input eee = (client1input) e3.getValue();
					clientAddress=eee.region;
				}
			}
			
			
			Iterator it = Bar.Bars2.entrySet().iterator();
			int temp=0;
			while(it.hasNext())
			{
			
				Map.Entry e2 = (Entry) it.next();
				
				BarInfo tt = (BarInfo) e2.getValue();
							
				String barkey = (String) e2.getKey();
				String AddressNum = tt.address;
				
				if(tt.address.equals(clientAddress))
					temp=100;

				
				else
					temp=(int) (Math.random()*20);
				
				Bar.ranking.put(temp, new BarInfo(tt.name, tt.photo, tt.phone, tt.address, tt.typeofBar, 
						tt.Barprice, tt.BarAtmos,
						tt.time, barkey, tt.smoke, tt.restroom, tt.explain));
		
				System.out.println(tt.photo+" : "+temp+" before going to the ranking TreeMap");
			}
			
			dispose();
			new RankCal(tempid);
			
		}
	}
	
	
	
	class SmokeWin implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Iterator it = Bar.Bars2.entrySet().iterator();
			
			while(it.hasNext())
			{
				Map.Entry e2 = (Entry) it.next();
				BarInfo tt = (BarInfo) e2.getValue();
			
				clickerbeauty = "Smoke";
				
				int temp;
				
				
				if(tt.smoke =="NonSmoke") 
				{
					temp=90+(int)(Math.random()*10);
				}
				
				else
					temp=(int) (Math.random()*20);
				
				
				Bar.ranking.put(temp, new BarInfo(tt.name, tt.photo, tt.phone, tt.address, tt.typeofBar, 
						tt.Barprice, tt.BarAtmos,
						tt.time, tt.rest, tt.smoke, tt.restroom, tt.explain));
		
				System.out.println(tt.photo+" : "+temp+" before going to the ranking TreeMap");
			}
			
			dispose();
			new RankCal(tempid);
			
		}
	}
	
}






public class Rankings extends Frame{
	
	Rankings()
	{		
		RankCal tempboard = new RankCal("test");
		

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
