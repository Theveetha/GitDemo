package StepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace or @UpdatePlace")
	public void beforeScenario() throws IOException {
		//here we have to call the methods which will generate us the place_id
		//also we have to run this only if the place_id is null 'coz there is an option of run the scenario completely or using tag and if they are running it completely we needn't create data again
		StepDefinitions sd = new StepDefinitions();
//		if(sd.placeid==null)//here since placeid is static variable its assigned to class memory and not object, hence we can directly call the variable using class name and not via object
		if(StepDefinitions.placeid == null)
		//here this will be executed only if placeid is null		
		{
		sd.add_Place_Payload_with("Zen", "Avalapalli", "Telugu");
		sd.user_calls_with_http_request("getAddPlace", "post");//these two are to generate Place_Id
		sd.verify_created_maps_to_using("place_id", "Zen", "getGetPlace", "name");//though this uses other validation since place_id assign is happening here we are using this method.
		}
	}

}
