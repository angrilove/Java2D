package alpha.draw;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * 绘制渐变线
 * 
 * @author Anshen
 *
 */
public class CycleTest extends Applet implements ItemListener {

	private static final long serialVersionUID = 1L;

	// 要绘制的矩形
	private Rectangle2D rect;

	// 终点线
	private Line2D line;

	// 选择循环类型
	private Checkbox cyclic;
	private Checkbox acyclic;

	public void init() {

		rect = new Rectangle2D.Float(-0.5f, -0.5f, 1.0f, 1.0f);

		line = new Line2D.Float(-0.25f, 0.0f, 0.25f, 0.0f);

		setBackground(Color.ORANGE);
		CheckboxGroup group = new CheckboxGroup();
		setLayout(new BorderLayout());
		Panel p = new Panel();
		p.setBackground(Color.GREEN);
		cyclic = new Checkbox("cyclic", group, true);
		cyclic.addItemListener(this);
		p.add(cyclic);
		acyclic = new Checkbox("acyclic", group, true);
		acyclic.addItemListener(this);
		p.add(acyclic);
		add(p, BorderLayout.SOUTH);
	}

	public void paint(Graphics g) {
		// 缩放后矩形宽度
		final double scaleWidth = 100.0f;

		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(100, 100);
		g2d.scale(scaleWidth, 50);

		// 绘制渐变线
		g2d.setPaint(new GradientPaint(line.getP1(), Color.BLACK, line.getP2(), Color.WHITE, cyclic.getState()));
		g2d.fill(rect);

		g2d.setPaint(Color.RED);
		g2d.setTransform(new AffineTransform());
		g2d.translate(100 - 0.25 * scaleWidth, 100);
		g2d.rotate(Math.PI / 2);
		g2d.scale(scaleWidth / 2, 1);
		g2d.draw(line);

		g2d.setTransform(new AffineTransform());
		g2d.translate(100 + 0.25 * scaleWidth, 100);
		g2d.rotate(Math.PI / 2);
		g2d.scale(scaleWidth / 2, 1);
		g2d.draw(line);
	}

	public void itemStateChanged(ItemEvent e) {
		repaint();
	}
}
