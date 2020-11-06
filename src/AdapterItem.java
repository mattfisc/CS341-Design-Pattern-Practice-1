import javax.swing.Icon;

public class AdapterItem implements AdapterItemInterface{

	
	public ListItem li;
	private ItemIcon ii;
	
	public AdapterItem(ListItem li) {
		this.li = li;
		this.ii = null;
	}

	public AdapterItem(ItemIcon ii) {
		this.li = null;
		this.ii = ii;
	}

	@Override
	public int getValA() {
		if(li != null) 
			return li.getValA();
		
		else if(ii != null)
			return ii.getValA();
		
		return 0; 
			
	}

	@Override
	public int getValB() {
		if(li != null) 
			return li.getValB();
		
		else if(ii != null)
			return ii.getValB();
		
		return 0;
	}

	@Override
	public Icon createIcon(int diameter) {
		if(li != null) 
			return li.createIcon(diameter);
		
		else if(ii != null) {
			ii.setDiameter(diameter);
			return ii;
		}
		System.out.println("null");
		return null;
	}
	
	
}
