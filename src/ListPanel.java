import java.awt.Component;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class ListPanel extends JPanel {
	private int diameter = 30;
	private ArrayList<AdapterItem> mList = null;

	public ListPanel(String title) {
		super();
		mList = new ArrayList<AdapterItem>();
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED), title));
	}

	public ListPanel(String title, ArrayList<AdapterItem> list) {
		this(title);
		addItems(list);
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
		repaint();
	}

	public void addItems(ArrayList<AdapterItem> list) {
		mList = (ArrayList<AdapterItem>) list.clone();
		for (AdapterItem item : mList) {
			add(new JLabel(item.createIcon(diameter)));
		}
	}
	
	public void sort() {
	
	}
	
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