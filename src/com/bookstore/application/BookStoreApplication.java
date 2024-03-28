package com.bookstore.application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.pojo.Book;
import com.bookstore.pojo.Customer;
import com.bookstore.pojo.Mapping;
import com.bookstore.validation.Validation;

public class BookStoreApplication {
	
	public static void main(String[] args) {

        List<Book> books = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        List<Mapping> mappings = new ArrayList<>();

        
        Validation<Book> bookValidation = book -> {
            for (Book existingBook : books) {
                if (existingBook.getId() == book.getId()) {
                    System.out.println("Book with ID " + book.getId() + " already exists.");
                    return false;
                }
            }
            return true;
        };

        Validation<Customer> customerValidation = customer -> {
            for (Customer existingCustomer : customers) {
                if (existingCustomer.getId() == customer.getId()) {
                    System.out.println("Customer with ID " + customer.getId() + " already exists.");
                    return false;
                }
            }
            return true;
        };

        Validation<Mapping> mappingValidation = mapping -> {          
            boolean validCustomer = customers.stream().anyMatch(c -> c.getId() == mapping.getCustomerId());
            boolean validBook = books.stream().anyMatch(b -> b.getId() == mapping.getBookId());
            if (!validCustomer || !validBook) {
                System.out.println("Invalid customer or book.");
                return false;
            }

            Book book = books.stream().filter(b -> b.getId() == mapping.getBookId()).findFirst().orElse(null);
            if (book != null && book.getNumOfBooksLeft() < mapping.getNumOfBooks()) {
                System.out.println("Not enough inventory for book " + book.getName());
                return false;
            }

            for (Mapping existingMapping : mappings) {
                if (existingMapping.getCustomerId() == mapping.getCustomerId() && existingMapping.getBookId() == mapping.getBookId()) {
                    System.out.println("Customer already bought this book.");
                    return false;
                }
            }

            if (book != null) {
                book.setNumOfBooksLeft(book.getNumOfBooksLeft() - mapping.getNumOfBooks());
            }
            return true;
        };

        addEntity(books, new Book(1, "Book1", "Author1", 1925, 10), bookValidation);
       // addEntity(books, new Book(1, "Book1", "Author1", 1925, 10), bookValidation);
        addEntity(books, new Book(2, "Book2", "Author2", 1960, 15), bookValidation);
        addEntity(books, new Book(3, "Book3", "Author3", 1949, 12), bookValidation);

        addEntity(customers, new Customer(1, "Siya", "Female", LocalDate.of(1990, 5, 15), 0, "Vaishali sector 2", "Siya@example.com", "123-456-7890"), customerValidation);
        //addEntity(customers, new Customer(1, "Siya", "Female", LocalDate.of(1990, 5, 15), 0, "Vaishali sector 2", "Siya@example.com", "123-456-7890"), customerValidation);
        addEntity(customers, new Customer(2, "Ankit", "Male", LocalDate.of(1985, 8, 20), 0, "Vaishali sector 6", "Ankit@example.com", "987-654-3210"), customerValidation);
        addEntity(customers, new Customer(3, "Jitu", "Male", LocalDate.of(1995, 3, 10), 0, "Vaishali sector 3", "Jitu@example.com", "555-555-5555"), customerValidation);


        Mapping book1 = new Mapping(1, 1, 1); 
        addMapping(mappings, book1, mappingValidation);
        
        Mapping book2 = new Mapping(1, 1, 1); 
        addMapping(mappings, book2, mappingValidation);
        
        Mapping book3 = new Mapping(3, 3, 1);
        addMapping(mappings, book3, mappingValidation);

        System.out.println("Books in the store:");
        for (Book book : books) {
            System.out.println(book.getName() + " by " + book.getAuthor() + " - Inventory: " + book.getNumOfBooksLeft());
        }

        System.out.println("\nCustomers in the store:");
        for (Customer customer : customers) {
            System.out.println(customer.getName() + " - " + customer.getEmail());
        }
    }

    private static <T> void addEntity(List<T> list, T entity, Validation<T> validation) {
        if (validation.validate(entity)) {
            list.add(entity);
            System.out.println(entity.getClass().getSimpleName() + " added: " + entity.toString());
        }
    }

    private static void addMapping(List<Mapping> mappings, Mapping mapping, Validation<Mapping> validation) {
        if (validation.validate(mapping)) {
            mappings.add(mapping);
            System.out.println("Mapping added: " + mapping.toString());
        }
    }
	
}
