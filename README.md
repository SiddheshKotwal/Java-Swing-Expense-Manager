# Java Swing Expense Manager

[![Java](https://img.shields.io/badge/Language-Java-blue.svg)](https://www.java.com)
[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/licenses/MIT)

A desktop application built with Java Swing for efficient tracking and management of personal expenses. It provides a clean and intuitive graphical user interface (GUI) to perform CRUD operations on expense records, which are persistently stored in a local SQLite database.

## Application Showcase

### 1. Adding a New Expense
Fill the amount, category, and date fields and click "Add Expense".

<p align="left">
  <img src="./Expense%20Tracker%20Images/add%20expense/Capture1.JPG" alt="Adding Expense Step 1" width="270">
  <img src="./Expense%20Tracker%20Images/add%20expense/Capture2.JPG" alt="Adding Expense Step 2" width="270">
  <img src="./Expense%20Tracker%20Images/add%20expense/Capture3.JPG" alt="Adding Expense Step 3" width="270">
</p>

### 2. Updating an Expense
Select a row, modify the fields, and click "Update Expense".

<p align="left">
  <img src="./Expense%20Tracker%20Images/update%20expense/Capture4.JPG" alt="Updating Expense Step 1" width="270">
  <img src="./Expense%20Tracker%20Images/update%20expense/Capture5.JPG" alt="Updating Expense Step 2" width="270">
  <img src="./Expense%20Tracker%20Images/update%20expense/Capture6.JPG" alt="Updating Expense Step 3" width="270">
</p>

### 3. Deleting an Expense
Select a row and click "Delete Expense".

<p align="left">
  <img src="./Expense%20Tracker%20Images/delete%20expense/Capture12.JPG" alt="Deleting Expense Step 1" width="270">
  <img src="./Expense%20Tracker%20Images/delete%20expense/Capture7.JPG" alt="Deleting Expense Step 2" width="270">
  <img src="./Expense%20Tracker%20Images/delete%20expense/Capture8.JPG" alt="Deleting Expense Step 3" width="270">
</p>

### 4. Viewing Total and Category-wise Expenses
Click "Get Total Expenses" for overall total, or select a category from the dropdown.

<p align="left">
  <img src="./Expense%20Tracker%20Images/Total%20and%20Category%20wise%20total%20expenses/Capture9.JPG" alt="Viewing Totals Step 1" width="270">
  <img src="./Expense%20Tracker%20Images/Total%20and%20Category%20wise%20total%20expenses/Capture11.JPG" alt="Viewing Totals Step 2" width="270">
  <img src="./Expense%20Tracker%20Images/Total%20and%20Category%20wise%20total%20expenses/Capture12.png" alt="Viewing Totals Step 3" width="270">
</p>

---

## Features

- **Add Expenses:** Easily input new expense records.
- **View All Expenses:** Display all recorded expenses in a tabular format.
- **Update Expenses:** Modify details of existing expense entries.
- **Delete Expenses:** Remove specific expense records.
- **Total Expenses:** Calculate and display the sum of all expenses.
- **Category-wise Totals:** View the total expenditure for selected categories.
- **Data Persistence:** Utilizes SQLite for local data storage.
- **Input Validation:** Ensures data integrity through input checks.

---

## Technologies & Design Patterns

### Technologies Used
- **Language:** Java
- **GUI Framework:** Java Swing
- **Database:** SQLite
- **JDBC Driver:** SQLite JDBC

### Architecture
- **MVC (Model-View-Controller):** Separates data management, UI, and user input handling.
- **DAO (Data Access Object):** Abstracts database interactions.

---

## Setup and How to Run

### Prerequisites
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)

### Instructions
1.  **Clone the repository:**
    ```bash
    git clone https://github.com/SiddheshKotwal/Java-Swing-Expense-Manager.git
    ```
2.  **Navigate to the project directory:**
    ```bash
    cd Java-Swing-Expense-Manager
    ```
3.  **Compile the Java source files:**
    ```bash
    javac -d bin -cp "lib/*" src/*.java
    ```
4.  **Run the application:**
    ```bash
    java -cp "bin;lib/*" Main
    ```
    *(Use `;` as the separator on Windows, and `:` on macOS/Linux)*

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.