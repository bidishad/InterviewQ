package RedMart1;

import java.util.ArrayList;

public class van {
	private final static int MAX_CARTON_PER_VAN = 20;
	ArrayList<carton> cartons;
	
	public van(){
		cartons = new ArrayList<carton>();
	}
	
	public void addNewCarton(carton c){
		if(cartons.size()<MAX_CARTON_PER_VAN){
			cartons.add(c);
		}
	}
}
