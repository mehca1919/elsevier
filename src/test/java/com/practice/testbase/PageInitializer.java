package com.practice.testbase;

import com.practice.pages.HomePageElements;

public class PageInitializer extends BaseClass{
	public static HomePageElements homepage;
	
	
	public static void	 initialize()
	{
		homepage = new HomePageElements(driver);
	}

}
