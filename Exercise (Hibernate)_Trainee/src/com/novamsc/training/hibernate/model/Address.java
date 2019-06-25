package com.novamsc.training.hibernate.model;

import java.io.Serializable;

/**
 * Domain model that represents an address. This class is usually embedDed as composite class.
 * </p>
 * 
 * @author yewfai.chan
 */
public class Address implements Serializable
{
    private static final long serialVersionUID = 1021929025231964143L;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String country;

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Address other = (Address) obj;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        return true;
    }

    public String printAddress() {

        String container = "";
        if (!address1.isEmpty() && address1 != null) {
            container += address1;
        } else {
            if (!address2.isEmpty() && address2 != null) {
                container += address2;
            }
        }
        if (!city.isEmpty()) {
            container += ", " + city;
        }
        //
        if (state != null) {
            container += ", " + state;
        }
        if (!zip.isEmpty()) {
            container += ", " + zip;
        }
        if (!country.isEmpty()) {
            container += ", " + country;
        }
        return container;
    }

}
