package alpha.game;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * 边界检测
 * 
 * @author ex4m
 */
public class Minecraft extends Applet implements MouseMotionListener {
	
	private static final long serialVersionUID = 1L;
	
	// 设置方块的宽度为100个像素
	private int defaultSize = 100;
	
	private Shape[] transversShapes;
	
	private Shape[] verticalShapes;

	private Shape shape;

	private int width;

	private int height;
	
	private int x;
	
	private int y;
	
	public void drawGrid() {
		
	}

	@Override
	public void init() {
		width = getSize().width;
		height = getSize().height;
		System.out.printf("width: %d, height: %d\n", width, height);
		// 确定竖线
		transversShapes = new Line2D[(width / defaultSize) + 1];

		for (int i = 0; i < transversShapes.length; i++) {
			transversShapes[i] = new Line2D.Float(i * defaultSize, 0, i * defaultSize, height);
		}
		
		// 确定横线
		verticalShapes = new Line2D[(height / defaultSize) + 1];
		for (int i = 0; i < verticalShapes.length; i++) {
			verticalShapes[i] = new Line2D.Float(0, i * defaultSize, width, i * defaultSize);
		}
		System.out.printf("transvers num: %d, vertical num: %d\n", transversShapes.length, verticalShapes.length);
		addMouseMotionListener(this);
		
		shape = new Rectangle2D.Float(0, 0, defaultSize, defaultSize);
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.GREEN);
//		if (mouseOver) {
//			for (int i = 0; i < transversShapes.length; i++) {
//				g2d.fill(transversShapes[i]);
//			}
//			for (int i = 0; i < verticalShapes.length; i++) {
//				g2d.fill(verticalShapes[i]);
//			}
//		} else {
		System.out.println("画横线：");
		for (int i = 0; i < transversShapes.length; i++) {
			Line2D l2d = (Line2D) transversShapes[i];
			System.out.printf("(%f , %f) to (%f, %f)\t", l2d.getX1(), l2d.getY1(), l2d.getX2(), l2d.getY2());
			g2d.draw(transversShapes[i]);
		}
		System.out.println("\n画竖线：");
		for (int i = 0; i < verticalShapes.length; i++) {
			Line2D l2d = (Line2D) transversShapes[i];
			System.out.printf("(%f , %f) to (%f, %f)\t", l2d.getX1(), l2d.getY1(), l2d.getX2(), l2d.getY2());
			g2d.draw(verticalShapes[i]);
		}

		// 1. RED
		g2d.setColor(Color.ORANGE);
		g2d.draw(new Line2D.Float(0, 0, width, height));
//		// 2. BLUE
//		g2d.setColor(Color.BLUE);
//		g2d.draw(new Line2D.Float(0, 0, -width, height));
//		// 3. GRAY
//		g2d.setColor(Color.GRAY);
//		g2d.draw(new Line2D.Float(0, 0, width, -height));
//		// 4. CYAN
//		g2d.setColor(Color.CYAN);
//		g2d.draw(new Line2D.Float(0, 0, -width, -height));
	
		shape = new Rectangle2D.Float(x / defaultSize * defaultSize, y / defaultSize * defaultSize, defaultSize, defaultSize);
		g2d.setBackground(Color.RED);
		g2d.setColor(Color.RED);
		g2d.draw(shape);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// 
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		repaint();
	}

}
