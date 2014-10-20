package alpha;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;

public class BorderLayoutTest extends Applet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		setLayout(new BorderLayout());
		add(new Button("北"), BorderLayout.NORTH);
		add(new Button("南"), BorderLayout.SOUTH);
		add(new Button("西"), BorderLayout.WEST);
		add(new Button("东"), BorderLayout.EAST);
		add(new Button("中"), BorderLayout.CENTER);
	}
	
}
