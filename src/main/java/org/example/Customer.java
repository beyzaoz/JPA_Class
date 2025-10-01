package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="customers") //It is referance to table of customers. Customer on java is equal customers on database.
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // bu id yi neye gore yoneticek.
    @Column(name="customer_id")
    private int id; //customer_id

    @Column(name = "customer_name", length = 100, nullable = false)
    private String name;

    @Column(name = "customer_mail",unique = true, nullable = false)
    private String mail;

    @Temporal(TemporalType.DATE)
    @Column(name = "customer_on_date")
    private LocalDate onDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_gender")
    private GENDER gender;
    public enum GENDER{
        MALE,
        FEMALE
    }


    public Customer() {
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getOnDate() {
        return onDate;
    }

    public void setOnDate(LocalDate onDate) {
        this.onDate = onDate;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", onDate=" + onDate +
                ", gender=" + gender +
                '}';
    }
}
