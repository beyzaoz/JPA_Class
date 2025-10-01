package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.Transaction;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("market");
        EntityManager em =  emf.createEntityManager();
        em.getTransaction().begin(); //Transactioni baslat.
        EntityTransaction transaction = em.getTransaction(); //Bu sekilde de olustuirulur.
//        Customer customer = new Customer();
//
//        customer.setName("Mustafa");
//        customer.setMail("test@patika.com");
//        customer.setGender(Customer.GENDER.MALE);
//        customer.setOnDate(LocalDate.now());
//
//        em.persist(customer);
//
//
//
//        em.getTransaction().commit(); //Commitleme islemi.
        //CRUD ISLEMLERI
//        Customer customer = em.find(Customer.class,1); //SELECT komutu id si 1 olani getirdi.
//        em.remove(customer);


//
//        //Supplier ekleme
//        Supplier supplier = new Supplier();
//        supplier.setAddress("Adres");
//        supplier.setCompany("Patika");
//        supplier.setContact("23456780");
//        supplier.setMail("info@patika.dev");
//        supplier.setPerson("Mustafa Cetindag");
//        em.persist(supplier);


        //color ekleme
        Color blue = new Color("Blue");
        Color yellow = new Color("yellow");
        Color red = new Color("red");
        em.persist(blue);
        em.persist(yellow);
        em.persist(red);



        //code ekleme
        Code code = new Code();
        code.setGroup("112233");
        code.setSerial("44456");
        em.persist(code);

        Category category = new Category();
        category.setName("phones");
        em.persist(category);

        Product product = em.find(Product.class,1);
        List<Color> colorList = new ArrayList<>();

        colorList.add(blue);
        colorList.add(red);
        product.setColorList(colorList);

        for(Color c : colorList){
            em.persist(c);
        } //Array list gonderemezsin. Eger listeyse tektek atanacak

//        //urun ekleme
//        product.setName("Iphone 15 pro");
//        product.setPrice(1234);
//        product.setStock(100);
//        product.setCode(code);
//        product.setSupplier(supplier);
//        product.setCategory(category);
//        em.persist(product);
//        transaction.commit();
//







    }
    }
