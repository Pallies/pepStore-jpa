package fr.diginamic.entities.store;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

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

    public Address() {
    }

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

    public void addressMerge(Address addressOld) {
        if (getNumber() == null)
            setNumber(addressOld.getNumber());
        if (getStreet() == null)
            setStreet(addressOld.getStreet());
        if (getZipCode() == null)
            setZipCode(addressOld.getZipCode());
        if (getCity() == null) {
            setCity(addressOld.getCity());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Address) return false;
        Address address = (Address) obj;
        return getNumber().equals(address.getNumber())
                && getStreet().equals(address.getStreet())
                && getZipCode().equals(address.getZipCode())
                && getCity().equals(address.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getStreet(), getZipCode(), getCity());
    }
}
