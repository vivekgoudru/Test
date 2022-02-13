import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class Test01_GET {

	@BeforeTest
	void test_03() {
		System.out.println("Checking Pre requisites :) ");
	}
	@Test
	void test_01() {

		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		int Actual = response.statusCode();
		Assert.assertEquals(Actual, 200);
	}
	@Test
	void test_02() {
		given().
			get("https://reqres.in/api/users?page=2").
		then().
			statusCode(200).
			body("data.id[0]", equalTo(7)).
			body("data.first_name", hasItems("Lindsay","Tobias"));
	}
	
}
