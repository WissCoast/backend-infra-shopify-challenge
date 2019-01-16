# backend-shopify-challenge

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

The project uses the SQL [H2 in-memory database](http://www.h2database.com/html/main.html) for simplicity sake. It requires no extra set up for you to run locally. It is written in java, so it is packaged with the project in the dependencies. All communication to the database is made through [JPA](https://en.wikipedia.org/wiki/Java_Persistence_API), and the queries are made my [JPQL](https://en.wikipedia.org/wiki/Java_Persistence_Query_Language) so it would take no time to integrate any other SQL database (and a NoSQL database with minimal effort).

### Explanations and Thought Process

The 3 important classes in the domain are Cart, Product and CartProduct. Cart and Product are self-explanatory. The difference between Produt and CartProduct, is that Product represents object in the shop's inventory, while a CartProduct represents an object in a cart. The CartProduct contains the the productId it represents, the cartId it's in and the quantity of the product it holds.

### Criticism of my project

- Money should have been represented using a more precise datatype such as the [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html) class in Java, instead of using "long". 
