# ERS-Project
The Expense Reimbursement System (ERS) will manage the process of reimbursing
employees for expenses incurred while on company time. All employees in the
company can login and submit requests for reimbursement and view their past tickets
and pending requests. Finance managers can log in and view all reimbursement
requests and past history for all employees in the company. Finance managers are
authorized to approve and deny requests for expense reimbursement.

**Reimbursement Types:**
LODGING, TRAVEL, FOOD, or OTHER.

# TODO:
add our own theme!



# Functions
Functions that are currently implemented and tested to be working between the Java Application and Database.

## Currently Implemented:

### Login Authentication:
Database will return ERS_USERS_ID if username/password combination is valid. Otherwise, it will return -1. Java Application will return true or false, and will set the User Object's ID to ERS_USER_ID if valid.

```java
            cs.execute();
			
			resultId = cs.getInt(1);
			if (resultId == -1) {
				return false;
			}
			t.setId(resultId);
			cs.close();
			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
		}
		return true;
```

### Create Reimbursement:
To create a Reimbursement a user needs to fill out the following fields:
"amount" (integer)
"description" (string)
"type" (integer)

The application should automatically handle getting the:
"author" (integer)
"status" (integer) (defaults to pending when a ticket is first created)

**Example of interacting with create(t) method.**
```java
System.out.println("create(t)");
		Reimbursement reimb = new Reimbursement();
		User user = new User();
		System.out.println("amount:");
		reimb.setAmount(sc.nextInt());
		System.out.println("description:");
		reimb.setDescription(sc.next());
		user.setId(1); //testing id of 1
		System.out.println("You are logged in as: " + user.getId());
		reimb.setAuthor(user.getId());
		reimb.setStatusid(1);
		int status = reimb.getStatusid();
		switch (status) {
		case 1:
			System.out.println("The ticket's status is now: Pending");
			break;
		case 2:
			System.out.println("The ticket's status is now: Denied");
			break;
		case 3:
			System.out.println("The ticket's status is now: Approved");
			break;
		default:
			System.out.println("There was an error retreiving status!");
			break;
		}
		
		System.out.println("Ticket Type: (Enter number) \n"
							+ "1. Lodging \n"
							+ "2. Travel \n"
							+ "3. Food \n"
							+ "4. Other \n");
		reimb.setTypeid(sc.nextInt());
		
		System.out.println("Your Reimbursement Ticket: ");
		System.out.println(rs.create(reimb));
```

#TEST