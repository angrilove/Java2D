
package alpha.trans;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 *
 * 仿射测试
 * 
 * @author ex4m
 *
 */
public class AffineTest extends Applet implements ItemListener {

	private static final long serialVersionUID = 1L;

	// 要绘制的矩形
	private Rectangle2D rect;

	private Checkbox rotateFirst;
	private Checkbox translateFirst;

	public void init() {
		setLayout(new BorderLayout());
		CheckboxGroup checkboxGroup = new CheckboxGroup();
		Panel p = new Panel();
		rotateFirst = new Checkbox("rotate, translate", checkboxGroup, true);
		rotateFirst.addItemListener(this);
		p.add(rotateFirst);
		translateFirst = new Checkbox("translate, rotate", checkboxGroup, false);
		translateFirst.addItemListener(this);
		p.add(translateFirst);
		add(p, BorderLayout.SOUTH);

		// 基于原点构建矩形
		rect = new Rectangle2D.Float(-0.5f, -0.5f, 2.0f, 2.0f);
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		final AffineTransform identity = new AffineTransform();
		identity.setToIdentity();
		boolean rotate = rotateFirst.getState();
		Random r = new Random();
		final double oneRadian = Math.toRadians(1.0);
		for (double radians = 0.0; radians < 2.0 * Math.PI; radians += oneRadian) {
			g2d.setTransform(identity);
			if (rotate) {
				g2d.translate(100, 100);
				g2d.rotate(radians);
			} else {
				g2d.rotate(radians);
				g2d.translate(100, 100);
			}
			g2d.scale(10, 10);
			g2d.setColor(new Color(r.nextInt()));
			g2d.fill(rect);
		}
	}

	public void itemStateChanged(ItemEvent e) {
		repaint();
	}
}
