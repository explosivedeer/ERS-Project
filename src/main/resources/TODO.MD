Backend:
- Database
   > Data Tables & Relations Between Them
   > Stored Functions (to call from the Java Program)

- Java Program
   > Controllers
   > Models
   > Repository (DaoContract/ModelDao)
   > Services (Methods referenced by Controllers)
   > Servlets

Front End:
  - HTML
   > Accessible Pages
      AS Employee
    - Login Page
    - View Past Tickets
    - Add Reimbursement Request
      AS Manager
    - Login Page
    - View All Reimbursements for all employees
        (additional functionality: Filter Requests by Status, Approve/Deny)
  - CSS
    > All elements
  - JS
    - Implementations to change up the HTML based on server responses. Such as displaying 
      formatted HTML tables that can display Reimbursements found in the database.

# Methods for Models

## Employee:

### Login

### Create Reimbursement Request

### View Pending Requests

### View Updated Status

## Manager:

### Login

### View Pending Requests

### Approve/Deny Requests

### View Updated Status