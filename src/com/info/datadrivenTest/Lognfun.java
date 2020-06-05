package com.info.datadrivenTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Lognfun extends Roottest
{
	@Test
	public void Testloginfun() throws IOException
	{
	Applicationfun xcel=new Applicationfun("D://chromedriver//firefoxdrive//datadriven1.xlsx.xlsx");
	
	int rc=xcel.getrowcount("sheet1");
	for(int r=1;r<rc;r++)
	{
		String un=xcel.getcelldata("sheet1", r, 0);
		String pwd=xcel.getcelldata("sheet1", r, 1);
		
	
	System.setProperty("webdriver.chrome.driver", "D://chromedriver//firefoxdrive//chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://facebook.com");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	
	driver.findElement(By.id("email")).sendKeys(un);
	driver.findElement(By.id("pass")).sendKeys(pwd);
	driver.findElement(By.linkText("Log In")).click();
	try{
		driver.close();
	xcel.getcelldata("Sheet1", r, 2, Roottest.pass);
	
	}
	catch (Exception e) 
	{
		xcel.getcelldata("Sheet1", r, 2, Roottest.fail);
	
	
	driver.quit();
	driver.close();
}}}}
