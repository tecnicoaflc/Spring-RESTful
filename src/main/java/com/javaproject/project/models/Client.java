package com.javaproject.project.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Clients")
public class Client {

    @Id
    @Column(name="id") @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;


    @Column(name="first_name")
    @Getter @Setter
    private String first_name;

    @Column(name="last_name")
    @Getter @Setter
    private String last_name;

    @Column(name="phone")
    @Getter @Setter
    private String phone;

    @Column(name="city")
    @Getter @Setter
    private String city;

    @Column(name="email")
    @Getter @Setter
    private String email;

}
