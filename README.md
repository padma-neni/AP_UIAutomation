#  Automation Practice.com  -  Web Automation Documentation  #
#### APUIAutomation framework was selenium, java based automation test suite utilizing BDD methodogies of cucumber and Gherkin ####


   ## Tools and Operating Systems : ##
   
* Tools & Maven Dependencies
  - Selenium WebDriver
  - Cucumber
  - Webdriver Manager
  - Cucumber Maven report 
  - Extend Report
  
* Operating Systems 
  - Windows 10
  - Java SDK8
  - Maven 
 
 * Browser : Chrome

 ##  This framework sample code covers : ##
 
* 2 features (feature file)
   - Accounts Feature
   - E2E Feature
* 5 Scenarios
   - Create account with valid email address 
   - Create account with already registered email address
   - Login
   - Shopping work flow with existing user
   - Shopping work flow with new user

## Steps to run: ##
*	Clone the repository using "git clone "
*	Run "mvn clean install -P test" // to run profile with test

## Framework / Directory Structure ##
![Image of Directory structure](https://github.com/padma-neni/apUIAutomation/blob/master/images/DirectoryStructure.PNG)

### Cucumber Reports: net.masterthought - This will generate two reports ###
*	Cucumber Pretty (folder - "target\site\cucumber-pretty"), file - "index.html"
*	Cucumber Advance (folder - "target\site\cucumber-reports\cucumber-html-reports"), file - "overview-features.html"

## Folders for these reports: ##
![Image of Report Folder](https://github.com/padma-neni/apUIAutomation/blob/master/images/ReportsFolder.PNG)


## Snap Shot of Cucumber Report ##
![Image of Cucumber Report](https://github.com/padma-neni/apUIAutomation/blob/master/images/CucumberReport.PNG)

## Snap Shot of Extent Report ##
![Images of Extent Report](https://github.com/padma-neni/apUIAutomation/blob/master/images/ExtentReport.PNG)
