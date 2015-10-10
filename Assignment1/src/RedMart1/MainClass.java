package RedMart1;


import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


@Path("/redmart")
public class MainClass {
	SlotBooking slot;
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/getSlotString")
	public String provideSlotInfoString(String inputString) {
		JSONArray inputArr = null;
		try {
			inputArr = new JSONArray(inputString);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (inputArr != null) {
			ArrayList<Item> iList = new ArrayList<Item>();
			for (int i = 0; i < inputArr.length(); i++) {
				try {
					iList.add(new Item(Integer.parseInt(inputArr
							.getJSONObject(i).get("ID").toString()), Integer
							.parseInt(inputArr.getJSONObject(i).get("height")
									.toString()), Integer.parseInt(inputArr
							.getJSONObject(i).get("width").toString()), Integer
							.parseInt(inputArr.getJSONObject(i).get("breadth")
									.toString())));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			ArrayList<Integer> rslt = new ArrayList<Integer>();
			rslt = slot.availableSlots(iList);
			JSONArray resJArr = new JSONArray();
			JSONObject[] localjs = new JSONObject[rslt.size()];
			for (int i = 0; i < rslt.size(); i++) {
				try {
					localjs[i] = new JSONObject();
					if (rslt.get(i) / 4 == 0)
						localjs[i].put("Today", i);
					else if (rslt.get(i) / 4 == 1)
						localjs[i].put("Tomorrow", i);
					else
						localjs[i].put("Slot", 0);

					localjs[i].put("Time", slot.slots.get((rslt.get(i) % 4)));
					resJArr.put(localjs[i]);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			localjs = null;
			String res = null;
			try {
				res = resJArr.toString(1);
				System.out.println(res);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return res;
		} else {
			return "Something went wrong";
		}
	}
}
