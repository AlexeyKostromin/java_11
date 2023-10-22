package model;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.List;
import java.util.Map;
//{
//        "first_Name": "Adrian",
//        "last_Name": "Sparrow",
//        "age": "43",
//
//        "address": {
//        "street": "Albany Dr",
//        "city": "San Jose",
//        "zipcode": 95129
//        },
//
//        "role": "Manager",
//        "cities": [
//        "Los Angeles",
//        "New York"
//        ]
//        }

public class EmployeeModelJackson {

    private String firstName;
    private String lastName;
    private int age;
    private String role;
    private List<String> cities;
    private Map<String, String> properties;
    private Address address;

    @JsonGetter("first_Name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonGetter("last_Name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public Address getAddress() {
        return address;
    }

    public static class Address {
        private String street;
        private String city;
        private String zipcode;

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

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        @Override
        public String toString() {
            return getStreet() + ", " + getCity() + ", " + getZipcode();
        }
    }

}
