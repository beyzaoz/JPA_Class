package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library_jpa_system");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        EntityTransaction transaction = entityManager.getTransaction();
        Author author = new Author();
        author.setName("Albert");
        author.setCountry("Germany");
        author.setBithDate(LocalDate.of(1998,07,12));
        entityManager.persist(author);



        Publisher publisher = new Publisher();
        publisher.setName("Lux Edition");
        publisher.setAddress("2345 Edison street");
        publisher.setEstablishmentYear("1889");

        entityManager.persist(publisher);

        Category category = new Category();
        category.setName("Romantic");
        category.setName("Sci-Fic");
        category.setDescription("A book combining love and fiction, telling heartfelt stories.");

        entityManager.persist(category);

        Book book = new Book();
        BookBorrowing bookBorrowing = new BookBorrowing();
        book.setName("Love Song");
        book.setPublicationYear("2023");
        book.setStock(100);
        book.setAuthor(author);
        book.setBookBorrowings(List.of(bookBorrowing));
        book.setCategory(List.of(category));
        book.setPublisher(publisher);

        entityManager.persist(book);


        bookBorrowing.setBorrowerName("Fidan Kulac");
        bookBorrowing.setBorrowingDate(LocalDate.of(2025,2,19));
        bookBorrowing.setReturnDate(LocalDate.of(2025,10,29));
        bookBorrowing.setBook(book);
        entityManager.persist(bookBorrowing);

        entityManager.getTransaction().commit();
        entityManagerFactory.close();
    }
}