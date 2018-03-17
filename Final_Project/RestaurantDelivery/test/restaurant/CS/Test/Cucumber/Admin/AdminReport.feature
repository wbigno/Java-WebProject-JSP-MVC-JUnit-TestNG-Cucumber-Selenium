@AdminTest
@TaggedAgain
Feature: As an Admin I want to have reports that will allow me to monitor and manage our sight
#This is how background can be used to eliminate duplicate steps 
Background: 

   Given I am an admin user, and I am on the Admin page after logging in
@AdminUser-DataDriven
Scenario Outline: 
   When I am on the admin page I will click on the "admin report" tab
   And I will click on the "admin user report" tab
   And I will enter the "user Id" and the "first name" and "last name" and "email" and "admin" and "address" and "zipcode" and "phone"
   Then I will click the update button and see the results on the screen
 
 Examples:  
 	| user Id | first name	| last name		| email				| admin | address		| zipcode | phone		|
 	| 03	  | "Bob"		| "Jones"		| "bjones@test.com"	| 0		| "123 Happy"	| 11222	  | 1232345		|

 @AdminItemList-DataDriven
Scenario Outline: 
   When I am on the Admin Item page I want to be able to disable items so that they do not appear on the menu for users
   And to do this I will click on the disable item field and enter the "item id"
   Then I wll click on the disable button to complete the process and will see the update on the screen
 
 Examples:  
 	| item id |
 	| 01	  |
 
 @AdminLocationList-DataDriven
Scenario Outline: 
   When I am on the Amdin Location Page
   And I want to add a new location I will need to scroll down the screen to the form
   And I will enter the "location name" and "address" and "zipcode" and "staff count" and "category" and "image"
   Then I will click the update button to add the location
 
 Examples:  
 	|location name 	| address			| zipcode	| staff count |category 	| image	|
 	| "South"		| "123 South St"	| 11222		| 10 		  | "Hot"		| " "	|
 	
 