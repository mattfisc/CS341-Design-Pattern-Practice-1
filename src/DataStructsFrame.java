import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Matthew Fischer
 */
public class DataStructsFrame extends JFrame implements ActionListener, MouseListener {
	
	private JPanel panel;
	
	private ArrayList<AdapterItem> list;
	private ListPanel unorderedList;
	private ListPanel orderedList;
	
	private JButton sortButton;
	private JButton sortButton2;
	private JButton addVal;
	
	private JTextField inputValA;
	private JTextField inputValB;
	
	public DataStructsFrame(String title, int[] array1,int[] array2) {
		super(title);

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		list = arrayToList(array1,array2);

		unorderedList = new ListPanel("Unordered List");
		unorderedList.setDiameter(75);
		unorderedList.addItems(list);
		
		
		panel.add(unorderedList);
		
		
		orderedList = new ListPanel("Ordered List");
		orderedList.setDiameter(100);

		sortButton = new JButton("Sort High to Low Val A");
		sortButton.setSize(30, 10);
		sortButton.setAlignmentX(CENTER_ALIGNMENT);
		sortButton.addActionListener(this);
		panel.add(sortButton);
		
		sortButton2 = new JButton("Sort Low to High Val B");
		sortButton2.setSize(30, 10);
		sortButton2.setAlignmentX(CENTER_ALIGNMENT);
		sortButton2.addActionListener(this);
		panel.add(sortButton2);

		inputValA = new JTextField("Value A...");
		inputValB = new JTextField("Value B...");
		
		inputValA.addMouseListener(this);
		inputValB.addMouseListener(this);
		
		addVal = new JButton("Add Values");
		addVal.setSize(30, 10);
		addVal.setAlignmentX(CENTER_ALIGNMENT);
		addVal.addActionListener(this);
		
		// ADD TO PANEL
		panel.add(addVal);
		panel.add(inputValA);
		panel.add(inputValB);
		
		// ADD PANEL TO PANEL
		panel.add(orderedList);
		add(panel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	/**
	 * arrayToList function changes an two arrays to a list of AdapterItems
	 * @param array1 array int for val A
	 * @param array2 array int for val B
	 * @return list of AdapterItems
	 */
	private ArrayList<AdapterItem> arrayToList(int[] array1,int[] array2) {
		ArrayList<AdapterItem> list = new ArrayList<AdapterItem>();

		for (int i = 0; i < array1.length; i++) {
			AdapterItem item = new AdapterItem( new ListItem(array1[i],array2[i]) );
			list.add(item);
		}

		return list;
	}
	
	/**
	 * actionPerformed function on button click performed
	 */
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == sortButton){
			orderedList.setOpaque(true);
			//Collections.sort(list);
			orderedList.sortHighToLow(list);
			
			orderedList.removeAll();
			
			orderedList.addItems(list);
			panel.add(orderedList);
			pack();
		}
		else if(ae.getSource() == sortButton2) {
			orderedList.setOpaque(true);

			orderedList.sortLowToHigh(list);
			//Collections.sort(list);
			orderedList.removeAll();
			
			orderedList.addItems(list);
			panel.add(orderedList);
			pack();
			
		}
		else if(ae.getSource() == addVal) {
			
			// GET VALUES
			int valA = Integer.parseInt(inputValA.getText());
			int valB = Integer.parseInt(inputValB.getText());
			
			// ADD ADAPTERITEM
			AdapterItem item = new AdapterItem(new ListItem(valA,valB));
			
			// ADD TO UNORGANIZED LIST
			list = unorderedList.addItem(list,item);

			pack();
			
			// RESET VALUE TEXT FIELD
			inputValA.setText("Value A...");
			inputValB.setText("Value B...");
			
			// CLEAR SORTED LIST
			orderedList.setOpaque(false);
				
		}
	}
	
	/**
	 * mouseClicked function if mouse clicks a textfield 
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == inputValA) {
			// empty textfield on click
			inputValA.setText("");
			
		}
		else if(e.getSource() == inputValB) {
			// empty textfield on click
			inputValB.setText("");
			
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
