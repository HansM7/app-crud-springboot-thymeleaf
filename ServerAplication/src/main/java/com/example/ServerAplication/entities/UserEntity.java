package com.example.ServerAplication.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String father_lastname;

    private String mother_lastname;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
