package BC_1;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import BC_1.Register3.addAction;
import BC_1.Register3.btnActionBar;




class Register1 extends Frame
{
	
	Button nextbtn;
	Button imagepush;
	Button close;
	FileDialog fd1;
	static String imagefilename="Bar_Image/NoSearch.png";
	ImageIcon ImageFilebuf;
	static String barname;  //didnt descided whether to use this as an id or the barname, but id is more.. 
	
	static String iname, iphone, iaddress, itypeofbar,iprice, iatmos;

	Label lbl_name,lbl_phone,lbl_Address,lbl_TB,lbl_set,lbl_pr,lbl_pr_2,lbl_Ats,lbl_Ats2,lbl3;
	JLabel lbl_image;
	TextField name, phone, Address, TypeofBar, Price, Atmosphere;
	Choice choice;
	private JSlider slider,slider2;
	Panel imagepPanel;
	Panel panel;
	
	Dialog dd3 = new Dialog(this, "Addmenu", true);
	TextField food = new TextField();
	TextField price = new TextField();
	Button addbtn = new Button();
	 int resx;
	  int resy;
	  String Tb = "";
	  
	 String slx = "";
	 String sly = "";
	
	
	
	Register1(String barname)
	{
		addWindowListener(new Close_c());

		this.barname = barname;
		//String defaultImg = "btn.png";
		fd1 = new FileDialog(this,"Select file to Open");
		
		
		  
		setBounds(250,35,635,700);
		setBackground(new Color(255, 255, 153));
		setLayout(null);
		imagepush = new Button("Image");	
		imagepush.addActionListener(new PhotoInput());
		
		imagepPanel = new Panel();
		lbl_name = new Label("name : ");
		lbl_phone = new Label("phone : ");
		lbl_Address = new Label("Address : ");
		lbl_TB = new Label("TypeofBar : ");
		lbl_set = new Label("°ÿMust Select the Atmosphere and Price Slider");
		lbl_pr = new Label("Atmosphere:");
		lbl_pr_2 = new Label("Common");
		lbl_Ats = new Label("price: ");
		lbl_Ats2 = new Label("Common");
		
		lbl_image = new JLabel("Regist");
				
		
		 name = new TextField();
		 phone = new TextField();
		 Address = new TextField();
		 TypeofBar = new TextField();
		 Price = new TextField();
		 Atmosphere = new TextField();
		
		 choice = new Choice();
		 slider = new JSlider();
		 slider2= new JSlider();
		 
		 Panel panel = new Panel();
			panel.setBounds(0, 0, 630, 79);
			panel.setBackground(new Color(255,153,102));
			add(panel);
			panel.setLayout(null);
			
			Label label_10 = new Label("BarAdd");
			label_10.setFont(new Font("Segoe UI", Font.PLAIN, 23));
			label_10.setBounds(10, 20, 235, 69);
			panel.add(label_10);
		lbl_name.setBounds(342, 89, 69, 23);
		 add(lbl_name);
		 
		 name.setBounds(417, 85, 192, 33);
		 add(name);
		
		 lbl_phone.setBounds(342, 139, 69, 23);
		 add(lbl_phone);
		 
		 phone.setBounds(417, 135, 192, 33);
		 add(phone);
		
		 lbl_Address.setBounds(342, 191, 69, 23);
		 add(lbl_Address);
		 
		 Address.setBounds(417, 187, 192, 33);
		 add(Address);
		 
		 lbl_TB.setBounds(342, 288, 69, 23);
		 add(lbl_TB);
		 
		 choice.setBounds(510, 288, 108, 21);
		 choice.add("Select");
		 choice.add("Bar");
		 choice.add("Hope");
		 choice.add("Garden");
		 choice.add("CartBar");
		 choice.addItemListener(new choicelis());
		 add(choice);
		 
		 lbl_set.setBounds(345, 355, 300, 23);
		 add(lbl_set);
		 
		 slider.setBounds(381, 406, 200, 26);
		 slider.setValue(1);
		 slider.setBackground(new Color(204, 255, 153));
		 slider.setMaximum(2);
		 add(slider);
		 slider.addChangeListener(new slideraction());
		 
		 lbl_pr.setBounds(342, 438, 75, 23);
		 add(lbl_pr);
		 
		 lbl_pr_2.setBounds(540, 438, 69, 23);
		 add(lbl_pr_2);
		 
		 slider2.setBounds(381,510, 200, 26);
		 slider2.setBackground(new Color(204, 255, 102));
		 slider2.setValue(1);
		 slider2.setMaximum(2);
		 add(slider2);
		 slider2.addChangeListener(new slideraction());
		 
		 lbl_Ats.setBounds(342, 553, 69, 23);
		 add(lbl_Ats);
		 
		 lbl_Ats2.setBounds(540, 553, 69, 23);
		 add(lbl_Ats2);
		
		imagepush.setBounds(0, 448,336,67);
		imagepush.setBackground(new Color(102,254,153));
		add(imagepush);
		
		
		ImageFilebuf= new ImageIcon(imagefilename);
		imagepPanel.setBounds(0, 80, 336, 349);
		imagepPanel.setBackground(new Color(204,255,153));
		imagepPanel.add(new JLabel(ImageFilebuf));
		add(imagepPanel);
		
		close = new Button("close");
		close.setBounds(15, 596, 213, 65);
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		} );
		add(close);
		
		nextbtn = new Button("next");
		nextbtn.setBounds(406, 596, 213, 65);
		nextbtn.addActionListener(new btnActionBar(barname));
		
	
		add(nextbtn);
		setVisible(true);
	}
	
	class Photocheck extends Frame
	{
		Photocheck(String bufimagefile)
		{
			setBounds(0,0,100,100);
			setLayout(new FlowLayout());
			
			ImageIcon checkImage = new ImageIcon(bufimagefile);
			JLabel imagecheck= new JLabel(checkImage);
			
			System.out.println(bufimagefile); ///testing the source of image 
			add(new Label("dfsdfds"));
			add(imagecheck);
			
			setVisible(true);	
		}
	}
	
	
	class PhotoInput implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			fd1.setVisible(true);
			System.out.println(fd1.getDirectory()+fd1.getFile());

			try {
				
				FileInputStream fis = new FileInputStream(fd1.getDirectory()+fd1.getFile());
				FileOutputStream fout = new FileOutputStream("Bar_Image/"+barname+".png");
				
				int data = 0;
				try {
					while((data=fis.read())!=-1)
					{
						char ch = (char) data;
						System.out.print(ch);
						fout.write(data);
					}
					} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				
				imagefilename= "Bar_Image/"+barname+".png";						
				dispose();
				new Register1(barname);
					
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
		}
	}
	class slideraction implements ChangeListener
	{
		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()== slider){
			    int x = slider.getValue();
			    resx = x;
			    
			    if(slider.getValue()==0)
			    {
			    lbl_pr_2.setText("slience");
			    resx=0;
			    }
			    else if(slider.getValue()==1)
			    {
			    	lbl_pr_2.setText("common");
			    	resx=1;
			    }
			    else if(slider.getValue()==2)
			    {
			    	lbl_pr_2.setText("noisy");
			    	resx=2;
			    }
			  slx = Integer.toString(resx);
			   
			   }
			   if(e.getSource()== slider2){
			     int y = slider2.getValue();
			     resy = y;
			     
			     if(slider2.getValue()==0)
			     {
			     lbl_Ats2.setText("cheap");
			     resy=0;
			     }
			     else if(slider2.getValue()==1)
			     {
			    	 lbl_Ats2.setText("common");
			    	 resy=1;
			     }
			     else if(slider2.getValue()==2)
			     {
			    	 lbl_Ats2.setText("High-price");
			    	 resy=2;
			     }
			     
				   sly = Integer.toString(resy);
			   }
			  
			   
		}
		
	}
	 class choicelis implements ItemListener
	 {
	  String item;
	  @Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
		  if(e.getSource() == choice )
		   {
		   Choice choice = (Choice)e.getSource();
		   item = choice.getSelectedItem();
		   Tb = item;
		}
	  }
	 }
	
	class btnActionBar implements ActionListener
	{
		String buf;
		
		btnActionBar(String buf)
		{
			this.buf=buf;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			dispose();
			new Register2(buf);
			

			iname = name.getText();
			iphone = phone.getText();
			iaddress = Address.getText();
			itypeofbar = Tb;
			iprice = slx;
			iatmos = sly;
			
			System.out.println(Register1.iprice + "from Slider ACtion");

		}
	}
}


