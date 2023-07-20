/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sunrise.crud.entity;

import java.io.Serializable;

/**
 *
 * @author danie
 */
public class User implements Serializable {
    
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String consultation;

    public User() {
    }

    public User(int id, String name, String lastName, String email, String consultation) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.consultation = consultation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConsultation() {
        return consultation;
    }

    public void setConsultation(String consultation) {
        this.consultation = consultation;
    }
    
    
}
