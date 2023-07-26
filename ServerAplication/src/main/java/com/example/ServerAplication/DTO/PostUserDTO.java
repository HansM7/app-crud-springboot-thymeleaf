package com.example.ServerAplication.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;


public class PostUserDTO {

    @NotEmpty()
    @Pattern(regexp = "^[^0-9]+$", message = "The field cannot be numbers")
    private String name;

    @NotEmpty()
    private String father_lastname;

    @NotEmpty()
    private String mother_lastname;

    @Min(0)
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
