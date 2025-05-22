# Class Roster App
A simple CRUD application implementing MVC design pattern and using Spring for dependency injection.
The user can construct a class roster by adding, removing, and viewing current students.

# Setup
## Dependencies
This project requires:

- Maven
- Java 1.8+
- Unix shell

## Installation
To install the program, first clone this repository into a directory of your choice

```
git clone https://github.com/Raz-Rotundu/ClassRoster
cd ClassRoster
mvn clean compile
```
The application can now be opened in the IDE of your choice

# Features
## Spring
This project used the Spring framework for dependency injection. An IOC container is configured to assemble, instantiate and configure the beans used throughout the project. This project uses an XML-based setup, where the Beans are defined in the application context configuration file itself.
## MVC Pattern
This project's packages are organized roughly according to the MVC paradigm, with the dao, ui, and controller packages corresponding to the model, view and controller functionality. A service class acts as an interface to the model of the project, and handles all of the input validation when creating students, as well as logging.
## Logging and Persistence
This project uses two files for persistence:

1. roster.txt
2. audit.txt

The former contains the serialized content of the roster, and is loaded into memory on program start.
The latter logs all insertions and deletions performed by the user.
Both are updated on every insert and delete from the roster.

# Usage
Running the program will prompt the user with a menu describing the actions to take along with the corresponding key:

1. List Students
2. Create New Student
3. View a Student
4. Remove a Student
5. Exit

When creating a student two restrictions apply:

1. The new student must have a unique ID
2. The new student cannot have any blank fields

If these are not followed, the program will not allow the student to be created.