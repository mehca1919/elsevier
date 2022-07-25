package com.practice.test;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.practice.utils.API_Constans;

import io.restassured.RestAssured;

public class ApiTest {
	@Test
	public void testApi() {
		RestAssured.baseURI = API_Constans.BASE_URI;

		RestAssured.given().when().get(API_Constans.END_POINT)
		      .then().assertThat().statusCode(200).and()
		      .body("books[0].author", Matchers.is("Richard E. Silverman"))
		      .and().contentType("application/json");
		// System.out.println(res.asPrettyString());
		//res.then().assertThat().body("books[0].author", Matchers.is("Richard1 E. Silverman"));
//		assertEquals(200, res.statusCode());
//
//		JsonPath j = new JsonPath(res.asString());
//		assertEquals("Richard E. Silverman", j.get("books[0].author").toString());

	}
}
