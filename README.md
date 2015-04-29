# web-application-using-mean-stack-JSP-Servlet

# CMPE 273 Class Project
Application was developed as a part of an individual class project for the CMPE 273 class.

Created a MEAN (MongoDB, Express.js, Angular.js, Node.js) stack application for retrieving data from MongoDB database and display it to the customer on the home page.
Customer can select products and make orders.

Orders made by the customer will be managed by the application written in JSP-Servlet.

Logic of customer orders will be based on quantity of products remained in the MySQL database.

If quantity of products is zero, then customer will not be able to place an order.

If customer places an order, then he will be routed to a different port, which manages JSP-Servlet application.

Customer will need to signup and login to make payment for the selected product.

#Technologies Used
MongoDB was used as a database of catalogue.
Express.js as a middelware.
Angular.js for front end designing.
Node.js for routing of data information.

Servlet to handle inventory and manage order requests.
JSP for displaying information retrieved by the Servlets.
