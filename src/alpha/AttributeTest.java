package alpha;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttributeTest extends Applet implements ActionListener {

	private static final long serialVersionUID = 1L;

	// 剩余点值
	Label pointsRemaining;

	private final String[] ATTRS = { "Strength", "Wisdom", "Agility", "Magic" };

	@Override
	public void init() {
		pointsRemaining = new Label("Points remaining: 10", Label.CENTER);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		for (int i = 0; i < ATTRS.length; i++) {
			add(new AttributePanel(ATTRS[i], this));
		}
		add(pointsRemaining);

		System.out
				.printf("CENTER %d, LEFT %d, RIGHT %d, LEFT_ALIGNMENT %f, RIGHT_ALIGNMENT %f, ABORT %d, BOTTOM_ALIGNMENT %f",
						Label.CENTER, Label.LEFT, Label.RIGHT,
						Label.LEFT_ALIGNMENT, Label.RIGHT_ALIGNMENT,
						Label.ABORT, Label.BOTTOM_ALIGNMENT,
						Label.CENTER_ALIGNMENT);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int pr = Integer.parseInt(pointsRemaining.getText().substring(18));
		pr += ((AttributeButton) e.getSource()).updatePanel(pr);
		pointsRemaining.setText("Points remaining: " + pr);
	}

}

/**
 * 允许改变属性
 * 
 * @author ex4m
 *
 */
class AttributeButton extends Button {

	private static final long serialVersionUID = 1L;

	// 存放当前按钮的 Panel
	private AttributePanel parent;

	public AttributeButton(String label, AttributePanel parent) {
		super(label);
		this.parent = parent;
	}

	public int updatePanel(int pointsRemaining) {
		// 为 plus 分配一个点值
		if (getLabel().equals("+")) {
			// 仅在还有点值剩余是分配
			if (pointsRemaining > 0) {
				parent.allocatePoints(1);
				return -1;
			} else {
				return 0;
			}
		} else {
			// 不允许分配负数
			if (parent.getPointsAllocated() > 0) {
				parent.allocatePoints(-1);
				return 1;
			} else {
				return 0;
			}
		}
	}

}

/**
 * 允许改变一个角色的属性
 * 
 * @author ex4m
 *
 */
class AttributePanel extends Panel {

	private static final long serialVersionUID = 1L;

	// 属性的文本描述
	private String attribute;

	// 显示给这个属性所分配点值的 Label
	private Label pointsAllocated;

	public AttributePanel(String attribute, ActionListener l) {
		this.attribute = attribute;
		pointsAllocated = new Label("0", Label.CENTER);
		setLayout(new GridLayout(3, 1));
		setBackground(Color.GREEN);
		add(new Label(attribute, Label.CENTER));
		add(pointsAllocated);

		Button incr = new AttributeButton("+", this);
		incr.addActionListener(l);
		Button decr = new AttributeButton("-", this);
		decr.addActionListener(l);

		Panel p = new Panel();
		p.add(incr);
		p.add(decr);
		add(p);
	}

	// 更新 pointsAllocated label
	public void allocatePoints(int allocatePoints) {
		int value = getPointsAllocated() + allocatePoints;
		pointsAllocated.setText("" + value);
	}

	// 返回给这个属性分配的点值
	public int getPointsAllocated() {
		return Integer.parseInt(pointsAllocated.getText());
	}

	@Override
	public String toString() {
		return attribute + ": " + getPointsAllocated();
	}

}
