@LoginRegisterTest
@TaggedAgain
Feature: As a user I want to login or Register
#This is how background can be used to eliminate duplicate steps 
Background: 

   Given I am on the Websites Home page
@LoginUser-DataDriven
Scenario Outline: 
   When I I am a regular user, and select Login from Home page
   And I enter my <"user Id"> and <"password">
   Then I will be sent to the menu page to select items
 
 Examples:  
 	|user Id			| password	|
 	|"tsmit@gmail.com"	| "test"	|
 
 @RegisterNewUser-DataDriven
Scenario Outline: 
   When I I need to register as a new user, and select Register form home page
   And 	I enter my <"first name"> and <"last name"> and <"email"> and 
   And <"password"> and <"password2"> and <"gender"> and <"address"> and my new <"zipcode"> and <"phone">
   Then I will be registered as a new user, and sent to the login page for the first time to log in
 
 Examples:  
 	| first name	| last name		| email	 				 | password		| password2	| gender | address		| zipcode	| phone		|
 	| "John"		| "Smith"		| "jsmith@gmail.com" 	 | "pass2"		| "pass2"	| "M"	 | "1234 North" | 11222		| 1231234	|
 	| "Joan"		| "Anderson"	| "jand@here.com"	 	 | "pass3"		| "pass3"""	| "F"	 | "1890 East"	| 11222		| 2341223	|
 	
 