package com.example.customerService.dao.entities;

 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 

/**
 * Entity that maps the ORDER table.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {

 

    @Id
    @Column(name = "ID")
    private Integer customerId;

 

    @Column(name = "FIRST_NAME")
    private String firstName;

 

    @Column(name = "LAST_NAME")
    private String lastName;

 

    @Column(name = "CITY")
    private String city;

 

    @Column(name = "COUNTRY")
    private String country;



}