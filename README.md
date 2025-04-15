# orangehrm-automation-framework

Java test automation framework for a demo human resources management website at https://opensource-demo.orangehrmlive.com/.

## Description

This is my first Java test automation project, using Selenium, Maven and TestNG. Work in progress.

## Concepts included

* Page Object pattern
* WebDriver Singleton pattern
* Utility classes

## Getting Started

### Requirements

In order to utilise this project you need to have the following installed locally:

* Maven 3
* Java 11+

### Executing program

To run the tests navigate to `orangehrm-automation-framework` directory and run:
```
mvn clean install
```

## Adding tests

Each test class should contain tests specific to one of the website's pages, and should be named following the pattern: _PageNameTests_. E.g. "LoginPageTests".

New tests should be added in relevant test classes in `orangehrm-automation-framework\src\test\java\tests` directory.

Test methods should be descriptive and include "Test" at the end of its name, e.g. "loginTest". The _@Test_ annotation must be included above each test method.

Page Object classes should be added in `orangehrm-automation-framework\src\main\java\page` named following the patttern: _PageNamePage_. E.g. "AddEmployeePage".
