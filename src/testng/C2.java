package testng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class C2 {

	@Test
	void xyz()
	{
		System.out.println("this is xyz from c2..");
	}
	
	@AfterTest
	void bt()
	{
		System.out.println("this is AfterTest method..");
	}
}
