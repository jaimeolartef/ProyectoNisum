package com.example.ProjectCustomer.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "telefono")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Telefono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "cityCode", nullable = false)
    private String cityCode;

    @Column(name = "countryCode", nullable = false)
    private String countryCode;
}