class Register2 extends Frame
{
	
	static String cw, cr, cs, cb, ex;

	String barname;
	
	Button befobtn;
	Button nextbtn;
	
	Label lblwk,lblrt,lblsmk,lblrr,lblexp;
	Choice ch1,ch2,ch3,ch4,ch5,ch6;
	TextField Explain;
	 String ch1_1 ="";
	 String ch2_1 ="";
	 String ch3_1 ="";
	 String ch4_1 ="";
	 String ch5_1 ="";
	 String ch6_1 ="";
	
	Register2(String barname)
	{
		this.barname = barname;
		setBounds(250,35,635,700);
		setBackground(new Color(255, 255, 153));
		setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 630, 79);
		panel.setBackground(new Color(255, 153, 102));
		add(panel);
		panel.setLayout(null);
		
		Label label = new Label("BarAdd2");
		label.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		label.setBounds(10, 20, 235, 69);
		panel.add(label);
		lblwk = new Label("Working Time");
		lblrt = new Label("RestTime");
		lblsmk = new Label("Smoke");
		lblrr = new Label("RestRoom");
		lblexp = new Label("Explain");
		
		ch1 = new Choice();
		ch2 = new Choice();
		ch3 = new Choice();
		ch4 = new Choice();
		ch5 = new Choice();
		ch6 = new Choice();
		
