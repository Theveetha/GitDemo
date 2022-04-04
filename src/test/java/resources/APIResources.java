package resources;

//enum is a special class in java which has collection of constants or methods
public enum APIResources {//here instead of class we have to give it as enum

	//in normal java class when we declare a method to return any string the below mentioned is the format
	
//	String AddPlaceAPI = "/maps/api/place/add/json";
//	
//	public String getAddPlace() {
//		return AddPlaceAPI;
//	}
	
	//But here in enum to give a method whose purpose is just to return a string we can just provide the method name and just parse the String as an argument. Various methods are separated by , and once trial of method ends we have to give ;
	
	getAddPlace("/maps/api/place/add/json"),
	getGetPlace("/maps/api/place/get/json"),
	getDeletePlace("/maps/api/place/delete/json"),
	getUpdatePlace("/maps/api/place/update/json");
	
	String resource;//here we are declaring the resource

	//the constructor should be created with class name. and since all of our methods are accepting string we have to make our constructor access one string
	APIResources(String resource) {
		this.resource = resource;//here we are assigning the resource argument of APIResource to the string.resource present in the class using the keyword this.resource, so that value of the method is now stored in the resource present in this class and that value we are returning using below method.
	}
	
	//To return the String stored in the constructor
	public String getResource()
	{
		return resource;//here we will get an error 'coz resource variable just belongs to the Constructor method and can't be used in another method. Hence we have declare a String resource outside these methods within a class
	}

}
