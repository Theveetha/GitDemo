package Demo;

public class Demo {
	
	String AddPlaceAPI = "/maps/api/place/add/json";
	String GetPlaceAPI = "/maps/api/place/get/json";
	String DeletePlaceAPI = "/maps/api/place/delete/json";
	
	public String getAddPlace() {
		return AddPlaceAPI;
	}

	public String getGetPlace() {
		return GetPlaceAPI;
	}

	public String getDeletePlace() {
		return DeletePlaceAPI;
	}
}
