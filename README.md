# BlazeDemo Selenium Automation Framework

A data-driven Selenium test automation framework built for the [BlazeDemo](https://blazedemo.com) flight booking application, demonstrating end-to-end UI test automation with reporting and structured data handling.

## Tech Stack
- **Language:** Java
- **Automation Tool:** Selenium WebDriver
- **Test Framework:** TestNG
- **Build Tool:** Maven
- **Data Handling:** Apache POI (Excel-driven test data)
- **Reporting:** Extent Reports
- **Design Pattern:** Page Object Model (POM)

## Key Features
- Data-driven testing using Excel files via Apache POI, keeping test data separate from test logic
- Page Object Model for clean, maintainable, and reusable page classes
- Extent Reports integration for rich, visual HTML test execution reports
- TestNG for test grouping, prioritization, and assertions
- Maven for dependency management and build lifecycle

## What's Automated
- Flight search with source/destination selection
- Flight selection and purchase flow
- Passenger detail form submission
- Booking confirmation validation

## Project Structure
```
src/
├── main/java/
│   ├── pages/          # Page Object classes
│   └── utils/          # Utility classes (Excel reader, driver factory, etc.)
├── test/java/
│   └── tests/          # TestNG test classes
├── test/resources/
│   └── testdata/        # Excel test data files
reports/                 # Generated Extent Reports
pom.xml
```

## How to Run
```bash
git clone https://github.com/sruthykrishnaK/blazedemo-selenium-framework.git
cd blazedemo-selenium-framework
mvn clean test
```
Test execution reports are generated in the `reports/` (or `test-output/`) folder after each run — open the `.html` file in a browser to view results.

## Author
**Sruthy Krishna** — Software Tester
[Portfolio](https://portfolio-ipmf.vercel.app) | [GitHub](https://github.com/sruthykrishnaK)
