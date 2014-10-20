package alpha;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ManyShapes extends Applet implements ActionListener {

	private static final long serialVersionUID = 1L;

	private Button button;

	private int currentColor;

	private final Color[] bgColors = new Color[] {
			Color.RED, Color.BLUE,
			Color.GREEN, Color.YELLOW, Color.PINK
		};

	@Override
	public void init() {
		button = new Button("Button!");
		button.addActionListener(this);

		add(button);

		// 初始化背景色索引
		currentColor = -1;
		changeWindowColor();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			System.out.println("Press Button");
			changeWindowColor();
			repaint();
		}
	}

	@Override
	public void paint(Graphics g) {
		setBackground(bgColors[currentColor]);
		button.setForeground(bgColors[currentColor]);
		button.setBackground(bgColors[bgColors.length - currentColor - 1]);
		// 画图形
		Random r = new Random();
		for (int i = 0; i < 10000; i++) {
			int x = r.nextInt() % 300;
			int y = r.nextInt() % 300;
			int width = r.nextInt() % 300;
			int height = r.nextInt() % 300;
			g.setColor(new Color(r.nextInt()));
			int what = Math.abs(r.nextInt() % 5);
			switch (what) {
			case 0:
				g.draw3DRect(x, y, width, height, true);
				break;
			case 1:
				g.drawRect(x, y, width, height);
				break;
			case 2:
				g.drawOval(x, y, width, height);
				break;
			case 3:
				g.fillRect(x, y, width, height);
				break;
			case 4:
				g.fillOval(x, y, width, height);
				break;

			default:
				System.out.println("Invalid case: " + what);
				break;
			}
		}

	}

	private void changeWindowColor() {
		currentColor++;
		if (currentColor == bgColors.length) {
			currentColor = 0;
		}
	}

}
