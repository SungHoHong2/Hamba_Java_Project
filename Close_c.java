package BC_1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Close_c extends WindowAdapter{

	public void windowClosing(WindowEvent e)
	{
		e.getWindow().dispose();
		
	}

}
