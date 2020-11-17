package restassured;

import java.io.File;
import java.util.List;

import org.pojo.Data;
import org.pojo.RootClass;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestA {

	public static void main(String[] args) {
		
	RestAssured.baseURI = "https://reqres.in/";
	
	RootClass as = RestAssured.given().queryParam("page", "2").when().get("/api/user")
	.then().assertThat().statusCode(200).extract().as(RootClass.class);
		
	System.out.println(as.getPage());
	
	System.out.println(as.getPer_page());
	
	System.out.println(as.getTotal());
	
	List<Data> data = as.getData();
	
	for (Data d : data) {
		System.out.println(d.getId());
		System.out.println(d.getEmail());
		System.out.println(d.getFirst_name());
		System.out.println(d.getLast_name());
		System.out.println(d.getAvatar());
	}

	
	System.out.println(as.getSupport().getUrl());
	System.out.println(as.getSupport().getText());
	System.out.println(as.getAd().getCompany());
	System.out.println(as.getAd().getDescription());
	System.out.println(as.getAd().getUrl());
	
	
	
	
	
	
	
	
	}
}
