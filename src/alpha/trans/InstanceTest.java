package alpha.trans;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 * 生成随机图像
 * @author ex4m
 */
public class InstanceTest extends Applet {

	private static final long serialVersionUID = 1L;

	private Shape shape;

	public void init() {
		shape = new Rectangle2D.Float(-0.5f, 0.5f, 1.0f, 1.0f);
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		final AffineTransform identity = new AffineTransform();

		Random r = new Random();
		int width = getSize().width;
		int height = getSize().height;
		for (int i = 0; i < 500; i++) {
			g2d.setTransform(identity);
			g2d.translate(r.nextInt() % width, r.nextInt() % height);
			g2d.rotate(Math.toRadians(360 * r.nextDouble()));
			g2d.scale(20 * r.nextDouble(), 10 * r.nextDouble());
			g2d.setColor(new Color(r.nextInt()));
			g2d.fill(shape);
		}
	}
}
