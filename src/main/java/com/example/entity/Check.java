package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
public class Check {

    @Id
    @GeneratedValue
    private int id;

    @Size(min = 1, message = "name cannot be null!")
    private String name;

    @Size(min = 1, message = "url cannot be null!")
    @URL(message = "invalid url!")
    private String url;
}
