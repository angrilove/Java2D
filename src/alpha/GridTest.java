/*
 * Copyright anshen.
 */
package alpha;

import java.applet.Applet;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.StringTokenizer;

public class GridTest extends Applet {
	
	private static final long serialVersionUID = 1L;
	
	private final Color[] bgColors = new Color[] {
		Color.RED, Color.BLUE, Color.GREEN,
		Color.YELLOW, Color.PINK, Color.CYAN,
		Color.GRAY, Color.ORANGE, Color.MAGENTA
	};

	@Override
	public void init() {
		String str = "My Head Is My Only House Unless It Rains";
		StringTokenizer st = new StringTokenizer(str);

		setLayout(new GridLayout(3, 3, 5, 5));

		int i = 0;
		while (st.hasMoreTokens()) {
			Label label = new Label(st.nextToken(), Label.CENTER);
			label.setBackground(bgColors[i]);
			add(label);
			i++;
		}
	}

}
