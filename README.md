# backend/infra-shopify-challenge

### Documentation for the api is available [here](api_documentation.md)

### Requirements to run the code
- Java 1.8.*
- Maven 3.5.*

### Instructions to run the code locally

1. Clone this repo and go to the root directory where the file `pom.xml` is located
2. run this command in the terminal to build the project `mvn clean install`
3. run this command in the terminal to run the project `mvn spring-boot:run`

### Notes

The project is coded in Java, using the framework Spring Boot for fast development.

The project uses the SQL [H2 in-memory database](http://www.h2database.com/html/main.html) for simplicity sake. It requires no extra set up for you to run locally. It is written in java, so it is packaged with the project in the dependencies. All communication to the database is made through [JPA](https://en.wikipedia.org/wiki/Java_Persistence_API), and the queries are made my [JPQL](https://en.wikipedia.org/wiki/Java_Persistence_Query_Language) so it would take no time to integrate any other SQL database (and a NoSQL database with minimal effort). The database is prefilled using the script `data.sql` found in `backend-shopify-challenge\src\main\resources`

### Explanations

The 3 important classes in the domain are Cart, Product and CartProduct. Cart and Product are self-explanatory. The difference between Produt and CartProduct, is that Product represents object in the shop's inventory, while a CartProduct represents an object in a cart. The CartProduct contains the productId it represents, the cartId it's in and the quantity of the product it holds.
<br>
For the data model, a Product has an id, inventory_count, price and a title. A Cart has an id, a total_value and eventually a user_id. A Cart_Product has an id, a product_id, a cart_id and a quantity. In terms of SQL relations, a Cart has many Cart_Products and a Cart_Product has one Product.
<br>
The code is separated in 3 main packages: 
- The domain that contains the business logic (not a lot of business logic in this project, it's mostly CRUD operations). Inside the domain package, there's the service sub-package, from where the business logic is called and executed. 
- The persistence package that holds the repositories used to access the db
- The package rest that contains the controllers where the requests are mapped to the right endpoint by [Jetty](https://en.wikipedia.org/wiki/Jetty_(web_server)). From the endpoints, the calls are redirected to the right services. That's also where the exception handing is made; I decided to catch errors at the highest point and to handle them all at the place in code where they are sent back to the client. The rest package also contains the assemblers and the DTOs.
<br>



### Criticism of my project

- Money should have been represented using a more precise datatype such as the [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html) class in Java, instead of using "long".
- An authentification system would have been the next step, along with security mesures
- An exception mapper would have been better, instead of letting the exception classes generate their error messages. 
