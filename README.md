# Brokage Firm

A simple app managing: 
- creating, deleting, and listing orders (BUY or SELL)
- getting customer assets

It uses H2 as an embedded database (included)

## How to Run

You can run the entire project on an IDE (Intellij, for ex.) and access the url.
Also, you can run `mvn package` to create the jar file, and run it on your desired environment

Only an admin is authorized to use this app. Here are the basic credentials that this app uses (advanced methods required for the app to be run on production):

username: admin

password: strongpassword

URL: localhost:8080

Base url redirects to login page, and after being successful, it redirects to swagger page. 
Swagger stores all endpoints with their corresponding request and response models, so no need to document them here.

### Improvement Areas

- Advanced security configurations:
  - Separate credentials holder (Keycloak for ex.) or store it in a database
  - Authorize different endpoints with different roles (admin, user, etc.)
- A match order endpoint (To update orders with the status PENDING)
- An exception handler for better responses when an error occur
