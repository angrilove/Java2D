package alpha;

import java.applet.Applet;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FlowLayoutTest extends Applet
		implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;

	private TextField text;

	private Button click;

	private Label label;

	@Override
	public void init() {
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		add(new Button("Layout"));
		add(new Button("Managers"));
		add(new Button("Rule!"));

		add(new Label("请输入姓名："));

		text = new TextField(20);
		text.addKeyListener(this);
		add(text);

		click = new Button("Click Get Message!");
		click.addActionListener(this);
		add(click);

		label = new Label("..");
		add(label);
	}

	@Override
	public void paint(Graphics g) {
		System.out.println("paint label.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == click) {
			label.setText(text.getText());
			label.setSize(100, label.getHeight());
		}
		System.out.println("action performed.");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("key pressed.");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("key typed.");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == text
				&& e.getKeyCode() == KeyEvent.VK_ENTER) {
			label.setText(text.getText());
			label.setSize(100, label.getHeight());
		}
		System.out.println("key released.");
	}

}
