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
Req. No.
Req. Name
Req. Description
REQ_01
Customer module
A portal that allows a customer to login and allows to modify customer details with help of following operations :
Add details
Update details
Delete details
Store all details in customer database
REQ_02
Product module
Product module includes:
Get all products 
Get product by Id
Get product by name
Get top Rated products
Get least rated products
Get all products of a Company
Store all details in product database
REQ_03
Feedback  module
Feedback module is a Microservices that performs the following operations:
Get the feedback response.
Feedback module have following operations:
Add Feedback
Get Feedback 
Store all details in feedback database
REQ_04
Authorization service
This microservice is used with anonymous access to Generate JWT
REQ_05
Feedback Management Portal
It allows Customer to Register his/her details and login as an authorized customer.
Customers can see product details,top rated products and least rated products and give feedback and rating to any product from the portal.
Customers can also see the feedback and ratings given to the products.



