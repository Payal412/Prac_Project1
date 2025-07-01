package dependencyMethods;

import org.testng.annotations.Test;

public class LoginTests {

	@Test(priority=1)
	void loginByEmail()
	{
		System.out.println("This is login by email..");
	}
	
	@Test(priority=2)
	void loginByFacebook()
	{
		System.out.println("This is login by facebook..");
	}
	
	@Test(priority=3)
	void loginBytwitter()
	{
		System.out.println("This is login by twitter..");
	}
}
