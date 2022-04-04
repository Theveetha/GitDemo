package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	static RequestSpecification req;//here we have given static to this variable so that it can be shared accross various tests
	public RequestSpecification RequestSpecification() throws IOException {
		if(req==null)//this file creation will be executed only once when there is no data present in the req variable
		{
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));//we have to give the file we have to parse the file path. To create a new file in run stream there is a class called new FileOutputStream where it outputs all data into a file
		req = new RequestSpecBuilder()
				.addFilter(RequestLoggingFilter.logRequestTo(log))//this filter will be applied to the req object so that it will remember to log the requests and responses whenever this object is referred to.
				//logRequestTo is another method where we have to mention how do we want to store/view the response like log it to console or any file. This logrequestTo is expecting an object of PrintStream class. So we have to create an object
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
//				.setBaseUri("https://rahulshettyacademy.com")//here instead of hardcoding we have to call the method
				.setBaseUri(getGlobalValue("baseUrl"))
				.addQueryParam("key", "qaclick123")
				.setContentType(ContentType.JSON).build();
		return req;
		}
		return req;
	}
	
	public static String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties(); //Properties is a class present in Java for which we have to create an object.
		//Now to mention where exactly our file is present we can use method FileInputStream. FileOutputStream is used to create the new file
		FileInputStream fis = new FileInputStream("C:\\Users\\theve\\eclipse-workspace\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);//here this is used to link our FilePath to the Properties object.
		prop.getProperty(key);//From that Properties object we are parsing key as an argument to get our value in out getProperty method.
		//return prop;//this is wrong as we have to parse the string ie value of our key. so we have to return the value
		return prop.getProperty(key);
	}
	
	public String getJsonPath(Response response,String key) {
		String Resp = response.asString();
		JsonPath js = new JsonPath(Resp);
		return js.get(key).toString();//to know the key value we can just call this method
	}

}
