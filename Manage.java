package BC_1;

import BC_1.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Manage extends Frame {

	
	
	Manage()
	{
		setBounds(900,0,500,700);
		setLayout(new GridLayout(2,0));
		
		Panel Customers = new Panel();
		Customers.setLayout(new FlowLayout());
		Customers.setBackground(Color.cyan);
		
		Iterator it2 = client1.clients.entrySet().iterator();
		
		Button[] clientBtn = new Button[client1.clients.size()];
		
		int i = 0;
		while(it2.hasNext())
		{
			Map.Entry ee = (Entry) it2.next();
			client1input eee = (client1input) ee.getValue();
			
			String clientkey = (String) ee.getKey();
			clientBtn[i]=new Button(eee.name);
			clientBtn[i].addActionListener(new clientDestroy(clientkey));
			
			Customers.add(clientBtn[i]);
		i++;
		}
		

		
		Panel BarOwners = new Panel();
		BarOwners.setBackground(Color.green);
		BarOwners.setLayout(new FlowLayout());
		
		Iterator it = Bar.Bars2.entrySet().iterator();
		Button[] BarBtn = new Button[Bar.Bars2.size()];

		int s=0;
		
		while(it.hasNext())
		{
			Map.Entry ee = (Entry) it.next();
			
			String barkey = (String) ee.getKey();
					
			BarInfo eee = (BarInfo) ee.getValue();
		
			BarBtn[s] = new Button(eee.name);
			BarBtn[s].addActionListener(new BarDestroy(barkey));
			
			BarOwners.add(BarBtn[s]);
			
			
			s++;
		}
		

		add(Customers);
		add(BarOwners);
		setVisible(true);
	}
	
	
	class clientDestroy implements ActionListener
	{
		String clientkey;
		
		clientDestroy(String clientkey)
		{
			this.clientkey=clientkey;
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
			
			client1.clients.remove(clientkey);
			
			new Manage();
		}
	}
	
	
	class BarDestroy implements ActionListener
	{
		String barkey;
		
		BarDestroy(String barkey)
		{
			this.barkey=barkey;
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
			
			Bar.Bars2.remove(barkey);
			
			new Manage();
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Manage();		
	}

}
