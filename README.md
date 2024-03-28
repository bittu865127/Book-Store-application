# Book-Store-application
We are going to create an Book Store application in core java

Create 3 Pojo:

1. Book - id, Book name, Author, year of published & no of books left

2. Customer - id, Name, Gender, DOB, Age (from DOB find Age), address, email & phn no

3. one Mapping class - which has Customer id & purchased book id, no of books

Create one main class & add few Book & Customers to separate list

Create Functional Interface to implement validation check,

If we try to add an book, it should check it wasn't already added, same for customer as well

If we try to map, book to customer,

1) Validate customer & book are valid,

2) Check Book mentioned has Inventory i.e., no of books left,

3) Check no mapping already available.

if available throw an error saying customer already bought.

if yes was response increment no of books

if no was response stop process

4) If successfully added reduce inventory

Try to implement using Streams, Optional classes, Functional Interface, Method reference8
