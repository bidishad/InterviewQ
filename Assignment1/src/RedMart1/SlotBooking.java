package RedMart1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class SlotBooking {
	ArrayList<van> vans;
	HashMap<Integer,String> slots;
	
	public SlotBooking(){
		slots = new HashMap<Integer, String>();
		slots.put(0, "9AM-11AM");
		slots.put(1, "11AM-1PM");
		slots.put(2, "2PM-4PM");
		slots.put(3, "4PM-6PM");
		
		slots.put(10, "No Slots available today and Tomorrow");
		vans = new ArrayList<van>();
		for(int i=0;i<4;i++){
			vans.add(new van());
		}
	}
	
	@SuppressWarnings("deprecation")
	public ArrayList<Integer> availableSlots(ArrayList<Item> order){
		int i =0;
		
		Date dt = new Date();
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(dt.getHours()<9){
			i = 0;
		}
		else if (dt.getHours() < 11) {
			i = 1;
		} else if (dt.getHours() < 14) {
			i = 2;
		} else if (dt.getHours() < 16) {
			i = 3;
		} else {
			i = 4;
		}
		
		int totalVolume = 0;
		for(int j=0;j<order.size();j++){
			totalVolume += order.get(i).getVolume();
			
		}
		
		int numOfCartonRequired = totalVolume / (15*15*30);
		
		if(numOfCartonRequired==0){
			numOfCartonRequired = 1;
		}
		
		for(; i <8;i++){
			for(int k = 0;k<4;k++){
				van hold = vans.get(k);
				if(hold.cartons.size() + numOfCartonRequired <=20){
					for(int t=0;t<numOfCartonRequired ; t++){
						hold.addNewCarton(new carton());
					}
					result.add(i);
					break;
				}
			}
		}
		
		if(result.isEmpty()){
			result.add(10);
		}
		
		return result;
	}
}
