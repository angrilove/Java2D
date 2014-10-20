package alpha.draw;

import java.awt.*;
import java.applet.*;
import java.awt.geom.*;

public class GradientTest extends Applet {
	// 
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
