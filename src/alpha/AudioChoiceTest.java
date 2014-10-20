package alpha;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 * @author ex4m
 *
 */
public class AudioChoiceTest extends Applet implements ActionListener {

	private static final long serialVersionUID = 1L;

	public final String[] AUDIOS = {
			"ping", "pop", "return",
			"salvation", "shuffle", "squish"
			};

	private AudioClip[] clips;

	private Choice choice;

	private Button playClip;
	private Button loopClip;
	private Button sequenceClip;
	private Button stopClip;
	private Button stopAllClip;

	private boolean[] clipsPlaying;

	@Override
	public void init() {

		setBackground(new Color(48, 255, 0));

		choice = new Choice();
		clips = new AudioClip[AUDIOS.length];
		clipsPlaying = new boolean[AUDIOS.length];
		URL url = null;
		try {
			 url = new URL(getCodeBase(), "audio/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < AUDIOS.length; i++) {
			choice.add(AUDIOS[i]);
			clips[i] = getAudioClip(url, AUDIOS[i] + ".au");
			clipsPlaying[i] = false;
		}

		add(choice);

		playClip = new Button("Play clip");
		playClip.addActionListener(this);
		add(playClip);

		loopClip = new Button("Loop clip");
		loopClip.addActionListener(this);
		add(loopClip);

		sequenceClip = new Button("Sequence clip");
		sequenceClip.addActionListener(this);
		add(sequenceClip);

		stopClip = new Button("Stop clip");
		stopClip.addActionListener(this);
		add(stopClip);

		stopAllClip = new Button("Stop all clip");
		stopAllClip.addActionListener(this);
		add(stopAllClip);

		stopClip.setEnabled(false);
		stopAllClip.setEnabled(false);
	}

	public void stop() {
		for (int i = 0; i < AUDIOS.length; i++) {
			if (clipsPlaying[i]) {
				clips[i].stop();
				clipsPlaying[i] = false;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int clipIndex = choice.getSelectedIndex();
		AudioClip clip = clips[clipIndex];

		if (e.getSource() == playClip) {
			clip.play();
			stopClip.setEnabled(true);
			stopAllClip.setEnabled(true);
			clipsPlaying[clipIndex] = true;
		} else if (e.getSource() == loopClip) {
			clip.loop();
			stopClip.setEnabled(true);
			stopAllClip.setEnabled(true);
			clipsPlaying[clipIndex] = true;
		} else if (e.getSource() == sequenceClip) {
			// TODO AudioClip 无法检测 Audio 是否正在播放所以没有办法‘顺序播放’音频
			stop();
			for (int i = 0; i < AUDIOS.length; i++) {
				clips[i].play();
				clipsPlaying[i] = true;
			}
			stopClip.setEnabled(true);
			stopAllClip.setEnabled(true);
		} else if (e.getSource() == stopClip) {
			clip.stop();
			stopClip.setEnabled(false);
			stopAllClip.setEnabled(false);

			clipsPlaying[clipIndex] = false;

			for (int i = 0; i < AUDIOS.length; i++) {
				if (clipsPlaying[i]) {
					stopClip.setEnabled(true);
					stopAllClip.setEnabled(true);
					break;
				}
			}
		} else if (e.getSource() == stopAllClip) {
			for (int i = 0; i < AUDIOS.length; i++) {
				if (clipsPlaying[i]) {
					clips[i].stop();
					clipsPlaying[i] = false;
				}
			}

			stopClip.setEnabled(false);
			stopAllClip.setEnabled(false);
		}
	}

}
