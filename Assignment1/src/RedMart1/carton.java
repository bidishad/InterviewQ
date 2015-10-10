package RedMart1;

import java.util.ArrayList;

public class carton {
	private int height;
	private int width;
	private int breadth;
	private int Volume;
	
	ArrayList<Item> items;
	
	public carton(){
		this.height = 15;
		this.width = 30;
		this.breadth = 15;
		
		this.Volume = this.height * this.width * this.breadth;
		
		items = new ArrayList<Item>();
	}
	
	public void addNewItem(Item item){
		Volume -= item.getVolume();
		items.add(item);
	}
}
