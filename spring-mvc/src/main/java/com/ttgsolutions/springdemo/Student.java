package com.ttgsolutions.springdemo;

import java.util.LinkedHashMap;

public class Student {
    private String firstName;
    private String lastName;
    private String country;

    private String favoriteLanguage;

    private LinkedHashMap<String, String> countryOptions;

    private LinkedHashMap<String, String> favoriteNameOptions;

    private String favoriteName;

    private String[] operatingSystems;


    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public Student() {
        // populate country options: used ISO country code

        countryOptions = new LinkedHashMap<>();

        countryOptions.put("BR", "Brazil");
        countryOptions.put("FR", "France");
        countryOptions.put("DE", "Germany");
        countryOptions.put("IN", "India");
        countryOptions.put("US", "United States of America");

        favoriteNameOptions = new LinkedHashMap<>();
        favoriteNameOptions.put("HAR", "Hillary");
        favoriteNameOptions.put("JHR", "Jack");
        favoriteNameOptions.put("ERR", "Emerson");
        favoriteNameOptions.put("DR", "Daisy");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LinkedHashMap<String, String> getFavoriteNameOptions() {
        return favoriteNameOptions;
    }

    public String getFavoriteName() {
        return favoriteName;
    }

    public void setFavoriteName(String favoriteName) {
        this.favoriteName = favoriteName;
    }

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }
}