		Explain = new TextField();
		
		lblwk.setBounds(38, 127, 69, 23);
		add(lblwk);
		
		lblrt.setBounds(38, 235, 69, 23);
		add(lblrt);
		
		lblsmk.setBounds(38, 343, 100, 23);
		add(lblsmk);
		
		lblrr.setBounds(38, 437, 69, 23);
		add(lblrr);
		
		lblexp.setBounds(38, 529, 69, 23);
		add(lblexp);
		
		Label label_6 = new Label("-");
		label_6.setBounds(210, 127, 18, 23);
		add(label_6);
		
		Label label_7 = new Label("-");
		label_7.setBounds(210, 235, 18, 23);
		add(label_7);
		
		ch1.setBounds(128, 127, 76, 21);
		ch1.add("Select");
		ch1.add("00H");ch1.add("01H");ch1.add("02H");ch1.add("03H");
		ch1.add("04H");ch1.add("05H");ch1.add("06H");ch1.add("07H");
		ch1.add("08H");ch1.add("09H");ch1.add("10H");ch1.add("11H");
		ch1.add("12H");ch1.add("13H");ch1.add("14H");ch1.add("15H");
		ch1.add("16H");ch1.add("17H");ch1.add("18H");ch1.add("19H");
		ch1.add("20H");ch1.add("21H");ch1.add("22H");ch1.add("23H");
		
		ch1.setBackground(new Color(255, 255, 204));
		ch1.addItemListener(new choicelis());
		add(ch1);
		
		ch2.setBounds(234, 127, 69, 21);
		ch2.add("Select");
		ch2.add("00H");ch2.add("01H");ch2.add("02H");ch2.add("03H");
		ch2.add("04H");ch2.add("05H");ch2.add("06H");ch2.add("07H");
		ch2.add("08H");ch2.add("09H");ch2.add("10H");ch2.add("11H");
		ch2.add("12H");ch2.add("13H");ch2.add("14H");ch2.add("15H");
		ch2.add("16H");ch2.add("17H");ch2.add("18H");ch2.add("19H");
		ch2.add("20H");ch2.add("21H");ch2.add("22H");ch2.add("23H");
		ch2.addItemListener(new choicelis());
		add(ch2);
		
		ch3.setBounds(128, 235, 76, 21);
		ch3.add("Select");
		ch3.add("00H");ch3.add("01H");ch3.add("02H");ch3.add("03H");
		ch3.add("04H");ch3.add("05H");ch3.add("06H");ch3.add("07H");
		ch3.add("08H");ch3.add("09H");ch3.add("10H");ch3.add("11H");
		ch3.add("12H");ch3.add("13H");ch3.add("14H");ch3.add("15H");
		ch3.add("16H");ch3.add("17H");ch3.add("18H");ch3.add("19H");
		ch3.add("20H");ch3.add("21H");ch3.add("22H");ch3.add("23H");
		ch3.setBackground(new Color(255, 255, 204));
		ch3.addItemListener(new choicelis());
		add(ch3);
		
