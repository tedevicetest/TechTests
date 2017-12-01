package stepDefinitions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateHotelEntry {
	public static WebDriver driver;

	// Opens the browser (Chrome/Chromium) and navigates to the URL
	@Given("^The user navigates to the Hotel Management Platform$")
	public void The_user_navigates_to_the_Hotel_Management_Platform() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:3003/");

	}

	// Selects the Username & Password fields, fills in the username and password
	// then selects the login button to log user in
	@Given("^they select the login link$")
	public void they_select_the_login_link() throws Throwable {
		driver.findElement(By.linkText("Login")).click();
		
	}

	@Given("^They fill in the username and password they are logged in$")
	public void they_fill_in_the_username_and_password_they_are_logged_in() throws Throwable {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("doLogin")).click();

	}

	@When("^They fill in all the fields$")
	public void they_fill_in_all_the_fields() throws Throwable {
		// Fill in the fields
		driver.findElement(By.id("hotelName")).sendKeys("Tim's Hotel 1");
		driver.findElement(By.id("address")).sendKeys("1 Somewhere Rd, Somewhere, AB12 3CD");
		driver.findElement(By.id("owner")).sendKeys("Mr Hotel");
		driver.findElement(By.id("phone")).sendKeys("01234 567890");
		driver.findElement(By.id("email")).sendKeys("MrHotel@Hotel1.com");
	}

	@When("^select the create button$")
	public void select_the_create_button() throws Throwable {
		// Create the hotel
		driver.findElement(By.id("createHotel")).click();
	}

	@Then("^Hotel entry is created$")
	public void hotel_entry_is_created() throws Throwable {
		driver.findElement(By.cssSelector("body > div > div.row.detail > div.hotelRow > div:nth-child(1) > p")).click();
		// /html/body/div/div[2]/div[1]/div[1]/p
		if (driver.getPageSource().contains("Tim's Hotel 1")) {
			System.out.println("Hotel Name is CORRECT");
		} else {
			System.out.println("Hotel Name is WRONG");
		}

		if (driver.getPageSource().contains("1 Somewhere Rd, Somewhere, AB12 3CD")) {
			System.out.println("Address is CORRECT");
		} else {
			System.out.println("ADDRESS IS WRONG");
		}

		if (driver.getPageSource().contains("Mr Hotel")) {
			System.out.println("Owner is CORRECT");
		} else {
			System.out.println("Owner is WRONG");
		}

		if (driver.getPageSource().contains("01234 567890")) {
			System.out.println("Phone number is CORRECT");
		} else {
			System.out.println("Phone number is WRONG");
		}

		if (driver.getPageSource().contains("MrHotel@Hotel1.com")) {
			System.out.println("email is CORRECT");
		} else {
			System.out.println("email is WRONG");
		}
	}
	// Scenario 2 The user can make a booking

	@When("^new guest details are entered$")
	public void new_guest_details_are_entered() throws Throwable {
		driver.findElement(By.id("firstName")).sendKeys("Frank");
		driver.findElement(By.id("lastName")).sendKeys("Zappa");
		driver.findElement(By.id("totalPrice")).sendKeys("85");
		driver.findElement(By.id("depositPaid")).sendKeys("true");
		driver.findElement(By.id("checkIn")).sendKeys("2017-12-03");
		driver.findElement(By.id("checkOut")).sendKeys("2017-12-05");
	}

	@When("^Saved$")
	public void saved() throws Throwable {
		driver.findElement(By.id("createBooking")).click();
	}

	@Then("^booking is made$")
	public void booking_is_made() throws Throwable {
		if (driver.getPageSource().contains("Frank")) {
			System.out.println("First Name is CORRECT");
		} else {
			System.out.println("First Name is WRONG");
		}

		if (driver.getPageSource().contains("Zappa")) {
			System.out.println("Last Name is CORRECT");
		} else {
			System.out.println("Last Name is WRONG");
		}

		if (driver.getPageSource().contains("85")) {
			System.out.println("Price is CORRECT");
		} else {
			System.out.println("Price is WRONG");
		}

		if (driver.getPageSource().contains("true")) {
			System.out.println("Deposit paid is CORRECT");
		} else {
			System.out.println("Deposit paid is WRONG");
		}

		if (driver.getPageSource().contains("2017-12-03")) {
			System.out.println("Check In is CORRECT");
		} else {
			System.out.println("Check In is WRONG");
		}
		if (driver.getPageSource().contains("2017-12-05")) {
			System.out.println("Check Out is CORRECT");
		} else {
			System.out.println("Check Out is WRONG");
		}
		
		
	}
	
// Scenario 3 Cancelling a booking

	@When("^cancel button is selected$")
	public void cancel_button_is_selected() throws Throwable {
	    //driver.findElement(By.className("glyphicon_glyphicon-pencil_bookingDelete")).click();
		driver.findElement(By.cssSelector("span[class='glyphicon glyphicon-trash bookingDelete']")).click();
	}

	@Then("^booking no longer exists$")
	public void booking_no_longer_exists() throws Throwable {
	   if (driver.getPageSource().contains("Frank")) {
			System.out.println("Booking has NOT BEEN DELETED");
		} else {
			System.out.println("Booking HAS BEEN DELETED");
		}

		if (driver.getPageSource().contains("Zappa")) {
			System.out.println("Booking has NOT BEEN DELETEDT");
		} else {
			System.out.println("Booking HAS BEEN DELETED");
		}

		//driver.findElement(By.partialLinkText("Home")).click();
		
		//driver.close();
	}
	
// Scenario 4 Making multiple bookings
	
	@When("^User is on Hotel Booking page$")
	public void user_is_on_Hotel_Booking_page() throws Throwable {
	    
	}

	@Then("^I can make multiple bookings$")
	public void i_can_make_multiple_bookings() throws Throwable {
		 
			String csvFile = "hotelsDatas.csv";
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";

	        try {

	            br = new BufferedReader(new FileReader(csvFile));
	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	                String[] hotels = line.split(cvsSplitBy);
	                // reading a line column by column
	                for(int i=0;i<hotels.length;i++) {
	                	System.out.print(hotels[i].replaceAll("\"", ""));
	                	
	                	driver.findElement(By.id("firstName")).sendKeys(hotels[0].replaceAll("\"", ""));
	            		driver.findElement(By.id("lastName")).sendKeys(hotels[1].replaceAll("\"", ""));
	            		driver.findElement(By.id("totalPrice")).sendKeys(hotels[2].replaceAll("\"", ""));
	            		driver.findElement(By.id("depositPaid")).sendKeys(hotels[3].replaceAll("\"", ""));
	            		driver.findElement(By.id("checkIn")).sendKeys(hotels[4].replaceAll("\"", ""));
	            		driver.findElement(By.id("checkOut")).sendKeys(hotels[5].replaceAll("\"", ""));
	            		
	            		driver.findElement(By.id("createBooking")).click();
	                }
	                System.out.println(); // next line
	                
//	                driver.findElement(By.id("createBooking")).click();
	            }

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	    }
	   

}
