Welcome to Coffee Mob 
=====================

After work hours, we mob coffee shops. We ask coffee owners for special discounts on items of their choosing because we are the COFFEE MOB. 

Important information about our app:

1.  We are using Spring Boot as the foundation.
2.  Our main app will be hosted on Amazon.
3.  We are going to send our data as JSON to Amazon, which will put this data to Redis. Our JSON data will contain following information:
    * Name of the coffee shop
    * Date of meeting
    * Any discounts if there are
    * Location (We may change this data to a Google Maps link at a later sprint)
4.  Our app on Amazon will have a consumer that persists the incoming JSON to MySql database also hosted on Amazon.
5.  We are going to publish all our database data through an end-point.
6.  We are also going to create a simple HTML web page that listens our Amazon app through a Web Socket.
7.  We are packaging our app as a jar. To deploy the jar to Amazon, we are going to use scp.
8.  To package the app use: "mvn package" after making sure there are no compilation errors or failing tests.
8.  I have the necessary .pem file that is needed to ssh and scp the jar file.
9.  After copying the jar file, ssh to Amazon, and run java -jar coffeeMob-1.0.jar
	

Here is how to add an item to the Coffee Mob:
*   From an app like Postman, send an unauthorized request to ec2-54-93-58-245.eu-central-1.compute.amazonaws.com:8080/coffee-shop-service/coffee-shop
*   Here is an example data:
    *   {"coffeeName":"Kafe Nero", "date":"2016-06-03", "discount":"Coffee: 10%, Cakes: 10%", "location":"Istanbul"}
