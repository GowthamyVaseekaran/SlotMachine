package Coursework2;

public class Symbol implements ISymbol {

	private String image = " ";
	private int value = 0;

	/**
	 * Create constructor
	 * 
	 * @param image
	 * @param value
	 */
	public Symbol(String image, int value) {
		this.image = image;
		this.value = value;
		
	}

	@Override
	public void setImage(String image) {
		this.image=image;

	}

	@Override
	public String getImage() {
	return image;

	}

	@Override
	public void setValue(int v) {
		this.value=v;

	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return value;
		
	}
	
	public boolean equalTo(Symbol s){
		if(this.value == s.value){
			return true;
		}else{
			return false;
		}
		
		
	}

}
