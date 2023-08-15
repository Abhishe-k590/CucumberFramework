#Author: your.email@your.domain.com


Feature: Login
  Login thr orange app

@scanity
  Scenario: Successful login with valid credentials
    Given user launch chrome browser
    When user enters url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And enter valid username "Admin" and password "admin123"
    And clicks on login button
    Then Then pageTitle should be "OrangeHRM"
    And close the browser

 
   
    
