/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwk.lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aung Thu Moe
 */
@RestController
public class GuitarController {
    @Autowired
    private GuitarService service;
    
    @GetMapping("/api/guitars")
    @ResponseBody
    public ResponseEntity<?> getGuitars(){
        return ResponseEntity.ok(this.service.findAll());
    }
    
    @GetMapping("/api/guitars/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        Guitar guitar = this.service.findOne(id);
        System.out.println("Guitar: " + guitar.toString());
        if (guitar == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(guitar);
    }
    
    @PostMapping("/api/guitars")
    public ResponseEntity<?> addOne(@RequestBody Guitar guitar){
        try{
            this.service.create(guitar);
            return ResponseEntity.accepted().body(guitar);
        } catch (IllegalArgumentException ex){
            return ResponseEntity.badRequest().build();
        }
    }
//    
    @RequestMapping (value = "/api/guitars/{id}", method = {RequestMethod.PUT, RequestMethod.PATCH})
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Guitar gt){
        try{
            System.out.println(gt.getBrand());
            Guitar guitar = this.service.findOne(id);
            guitar.setBrand(gt.getBrand());
            guitar.setType(gt.getType());
            this.service.update(guitar);
            return ResponseEntity.accepted().body(gt);
        } catch (NullPointerException ex){
            return ResponseEntity.badRequest().build();
        }
    }
    
    @DeleteMapping("/api/guitars/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id){
        try{
            this.service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (NullPointerException ex) {
            return ResponseEntity.notFound().build();
        }
    }
 
}

