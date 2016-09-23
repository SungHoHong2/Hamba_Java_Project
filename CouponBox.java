package BC_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class CouponBox extends Frame{
	String currentID;

/////	static HashMap clients = new HashMap();
	
	CouponBox(String buf)
	{
		addWindowListener(new Close_c());
		
		this.currentID=buf;
		setBounds(900,0,500,755);
		setLayout(null);
		
		Label TopBanner = new Label("Usable Coupons");
		TopBanner.setForeground(Color.white);
		TopBanner.setBackground(new Color(217,68,68));
		TopBanner.setBounds(0,20,500,60);
		add(TopBanner);
		
		Panel bottomPanel = new Panel();
		bottomPanel.setBounds(0,80,500,695);
		bottomPanel.setLayout(null);
		
		ScrollPane sp = new ScrollPane();
		sp.setBounds(0,80,500,400);
		
		
		Panel UsedCoupons = new Panel();
		UsedCoupons.setBounds(0,465,500,300);
		UsedCoupons.setLayout(null);
		UsedCoupons.setBackground(Color.LIGHT_GRAY);
		
	    Iterator it2 = UsedCouponsClass.UsedCouponsArray.entrySet().iterator();
	    JButton BarPhoto;
	    	    
	    while(it2.hasNext())
	    {
	    	Map.Entry e3 = (Entry) it2.next();
	    	UsedCouponsInput eee = (UsedCouponsInput) e3.getValue();
	    	ImageIcon imgbuffer = new ImageIcon("Bar_Image/"+eee.Barname+".png");
	    	
	   
	    	if(e3.getKey().equals(currentID))
	    	{
	    		BarPhoto = new JButton(imgbuffer);
	    		BarPhoto.setBounds(50,50,200,150);
	    		BarPhoto.addActionListener(new Specific(eee.Barname));
	    		
	    		Label goClick = new Label("Go and Review the Bar!!");
	    		goClick.setBounds(270,115,200,50);
	    		
	    		UsedCoupons.add(BarPhoto);
	    		UsedCoupons.add(goClick);
	    	}
	    }
	    
		
	    
		Iterator it = clientCoupon.clientCoupons.entrySet().iterator();	
		Button []using = new Button[clientCoupon.clientCoupons.size()];
		Label []BarLabel = new Label[clientCoupon.clientCoupons.size()];
		
		int i=0;
		while(it.hasNext())
		{
			Map.Entry e= (Entry) it.next();
		
			String buffer = (String) e.getKey();
			int buffernum = buffer.indexOf('*');
			int buffernum2 = buffer.indexOf('/');
			System.out.println(buffer + "before the SubString");

			
			String Barname = buffer.substring(buffernum+1,buffernum2);
			String CouponName = buffer.substring(buffernum2);
			
			String buffer2 = buffer.substring(0,buffernum);  //stripping out the id 
			System.out.println(buffer2);
			
			if(currentID.equals(buffer2))
			{
				using[i] = new Button("Use Coupon");
				using[i].setBounds(10,10+i*120,100,100);
				
				using[i].addActionListener(new CouponUseAction(buffer));
				
				BarLabel[i] = new Label("Bar Name : "+Barname+"     Coupon Name : "+CouponName);
				BarLabel[i].setBounds(130,45+i*120,330,30);
				
			
				bottomPanel.add(BarLabel[i]);
				bottomPanel.add(using[i]);
				i++;
			}
	
		}
	
		add(UsedCoupons);
		sp.add(bottomPanel);
		add(sp);
		System.out.println(clientCoupon.clientCoupons+" inserted Coupons to Customers");
		setVisible(true);
		
	}
	
	class CouponUseAction implements ActionListener
	{
		String buf;
		
		CouponUseAction(String buf)
		{
			this.buf = buf; 
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			System.out.println("Using Coupon : "+buf);
			
			clientCoupon.clientCoupons.remove(buf);
				
			int start = buf.lastIndexOf('*')+1;
			int end = buf.lastIndexOf('/');
			
			String buffering = buf.substring(start,end);
			dispose();
			
			new CouponBox(currentID);
			
			System.out.println(currentID+" : "+buffering+" going to UsedCoupons");
			
			new UsedCouponsClass(currentID, buffering);	
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
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new	CouponBox("dsfsdf");
		
		
	}

}
