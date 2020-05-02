package services;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.containsString;

import java.io.File;

public class ChangeManagementTests extends BaseRequest{
	
	
	/*@Test
	public void getIncidents(){
		request
			.get("ChangeRequest")
			.then()
			.assertThat()
			.statusCode(200)
			.body(containsString("number"),containsString("sys_id"));		
	}*/
	
	
	/*public void createChangeRequest(){
		request
			.body(new File("./data/CR1.json"))
			.post("change_request")
			.then()
			.assertThat()
			.statusCode(200)
			.body(containsString("number"),containsString("sys_id"));		
	}*/
}
