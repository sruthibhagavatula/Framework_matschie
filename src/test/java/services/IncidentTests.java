/*package services;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.containsString;

import java.io.File;

public class IncidentTests extends BaseRequest{
	
	
	@Test
	public void getIncidents(){
		request
			.get("incident")
			.then()
			.assertThat()
			.statusCode(200)
			.body(containsString("number"),containsString("sys_id"));		
	}
	
	@Test
	public void createIncident(){
		request
			.body(new File("./data/incident1.json"))
			.get("incident")
			.then()
			.assertThat()
			.statusCode(200)
			.body(containsString("number"),containsString("sys_id"));		
	}
}
}
*/