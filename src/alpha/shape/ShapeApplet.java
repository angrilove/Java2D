package alpha.shape;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * 绘制图形
 * 
 * @author ex4m
 *
 */
public class ShapeApplet extends Applet implements ActionListener {

	private static final long serialVersionUID = 1L;

	private Button circleBtn;

	private Button rectBtn;

	private Shape elli;

	private Shape rect;
	
	private Graphics2D g2d;

	@Override
	public void init() {
		circleBtn = new Button("画圆形");
		rectBtn = new Button("画矩形");
		circleBtn.addActionListener(this);
		rectBtn.addActionListener(this);
		add(circleBtn);
		add(rectBtn);
		elli = new Ellipse2D.Float(100f, 100f, 100f, 100f);
		rect = new Rectangle2D.Float(10f,  10f, 100f, 100f);
	}

	@Override
	public void paint(Graphics g) {
		g2d = (Graphics2D) g;
		g2d.setColor(Color.GREEN);
		g2d.fill(elli);
		g2d.fill(rect);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		g2d.translate(150, 150);
		g2d.fill(elli);
		g2d.fill(rect);
	}

}
