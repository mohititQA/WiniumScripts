import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.winium.WiniumDriverService;
import java.util.*;

public class class1 {
	static DesktopOptions option; 
	static WiniumDriver driver;
	static WiniumDriverService service;
	static int number1,number2=0;
	static int result = 0;
	static int length1;
	static int length2;
	
	public static void setupEnvironment() throws IOException, InterruptedException, AWTException
	{
		option= new DesktopOptions();
		 
		option.setApplicationPath("C:\\Windows\\System32\\calc.exe");
		File driverpath = new File("C:\\WiniumDriver\\Winium.Desktop.Driver.exe");
		service = new WiniumDriverService.Builder().usingDriverExecutable(driverpath).usingPort(9999).withVerbose(true).withSilent(false).buildDesktopService();
		service.start();
		driver = new WiniumDriver(service, option);
		
		driver.findElement(By.name("Calculator"));
		driver.findElementByName("Menu").click();
		Thread.sleep(2000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_DOWN);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		
		//WebElement view = navigationMenu.findElement(By.name("System"));
		
		//driver.findElement(By.name("Scientific Calculator mode")).click();
		//WebElement frame = window.findElement(By.name("Calculator"));
		//WebElement menuButton = window.findElement(By.name("SystemMenuBar"));
		
		//WebElement viewMenu = menuButton.findElement(By.name("View"));
		//menuButton.click();
		//menuButton.findElement(By.name("Scientific Calculator")).click();
	}
	
	public static void Sum(int number1,int number2)
	{
		 length1 = String.valueOf(number1).length();
		 length2 = String.valueOf(number2).length();
		 String number3 = String.valueOf(number1);
		 String number4 = String.valueOf(number2);
	  	  char[] digits1 = number3.toCharArray();
	  	  char[] digits2 = number4.toCharArray();
	  	 for (int i = 0 ; i<length1 ;i++)
	  	   {
	  		 driver.findElement(By.id("num"+digits1[i]+"Button")).click();
	  	   }
		
		driver.findElement(By.name("Plus")).click();
		 for (int i = 0 ; i<length1 ;i++)
	  	   {
	  		 driver.findElement(By.id("num"+digits2[i]+"Button")).click();
	  	   }
	
		driver.findElement(By.name("Equals")).click();
		String output = driver.findElement(By.id("CalculatorResults")).getAttribute("Name");
		
		String [] result = output.split(" ");
		
		int expectedResult = number1+number2;
		//verifying the expected and actual output 
		Assert.assertEquals(expectedResult,Integer.parseInt(result[2].replaceAll(",", "")),"Output is matching.");
		
		
	}
	public static void Divion(int number1,int number2)
	{
		 driver.findElement(By.name("Clear")).click();
		 length1 = String.valueOf(number1).length();
		 length2 = String.valueOf(number2).length();
		 String number3 = String.valueOf(number1);
		 String number4 = String.valueOf(number2);
	  	  char[] digits1 = number3.toCharArray();
	  	  char[] digits2 = number4.toCharArray();
	  	 for (int i = 0 ; i<length1 ;i++)
	  	   {
	  		 driver.findElement(By.id("num"+digits1[i]+"Button")).click();
	  	   }
		driver.findElement(By.name("Divide by")).click();
		 for (int i = 0 ; i<length1 ;i++)
	  	   {
	  		 driver.findElement(By.id("num"+digits2[i]+"Button")).click();
	  	   }
		driver.findElement(By.name("Equals")).click();
		String output = driver.findElement(By.id("CalculatorResults")).getAttribute("Name");
		
		String [] result = output.split(" ");
		
		double expectedResult = ((double)number1)/number2;

		//verifying the expected and actual output 
		
		Assert.assertEquals(expectedResult,Double.parseDouble(result[2]),"Output is matching.");
		

		//System.out.println("The output of the division is  : "+result);
	}
	
	public static void Mod(int number1,int number2)
	{
		driver.findElement(By.name("Clear")).click();
		length1 = String.valueOf(number1).length();
		 length2 = String.valueOf(number2).length();
		 String number3 = String.valueOf(number1);
		 String number4 = String.valueOf(number2);
	  	  char[] digits1 = number3.toCharArray();
	  	  char[] digits2 = number4.toCharArray();
	  	 for (int i = 0 ; i<length1 ;i++)
	  	   {
	  		 driver.findElement(By.id("num"+digits1[i]+"Button")).click();
	  	   }
		driver.findElement(By.name("Modulo")).click();
		 for (int i = 0 ; i<length1 ;i++)
	  	   {
	  		 driver.findElement(By.id("num"+digits2[i]+"Button")).click();
	  	   }
		driver.findElement(By.name("Equals")).click();
		String output = driver.findElement(By.id("CalculatorResults")).getAttribute("Name");
	
		String [] result = output.split(" ");
		int expectedResult = number1%number2;
		//verifying the expected and actual output 
		Assert.assertEquals(expectedResult,Integer.parseInt(result[2].replaceAll(",", "")),"Output is matching.");

		//System.out.println("The output of the mod  is  : "+result);
	}
	
	public static void Squareroot(int number1)
	{
		driver.findElement(By.name("Clear")).click();
		
		length1 = String.valueOf(number1).length();
		
		 String number3 = String.valueOf(number1);
		
	  	  char[] digits1 = number3.toCharArray();
	  	  
	  	 for (int i = 0 ; i<length1 ;i++)
	  	   {
	  		 driver.findElement(By.id("num"+digits1[i]+"Button")).click();
	  	   }
		driver.findElement(By.name("Square root")).click();
		driver.findElement(By.name("Square root")).click();
		driver.findElement(By.name("Square root")).click();
		String output = driver.findElement(By.id("CalculatorResults")).getAttribute("Name");
		
		String [] result = output.split(" ");
		
		double expectedResult = Math.sqrt(Math.sqrt(Math.sqrt(number1)));
		
		//verifying the expected and actual output 
		
		Assert.assertEquals(expectedResult,Double.parseDouble(result[2]),"Output is matching.");

		//System.out.println("The output of the mod  is  : "+result);
	}
	 
      public static void main(String[] args) throws IOException, InterruptedException, AWTException
      {
    	  setupEnvironment();
    	  Scanner scan = new Scanner(System.in);
    	  
    	  System.out.println("enter the first number : ");
    	  number1 = scan.nextInt();
    	  System.out.println("enter the Second number : ");
    	  number2 = scan.nextInt();
    	  Sum(number1,number2);
    	  Divion(number1,number2);
    	  Mod(number1,number2);
    	  Squareroot(number1);
    	    
    	  
      }
}
