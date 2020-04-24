Feature: PhpTravels login process

  Background:
    Given The home page is clicked

  Scenario Outline:
    Given Forgot password is clicked
    And The '<field>' is filled with '<value>'
    And Submit button is clicked
    Then An '<msg>' error is shown on forget password page
    Examples:
      |field     |value         |msg                                                                       |
      |inputEmail|asdf@gmail.com|The characters you entered didn\'t match the image shown. Please try again.|


  Scenario Outline:
    Given Click Store menu
    And  Choose year '<year>'
    Then An '<msg>' error is shown on products page
    Examples:
      |msg|year|
      |Product group does not contain any visible products|2020|


  Scenario Outline:
    Given Click Store menu
    And Choose year '<year>'
    And Order Web Application
    Then Total due today is '<price>'
    Examples:
      |price|year|
      |500|2019  |



  Scenario Outline:
    Given The '<field>' is filled with '<value>'
    And The Login button is clicked
    Then An '<msg>' error is shown on login page
    Examples:
      | field | value | msg |
      |inputEmail|asdf@gmail.com|Please complete the captcha and try again.|
      |inputEmail||Please complete the captcha and try again.|

