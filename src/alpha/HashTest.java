package alpha;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.AffineTransform;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;

public class HashTest extends Applet implements ItemListener {

	private static final long serialVersionUID = 1L;

	// 用来添加平铺图片的Hashtable
	private Hashtable<String, Image> imageTable;

	// 选择不同平铺图像的选项
	private Choice selections;

	// 假设图片块的宽与高相等，这个值既代表宽又代表高
	private int imageSize;

	// 图片文件名
	private final String[] filenames = {
			"cement.gif", "dirt.gif", "grass.gif",
			"pebbles.gif", "stone.gif", "water.gif", "smile.gif"
		};

	// 初始化 Applet
	@Override
	public void init() {
		int len = filenames.length;
		imageTable = new Hashtable<String, Image>(len);
		selections = new Choice();
		// 创建一个 Panel 在窗体的底部容纳选择框
		Panel p = new Panel();
		p.add(selections, BorderLayout.SOUTH);
		p.setBackground(Color.RED);
		// 把 Choice 添加到 applet 中并注册 ItemListener
		setLayout(new BorderLayout());
		add(p, BorderLayout.SOUTH);
		selections.addItemListener(this);
		URL url = null;
		try {
			url = new URL(getCodeBase() + "image/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		// 为图像分配内存
		for (int i = 0; i < len; i++) {
			Image imge = getImage(url, filenames[i]);
			while (imge.getWidth(this) < 0) {
				continue;
			}
			// 把图像添加到 Hashtable 和 Choice 中
			imageTable.put(filenames[i], imge);
			selections.add(filenames[i]);
			// 设置 imageSize 属性
			if (i == 0) {
				imageSize = imge.getWidth(this);
			}
			if (imageSize < imge.getWidth(this)) {
				imageSize = imge.getWidth(this);
			}
		}
	}

	// 在 Applet 内平铺当前选择的对象
	@Override
	public void paint(Graphics g) {
		// 把传入的 Graphics 容器转化为可用的 Graphics2D 对象
		Graphics2D g2d = (Graphics2D) g;
		// 保存 Applect 的宽和高
		int width = getSize().width;
		int height = getSize().height;
		// 为放置平铺图像创建一个 AffineTransform
		AffineTransform at = new AffineTransform();
		// 得到当前所选择的图像
		Image currImage = imageTable.get(selections.getSelectedItem());
		// 在 Applet 内铺满图像
		int y = 0;
		while (y < height) {
			int x = 0;
			while (x < width) {
				at.setToTranslation(x, y);
				// 绘制图像
				g2d.drawImage(currImage, at, this);
				x += imageSize;
			}
			y += imageSize;
		}
	}

	// 在所选图像改变时调用
	@Override
	public void itemStateChanged(ItemEvent e) {
		// 重绘画面
		repaint();
	}
}
