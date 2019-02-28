Feature: Cucumber test
Scenario: User's successful login and logout
Given User is on facebook login page using "chrome" browser
When User inputs email "be75ega@gmail.com" and password "kaku23" and click login button 
Then User lands on home page where users name "Mekdes Tadesse" is displayed 
Then then User navigates to menu and clicks menu button 
And then click logout button and User successfuly logout from facebook
