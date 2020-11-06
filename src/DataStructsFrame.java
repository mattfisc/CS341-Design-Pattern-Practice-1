import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DataStructsFrame extends JFrame {
	public DataStructsFrame(String title, int[] array1,int[] array2) {
		super(title);

		final JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		final ArrayList<ListItem> list = arrayToList(array1,array2);

		final ListPanel unorderedList = new ListPanel("Unordered List");
		unorderedList.setDiameter(75);
		unorderedList.addItems(list);

		final ListPanel orderedList = new ListPanel("Ordered List");
		orderedList.setDiameter(100);

		JButton sortButton = new JButton("Sort High to Low Val A");
		sortButton.setSize(30, 10);
		sortButton.setAlignmentX(CENTER_ALIGNMENT);

		sortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				sortHighToLow(list);
				Collections.sort(list);
				orderedList.removeAll();
				orderedList.addItems(list);
				panel.add(orderedList);
				pack();
			}
		});

		panel.add(unorderedList);
		panel.add(sortButton);
		
		JButton sortButton2 = new JButton("Sort Low to High Val B");
		sortButton2.setSize(30, 10);
		sortButton2.setAlignmentX(CENTER_ALIGNMENT);

		sortButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				sortLowToHigh(list);
				Collections.sort(list);
				orderedList.removeAll();
				orderedList.addItems(list);
				panel.add(orderedList);
				pack();
			}
		});

		panel.add(sortButton2);
		
		add(panel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private ArrayList<ListItem> arrayToList(int[] array1,int[] array2) {
		ArrayList<ListItem> list = new ArrayList<ListItem>();

		for (int i = 0; i < array1.length; i++) {
			ListItem item = new ListItem(array1[i],array2[i]);
			list.add(item);
		}

		return list;
	}
	
	private void sortHighToLow(ArrayList<ListItem> list) {
		for(int i = 0; i < list.size()-1; i++) {
			if(list.get(i).getValA() < list.get(i+1).getValA() ) {
				ListItem temp = list.get(i);
				list.set(i, list.get(i+1));
				list.set(i+1, temp);
				i = -1;
			}
		}
	}
	private void sortLowToHigh(ArrayList<ListItem> list) {
		for(int i = 0; i < list.size()-1; i++) {
			if(list.get(i).getValB() > list.get(i+1).getValB() ) {
				ListItem temp = list.get(i);
				list.set(i, list.get(i+1));
				list.set(i+1, temp);
				i = -1;
			}
		}
	}
}
