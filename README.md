# Conference Track Management

## Prerequisites for Building
* Java 1.7 or above
* Gradle (for building)
* JUnit (for test dependencies, will be automatically downloaded by Gradle)

## Prerequisites for Executing the Program
* Java 1.7 or above

## How to Build

```bash
cd /path/to/project-root
gradle build
```

This build task compiles the code, builds a jar file in `build/libs` directory, and executes the
tests.

## How to Run the Program

After `gradle build`:

```bash
java -jar /path/to/conference-track-management-1.0.jar /path/to/input_file
```

## TODO

* Add README.md file with design choices section
* Expand javadoc
* Expand unit tests
* Expand acceptance tests

