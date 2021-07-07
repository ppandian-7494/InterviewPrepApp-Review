# Interview Prep Application
​
The goal for this project will be to build an interacting application that allows the user to save documents required for Job Interview in MySQL DB and retrieve them. 

# Domain Objects
User, Document

# DB relationship
ManyToMany
The corresponding db tables are:
users, documents along with the join table user_document. 

# The /register endpoint
This end point allows to add new users.


# The /users endpoint
/users endpoint displays the userId, UserName, Password, Full Name of the users

The userId values are clickable. When clicked on, this will send a GET request to the /users/{userId} endpoint.

/users endpoint displays the topic of associated documents of the users. The topic values are clickable. When clicked on, this will send a GET request to the /users/{userId}/documents/{documentId} endpoint.

# The /users/{userId} endpoint
On the /users/{userId} screen the user information is updatable/deletable.
Available documents are displayed based on clickable topics. When clicked on, this will send a GET request to the /users/{userId}/documents/{documentId} endpoint.

When click on "Create New document" button it sends a post to create a new document to the url: /users/{userId}/documents  

# The /users/{userId}/documents/{documentId} endpoint
On the /users/{userId}/documents/{documentId} endpoint the document information are updatable/ deletable.



