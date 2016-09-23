package BC_1;

import java.awt.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class Menus extends Frame{

	String barname;
	
	Menus(String barname)
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
			String [] bufmenus 	=	(String[]) e.getValue();
		
			if(e.getKey().equals(barname))
			{
				for(int i=0; i<4; i++)
				add(new Label(bufmenus[i]));
			}		
		}
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Menus("Oracle");
	}

}
