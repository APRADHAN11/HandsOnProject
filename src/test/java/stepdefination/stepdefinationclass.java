package stepdefination;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hooks.hooksclass;
import junit.framework.Assert;




public class stepdefinationclass {

	   WebDriver driver=hooksclass.driver; 
	   
		String CouponsName = "CouponN" + RandomStringUtils.randomAlphabetic(3); 
		String NameUpdate, CodeUpdate;

	  @Given("User navigation for the Login page")
	  public void user_navigation_for_the_Login_page() {		
			
			driver.get("http://retailm1.upskills.in/admin/index.php?route=common/login/");
			driver.manage().window().maximize();		

		}

	  @Given("Enter Username {string} and Password {string}")
	  public void enter_Username_and_Password(String Username, String Password)
			  throws InterruptedException {
			
			driver.findElement(By.id("input-username")).sendKeys(Username);
			driver.findElement(By.id("input-password")).sendKeys(Password);
			Thread.sleep(1000);
			
	  }
	  
	  @Then("User should be able to login")
	  public void user_should_be_able_to_login() {
			driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button")).click();
			
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"content\"]/div[1]/div/h1")));
			}
		
	  @When("Dashboard page Open")
	  public void dashboard_page_Open() {
			
			driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button")).click();
			driver.findElement(By.xpath("//*[@id=\"menu-marketing\"]/a/i")).click();
			driver.findElement(By.xpath("//*[@id=\"menu-marketing\"]/ul/li[3]/a")).click();
		    driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/a/i")).click();

	  }
	  
	  @Then("User should be able to navigate to Coupons page")
	  public void user_should_be_able_to_navigate_to_Coupons_page() {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"content\"]/div[1]/div/h1")));	 
		}
	
	  @Given("Fill values with CouponDetails as CouponName {string} and Code {string} and Discount {float} and TotalAmount {float} and UsesPerCoupon {string} and UsesPerCustomer {string}")
	  public void couponname_and_Code_and_Discount_and_TotalAmount_and_UsesPerCoupon_and_UsesPerCustomer(String CouponName, String Code, float Discount, float TotalAmount, String UsesPerCoupon, String UsesPerCustomer) {
		  
	  			
			driver.findElement(By.xpath("//*[@id=\"input-name\"]")).sendKeys(CouponName);
			driver.findElement(By.xpath("//*[@id=\"input-code\"]")).sendKeys(Code);
			driver.findElement(By.xpath("//*[@id=\"input-discount\"]")).sendKeys(Float.toString(Discount));	//Discount
			driver.findElement(By.xpath("//*[@id=\"input-total\"]")).sendKeys(Float.toString(TotalAmount)); // Total Amount
	  }	
			@Given("Select Values from Drop Down for Type and Products and Category and Status")
			public void select_Values_from_Drop_Down_for_Type_and_Products_and_Category_and_Status() {
				
				driver.findElement(By.id("input-type")).click();	                                          // Selecting Type
				Select Type= new Select(driver.findElement(By.id("input-type")));
						Type.selectByVisibleText("Percentage");
						
				driver.findElement(By.id("input-product")).click();	                                         // Selecting Product
				Select Product= new Select(driver.findElement(By.id("input-product")));
						Product.selectByVisibleText("abcdefg");					
				
				driver.findElement(By.id("input-catagory")).click();                                         // Selecting Category
				Select category= new Select(driver.findElement(By.id("input-catagory")));
						category.selectByVisibleText("Rings");	
						
				driver.findElement(By.id("input-status")).click();                                              //selecting Status
				Select status= new Select(driver.findElement(By.id("input-status")));
								status.selectByVisibleText("Enable");
				
			}
			
			@Given("Select Radio buttons for Customer Login and Free Shipping")
			public void select_Radio_buttons_for_Customer_Login_and_Free_Shipping() {
				driver.findElement(By.xpath("//*[@id=\"tab-general\"]/div[6]/div/label[1]/input")).click();  // Selecting Customer Login
				driver.findElement(By.xpath("//*[@id=\"tab-general\"]/div[7]/div/label[1]/input")).click();  // Selecting Shipping
			}
			
			@Given("Select Date Start and Date End from Calander")
			public void select_Date_Start_and_Date_End_from_Calander() {

			driver.findElement(By.xpath("//*[@id=\"tab-general\"]/div[10]/div/div/span/button")).click();   // Selecting calendar for Start Date
			driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/table/tbody/tr[5]/td[1]")).click();   // Selecting Start Date
			
			driver.findElement(By.xpath("//*[@id=\"tab-general\"]/div[11]/div/div/span/button")).click();   // Selecting calendar for End Date
			driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/table/tbody/tr[6]/td[3]")).click();   // Selecting End Date
			}
			
			@When("Click on Save button")
			public void click_on_Save_button() {
				driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/button")).click();				// Saving Coupon
				
			}
						
			
			@Then("Coupons should display on Coupon list")
			public void coupons_should_display_on_Coupon_list() throws Throwable {		
			WebElement CP = driver.findElement(By.xpath("//td[text()='"+CouponsName+"']"));
			Assert.assertTrue(CP.isDisplayed());
			System.out.println(CP);
			 Thread.sleep(5000);
		}
			@When("Click on Edit action on Coupons page and update values")
			public void click_on_Edit_action_on_Coupons_page_and_update_values() throws Throwable {
				
			NameUpdate = CouponsName + "UpdatedValue";
			CodeUpdate = CouponsName +"1";
			driver.findElement(By.xpath("//div/table/tbody/tr//td[contains(text(),CouponsName)]//following-sibling::td[6]/a/i")).click();
			driver.findElement(By.xpath("//*[@id=\"input-name\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"input-name\"]")).sendKeys(NameUpdate);
			driver.findElement(By.xpath("//*[@id=\"input-code\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"input-code\"]")).sendKeys(CodeUpdate);
			driver.findElement(By.xpath("//*[@id=\"input-type\"]")).sendKeys("Percentage");
		    driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/button")).click();
		    Thread.sleep(5000);
		}

			@Then("Coupon should update")
			public void coupon_should_update() throws Throwable {
			WebElement Couponname = driver.findElement(By.xpath("//td[text()='"+CouponsName+"']"));
			Assert.assertTrue(Couponname.isDisplayed());
			System.out.println(Couponname + "Updated Coupns should present");
			Thread.sleep(5000);
		}

		@When("Delete the coupon")
		public void delete_the_coupon() throws InterruptedException {

			driver.findElement(By.xpath("//td[contains(text(),NameUpdate)]//preceding-sibling::td[1]")).click();
			driver.findElement(By.xpath("//button[@data-original-title='Delete']")).click();
			driver.switchTo().alert().accept();
		    Thread.sleep(5000);
		}
		@Then("Coupon should be Deleted")
		public void coupon_should_be_Deleted() {
		    driver.findElement(By.xpath("//div[text()=' Coupon got deleted.']"));
		        
		}
	  }
	  
