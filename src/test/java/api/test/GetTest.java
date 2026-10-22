package api.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endPoints.UserEndPoints;
import api.payload.Users;
import io.restassured.response.Response;

public class GetTest {
	Users up;
	int id;
	@BeforeClass
	public void payload() {
		up=new Users();
       up.setId(1);
       up.setPetId(1);
       up.setQuantity(33);
       up.setShipDate("2026-10-22T18:36:30.670Z");
       up.setStatus("placed");
       up.setComplete(true);	
	}
	
@Test  (priority=1)
public void posts(ITestContext context) {
 Response get = UserEndPoints.post(up);
     get.then().log().all();
	Assert.assertEquals(get.statusCode(), 200);
	 id = get.jsonPath().getInt("id");
	context.setAttribute("id", id);
}


	/* (priority=2)
public void del(ITestContext context) {
		int id=(int) context.getAttribute("id");
Response res = UserEndPoints.delet(id);
Assert.assertEquals(res.getStatusCode(), 200);
}*/

	@Test  (priority=2)
	public void purc() {
		Response res = UserEndPoints.purchase(id);
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
		
	}
	
}
