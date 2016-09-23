package BC_1;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class SplashImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ImageIcon tt = new ImageIcon("images/splashimage.gif");
		 JWindow window = new JWindow();
	        window.getContentPane().add(
	                new JLabel(tt), (SwingConstants.CENTER));
	        window.setBounds(0, 0, 900, 600);
	        window.setVisible(true);
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        window.setVisible(false);
	    
	        Main player1 = new Main();
			window.dispose();
	}

}
