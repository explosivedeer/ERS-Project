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