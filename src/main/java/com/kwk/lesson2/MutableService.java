/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwk.lesson2;

import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Aung Thu Moe
 */
public abstract class MutableService<T extends MutableModel> extends ImmutableService<T> {

    public MutableService(JpaRepository<T, Long> repository) {
        super(repository);
    }
      public void update(T model){
        model.setLastModifiedDate(new Date());
        this.repository.save(model);
    }
    
}
