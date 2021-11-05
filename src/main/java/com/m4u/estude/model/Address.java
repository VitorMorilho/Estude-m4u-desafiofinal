package com.m4u.estude.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tbl_id_address")
    private Integer id;

    @Column(name = "tbl_id_street", length = 35, nullable = false)
    private String street;

    @Column(name = "tbl_id_city", length = 35, nullable = false)
    private String city;

    @Column(name = "tbl_id_sate", length = 35, nullable = false)
    private String state;

    @Column(name = "tbl_id_zipCode", nullable = false)
    private Integer zipCode;

    @Column(name = "tbl_id_country", length = 35, nullable = false)
    private String country;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tbl_id_student")
    private Student student;

    public Address(){

    }

    public Address(String street,String city,String state,Integer zipCode){
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    //Métodos construtores

    public Address(Integer id, String street, String city, String state, Integer zipCode, String country, Student student) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                ", country='" + country + '\'' +
                ", student=" + student +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
