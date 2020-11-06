import javax.swing.Icon;

public class AdapterItem implements AdapterItemInterface{

	
	public ListItem li;
	private ItemIcon ii;
	
	/**
	 * AdapterItem constructor
	 * @param li ListItem
	 */
	public AdapterItem(ListItem li) {
		this.li = li;
		this.ii = null;
	}

	/**
	 * AdapterItem constructor
	 * @param ii ItemIcon
	 */
	public AdapterItem(ItemIcon ii) {
		this.li = null;
		this.ii = ii;
	}

	/**
	 * getValA function
	 * return valA int
	 */
	@Override
	public int getValA() {
		if(li != null) 
			return li.getValA();
		
		else if(ii != null)
			return ii.getValA();
		
		return 0; 
			
	}

	/**
	 * getValB function
	 * return valB int
	 */
	@Override
	public int getValB() {
		if(li != null) 
			return li.getValB();
		
		else if(ii != null)
			return ii.getValB();
		
		return 0;
	}

	/**
	 * createIcon function of ItemIcon or ListItem
	 * return Icon of a ItemIcon or ListItem 
	 */
	@Override
	public Icon createIcon(int diameter) {
		if(li != null) 
			return li.createIcon(diameter);
		
		else if(ii != null) {
			ii.setDiameter(diameter);
			return ii;
		}
		return null;
	}
	
	
}
