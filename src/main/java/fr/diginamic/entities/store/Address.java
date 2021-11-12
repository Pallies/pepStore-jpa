package fr.diginamic.entities.store;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * The Class Address.
 */
@Embeddable
public class Address implements Serializable {

    /** The number. */
    @Column(name="NUMERO")
    private String number;
    
    /** The Street. */
    @Column(name="RUE", nullable = false)
    private String Street;
    
    /** The zip code. */
    @Column(name = "CODE_POSTAL",length = 5, nullable = false)
    private String zipCode;
    
    /** The city. */
    @Column( name = "VILLE",length = 50, nullable = false)
    private String city;

    /**
     * Instantiates a new address.
     */
    public Address() {
    }

    /**
     * Instantiates a new address.
     *
     * @param number the number
     * @param street the street
     * @param zipCode the zip code
     * @param city the city
     */
    public Address(String number, String street, String zipCode, String city) {
        setNumber(number);
        setStreet(street);
        setZipCode(zipCode);
        setCity(city);
    }

    /**
     * Gets the number.
     *
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the number.
     *
     * @param number the new number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Gets the street.
     *
     * @return the street
     */
    public String getStreet() {
        return Street;
    }

    /**
     * Sets the street.
     *
     * @param street the new street
     */
    public void setStreet(String street) {
        Street = street;
    }

    /**
     * Gets the zip code.
     *
     * @return the zip code
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the zip code.
     *
     * @param zipCode the new zip code
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets the city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city the new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Address merge.
     *
     * @param addressOld the address old
     */
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

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Address) return false;
        Address address = (Address) obj;
        return getNumber().equals(address.getNumber())
                && getStreet().equals(address.getStreet())
                && getZipCode().equals(address.getZipCode())
                && getCity().equals(address.getCity());
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getStreet(), getZipCode(), getCity());
    }
}
