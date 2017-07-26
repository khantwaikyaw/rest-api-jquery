/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwk.lesson2;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aung Thu Moe
 */
@RestController
public class GuitarController {
    
    private List<Guitar> guitar = new ArrayList<>();
    
    public GuitarController(){
        
        this.guitar.add( new Guitar(1, "Gibson", "Les Paul"));
        this.guitar.add( new Guitar(2, "Epiphone", "Les Paul"));
        this.guitar.add( new Guitar(3, "Ibanez", "Ibanez"));
        
    }
    
    @GetMapping("/api/guitars")
    public ResponseEntity<?> getGuitars(){
        return ResponseEntity.ok(this.guitar);
    }
    
    @GetMapping("/api/guitars/{id}")
    public ResponseEntity<?> getOne(@PathVariable int id){
        for (Guitar guitars: this.guitar){
            if (guitars.getId() == id ){
                return ResponseEntity.ok(guitars);
            }
        }
        return ResponseEntity.notFound().build();
    }
   
 
}

