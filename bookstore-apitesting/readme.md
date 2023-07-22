# Bookstore Automation Framework

This is a test automation framework for the Bookstore backend API. The framework is written in Java and uses Retrofit2 for API automation. The structure of the framework is modular and scalable, making it easy to maintain and extend for additional test scenarios.

## Folder Structure

- `src/main/java/api`: Contains classes related to API automation using Retrofit2.
    - `ApiClient.java`: Handles the API client configuration and initialization.
    - `ApiEndpoints.java`: Defines the API endpoints as interface methods.
    - `models`: Contains model classes representing the API responses.

- `src/main/java/utils`: Contains utility classes for the framework.
    - `Config.java`: Reads configuration from `config.properties` file.
    - `TestData.java`: Stores test data (e.g., username, password, author name, etc.).

- `src/resources/config.properties`: Configuration file for the framework.

- `src/test/java/tests`: Contains test classes for the automation scenarios.
    - `BookStoreTest.java`: Contains the actual test case to interact with the Bookstore backend API.

## Usage

1. **Configuration (config.properties)**: Update the `config.properties` file in the `src/resources` folder with the appropriate values for the backend API base URL.

2. **Test Data (TestData.java)**: Update the `TestData.java` file in the `src/main/java/utils` folder with the test data you want to use in the test scenarios. For example, update `USERNAME`, `PASSWORD`, `AUTHOR_NAME`, and `PUBLISHER_NAME`.

3. **API Automation (api)**: The `api` package contains classes for API automation using Retrofit2. The `ApiClient.java` class initializes the API client, and the `ApiEndpoints.java` class defines the API endpoints as interface methods.

4. **Test Scenarios (tests)**: The `tests` package contains test classes. For example, `BookStoreTest.java` contains the actual test case that interacts with the Bookstore backend API. Modify or add new test scenarios as needed.

5. **Running Tests**: To run the test cases, execute the test classes using a test runner (e.g., JUnit or TestNG). Ensure you have the necessary dependencies (Retrofit2, Gson, JUnit) added to your project build path or managed through a build tool like Maven or Gradle.

6. **Framework Extensibility**: The framework is designed to be modular and scalable, making it easy to add new test scenarios or endpoints. To add new API endpoints, define them in the `ApiEndpoints.java` interface. To add new test scenarios, create additional test classes in the `tests` package and use the `ApiEndpoints` class to interact with the API.

## Dependencies

- Retrofit2: A type-safe HTTP client for Java.
- Gson: A Java library to serialize and deserialize JSON objects.
- JUnit: A unit testing framework for Java.

## Contributing

This is an open-source project, and contributions are welcome. If you find any issues or have improvements to suggest, feel free to create a pull request.


