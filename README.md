# Book-Store-Spring-Boot-App
Development of endpoints for an online book store using Spring boot

## Dependencies
1. Spring Web
2. Spring boot starter data mongodb
3. Spring data JPA
4. Lombok


## Functionality
The application will use a MongoDb database and the columns will include:
> Title, author, category, price, totalCopies

1. The admin will be able to add books one at a time or upload multiple using a CSV File
2. Users will be able to view a list of available books and can filter based on category
3. Users can get book by id:  they get all the detail of book for that id. The end point for this function is:”/api/book/{id}”. 
4. Admin will be able to update a book: The end point is “/api/books/update/{id}” where id is path variable. 
Here we pass the BookDto object too. h variable “id” in the url, it gives exception. While updating if “id” in the bookDto object is removed, it still updates other field updated in the id of the path variable.
