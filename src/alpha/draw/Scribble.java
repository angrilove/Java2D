package alpha.draw;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * 绘制图形
 */
public class Scribble extends Applet implements ItemListener, ActionListener,
		MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;

	private Choice colorChooser;

	private Color currentColor;

	private Point start;

	private Point end;

	private Button clearWindowBtn;

	private Button byteBtn;

	private final ColorDescription[] colors = new ColorDescription[] {
			new ColorDescription(Color.BLACK, "Black"),
			new ColorDescription(Color.RED, "Red"),
			new ColorDescription(Color.GREEN, "Green"),
			new ColorDescription(Color.BLUE, "Blue"),
			new ColorDescription(Color.YELLOW, "Yellow"),
			new ColorDescription(Color.ORANGE, "Orange"),
			new ColorDescription(Color.GRAY, "Gray"),
			new ColorDescription(Color.CYAN, "Cyan")
		};

	private void drawBytes() {
		Graphics g = getGraphics();
		byte[] data = {
				0, 0, 0, 0, 0, 0, 0, 0,
				2, 2, 3, 3, 3, 5, 5, 0,
				100, 100, 0, 1, 2, -127, 111, 127,
				0, 0, 1, 2, 3, 5, 127, 0
			};
		g.drawBytes(data, 0, data.length, 10, 10);
	}

	@Override
	public void init() {
		start = null;
		end = null;

		setBackground(Color.WHITE);
		addMouseListener(this);
		addMouseMotionListener(this);

		setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		currentColor = colors[0].color;
		createSidebar();
	}

	@SuppressWarnings("deprecation")
	private void createSidebar() {
		colorChooser = new Choice();
		for (int i = 0; i < colors.length; i++) {
			colorChooser.add(colors[i].text);
		}
		colorChooser.addItemListener(this);
		clearWindowBtn = new Button("Clear Window");
		clearWindowBtn.addActionListener(this);

		byteBtn = new Button("Draw Bytes");
		byteBtn.addActionListener(this);

		Frame frame = new Frame();
		frame.setLocation(getX() + getSize().width + 8, getY());
		frame.setLayout(new GridLayout(3, 1, 5, 5));
		frame.setBackground(Color.YELLOW);
		frame.add(new Label("Pen Color:", Label.CENTER));
		frame.add(colorChooser);
		frame.add(clearWindowBtn);
		frame.add(byteBtn);
		frame.pack();
		frame.show();
	}

	private void drawPoints() {
		Graphics draw = getGraphics();
		draw.setColor(currentColor);
		draw.drawLine(start.x, start.y, end.x, end.y);
	}

	@Override
	public void destroy() {
		removeMouseListener(this);
		removeMouseMotionListener(this);
		colorChooser.removeItemListener(this);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (start == null) {
			start = new Point(e.getX(), e.getY());
		}
		if (end == null) {
			end = new Point(e.getX(), e.getY());
		}
		// start.x = end.x;
		// start.y = end.y;
		start.x = end.x = e.getX();
		start.y = end.y = e.getY();
		drawPoints();
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseDragged(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		start = null;
		end = null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clearWindowBtn) {
			repaint();
		} else if (e.getSource() == byteBtn) {
			drawBytes();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		String color = colorChooser.getSelectedItem();
		for (int i = 0; i < colors.length; i++) {
			if (colors[i].matches(color)) {
				currentColor = colors[i].color;
				break;
			}
		}
	}

}

class ColorDescription {

	public Color color;

	public String text;

	public ColorDescription(Color color, String text) {
		this.color = color;
		this.text = text;
	}

	public boolean matches(String description) {
		return text.equals(description);
	}
}
