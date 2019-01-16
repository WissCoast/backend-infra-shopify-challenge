# backend-shopify-challenge

**Create cart**
----
  Creates a cart and returns the cart id in plain text

 **URL :** /cart

 **Method :** `POST`
  
* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{{cart id}}`
    
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

If the cart id doesn't exist
  * **Code:** 404 NOT FOUND <br />
    **Content example:** `{"errorMessage": "Cart with id :cartId not found"}`
