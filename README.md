# Employee-Reimbursment-System (ERS)

Project Description

Employee Reimburesment System where employees can login and view past reimbursements as well as submit new reimbursement requests. Finance Managers can login and view all employee reimbursements along with the ability to approve or deny reimbursements.

Technologies Used
PostgreSQL - version 42.3.3
Javalin - version 4.3.0
jackson - version 2.12.4

Features

Can view reimbursement infromation for employees and managers can view all reimbursements 
Sessions allow users to access only sections they are assigned
New users can be registered into database as emlpoyees or managers

To-do list:

Improve approve and deny buttons for better functionality, only affecting one line instead of line plus a random line.
Fix data dispaly so actual date is shown and not long number

Getting Started
In Bash use git clone [https://github.com/Cunnjoel/Employee-Reimbursment-System]
Create environmental variables to match those in the ConnectionUtil class in the util folder
Run schema in Dbeaver to create database 
Ensure the role, type, and status tables are populated with corresponding data
  role: employee, manager
  type: food, lodging, travel
  status: pending, approved, denied
Start the server in IntelliJ by clicking the green arrow in the MainDriver class and press RUN
Open browser at http:localhost:9000

All the code required to get started
Images of what it should look like
Usage
Here, you instruct other people on how to use your project after they’ve installed it. This would also be a good place to include screenshots of your project in action.

License
This project uses the following license: <license_name>.
