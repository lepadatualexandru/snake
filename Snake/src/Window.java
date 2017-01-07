import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	static int velx,vely;
	public static void main(String args[]){
		JFrame wind=new JFrame("Snake L.Alex.");
		JPanel a=new JPanel();
		a.setPreferredSize(new Dimension(600,600));
		wind.add(a);
		wind.pack();
		wind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wind.add(new Peint());
		wind.addKeyListener(new Butoane());
		wind.setVisible(true);
	}
	
	
}
