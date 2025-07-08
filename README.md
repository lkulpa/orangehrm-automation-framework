# 🧪 OrangeHRM Automation Framework

Automated UI testing framework for the [OrangeHRM Demo Site](https://opensource-demo.orangehrmlive.com/), built with Java, Selenium, and TestNG.  
Includes modern reporting, reusable page objects, and utility layers for scalable test development.

---

## 🚀 Features

- 🔹 **Page Object Model (POM)** for maintainable locators and logic  
- 🔹 **Singleton WebDriver** management with support for Chrome, Firefox, Edge  
- 🔹 **Data-driven testing** using `java-faker`  
- 🔹 **Allure Reporting** with detailed step annotations  
- 🔹 **Cross-browser & headless support**  
- 🔹 **Rich utility classes** for waits, config, screenshots, and more  

---

## 🛠️ Tech Stack

| Component         | Version      |
|------------------|--------------|
| Java             | 21           |
| Maven            | 3.x+         |
| Selenium         | 4.33.0       |
| TestNG           | 7.11.0       |
| Allure           | 2.29.0       |
| Java Faker       | 1.0.2        |

---

## 📁 Project Structure

```
orangehrm-automation-framework/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── page/
│   │   │   ├── page/pim/
│   │   │   └── utils/
│   │   └── resources/
│   └── test/
│       ├── java/
│       │   ├── tests/
│       │   └── utils/
│       └── resources/
├── pom.xml
└── README.md
```

---

## ⚙️ Getting Started

### 🧩 Prerequisites

- Java 11+  
- Maven 3+

### 🔧 Configuration

Configuration values are read **first from environmental variables** to allow e.g. Jenkins parameterization integration, and if not found, fall back to `src/main/resources/configuration.properties`.

#### 🔑 Available Parameters

| Property Key       | Purpose                             | Example Value         |
|--------------------|-------------------------------------|-----------------------|
| `browserType`      | Browser to run tests on             | `chrome`, `firefox`   |
| `headlessMode`     | Run browser in headless mode        | `true`, `false`       |
| `maximizeWindow`   | Maximize browser window on startup  | `true`, `false`       |
| `validUsername`    | Login username                      | `Admin`               |
| `validPassword`    | Login password                      | `admin123`            |
| `appUrl`           | Application login URL               | `https://...`         |
| `implicitWaitDuration` | Implicit wait duration (seconds) | `6`                   |

### ▶️ Running Tests

From the project root, run:

```bash
mvn clean test
```

Allure reports will be generated under `target/allure-results`.

---

## 🧪 Writing Tests

This framework follows a consistent and descriptive naming convention to improve readability, maintainability, and discoverability of test cases and components.

### ✅ Test Class Naming

- Place under: `src/test/java/tests/`
- **Pattern**: `PageNameTests.java`  
  _Example_: `LoginPageTests.java`, `MyInfoPageTests.java`

### ✅ Test Method Naming

- Use **descriptive names** ending with `Test`
- Use camelCase with action-oriented verbs  
  _Examples_:
  - `loginWithValidCredentialsTest`
  - `editPersonalDetailsWithInvalidDataTest`
  - `searchForEmployeeByIdTest`

Each method must be annotated with:
```java
@Test
```

### ✅ Page Object Class Naming

- Place under: `src/main/java/page/`
- **Pattern**: `PageNamePage.java`  
  _Examples_: `LoginPage.java`, `AddEmployeePage.java`

Each class should:
- Extend `BasePage`
- Use `PageFactory.initElements(...)` for WebElement initialization
- Contain `@Step`-annotated methods for Allure reporting

### ✅ Page Object Method Naming

- Use action-oriented, fluent-style methods that describe user interactions
- Return the page object (`this`) for chaining

_Examples_:
```java
public LoginPage enterUsernameInput(String username)
public AddEmployeePage clickSaveButton()
public MyInfoPage selectNationalityDropdownOption(String nationality)
```

### ✅ WebElement Variable Naming

- Use clear, camelCase names that reflect the UI purpose
- Include suffixes like `Input`, `Button`, `Dropdown`, `Label`, `Checkbox`, etc.

_Examples_:
```java
@FindBy(name = "username")
private WebElement usernameInput;

@FindBy(css = "button[type='submit']")
private WebElement loginButton;
```

---

## 📸 On Failure

- TestNG listener captures screenshots  
- Stored in `./screenshots/`  
- Attached to Allure report automatically

---

## 🤝 Contribution

Contributions and suggestions are welcome. This is a learning project and still in progress!
