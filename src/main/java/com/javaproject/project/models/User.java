package com.javaproject.project.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Users")
public class User {


    @Id
    @Getter @Setter
    @Column(name="id") @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter @Column(name="name")
    private String name;

    @Getter @Setter @Column(name="lastname")
    private String lastname;

    @Getter @Setter @Column(name="email")
    private String email;

    @Getter @Setter @Column(name="phone")
    private int phone;

    /*@Getter @Setter @Column(name="toDoList")
    private List<String> toDoList;*/


    @Getter @Setter @Column(name="password")
    private String password;



}
