package alpha;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.MalformedURLException;
import java.net.URL;

public class AudioClipTest extends Applet
		implements ActionListener, ItemListener {

	private static final long serialVersionUID = 1L;

	private AudioClip ac;

	private Button button;

	private Checkbox checkbox;

	@Override
	public void init() {
		try {
			URL url = new URL(getCodeBase() + "audio/");
			System.out.println(getCodeBase());
			ac = getAudioClip(url, "spacemusic.au");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		setBackground(Color.GREEN);

		button = new Button("Play!");
		button.addActionListener(this);
		add(button);

		checkbox = new Checkbox("Loop?", null, false);
		checkbox.addItemListener(this);
		add(checkbox);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (button.getLabel().equals("Stop!")) {
			ac.stop();
			button.setLabel("Play!");
		} else if (button.getLabel().equals("Play!")) {
			if (checkbox.getState() == true) {
				ac.loop();
			} else {
				ac.play();
			}
			button.setLabel("Stop!");
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (checkbox.getState() == true) {
			ac.loop();
			button.setLabel("Stop!");
		} else {
			ac.stop();
			button.setLabel("Play!");
		}
	}

}
