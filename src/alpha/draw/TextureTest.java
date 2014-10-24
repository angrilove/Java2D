package alpha.draw;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.TexturePaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * 绘制材质
 * 
 * @author Anshen
 *
 */
public class TextureTest extends Applet implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private TextField input;

	public void init() {
		setLayout(new BorderLayout());
		Panel p = new Panel();
		input = new TextField("", 20);
		p.add(input);
		Button ok = new Button("Ok");
		ok.addActionListener(this);
		p.add(ok);
		add(p, BorderLayout.SOUTH);
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if ("".equals(input.getText().trim())) {
			g2d.translate(112, 15);
			g2d.rotate(Math.PI/4);
			g2d.draw(new Rectangle2D.Double(0, 0, 104, 104));
			return;
		}

		MediaTracker mt = new MediaTracker(this);
		Image image = getImage(getCodeBase(), input.getText());
		mt.addImage(image, 0);
		try {
			mt.waitForAll();
		} catch (InterruptedException e) {}
		// 传入错误的文件
		if (image.getWidth(this) <= 0 || image.getHeight(this) <= 0) {
			input.setText(input.getText() + " : invalid filename.");
			return;
		}
		BufferedImage bimage = new BufferedImage(image.getWidth(this),
			image.getHeight(this), BufferedImage.TYPE_INT_RGB);

		((Graphics2D) bimage.getGraphics()).drawImage(image, new AffineTransform(), this);

		Rectangle2D bounds = new Rectangle2D.Float(0, 0, bimage.getWidth(), bimage.getHeight());

		g2d.setPaint(new TexturePaint(bimage, bounds));
		g2d.translate(112, 15);
		g2d.rotate(Math.PI/4);
		g2d.fill(new Rectangle2D.Double(0, 0, 104, 104));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
