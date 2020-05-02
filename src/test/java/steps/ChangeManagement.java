package steps;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;

import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ChangeManagement {
	private Response response;
	private ValidatableResponse json;
    private RequestSpecification request;
    String CRNum;
    private JsonPath response1;
    
	@Given("User to be authenticated")
	public void setUp(){ 
		request = given().log().all();
	}
	
	@And("CR will be added with short_desc")
	public void cr_will_be_added_with_short_desc(){
		String short_desc="description from matschie";
		request = request.and().body("{\r\n" + 
				"	\"short_description\" : \"Good start\",\r\n" + 
				"	\"category\" : \"software\",\r\n" + 
				"	\"description\" : \"sruthi\"\r\n" + 
				"}");
		
	}
	
	@And("get the CR")
	
	public void get_the_CR() {
		response=request.and().contentType(ContentType.JSON).get("change_request");
		
	}
	
	@When("get the CRNumber")
	
		public void get_the_CRNumber() 
		{
		response1= response.jsonPath();
		int count=response1.getList("result.sys_id").size();
		System.out.println(count);
		int rand=(int) Math.floor(Math.random()*count);
		System.out.println(rand);
		CRNum=(String) response1.getList("result.sys_id").get(rand);
		System.out.println(CRNum);
	}
	
	@When("delete the cr")
	public void delete_the_cr()
	{	
		response=request.when().contentType(ContentType.JSON).delete("change_request/"+CRNum);
		
	}
	@When("new CR is created")
	
	public void a_new_CR_created(){
		System.out.println(request);
		response = request.when().contentType(ContentType.JSON).post("change_request");
		System.out.println("response: " + response.prettyPrint());
}
	@Then("the status code should be (\\d+)$")
	public void verify_status_code(int statusCode){
		json = response.then().statusCode(statusCode);
	}


}
