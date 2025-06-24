package com;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG {

		@BeforeSuite
		public static void bsuite()
		{
			System.out.println("1-Before Suite");
		}
		@BeforeTest
		public static void btest()
		{
			System.out.println("2-Before Test");
		}
		@BeforeClass
		public static void bclass()
		{
			System.out.println("3-Before Class");
		}
		@BeforeMethod
		public static void bmethod()
		{
			System.out.println("4-Before Method");
		}
		@Test  // 1 test case
		public static void testcase1()
		{
			System.out.println("5-Test Case 1");
		}
		@AfterSuite
		public static void Asuite()
		{
			System.out.println("9-After Suite");
		}
		@AfterTest
		public static void Atest()
		{
			System.out.println("8-After Test");
		}
		@AfterClass
		public static void Aclass()
		{
			System.out.println("7-After Class");
		}
		@AfterMethod
		public static void Amethod()
		{
			System.out.println("6-After Method");
		}	
}
