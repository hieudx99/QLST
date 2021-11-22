package com.example.qlst.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {
    private int id;
    private String name;
    private String image;
    private String description;

    public Category(String name, String image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
    }
}
