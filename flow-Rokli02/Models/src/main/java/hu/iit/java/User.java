package hu.iit.java;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class User {
    @JacksonXmlProperty(localName = "name")
    private String name;
    @JacksonXmlProperty(localName = "age")
    private Integer age;
    @JacksonXmlProperty(localName = "favouriteColour")
    private String favouriteColour;

    public User() {}

    public User(String name, Integer age, String favouriteColour) {
        this.name = name;
        this.age = age;
        this.favouriteColour = favouriteColour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFavouriteColour() {
        return favouriteColour;
    }

    public void setFavouriteColour(String favouriteColour) {
        this.favouriteColour = favouriteColour;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", favouriteColour='" + favouriteColour + '\'' +
                '}';
    }
}
