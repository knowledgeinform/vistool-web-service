# VisTool-UI Contributing Document
The most up-to-date version of this document can be found on the VisTool wiki at https://aplwiki.jhuapl.edu/confluence/display/SESSIG/VisTool+Contributing+Document

##Testing Expectations
VisTool (and IST as a whole) should strive for a robust testing strategy, with the highest degree of test automation possible. To begin with, developers are encouraged to read through the DevOps Guild's wiki pages on automated testing for thoughts and ideas on theories and best practices for testing.

VisTool developers can refer to the Testing Pyramid as a guide to test development and organization and the relative weight/level of effort that should be devoted to each category.

In particular, focus should be on unit, integration, and system tests.

### Unit Testing
VisTool developers should strive to write code that lends itself well to unit testing, by following best practices in modular/object-oriented code design/development and test-driven development. JUnit 5 is a good tool for the Java web service unit tests. Jasmine (with the Karma test server) is the Angular default/standard test library.

The goal of unit testing is to ensure that methods/classes/small functions work as expected, and should be the bulk of VisTool tests. Bamboo should be set to run these tests at every build of master and feature branches.

### Integration Tests
Integration tests should make up a smaller set of tests than the VisTool unit tests, and are intended to test interactions between individual functions/classes, and possibly interactions with the database. Cucumber and Robot Framework could be good libraries to use for web service testing.

### System Testing
System testing or end to end (E2E) testing, and should test the application as a whole, including interactions between the front end and the web service and between the web service and the backend. It is intended to evaluate the system's compliance with the project requirements. Usability testing could fall under this category as well. A testing library like Protractor could be a good tool for this kind of testing.

## Code Review Process
Refer to the wiki for the most up-to-date code review process.
