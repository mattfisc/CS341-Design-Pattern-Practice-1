

import javax.swing.Icon;

/**
 * 
 * @author Matthew Fischer
 *
 */
public class ListItem implements Comparable<ListItem> {
	private int valA;
	private int valB;
	
	/**
	 * ListItem constructor
	 * @param valA
	 * @param valB
	 */
	public ListItem(int valA, int valB) {
		this.valA = valA;
		this.valB = valB;
	}

	/**
	 * getValA function gets an int value A
	 * @return valA int
	 */
	public int getValA() {
		return valA;
	}
	
	/**
	 * getValB function gets an int value B
	 * @return valB int
	 */
	public int getValB() {
		return valB;
	}

	/**
	 * createIcon function converts a ListItem to an Icon
	 * @param diameter int is the diameter of the Icon
	 * @return Icon of the ListItem
	 */
	public Icon createIcon(int diameter) {
		return new ItemIcon(this, diameter);
	}

	@Override
	public int compareTo(ListItem o) {
		return 0;
	}

}