package alpha.shape;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

/**
 * 边界检测
 * 
 * @author ex4m
 */
public class MouseShapeTest extends Applet implements MouseMotionListener {
	
	private static final long serialVersionUID = 1L;
	
	private Shape shape;
	
	private boolean mouseOver;

	private Color currentColor;

	@Override
	public void init() {
		int[] x = {25, 55, 60, 75, 110, 130};
		int[] y = {65, 100, 133, 20, 115, 55};
		
		shape = new Polygon(x, y, x.length);
		mouseOver = false;
		addMouseMotionListener(this);
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(currentColor);
		if (mouseOver) {
			g2d.fill(shape);
		} else {
			g2d.draw(shape);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// 
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		boolean prevValue = mouseOver;
		mouseOver = shape.contains(e.getPoint());
		if (prevValue != mouseOver) {
			currentColor = new Color(new Random().nextInt());
			repaint();
		}
	}

}
