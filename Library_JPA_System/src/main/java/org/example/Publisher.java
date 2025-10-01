package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id ")
    private int id;

    @Column(name = "publisher_name")
    private String name;

    @Column(name = "establishment_year")
    private String establishmentYear;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "publisher",fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Book> bookLists;

    public Publisher() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEstablishmentYear() {
        return establishmentYear;
    }

    public void setEstablishmentYear(String establishmentYear) {
        this.establishmentYear = establishmentYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBookLists() {
        return bookLists;
    }

    public void setBookLists(List<Book> bookLists) {
        this.bookLists = bookLists;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", establishmentYear='" + establishmentYear + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
