import java.awt.Component;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 * 
 * @author Matthew Fischer
 *
 */
public class ListPanel extends JPanel {
	private int diameter = 30;
	private ArrayList<AdapterItem> mList = null;

	/**
	 * ListPanel constructor
	 * @param title String title of ListPanel (JPanel)
	 */
	public ListPanel(String title) {
		super();
		mList = new ArrayList<AdapterItem>();
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED), title));
	}
	
	/**
	 * ListPanel constructor
	 * @param title String title of ListPanel (JPanel)
	 * @param list ArayList of AdapterItems 
	 */
	public ListPanel(String title, ArrayList<AdapterItem> list) {
		this(title);
		addItems(list);
	}

	/**
	 * setDiameter function sets the diameter to this list and repaints on JPanel
	 * @param diameter int size of the icon being painted
	 */
	public void setDiameter(int diameter) {
		this.diameter = diameter;
		repaint();
	}

	/**
	 * addItems function adds all list items to a label and displays it on the JPanel
	 * @param list is an ArrayList of AdapterItems 
	 */
	public void addItems(ArrayList<AdapterItem> list) {
		mList = (ArrayList<AdapterItem>) list.clone();
		for (AdapterItem item : mList) {
			add(new JLabel(item.createIcon(diameter)));
		}
	}
	
	/**
	 * addItem function adds one item to the list and one JLabel to the JPanel
	 * @param list ArrayList of AdapterItems 
	 * @param item AdapterItem is added to list
	 * @return list is an ArrayList of AdapterItems 
	 */
	public ArrayList<AdapterItem> addItem(ArrayList<AdapterItem> list, AdapterItem item) {
		list.add(item);
		add(new JLabel(item.createIcon(diameter)));
		return list;
	}

	/**
	 * sortHighToLow function sorts val A from high to low
	 * @param list ArrayList of AdapterItems
	 */
	public void sortHighToLow(ArrayList<AdapterItem> list) {
		for(int i = 0; i < list.size()-1; i++) {
			if(list.get(i).getValA() < list.get(i+1).getValA() ) {
				AdapterItem temp = list.get(i);
				list.set(i, list.get(i+1));
				list.set(i+1, temp);
				i = -1;
			}
		}
	}
	
	/**
	 * sortLowToHigh function to sort Val B from low to high
	 * @param list ArrayList of AdapterItems
	 */
	public void sortLowToHigh(ArrayList<AdapterItem> list) {
		for(int i = 0; i < list.size()-1; i++) {
			if(list.get(i).getValB() > list.get(i+1).getValB() ) {
				AdapterItem temp = list.get(i);
				list.set(i, list.get(i+1));
				list.set(i+1, temp);
				i = -1;
			}
		}
	}
}