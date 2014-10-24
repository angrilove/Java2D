package alpha.draw;

import java.applet.Applet;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

public class BufferedImageTest extends Applet {

	private static final long serialVersionUID = 1L;

	private BufferedImage bimage;
	private final int BIMAGE_WIDTH = 100;
	private final int BIMAGE_HEIGHT = 100;
	
	private Random r;

	@Override
	public void init() {
		r = new Random();
		bimage = new BufferedImage(BIMAGE_WIDTH, BIMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D g2d = bimage.createGraphics();
		final int stripWidth = BIMAGE_WIDTH / 10;
		final int stripHeight = BIMAGE_HEIGHT / 10;

		g2d.setPaint(new Color(r.nextInt()));
		g2d.fill(new Rectangle(0, 0, BIMAGE_WIDTH, BIMAGE_HEIGHT));
		// 随机颜色绘制垂直条纹
		g2d.setPaint(new Color(r.nextInt()));
		int x = stripWidth / 2;
		while (x < BIMAGE_WIDTH) {
			g2d.fill(new Rectangle(x, 0, stripWidth, BIMAGE_HEIGHT));
			x += 2 * stripWidth;
		}
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
		// 随机颜色绘制水平条纹
		g2d.setPaint(new Color(r.nextInt()));
		int y = stripHeight / 2;
		while (y < BIMAGE_HEIGHT) {
			g2d.fill(new Rectangle(0, y, BIMAGE_WIDTH, stripHeight));
			y += 2 * stripHeight;
		}
		
		g2d.setStroke(new BasicStroke(2.0f));
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));

		g2d.setPaint(Color.BLACK);
		g2d.draw(new Rectangle(0, 0, BIMAGE_WIDTH, BIMAGE_HEIGHT));
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		for (int i = 0; i < 20; i++) {
			g2d.drawImage(bimage, AffineTransform.getTranslateInstance(
					r.nextInt() % getSize().getWidth(), r.nextInt() % getSize().getHeight()), this);
		}
	}

}
