import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;

public class ItemIcon implements Icon {
	private final static int DEFAULT_THICKNESS = 5;
	private final static int DEFAULT_DIAMETER = 50;

	private int width = DEFAULT_DIAMETER;
	private int height = DEFAULT_DIAMETER;

	private int thickness = DEFAULT_THICKNESS;
	private int borderSize = DEFAULT_THICKNESS;

	private int valA;
	private int valB;
	
	/**
	 * ItemIcon constructor
	 * @param valA int for value A
	 * @param valB int for value B
	 */
	public ItemIcon(int valA, int valB) {
		this.valA = valA;
		this.valB = valB;
	}

	/**
	 * ItemIcon constructor
	 * @param valA int for value A
	 * @param valB int for value B
	 * @param diameter int is the diameter of a ItemIcon
	 */
	public ItemIcon(int valA, int valB, int diameter) {
		this.valA = (valA);
		this.valB = (valB);
		setDiameter(diameter);
	}

	/**
	 * ItemIcon constructor
	 * @param item ListItem converts to a ItemIcon
	 */
	public ItemIcon(ListItem item) {
		this.valA = item.getValA();
		this.valB = item.getValB();
	}

	/**
	 * ItemIcon constructor
	 * @param item ListItem converts elements to ItemIcon
	 * @param diameter int sets the diameter
	 */
	public ItemIcon(ListItem item, int diameter) {
		this(item);
		setDiameter(diameter);
	}

	/**
	 * setDiameter sets width and height of Icon by the diameter
	 * @param diameter int for width and height of icon
	 */
	public void setDiameter(int diameter) {
		width = diameter;
		height = diameter;
	}

	/**
	 * getIconHeight function gets the icon height
	 * return int height and default thickness
	 */
	public int getIconHeight() {
		return height + 2 * DEFAULT_THICKNESS;
	}

	/**
	 * getIconWidth function gets the icon width
	 * return int icon width and default thickness
	 */
	public int getIconWidth() {
		return width + 2 * DEFAULT_THICKNESS;
	}

	/**
	 * paintIcon function paints the icon on a graphic
	 */
	public void paintIcon(Component comp, Graphics g, int x, int y) {
		// get graphics context
		Graphics2D g2 = (Graphics2D) g;

		// set stroke size and color
		g2.setPaint(Color.BLACK);
		Stroke s = new BasicStroke(thickness);
		g2.setStroke(s);

		// draw white-filled circle with red border
		Ellipse2D e1 = new Ellipse2D.Float(x + borderSize, y + borderSize, height, width);
		g2.draw(e1);
		g2.setPaint(Color.WHITE);
		g2.fill(e1);
		g2.setPaint(Color.RED);

		// draw text
		Font f = new Font("Arial", Font.BOLD, 14);
		FontMetrics fm = g.getFontMetrics(f);
		String strValA = ((Integer) valA).toString();
		String strValB = ((Integer) valB).toString();
		Rectangle2D rect1 = fm.getStringBounds(strValA, g2);
		Rectangle2D rect2 = fm.getStringBounds(strValB, g2);

		int textHeight = (int) rect1.getHeight() ;
		int textWidth = (int) rect1.getWidth() +(int) rect2.getWidth();
		
		int panelHeight = getIconHeight();
		int panelWidth = getIconWidth();

		// Center text horizontally and vertically
		int offsetX = (panelWidth - textWidth) / 2;
		int offsetY = (panelHeight - textHeight) / 2 + fm.getAscent();

		// Draw the string.
		g2.setFont(f);
		g2.drawString(strValA+","+strValB, x + offsetX, y + offsetY);
	}

	/**
	 * @return the valA
	 */
	public int getValA() {
		return valA;
	}

	/**
	 * @param valA the valA to set
	 */
	public void setValA(int valA) {
		this.valA = valA;
	}

	/**
	 * @return the valB
	 */
	public int getValB() {
		return valB;
	}

	/**
	 * @param valB the valB to set
	 */
	public void setValB(int valB) {
		this.valB = valB;
	}
	
	
	
}
