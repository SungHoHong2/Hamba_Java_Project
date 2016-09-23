package BC_1;

import BC_1.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WClose_c extends WindowAdapter{

	public void windowClosing(WindowEvent e)
	{
		e.getWindow().dispose();
	}

}
