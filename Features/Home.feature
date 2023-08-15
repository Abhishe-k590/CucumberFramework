@tag
Feature: Home
  validate the home page
  
  
Background: All Steps are comman
 Given user launch chrome browser
    When user enters url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And enter valid username "Admin" and password "admin123"
    And clicks on login button
    Then Then pageTitle should be "OrangeHRM"
    And subtitle should be "Dashboard"

@smoke
  Scenario: after login validate all the tabs are present in homepage
    And Validate all the Tabs are present in the homepage
    And close the browser
    
@scanity  
 Scenario: scrolldown in home_homepage
    And Scrolldown to see the chart
    And close the browser
@Regression  
 Scenario: navigate to Adminpage
    When click on Admintab
    And click on Qualificitions dropdown
    And select Eduction option
    Then Education page should be displayed
    When  Bachelors Degree checkbox should be selected
    And click on editIcon
    Then "Edit Education" page should be dislayed
    And click on cancle button
    And close the browser
    
    