package alpha;

import java.applet.Applet;
import java.awt.Graphics;

/**
 * 
 * 
 * @author ex4me
 *
 */
public class ActApplet extends Applet {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		System.out.println("start main method.");
	}

	@Override
	public void init() {
		System.out.println("start init method.");
	}

	@Override
	public void start() {
		System.out.println("start start method.");
	}

	@Override
	public void stop() {
		System.out.println("start stop method.");
	}

	@Override
	public void paint(Graphics g) {
		System.out.println("start paint method.");
	}

	@Override
	public void resize(int width, int height) {
		System.out.println("start resize method.");
		System.out.printf("width is %d, height is %d.\n", width, height);
	}

	@Override
	public void destroy() {
		System.out.println("start destory method.");
	}

}
