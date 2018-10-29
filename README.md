# Simple API 

**This application uses HTTP Basic authentication, with the following details:**

**username:** admin 
**password:** password 

### There are paths for the following: 


**PATHS**

**/**

The main page is acccessible to all users 

**/moredata:** 

Adds information to an arraylist of data. This can also be a database, if necessary. This is only accessible to authenticated users. 

**/showdata:**

Shows a json array containing a list of objects. 

**/admin:** 
Only accessible to admin users 

**This project uses Commons Lang to generate a random string up to a given number of characters**
(See the POM file)  


