package alpha.draw;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class ImageTest extends Applet {

	private static final long serialVersionUID = 1L;

	private Image[] images;

	private final String[] filenames = {
			"1.gif", "2.gif", "3.gif", "4.gif", "5.gif", "6.gif", "7.gif"
		};

	@Override
	public void init() {
		images = new Image[filenames.length];
		try {
			URL imageURL = new URL(getCodeBase() + "image/");
			for (int i = 0; i < filenames.length; i++) {
				images[i] = getImage(imageURL, filenames[i]);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		// 保存一个恒等变换
		final AffineTransform identity = new AffineTransform();
		AffineTransform at = new AffineTransform();
		Random r = new Random();
		int width = getSize().width;
		int height = getSize().height;

		for (int i = 0; i < 100000; i++) {
			// 清除变换
			at.setTransform(identity);
			// 随机平移旋转
			at.translate(r.nextInt() % width, r.nextInt() % height);
			at.rotate(Math.toRadians(360 * r.nextDouble()));
			g2d.drawImage(images[i % images.length], at, this);
		}
	}

}
