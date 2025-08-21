# Java Swing Expense Manager

![Java](https://img.shields.io/badge/Language-Java-blue.svg)
![License](https://img.shields.io/badge/License-MIT-green.svg)

A desktop application built with Java Swing for efficient tracking and management of personal expenses. It provides a clean and intuitive graphical user interface (GUI) to perform CRUD operations on expense records, which are persistently stored in a local SQLite database.

## Application Showcase

*Note: You can select the best image that represents each step from your folders.*

### 1. Main Interface & Viewing Expenses
The main window displays all current expenses in a clear, organized table.

![Main Application Window](./Expense%20Tracker%20Images/delete%20expense/Capture7.JPG)

### 2. Adding a New Expense
Users can easily add a new expense by filling out the amount, category, and date fields.

![Adding a new expense](./Expense%20Tracker%20Images/add%20expense/Capture2.JPG)

### 3. Updating an Expense
To update, select a row from the table, modify the details in the input fields, and click the "Update Expense" button.

![Updating an existing expense](./Expense%20Tracker%20Images/update%20expense/Capture5.JPG)

### 4. Deleting an Expense
Select any row and click the "Delete Expense" button to remove an entry.

![Deleting an expense](./Expense%20Tracker%20Images/delete%20expense/Capture8.JPG)

### 5. Viewing Totals
The application can calculate and display the total sum of all expenses or the total for a specific category selected from the dropdown.

![Viewing total expenses](./Expense%20Tracker%20Images/Total%20and%20Category%20wise%20total%20expenses/Capture11.JPG)

---

## Features

- **Add Expenses:** Add new expenses with amount, category, and date.
- **View All Expenses:** Display all expense records in a clear, sortable table.
- **Update Expenses:** Select and modify the details of any existing expense.
- **Delete Expenses:** Remove unwanted expense records from the database.
- **Calculate Totals:** View the total sum of all expenses.
- **Filter by Category:** Calculate and view the total expenses for a specific category.
- **Persistent Storage:** All data is saved locally in an SQLite database file (`expenses.db`).
- **Input Validation:** Robust checks to ensure all fields are filled correctly and prevent common errors.

---

## Technologies & Design Patterns

### Technologies Used
- **Language:** Java
- **GUI:** Java Swing
- **Database:** SQLite
- **Database Connectivity:** JDBC API

### Architecture
- **Model-View-Controller (MVC):** The application is structured using the MVC pattern to ensure a clean separation of concerns between the data logic (Model), the user interface (View), and the user input handling (Controller).
- **Data Access Object (DAO):** The DAO pattern is implemented to abstract and encapsulate all database interactions, isolating the business logic from the persistence layer.

---

## Setup and How to Run

### Prerequisites
- Java Development Kit (JDK) 11 or higher installed and configured.

### Running the Application from the Command Line

1.  **Clone or download the repository:**
    ```bash
    git clone [https://github.com/your-username/your-repo-name.git](https://github.com/your-username/your-repo-name.git)
    ```

2.  **Navigate to the project's root directory:**
    ```bash
    cd Java-Swing-Expense-Manager
    ```

3.  **Compile the source code:**
    This command compiles all `.java` files from the `src` directory and places the output `.class` files into a new `bin` directory.
    ```bash
    javac -d bin -cp "lib/*" src/*.java
    ```

4.  **Run the application:**
    This command executes the main class, making sure to include both the compiled code (`bin`) and the libraries (`lib`) in the classpath.
    
    *On Windows (using PowerShell or Command Prompt):*
    ```powershell
    java -cp "bin;lib/*" Main
    ```
    *On macOS/Linux:*
    ```bash
    java -cp "bin:lib/*" Main
    ```

---

## License

This project is licensed under the MIT License.