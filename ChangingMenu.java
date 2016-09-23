package BC_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class ChangingMenu extends Frame{

String barname;
TextField [] changer = new TextField[20];
int MenuLength;

	ChangingMenu(String barname)
	{
		this.barname=barname;
		
		setBounds(900,300,220,200);
		setBackground(Color.red);
		setLayout(new FlowLayout());
		addWindowListener(new Close_c());
		
	
		Iterator it = MenuInfo.MenuInfos.entrySet().iterator();
		add(new Label("Menus"));
		
		
		while(it.hasNext())
		{
			Map.Entry e = (Entry) it.next();
			String [] bufmenus 	=(String[]) e.getValue();
		
			if(e.getKey().equals(barname))
			{
				MenuLength = bufmenus.length;
				for(int i=0; i<bufmenus.length; i++)
				{
					changer[i]= new TextField(bufmenus[i]);
					add(changer[i]);				
				}
			}		
		}
		
		Button Changeit = new Button("Change it");
		Changeit.addActionListener(new ChangeAgain());
		
		add(Changeit);
		
		setVisible(true);
	}
	
	
	class ChangeAgain implements ActionListener
	{
		String menu[]= new String[MenuLength];
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			for(int i=0; i<MenuLength; i++)
			{
				System.out.println(changer[i].getText()+" before changing the Menus");
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
