# Automation Exercise Automation

Automation Exercise Automation is a test automation project created for the [Automation Exercise](https://automationexercise.com/) website. The project covers the main user flows of an e-commerce application, including user registration, login, product search, cart actions, checkout, payment confirmation and Contact Us form submission.

The framework is built with Java, Selenium WebDriver, TestNG and Maven, using the Page Object Model design pattern.

## Test Documentation

Manual test cases are documented in the `Automation Exercise Test Cases.xlsx` file. This file was used as a reference for creating automated test scenarios.

The test documentation contains:
* Test case ID
* Test case name
* Preconditions
* Test steps
* Expected result
* Actual result
* Test status

## Dependencies

* Run on Windows OS
* IDE for this project is IntelliJ IDEA Community Edition
* Browsers needed is Chrome as mandatory but also preferred are Firefox, Edge and Safari
* Java version 26
* Apache Maven
* Selenium WebDriver 4.43.0
* TestNG 7.12.0
* WebDriverManager 6.3.4
* Apache POI 5.5.1

## Installation

Open terminal in IDE and clone the repository:

```
git clone https://github.com/nikolanikolic755/selenium-automation.git
```

Open the project in IntelliJ IDEA and make sure Maven dependencies are imported from `pom.xml`.

## Executing Program

Run all tests from terminal with:

```
mvn test
```

Run a specific test class from terminal with:

```
mvn test -Dtest="AuthenticationTests"
```

Other examples:

```bash
mvn test -Dtest="ProductTest"
mvn test -Dtest="CartTest"
mvn test -Dtest="CheckoutTests"
mvn test -Dtest="ContactTest"
```

## Framework Walkthrough

Packages:

* `Base` - Contains the base test class used for WebDriver setup and page object declarations
* `Pages` - Contains Page Object Model classes for pages and shared page components
* `Tests` - Contains TestNG test classes with automated test scenarios

Files:

* `pom.xml` - Contains Maven configuration and all project dependencies
*  `manual-test-cases.xlsx` - Excel file with manual test cases used as a reference for automated test scenarios
* `BaseTest.java` - Contains WebDriver, WebDriverWait and page object references used by test classes
* `LoginPage.java` - Contains elements and methods for login and signup actions
* `SignupPage.java` - Contains elements and methods for filling registration account information
* `HomePage.java` - Contains elements and methods used on the home page
* `NavigationMenu.java` - Contains navigation menu elements and actions
* `ProductsPage.java` - Contains product listing, product search and add-to-cart actions
* `CartPage.java` - Contains cart page elements and cart actions
* `CheckoutPage.java` - Contains checkout page elements and order summary actions
* `PaymentPage.java` - Contains payment form elements and order confirmation methods
* `ContactUsPage.java` - Contains Contact Us form elements and submission methods

## Test Coverage

Authentication tests:

* Verify user can register with valid data
* Verify user cannot register with an already existing email
* Verify user cannot register with an empty name field
* Verify user can login with valid credentials
* Verify user can logout
* Verify user cannot login with invalid password

Product tests:

* Verify products are displayed on the Products page
* Verify user can open product details page
* Verify product search returns correct results

Cart tests:

* Verify user can add multiple products to cart
* Verify user can remove product from cart
* Verify product remains in cart after page refresh

Checkout tests:

* Verify user can complete checkout process with one product
* Verify user cannot proceed to checkout with empty cart
* Verify total price is correct on checkout page

Contact tests:

* Verify user can submit Contact Us form successfully

## Naming Convention

* Classes are written in PascalCase
* Methods are written in camelCase
* Page object classes are placed in the `Pages` package
* Test classes are placed in the `Tests` package
* Test method names describe the test scenario that is being automated

## Project Structure

```text
Automation-Exercise-Project
├── .idea
└── selenium-automation
    ├── .mvn
    ├── src
    │   ├── main
    │   └── test
    │       └── java
    │           ├── Base
    │           │   └── BaseTest.java
    │           ├── Pages
    │           │   ├── CartPage.java
    │           │   ├── CheckoutPage.java
    │           │   ├── ContactUsPage.java
    │           │   ├── HomePage.java
    │           │   ├── LoginPage.java
    │           │   ├── NavigationMenu.java
    │           │   ├── PaymentPage.java
    │           │   ├── ProductsPage.java
    │           │   └── SignupPage.java
    │           └── Tests
    │               ├── AuthenticationTests.java
    │               ├── CartTest.java
    │               ├── CheckoutTests.java
    │               ├── ContactTest.java
    │               └── ProductTest.java
    ├── target
    ├── pom.xml
    ├── .gitignore
    ├── manual-test-cases.xlsx
    └── README.md
```

## Other

* Tests are written using TestNG annotations
* Each test starts a new Chrome browser session
* Browser setup is handled with WebDriverManager
* Test classes use Page Object Model to keep test methods clean and readable
* Cookies are deleted and the browser is closed after each test
* Some tests use an existing session cookie to simulate a logged-in user
* Explicit and implicit waits are used to improve test stability
