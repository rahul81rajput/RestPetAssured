package api.endPoints;
import static io.restassured.RestAssured.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import api.payload.Users;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class UserEndPoints {
	
	
	public static  int get(ITestContext contxt) {		
       int st = given()
		.when().get(routes.GetUri).statusCode();
		return st;
	}
	
	
	public static Response post(Users up) {
		System.out.println("Enter");
		Gson gson =new Gson();
		String s=gson.toJson(up);
		System.out.println(s);
		Response res = given().contentType(ContentType.JSON).body(s).accept(ContentType.JSON)
		.when().post(routes.PostUri);System.out.println("Post");
		return res;
	}
	
	
    public static Response delet(int id) {
    	Response res = given()
    	.when().delete(routes.DeletUri+id);
        return res;
}
	public static Response purchase(int id) {
		
		Response res = given()
		.when().get(routes.PurchaseOrder+id);
		return res;
	}
	
	
	
}
