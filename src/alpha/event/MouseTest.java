package alpha.event;

import java.applet.Applet;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseTest extends Applet implements MouseListener {

	private static final long serialVersionUID = 1L;

	private TextArea textarea;
	
	@Override
	public void init() {
		setLayout(new GridLayout(2, 1));
		Panel p = new Panel();
		p.setBackground(new Color(0, 127, 255));
		p.add(new Label("I LOVE Mouse Events!"));
		p.addMouseListener(this);
		add(p);
		
		textarea = new TextArea();
		add(textarea);
	}
	
	private void reportMouseEvent(String message, MouseEvent e) {
		String point = "(" + e.getX() + ", " + e.getY() + ")";
		textarea.append(message + e.getSource().getClass() + " at " + point + "\n");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// 对于这个方法，鼠标左键单击和右键单击是不同的
		if (e.getModifiers() == MouseEvent.BUTTON1_MASK) {
			reportMouseEvent("Mouse left-clicked on ", e);
		}
		
		if (e.getModifiers() == MouseEvent.BUTTON3_MASK) {
			reportMouseEvent("Mouse right-clicked on ", e);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		reportMouseEvent("Mouse entered ", e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		reportMouseEvent("Mouse exited ", e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		reportMouseEvent("Mouse pressed over ", e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		reportMouseEvent("Mouse released over ", e);
	}

}
