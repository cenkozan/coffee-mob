 - Welcome to Coffee Mob - 

After work hours, we mob coffee shops. We ask coffee owners for special discounts on items of their choosing because we are the COFFEE MOB. 

Important information about our app:

	1 Our main app will be hosted on Amazon.
	2 We are going to use Boxfuse which makes our job easier to deploy our Java application to Amazon (follow the instructions to set up Boxfuse on: https://console.boxfuse.com/#/getStarted, simple example here: https://boxfuse.com/blog/spring-boot-ec2)
	3 We are going to send our data as JSON to Amazon, which will put this data to Redis. Our JSON data will contain following information:
		- Name of the coffee shop
		- Date of meeting
		- Any discounts if there are
		- Location (We may change this data to a Google Maps link in a later sprint)
	4 Our app on Amazon will have a consumer that persists the incoming JSON to MySql database also hosted on Amazon.
	5 We are going to publish all our database data through an end-point.
	6 We will also create a simple HTML web page that listens our Amazon app through a Web Socket.
	
	
These were the requirements.

Here are some gotchas:

 - Boxfuse Vmware image is very basic. It doesn't let you install Redis or anything except DB (Postgres and Mysql)
 

