package dependencyMethods;

import org.testng.annotations.Test;

public class SignupTests {

	@Test(priority=1)
	void signupbyemail()
	{
		System.out.println("This is signup by email..");
	}
	
	@Test(priority=2)
	void signupbyfacebook()
	{
		System.out.println("This is signup by facebook..");
	}
	
	@Test(priority=3)
	void signupbytwitter()
	{
		System.out.println("This is signup by twitter..");
	}
}
