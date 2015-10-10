package redmart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;




public class ClientProgram1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JSONObject obj1 = new JSONObject();
		JSONObject obj2 = new JSONObject();
		JSONObject obj3 = new JSONObject();
		JSONArray arr = new JSONArray();
		
		try{
			obj1.put("ID", "1");
			obj1.put("height", "10");
			obj1.put("width", "5");
			obj1.put("breadth", "9");
			arr.put(obj1);
			
			obj2.put("ID", "2");
			obj2.put("hight", "10");
			obj2.put("width", "4");
			obj2.put("breadth", "9");
			arr.put(obj2);
			
			obj3.put("ID", "3");
			obj3.put("hight", "8");
			obj3.put("width", "5");
			obj3.put("breadth", "9");
			arr.put(obj3);
			
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost request = new HttpPost
					("http://localhost:8080/Assignment1/rest/redmart/getSlotString");
			StringEntity input = new StringEntity(arr.toString());
			input.setContentType("application/json");
			request.setEntity(input);
			
			System.out.println(arr.toString());
			HttpResponse response = httpClient.execute(request);
			
			BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			
		}catch(Exception ex){
			
		}
	}

}
