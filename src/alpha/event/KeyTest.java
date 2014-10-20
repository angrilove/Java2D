
package alpha.event;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;


/**
 * 绘制一个可移动的矩形，背景可以更改。
 * 'Up' 上移
 * 'Down' 下移
 * 'Left' 左移
 * 'Right' 右移
 * 'r' 背景变红
 * 'g' 背景变绿
 * 'b' 背景变蓝
 * 'w' 背景变蓝
 */
public class KeyTest extends Applet implements KeyListener {

	private static final long serialVersionUID = 1L;

	/** Removable black rectangle. */
	private Rectangle r;

	/** Current background. */
	private Color backColor;

	@Override
	public void init() {
		r = new Rectangle(0, 0, 20, 10);
		backColor = Color.WHITE;
		addKeyListener(this);
	}

	public void paint(Graphics g) {
		setBackground(backColor);
		g.fillRect(r.x, r.y, r.width, r.height);
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_LEFT) {
			r.x -= 5;
			if (r.x < 0) {
				r.x = 0;
			}
			repaint();
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			r.x += 5;
			if (r.x > getSize().width - r.width) {
				r.x = getSize().width - r.width;
			}
			repaint();
		} else if (keyCode == KeyEvent.VK_UP) {
			r.y -= 5;
			if (r.y < 0) {
				r.y = 0;
			}
			repaint();
		} else if (keyCode == KeyEvent.VK_DOWN) {
			r.y += 5;
			if (r.y > getSize().height - r.height) {
				r.y = getSize().height - r.height;
			}
			repaint();
		}
	}

	public void keyReleased(KeyEvent e) {
		// Nothing to do.
	}

	public void keyTyped(KeyEvent e) {
		char keyChar = e.getKeyChar();
		switch (keyChar) {
		case 'r':
			backColor = Color.RED;
			repaint();
			break;
		case 'g':
			backColor = Color.GREEN;
			repaint();
			break;
		case 'b':
			backColor = Color.BLUE;
			repaint();
			break;
		case 'w':
			backColor = Color.WHITE;
			repaint();
			break;
		}
	}
}
