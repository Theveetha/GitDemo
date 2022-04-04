package resources;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddressLocation;
import Pojo.GetAddress;
import Pojo.UpdateAddress;

public class TestDataBuild {
	
	public GetAddress AddPlacePayload(String name, String language, String address) {
		GetAddress ga = new GetAddress();
		ga.setAccuracy(50);
		ga.setName(name);
		ga.setPhone_number("(+91) 983 893 3937");
		ga.setAddress(address);
		ga.setWebsite("http://google.com");
		ga.setLanguage(language);

		List<String> TypeList = new ArrayList<String>();
		TypeList.add("shoe park");
		TypeList.add("shop");
		ga.setTypes(TypeList);
		
		AddressLocation al = new AddressLocation();
		al.setLat(-38.383494);
		al.setLng(33.427362);
		ga.setLocation(al);
		
		return ga;//here we are returning the object of GetAddress class
	}
	
	public UpdateAddress UpdatePlacePayload(String place_id, String address) {
		UpdateAddress ua = new UpdateAddress();
		ua.setPlace_id(place_id);
		ua.setAddress(address);
		ua.setKey("qaclick123");
		return ua;
	}
	
	public String DeletePlacePayload(String placeid) {
		return "{\r\n"
				+ "    \"place_id\":\""+placeid+"\"\r\n"
				+ "}";
	}

}
