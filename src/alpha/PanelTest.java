package alpha;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;

public class PanelTest extends Applet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		setLayout(new FlowLayout());
		
		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(2, 2));
		p1.add(new Button("Button1"));
		p1.add(new Button("Button2"));
		p1.add(new Button("Button3"));
		p1.add(new Button("Button4"));
		add(p1);
		
		Panel p2 = new Panel();
		p2.setLayout(new BorderLayout());
		p2.add(new Button("北"), BorderLayout.NORTH);
		p2.add(new Button("南"), BorderLayout.SOUTH);
		p2.add(new Button("西"), BorderLayout.WEST);
		p2.add(new Button("东"), BorderLayout.EAST);
		p2.add(new Button("中"), BorderLayout.CENTER);
		add(p2);
	}
	
	

}
