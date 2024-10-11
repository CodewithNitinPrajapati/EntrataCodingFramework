# EntrataCodingFramework
EntrataAutomationFramework/

 **Project Structure**:
```
EntrataAutomationFramework/
│
├── .idea/                   # IDE-specific files (for IntelliJ IDEA)
│
├── src/
│   ├── main/                # Main application code (if applicable)
│   │   └── java/
│   │       └── com.entarta/ # Package structure for your main code
│   │           ├── core/    # Core utilities or base classes
│   │           ├── pageObjects/ # Page Object Model classes for UI elements
│   │           └── utils/   # Utility classes (e.g., helper functions)
│   │
│   └── resources/           # Non-Java resources (e.g., property files, configs)
│
├── test/                    # Test files
│   ├── java/                # Test source code
│   │   └── webTestCases/    # Test cases using Selenium WebDriver
│   │
│   └── resources/           # Test-specific resources (e.g., test data)
│       └── TestData/        # Directory for test data files
│           └── log4j2.xml    # Logging configuration file for Log4j
│
├── target/                  # Compiled output and build artifacts (auto-generated)
│
├── .gitignore               # Git ignore file to exclude unnecessary files
├── pom.xml                  # Maven project file for dependencies and build config
└── testng.xml               # TestNG configuration file for defining test suites

```
## Prerequisites

Before you begin, ensure you have the following installed on your machine:

1. **Java Development Kit (JDK)**:
   - Version: JDK 22
   - Verify installation:
     ```bash
     java -version
     ```

2. **Apache Maven**:
   - Required for managing project dependencies and building the project.
   - Verify installation:
     ```bash
     mvn -version
     ```

3. **Integrated Development Environment (IDE)**:
   - Recommended IDEs: IntelliJ IDEA, Eclipse, or Visual Studio Code
   - Ensure necessary plugins/extensions for Java and Maven support are installed.

4.**Web Driver Manager**:
   - Ensure WebDriverManager dependency added in pom.xml either need to install browser specific binary driver.
   <!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.9.2</version>
    </dependency>

6. **TestNG Library**:
   - TestNg dependency:
     ```xml
     <dependency>
         <groupId>org.testng</groupId>
         <artifactId>testng</artifactId>
         <version>7.7.0</version>
         <scope>test</scope>
     </dependency>
     ```

7. **Selenium Java Client**:
   - Selenium Java client dependency:
     ```xml
     <dependency>
         <groupId>org.seleniumhq.selenium</groupId>
         <artifactId>selenium-java</artifactId>
         <version>4.21.0</version>
     </dependency>
     ```

8. **Log4j Library**:
   - Log4j library for logging:
     ```xml
     <dependency>
         <groupId>org.apache.logging.log4j</groupId>
         <artifactId>log4j-api</artifactId>
         <version>2.20.0</version>
     </dependency>
     <dependency>
         <groupId>org.apache.logging.log4j</groupId>
         <artifactId>log4j-core</artifactId>
         <version>2.20.0</version>
     </dependency>
     ```

## How to Run the Tests
Once you have all prerequisites installed, you can run your tests using the following command from the project root:

```bash
mvn clean test
```

## Note
If want to run tests on local browser then go to config.properties file and change 'REMOTE' to 'LOCAL' or use this command 

```bash
mvn clean install -DexecutionType=LOCAL
```

<img width="398" alt="image" src="https://github.com/user-attachments/assets/02d1744c-ecdd-4fca-9552-f6a2485073e2">

