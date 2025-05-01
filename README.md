# Selenium Cucumber Test Project

This project is a test automation project developed using Selenium WebDriver, Cucumber, and Java.

## 🚀 Features

- Web automation with Selenium WebDriver
- BDD (Behavior Driven Development) test scenarios with Cucumber
- Detailed test reporting with Allure and Extent Reports
- CI/CD integration with GitHub Actions
- Dependency management with Maven

## 📋 Prerequisites

- Java JDK 17
- Maven 3.8+
- Chrome Browser
- Git

## 🔧 Installation

1. Clone the repository:
```bash
git clone [repository-url]
```

2. Navigate to the project directory:
```bash
cd SeleniumWalkedu
```

3. Install dependencies:
```bash
mvn clean install
```

## 🧪 Running Tests

### Run All Tests
```bash
mvn test
```

### Run Specific Feature File
```bash
mvn test -Dcucumber.filter.tags="@tag"
```

### Generate Allure Report
```bash
mvn allure:report
```

### Generate Extent Report
```bash
mvn test -Dcucumber.plugin="html:target/cucumber-reports.html"
```

## 📊 Reports

- Allure reports: in `target/site/allure-maven-plugin/` directory
- Extent reports: in `target/cucumber-reports.html` file

## 🔄 CI/CD

The project is integrated with GitHub Actions. On every push and pull request:
- Tests are automatically executed
- Allure and Extent reports are generated
- Reports are saved as GitHub Actions artifacts

## 📁 Project Structure

```
src/
├── main/
│   └── java/
│       └── org/example/
│           ├── pages/        # Page Object Model classes
│           ├── steps/        # Cucumber step definitions
│           └── utils/        # Utility classes
└── test/
    └── resources/
        └── features/         # Cucumber feature files
```

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📞 Contact

Project Owner - [@your-username](https://github.com/your-username)

Project Link: [https://github.com/your-username/SeleniumWalkedu](https://github.com/your-username/SeleniumWalkedu) 