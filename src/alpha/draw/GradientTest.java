package alpha.draw;

import java.applet.Applet;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

/**
 * 绘制仿射线
 * 
 * @author Anshen
 *
 */
public class GradientTest extends Applet {

	private static final long serialVersionUID = 1L;

	private Polygon poly;
	private Point2D p1;
	private Point2D p2;

	public void init() {
		final float[] radii = {10.0f, 20.0f};
		double radians = 0.0;
		final double increment = Math.toRadians(15.0);
		poly = new Polygon();
		for (int i = 0; i < 24; i++) {
			poly.addPoint((int) (radii[i % 2] * Math.cos(radians)),
							(int) (radii[i % 2] * Math.sin(radians)));

			radians += increment;
		}
		p1 = new Point2D.Float(0.0f, +20.0f);
		p2 = new Point2D.Float(0.0f, -20.0f);
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		AffineTransform at = new AffineTransform();
		at.translate(100, 100);
		at.scale(5, 5);

		g2d.setTransform(at);
		g2d.setPaint(new GradientPaint(p1, Color.ORANGE, p2, Color.GREEN));
		g2d.fill(poly);
	}
}
