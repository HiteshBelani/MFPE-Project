# MFPE-Project
Cognizant MFPE project - Product Feedback Management System

This Project was created for Cognizant MFPE project evaluations.

The usage of the internet to buy various items for daily necessities has grown significantly in recent years. Customers now prefer making purchases of numerous things online. However, the numerous e-commerce sites and growing number of online retailers make it challenging for shoppers to choose a certain product. 
A customer frequently wants to discover what other customers who have already purchased the same product think about it. Therefore, using implicit user feedback, we tried to rate products. In this project, we randomly selected a small number of goods and their respective Companies and Categories and tried to take their feedback from the Customers and rate them accordingly so that the other customers can see the rating and feedback of the products and make correct choices while buying.

This project is based on microservice architecture . There are 4 microservices in this project :-

1) Authorization Microservice
2) Customer Microservice
3) Product Microservice
4) Feedback Microservice

Product Feedback Portal (Frontend) is made using HTML,CSS and ReactJs.

![Wireframe Diagram](https://user-images.githubusercontent.com/66918672/224245315-24d3d0fe-7894-4972-9c58-845d6ea3325e.jpg)


Architecture Design:-

![MFPE Project Architecture Diagram](https://user-images.githubusercontent.com/66918672/224245768-11eae02a-0cbd-4286-a595-70f800e8af58.jpg)


Below are the modules that needs to be developed part of the Project:

#### Customer module 
A portal that allows a customer to add and modify customer details and view customer feedbacks with help of following operations :
Functionalities :- 
1) Add Customer details
2) Update Customer details
3) Delete Customer details
Store all details in customer database

#### Product module
Product module includes: 
1) Get all products 
2) Get product by Id
3) Get product by name
4) Get top Rated products
5) Get least rated products
6) Get all products of a Company
7) Get all products of a Category
Store all details in product database


#### Feedback  module
Feedback module is a Microservices that performs the following operations:
1) view Feedback of a Product
2) Add Feedback to a Product
3) View Feedbacks of a Customer.
Store all details in feedback database


#### Authorization service
This microservice is used with anonymous access to Generate JWT.
When a Customer Logins with his/her credentials , first the credentials are checked and then a token is generated for a Authorized user.
Wherever the Customer wants to update his/her details , first the token is checked if its valid or not.

1) Authenticates login credentials
2) Authorizes a Customer.





