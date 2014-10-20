package alpha.draw;

import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class StrokeTest extends Applet {

	private static final long serialVersionUID = 1L;

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		// Set pen width
		float penWidth = 3.0f;
		// 
		int endCaps = BasicStroke.CAP_BUTT;
		int lineJoins = BasicStroke.JOIN_MITER;
		// 限制斜角修饰为10像素
		float trim = 10.0f;
		// 设置虚线模式
		float[] dashPattern = {5.0f, 9.0f, 3.0f};
		// 立即开始（没有像素偏差）
		float dashOffset = 0.0f;
		BasicStroke stroke = new BasicStroke(penWidth, endCaps, lineJoins, trim, dashPattern, dashOffset);
		g2d.setStroke(stroke);
		g2d.draw(new Line2D.Float(10.0f, 10.0f, 140.f, 10.0f));
		g2d.draw(new Rectangle2D.Float(20.0f, 60.0f, 100.0f, 50.f));
	}
}
