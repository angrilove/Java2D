package alpha;

import java.applet.Applet;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Checkbox监听使用ItemListener.
 */
public class CheckboxTest extends Applet implements ItemListener {

	private static final long serialVersionUID = 1L;

	private CheckboxGroup group;

	private final String selections[] = {"Pepsi", "Coke", "Mountain Dew", "Tab"};

	private Checkbox createCheckbox(String label,
			CheckboxGroup group, boolean state) {
		Checkbox chk = new Checkbox(label, group, state);
		chk.addItemListener(this);
		return chk;
	}

	@Override
	public void init() {
		group = new CheckboxGroup();
		for (int i = 0; i < selections.length; i++) {
			add(createCheckbox(selections[i], group, false));
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println("Yes, I cerainly agree, " 
			+ group.getSelectedCheckbox().getLabel() + " is very delicious!");
	}

}
