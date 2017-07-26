/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwk.lesson2;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Aung Thu Moe
 */
@Component
public class RepositaryGuitar {
    
    private List<Guitar> guitar = new ArrayList<>();
    
    public RepositaryGuitar(){
        this.guitar.add( new Guitar(1, "Gibson", "Les Paul"));
        this.guitar.add( new Guitar(2, "Epiphone", "Les Paul"));
        this.guitar.add( new Guitar(3, "Ibanez", "Ibanez"));
    }
    
    public void addOne(Guitar guitar){
        if (guitar == null) throw new NullPointerException("No null");
        for(Guitar gt:this.guitar){
            if (gt.getId() == guitar.getId()){
                throw new IllegalArgumentException("nope");
            }
        }
        this.guitar.add(guitar);
    }
    
    public List<Guitar> getAll(){
        return this.guitar;
    }
    
    public Guitar getOne(int id)
    {
        for (Guitar guitars : this.guitar){
            if (id == guitars.getId()){
                return guitars;
            }
        }
        throw new NullPointerException("Not Exit");
    }
    
    public void delete(int id){
        Guitar guitar = this.getOne(id);
        this.guitar.remove(guitar);
    }
}
