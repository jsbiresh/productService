package com.js.productservice.dtos;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;


@Getter
@Setter
public class GenericProductDto {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "binary(16)", nullable = false, updatable = false)
    private UUID uuid;

    //    private Long id;
    private String title;
    private String description;
    private String image;
    private double price;
    private String category;

//    public void setId(Long id) {
//        this.uuid = UUID.fromString(String.valueOf(id));
//    }
//
//    public Long getId() {
//        return Long.parseLong(uuid.toString());
//    }

}
