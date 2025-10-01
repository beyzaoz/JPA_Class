package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library_jpa_system");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        EntityTransaction transaction = entityManager.getTransaction();

        Book book = new Book();
        book.setName("Love Song");
        book.setPublicationYear("2023");
        book.setStock(100);
        entityManager.persist(book);

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
        category.setDescription("Love and fiction is in one book. The author wants to create a stoory from presents love stories.");
        entityManager.persist(category);

        BookBorrowing bookBorrowing = new BookBorrowing();
        bookBorrowing.setBorrowerName("Fidan Kulac");
        bookBorrowing.setBorrowingDate(LocalDate.of(2025,2,19));
        bookBorrowing.setReturnDate(LocalDate.of(2025,10,29));
        entityManager.persist(bookBorrowing);
    }
}