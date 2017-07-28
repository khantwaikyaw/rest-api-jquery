/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwk.lesson2;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Aung Thu Moe
 */
public abstract class ImmutableService<T extends Model> {
    
    protected final JpaRepository<T, Long> repository;

    public ImmutableService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }
    
    public void create(T model){
        this.repository.save(model);
    } 
    
    public T findOne(Long id){
        return this.repository.findOne(id);
    }
    
    public List<T> findAll(){
        return this.repository.findAll();
    }
    
  
    public void delete(Long id){
        this.repository.delete(id);
    }
    
    public Boolean exist(Long id){
        return this.repository.exists(id);
    }
    
}
