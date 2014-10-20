package alpha;

import java.applet.Applet;
import java.awt.Button;
import java.awt.CardLayout;

public class CardLayoutTest extends Applet implements Runnable {

	private static final long serialVersionUID = 1L;
	
	private Thread timer;

	@Override
	public void init() {
		setLayout(new CardLayout());
		for (int i = 1; i <= 10; i++) {
			add(new Button("Card " + i), "Card " + i);
		}
		timer = new Thread(this);
	}

	@Override
	public void start() {
		timer = new Thread(this);
		timer.start();
	}

	@Override
	public void stop() {
		timer = null;
	}

	@Override
	public void run() {
		CardLayout layout = (CardLayout) getLayout();
		Thread t = Thread.currentThread();
		while (t == timer) {
			layout.next(this);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