		ch4.setBounds(234, 235, 69, 21);
		ch4.add("Select");
		ch4.add("00H");ch4.add("01H");ch4.add("02H");ch4.add("03H");
		ch4.add("04H");ch4.add("05H");ch4.add("06H");ch4.add("07H");
		ch4.add("08H");ch4.add("09H");ch4.add("10H");ch4.add("11H");
		ch4.add("12H");ch4.add("13H");ch4.add("14H");ch4.add("15H");
		ch4.add("16H");ch4.add("17H");ch4.add("18H");ch4.add("19H");
		ch4.add("20H");ch4.add("21H");ch4.add("22H");ch4.add("23H");
		ch4.addItemListener(new choicelis());
		add(ch4);
		
		ch5.setBounds(210, 343, 103, 21);
		ch5.add("Select");
		ch5.add("NonSmoke");
		ch5.add("Smoke");
		ch5.setBackground(new Color(255, 255, 204));
		ch5.addItemListener(new choicelis());
		add(ch5);
		
		ch6.setBounds(210, 439, 103, 21);
		ch6.add("Select");
		ch6.add("Yes");ch6.add("No");
		
		ch6.setBackground(new Color(255, 255, 204));
		ch6.addItemListener(new choicelis());
		add(ch6);
		
		Explain.setBounds(113, 511, 449, 66);
		Explain.setBackground(new Color(255, 255, 204));
		add(Explain);
		
		befobtn = new Button("Before");
		befobtn.setBounds(29,594, 145, 57);
		befobtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new Register1(null);
			}
		});
		add(befobtn);
		
		nextbtn = new Button("next");
		nextbtn.setBounds(446, 594, 145, 57);
		nextbtn.addActionListener(new btnActionBar());
		add(nextbtn);
		
		
		
		setVisible(true);
	}
	class choicelis implements ItemListener
	{
		  String item;
		  String item2;
		  String item3;
		  String item4;
		  String item5;
		  String item6;
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			 if(e.getSource() == ch1 )
			   {
			   Choice ch1 = (Choice)e.getSource();
			   item = ch1.getSelectedItem();
			   ch1_1 = item;
			   
			   }
			   else if(e.getSource() == ch2 )
			   {
			   Choice ch2 = (Choice)e.getSource();
			   item2 = ch2.getSelectedItem();
			   ch2_1 = item2;
			   }
			   else if(e.getSource() == ch3 )
			   {
			   Choice ch3 = (Choice)e.getSource();
			   item3 = ch3.getSelectedItem();
			  ch3_1= item3;
			   }
			   else if(e.getSource() == ch4 )
			   {
			   Choice ch4 = (Choice)e.getSource();
			   item4 = ch4.getSelectedItem();
			   ch4_1 = item4;
			   }
			   else if(e.getSource() == ch5 )
			   {
			   Choice ch5 = (Choice)e.getSource();
			   item5 = ch5.getSelectedItem();
			  ch5_1 = item5;
			   }
			   else if(e.getSource() == ch6 )
			   {
			   Choice ch6= (Choice)e.getSource();
			   item6 = ch6.getSelectedItem();
			   ch6_1 = item6;
			   }
		}
	}
	
	class btnActionBar implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			System.out.println(ch1_1 +"-"+ch2_1);
			cw = ch1_1+"-"+ch2_1;
			cr = ch3_1+"-"+ch4_1;
			cs = ch5_1;
			cb = ch6_1;
			ex = Explain.getText();
			
			
			int bufprice = Integer.parseInt(Register1.iprice);
			int bufatmos = Integer.parseInt(Register1.iatmos);
			

			System.out.println(bufprice+"  "+bufatmos);
	
			Bar.Bars2.put(barname, new BarInfo(Register1.iname, 
					Register1.imagefilename, Register1.iphone,
					Register1.iaddress, 
					Register1.itypeofbar, bufprice, bufatmos,
					Register2.cw, Register2.cr, Register2.cs, 
					Register2.cb, Register2.ex));
				
	
			
			
			dispose();
			new Register3();
		}
	}
}



