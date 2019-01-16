# backend-shopify-challenge

# Products

**Get all products**
----
Returns a JSON object containing all the products in the database

**URL :** /products/all

**Method :** `GET`

*  **URL Param**

   **Required: false**
   
   **Default value: false**
 
   `available=[boolean]`
   
if available is set to true, the query will only return items with inventory count greater than zero 

* **Success Response:**
  **Code:** 200 <br />
  **Response Example:**
example query: /products/all?available=true
```javascript
[
    {
        "id": "2",
        "title": "Super NES",
        "price": 1000,
        "inventoryCount": 200
    },
    {
        "id": "3",
        "title": "Atari 2600",
        "price": 1500,
        "inventoryCount": 5
    }
]
```

**Get product by title**
----
Returns a JSON object containing the object 

**URL :** /products/:title

**Method :** `GET`
   
* **Success Response:**
  **Code:** 200 <br />
  **Response Example:**
```javascript
{
    "id": "1",
    "title": "Sega Genesis",
    "price": 3000,
    "inventoryCount": 0
}
```

* **Error Response:**
  If the product title doesn't exist <br />
  **Code:** 404 NOT FOUND <br />
  **Content example:** `{"errorMessage":"Product with title :title not found"}`


**Add a product**
----
Adds an object, than returns a JSON object containing the object with the generated id

**URL :** /products/add

**Method :** `POST`

**Request body :** 
```javascript
{
    "title": "nintendo switch",
    "price": 499,
    "inventoryCount": 1
}
```
   
* **Success Response:**
  **Code:** 201 <br />
  **Response Example:**
```javascript
{
    "id": "402881816858566301685889a79f0002",
    "title": "nintendo switch",
    "price": 499,
    "inventoryCount": 1
}
```
# Cart

**Create cart**
----
  Creates a cart and returns the cart id in plain text

 **URL :** /cart

 **Method :** `POST`
  
* **Success Response:**

  * **Code:** 201 <br />
    **Content:** `:cartid`
    
 **View cart information**
----
  Returns a JSON object containing information about the cart

 **URL :** /cart/:cartid

 **Method :** `GET`
  
* **Success Response:**

  * **Code:** 200 <br />
    **Content example:** 
    ```javascript
    "products": [
        {
            "id": "1",
            "title": "Sega Genesis",
            "price": 3000,
            "quantity": 2
        },
        {
            "id": "2",
            "title": "Super NES",
            "price": 1000,
            "quantity": 1
        }
    ],
    "totalCartValue": 7000
 
* **Error Response:**
  If the cart id doesn't exist <br />
  **Code:** 404 NOT FOUND <br />
  **Content example:** `{"errorMessage": "Cart with id :cartId not found"}`

**Add a product to a cart**
----
  Adds a product to a cart and returns a JSON object containing the products in the cart

 **URL :** /cart/:cartid/product/:productid

 **Method :** `POST`
   
*  **URL Param**

   **Required: false**
   
   **Default value: 1**
 
   `quantity=[integer]`
  
* **Success Response:**

  * **Code:** 200 <br />
    **Content example:**
    /cart/123/product/1?quantity=2
    ```javascript
    "products": [
        {
            "id": "1",
            "title": "Sega Genesis",
            "price": 3000,
            "quantity": 2
        }
    ],
    "totalCartValue": 6000
 
* **Error Response:** <br />
  If the cart id doesn't exist <br />
  **Code:** 404 NOT FOUND <br />
  **Content example:** `{"errorMessage": "Cart with id :cartId not found"}`
 <br />
 If the product id doesn't exist
 **Code:** 404 NOT FOUND <br />
 **Content example:** `{"errorMessage": "Product with id :productId not found"}`
  
**Complete cart**
----
Completes the cart and reduces the inventory count

**URL :** /cart/:cartid/complete

**Method :** `POST`

* **Success Response:**

* **Code:** 200 <br />

* **Error Response:** <br />

  If the cart id doesn't exist <br />
  **Code:** 404 NOT FOUND <br />
  **Content example:** `{"errorMessage": "Cart with id :cartId not found"}`
  <br />
  If the product quantity is greater than the inventory count 
  **Code:** 400 BAD REQUEST <br />
  **Content example:** `{"errorMessage":"Shopping cart quantity is higher than inventory stock for product with name Sega Genesis"}`
