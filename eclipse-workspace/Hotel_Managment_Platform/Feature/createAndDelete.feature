Feature: Create a new Hotel entry
 
Scenario: That the user can create a new hotel entry
	Given The user navigates to the Hotel Management Platform
	And they select the login link
	And They fill in the username and password they are logged in
	When They fill in all the fields
	And select the create button
	Then Hotel entry is created
	
Scenario: The user can make a booking
	When new guest details are entered
	And Saved
	Then booking is made
	
Scenario: Canceling a booking
	When cancel button is selected
	Then booking no longer exists
	
Scenario: User makes multiple bookings
	When User is on Hotel Booking page
	Then I can make multiple bookings
	
	

	