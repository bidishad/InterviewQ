package RedMart1;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item {

	private int ID;
	private int height;
	private int width;
	private int breadth;
	
	public Item(){
		
	}
	public Item( int id, int h,int w,int b){
		this.ID=id;
		this.height=h;
		this.width=w;
		this.breadth=b;
	}
	public int getID(){
		return this.ID;
	}
	public int getHeight(){
		return this.height;
	}
	public int getWidth(){
		return this.width;
	}
	public int getbreadth(){
		return this.breadth;
	}
	public void setID(int a){
		this.ID=a;
	}
	public void setHeight(int h){
		this.height=h;
	}
	public void setWidth(int w){
		this.width=w;
	}
	public void setBreadth(int b){
		this.breadth=b;
	}
	
	public int getVolume(){
		return height*width*breadth;
	}
	
	public String toString() {
		        return new StringBuffer(" ID : ").append(this.ID)
		                .append(" hight : ").append(this.height)
		                .append(" width : ").append(this.width).
		                append(" breadth ").append(this.breadth).toString();
		    }

}
