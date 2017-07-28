/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwk.lesson2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Aung Thu Moe
 */

@Entity
@Table(name = "guitar")
public class Guitar extends MutableModel {

    private static final long serialVersionUID = -1118120524327897134L;
    
    @Column(name="brand")
    private String brand;
    
    @Column(name="type")
    private String type;
    
    public Guitar(){
        super();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
