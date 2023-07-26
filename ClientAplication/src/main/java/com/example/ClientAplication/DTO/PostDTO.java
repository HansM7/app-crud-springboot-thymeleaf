package com.example.ClientAplication.DTO;

import jakarta.validation.constraints.*;

public class PostDTO {

    @Size(min=5, message = "The name is too short")
    @NotEmpty(message = "Error field name empty")
    private String name;

    @NotEmpty(message = "Error field father_lastname empty")
    private String father_lastname;

    @NotEmpty(message = "Error field mother_lastname empty")
    private String mother_lastname;

    @NotNull(message = "Error field age empty")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFather_lastname() {
        return father_lastname;
    }

    public void setFather_lastname(String father_lastname) {
        this.father_lastname = father_lastname;
    }

    public String getMother_lastname() {
        return mother_lastname;
    }

    public void setMother_lastname(String mother_lastname) {
        this.mother_lastname = mother_lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