class Register3 extends Frame
{
	static int menuList = 6;
	static int priceList = 6;
	Button add,nextbtn,befbtn;
	Frame Regis;
	TextField[] menus= new TextField[menuList];
	TextField[] prmenus = new TextField[priceList];
	String []bufmenus = new String[menuList];
	String []bufprmenus = new String[priceList];
	
	
	Register3()
	{
	setBounds(250,35,635,700);
	setBackground(new Color(204, 204, 255));
		
		setLayout(null);
		
		Label label_1 = new Label("Food");
		label_1.setBounds(32, 99, 220, 23);
		add(label_1);
		
		Label label_2 = new Label("Price");
		label_2.setBounds(341, 99, 261, 23);
		add(label_2);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(32, 147, 242, 408);
		add(panel_1);
		panel_1.setLayout(new GridLayout(menuList,0));
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(340, 147, 242, 408);
		add(panel_2);
		panel_2.setLayout(new GridLayout(priceList, 0));
		
		
		
	
		
		for(int i=0; i<menuList; i++)
		{
			menus[i]=new TextField();
		
			panel_1.add(menus[i]);
		}
		for(int i=0; i<priceList; i++)
		{
			prmenus[i]=new TextField();
		
			panel_2.add(prmenus[i]);
		}
		

		
		add= new Button("add");
		add.setBounds(230, 584, 150, 50);
		nextbtn = new Button("final");
		nextbtn.setBounds(395, 584, 150, 50);
		befbtn = new Button("back");
		befbtn.setBounds(60, 584, 150, 50);
		
		add(add);
		add(nextbtn);
		add(befbtn);
		
		add.addActionListener(new addAction());
		nextbtn.addActionListener(new btnActionBar());
		befbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				dispose();
				new Register2(null);
			} 
		} );
		setVisible(true);
		
		
	}
	class addAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			menuList++;
			priceList++;
			dispose();
			new Register3();
		}
	}
	
	class btnActionBar implements ActionListener
	{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				String [] menusbuf = new String[menuList];
				String [] pribuf = new String[priceList];
				
				for(int i=0; i<menuList; i++)
				{
					menusbuf[i]=menus[i].getText();
					
				System.out.println(menusbuf[i]); //listeneing to the menus 
				
				}
				for(int i=0; i<priceList; i++)
				{
					pribuf[i]=prmenus[i].getText();
					
				System.out.println(pribuf[i]); //listeneing to the menus 
				
				}
				
				new MenuInfo(Register1.barname,menusbuf);
			//	new MenuInfo2(Register1.barname, pribuf);
				dispose();
			
			/*
			 * 	
	int 
c, barm, rank;

	static HashMap clients = new HashMap();
			 * 
			 * 	
	clients.put(id, new client1input(pw, name, region, jumin1, 
						jumin2, job, tt1, tt2, tt3, email,
						juso, barc, barm, 0));
	
			 */

			Iterator its = client1.clients.entrySet().iterator();
			
			
			String pw="", name="", region="", jumin1="", jumin2="", job="", 
					tt1="", tt2="", tt3="", 
					email="", juso="";
			int barc=0, barm=0;

				
			
			while(its.hasNext())
			{
				Map.Entry e2 = (Entry) its.next();

				if(e2.getKey().equals(Register1.barname))
				{
					client1input buffers = (client1input) e2.getValue();
					
					pw=buffers.pw;
					name=buffers.name;
					region=buffers.region;
					jumin1=buffers.jumin1;
					jumin2=buffers.jumin2;
					job=buffers.job;
					tt1=buffers.tt1;
					tt2=buffers.tt2;
					tt3=buffers.tt3;
					email=buffers.email;
					juso=buffers.juso;
					barc=buffers.barc;
					barm=buffers.barm;
					
				}
				
			}
			new client1input(pw, name, region, jumin1, jumin2, job, tt1, tt2, tt3, 
					email, juso, barc, barm,1);
			
			
			new Main_Users(Register1.barname);		
		}
	}
}

public class BarRegister{

	
	BarRegister()
	{
		new Register1("May");
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BarRegister();
	}

}
