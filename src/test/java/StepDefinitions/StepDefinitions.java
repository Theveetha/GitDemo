package StepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinitions extends Utils {
	RequestSpecification GivenReq;
	Response SpecResponse;
	JsonPath js;
	static String placeid;//here we have to add static 'coz this value we want it to remain constant throughout all test cases
	
	TestDataBuild Data = new TestDataBuild();//Create an object for TestDataBuild class so that we can access all the methods present within the class
//	Demo DemoAPI = new Demo();
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_Place_Payload_with(String name, String address, String language) throws IOException {
		
		GivenReq = given().spec(RequestSpecification())
				.body(Data.AddPlacePayload(name, language, address));//now here instead of the object created for pojo class we can call the object created for the TestDataBuild class and access the method. similarly we are calling for the RequestSpec.
	}

//	@When("User calls {string} with Post http request")
//	public void user_calls_with_Post_http_request(String API) throws IOException {//here API is the String that we get from When Statement
////		if(API=="Add Place API")
////		{
////		resource = APIResources.getAddPlace.toString();
////		}
////		else if(API=="Get Place API")
////		{
////		resource = APIResources.getGetPlace.toString();
////		}
//		APIResources resource = APIResources.valueOf(API);//here this ValueOf is expecting a String, which is retrieved from the argument in this method and that arg we are parsing it from When statement in feature file. Also we are creating an object for that class
//		resource.getResource();//this will return us the API String path
//		
//		SpecResponse = GivenReq//here GivenReq and res are declared in another method which is present in @Given. So we will get an error as that variable is not global. To over come this we have to declare those variables in the class level.
////				.when().post("/maps/api/place/add/json")
//				.when().post(resource.getResource());
////				.when().post(getGlobalValue("AddAPI"))
////				.when().post(DemoAPI.getAddPlace())
//	}
	
	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String API, String Method) throws IOException {
		APIResources resource = APIResources.valueOf(API);
//		SpecResponse = GivenReq
//					.when().post(resource.getResource());//here we have to make it dynamic using if
		if(Method.equalsIgnoreCase("Post"))
			SpecResponse = GivenReq
						.when().post(resource.getResource());
		else if(Method.equalsIgnoreCase("Get"))
			SpecResponse = GivenReq
						.when().get(resource.getResource());
		else if (Method.equalsIgnoreCase("Delete"))
			SpecResponse = GivenReq
						.when().delete(resource.getResource());
		else if (Method.equalsIgnoreCase("Update"))
			SpecResponse = GivenReq
						.when().put(resource.getResource());
//		System.out.println(SpecResponse.asPrettyString());
	}

	@Then("API call is success with Status Code {int}")
	public void api_call_is_success_with_Status_Code(Integer status) {
		Assert.assertEquals(SpecResponse.getStatusCode(),200);
	}

	@And("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
//		String Resp = SpecResponse.asString();
//		js = new JsonPath(Resp);//here we are removing this 'coz we have created a new method in Utils to retrieve us the value based on the key we parse
//		Assert.assertEquals(js.get(key).toString(),value);
		Assert.assertEquals(getJsonPath(SpecResponse,key),value);//here instead of conversion we are just calling the method
	}
	
	@And("verify {string} created maps to {string} using {string} for {string}")
	public void verify_created_maps_to_using(String key,String expected, String API, String responsekey) throws IOException {
//		placeid = js.get(key).toString();//here this js method we are using way often to pull the key value. So we can replace this by writing a common method in Utils which based on the key returns us the value
		if(placeid==null)//only if the placeid is null we have to update it else we have to reuse
		placeid = getJsonPath(SpecResponse,key);//here from method we are getting the value of the key present in feature
		
	    GivenReq = given().spec(RequestSpecification())
	    	.queryParam("place_id", placeid);
	    
	    user_calls_with_http_request(API,"get");//this step will automatically hit the Get http method as we are reusing the usercalls method.
	    Assert.assertEquals(getJsonPath(SpecResponse,responsekey),expected);//using the Json method created we are validating the name of the address is as expected or not
	}
	
	@Given("{string} Place Payload")
	public void place_Payload_with(String Method) throws IOException {
		if(Method.equalsIgnoreCase("Update"))
		{
			GivenReq = given().spec(RequestSpecification())
				.body(Data.UpdatePlacePayload(placeid,"Seetha ram nagar"));
		}
		else if(Method.equalsIgnoreCase("Delete"))
		{
			GivenReq = given().spec(RequestSpecification())
				.body(Data.DeletePlacePayload(placeid));
		}
	}
	
	@And("verify {string} using {string}")
	public void verify_using(String key, String API) throws IOException {
		GivenReq = given().spec(RequestSpecification())
				.queryParam(key, placeid);
		
		user_calls_with_http_request(API,"get");
	}
	
}
