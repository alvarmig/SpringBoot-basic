# Spring Boot Exercises - Mini projects
Collection of basic projects based on Spring boot and Maven.

<strong>Objective:</strong> The purpose of this repository is to store basic Spring boot and Maven based projects.

You can ding the following projects:
<ul>
  <li><strong>testAppSpringBoot:</strong> Basic Spring Boot project, this is a template that can be used as reference on how to create a Maven based project.</li>
  <li><strong>testAppSpringBootMySQL:</strong> These projects show the configuration of a Repository based on MySQL and implemented with Spring boot. 
    The program will create the database automatically for the user. 
    A simple REST API has been implemented to add users and display the users from the database.</li>
  <li><strong>chatbot:</strong> A mini chatbot implemented using REST services, MySQL, JavaScript, Ajax. 
    The app will respond the user with simple answers and will store or change the name of the user.</li>
</ul>

All of this project will show the Spring MVC configuration, MySQL connection, REST API services and dependencies. 

<hr>
<p align="center">
  <strong>testAppSpringBoot</strong>
</p>
A simple REST API was created with a GET requests that provides a simple greeting message to the user.
<br>
<p align="center">
  <img src="/img/img-1.JPG" width="400">
</p>


<hr>
<p align="center">
  <strong>testAppSpringBootMySQL</strong>
</p>
In this project a you can add user (name and email) to a database via POST request. Two POST methods have been implemented to insert values in the DB. One way is to use the @RequestParam annotation and the other way is to use the @RequesBody annotation to inser a User object.
<br>
Display all the user inserted in the database:
<p align="center">
  <img src="/img/img-4.JPG" width="950">
</p>
<br>
Insert user into database via a POST request using the @RequestParam annotation:
<p align="center">
  <img src="/img/img-2.JPG" width="600">
</p>
<br>
Insert user into database via a POST request using the @RequesBody annotation. A JSON is createt to represent the user object:
<p align="center">
  <img src="/img/img-3.JPG" width="400">
</p>
<br>

<hr>
<p align="center">
  <strong>chatbot</strong>
</p>
Simple chatbot app that will store the users name into a DB. MySQL was used to create the schema. The name can be modified if the user
mentions that the name has changed. REGEX has been used to identify keywords that the chatbot uses to respond. The functionality is limited and the purpose is too practice the fundamentals of REST API services and Repository funtionality.
<p align="center">
  <img src="/img/img-5.JPG" width="700">
</p>
The image below shows that the user is already in the db and welcomes back the user. 
<p align="center">
  <img src="/img/img-6.JPG" width="700">
</p>
