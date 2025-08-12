
# Sumerge Assessment Project

This is my automated testing framework built using **Java**, **Selenium WebDriver**, and the **Page Object Model (POM)** design pattern. The project aims to automate and validate key workflows of a hotel booking website.

*  Project Overview

In this project, I automated a typical user journey that includes:

1. Searching for hotels by location and selecting check-in/check-out dates on the **HomePage**.
2. Navigating search results and choosing a hotel on the **SearchResultPage**.
3. Completing the reservation by selecting room preferences and confirming the booking on the **ReservationPage**.

*  Technologies I Used

- **Java** as the programming language.
- **Selenium WebDriver** for browser automation.
- **TestNG** as the testing framework.
- **Page Object Model (POM)** for a clean and maintainable design.
- **Apache POI** to read test data from Excel files.
- **ChromeDriver** as the WebDriver for the Chrome browser.

*   Project Structure

```

├── Pages/
│   ├── HomePage.java
│   ├── SearchResultPage.java
│   └── ReservationPage.java
├── Tests/
│   └── TestData.java
│   └── Tests.java
├── Utils/
│   └── ExcelUtils.java
├── testdata/
│   └── testdata.xlsx
└── README.md

````

* How to Set It Up

# Prerequisites

- Java Development Kit (JDK) 11 or newer.
- Maven for dependency management (optional but recommended).
- An IDE like IntelliJ IDEA or Eclipse (optional).
- ChromeDriver compatible with your installed Chrome browser.

# Steps to Run

1. Clone this repository:

   ```bash
   git clone https://github.com/mahmoudelhalawany/Sumerge_Assesment.git
   cd Sumerge_Assesment


2. If you use Maven, install dependencies by running:

   ```bash
   mvn install
   

3. Make sure `chromedriver` is set up correctly on your machine and the path is configured in the project or system variables.

4. Run the tests from your IDE or with Maven:

   ```bash
   mvn test
   ```

* Test Data

I included test data in the Excel file located at `testdata/testdata.xlsx`. The framework reads this data to drive the automated test scenarios.

* Utilities

- `ExcelUtils` handles reading data from Excel using Apache POI.



