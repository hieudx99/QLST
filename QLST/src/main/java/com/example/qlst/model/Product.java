package com.example.qlst.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    private int id;
    private String name;
    private double unitPrice;
    private int nbr_sold;
    private int nbr_left;
    private String desc;
    private int size;
    private String color;
    private String image;
    private Category category;

    public Product(String name, double unitPrice, int nbr_sold, int nbr_left, String desc, int size, String color, String image, Category category) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.nbr_sold = nbr_sold;
        this.nbr_left = nbr_left;
        this.desc = desc;
        this.size = size;
        this.color = color;
        this.image = image;
        this.category = category;
    }

}
