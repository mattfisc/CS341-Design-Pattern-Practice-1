import javax.swing.Icon;

public class AdapterItem implements AdapterItemInterface{

	
	public Icon icon;
	
	public AdapterItem(Icon icon) {
		this.icon = icon;
	}

	@Override
	public int getIconHeight() {
		return icon.getIconHeight();
	}

	@Override
	public int getIconWidth() {
		return icon.getIconWidth();
	}

	@Override
	public void paintIcon() {
		// TODO Auto-generated method stub
		
	}
	
}
