@login
Feature: Login

@successCase
Scenario: Successful Login
	Given User is on Login page
	When User enter a valid email and password
	Then User can see the home page
	
@unsucessCase	
	Scenario: Unsuccessful Login
	Given User is on Login page
	When User enter a invalid email and password
	Then User cant login and an error message is displaying
	