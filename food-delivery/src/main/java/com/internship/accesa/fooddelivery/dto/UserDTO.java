package com.internship.accesa.fooddelivery.dto;

public class UserDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    private UserDTO id(Long id){
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDTO firstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDTO lastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public UserDTO email(String email){
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
