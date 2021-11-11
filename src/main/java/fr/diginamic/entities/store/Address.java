package fr.diginamic.entities.store;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Address implements Serializable {

    @Column(name = "NUMERO")
    private String number;
    @Column(name = "RUE", nullable = false)
    private String Street;
    @Column(name = "CODE_POSTAL", length = 5, nullable = false)
    private String zipCode;
    @Column(name = "VILLE", length = 50, nullable = false)
    private String city;

    public Address(){}

    public Address(String number, String street, String zipCode, String city) {
        setNumber(number);
        setStreet(street);
        setZipCode(zipCode);
        setCity(city);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
