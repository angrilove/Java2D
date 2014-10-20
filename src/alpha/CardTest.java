package alpha;

import java.applet.Applet;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardTest extends Applet implements Runnable, ActionListener {

	private static final long serialVersionUID = 1L;
	
	private Thread timer;
	
	private Button button;
	
	private PopupMenu popup;

	@Override
	public void init() {
		setLayout(new CardLayout());
		for (int i = 1; i <= 10; i++) {
			button = new Button("Card " + i);
			button.addActionListener(this);
			add(button, "Card " + i);
		}
		popup = new PopupMenu("Show 5th Card!");
		popup.add("Show First!");
		add(popup);
		popup.addActionListener(this);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		popup.show(this, 10, 10);
	}

}
