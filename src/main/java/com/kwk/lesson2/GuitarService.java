/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwk.lesson2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


/**
 *
 * @author Aung Thu Moe
 */
@Service
public class GuitarService extends MutableService<Guitar> {

    public GuitarService(JpaRepository<Guitar, Long> repository) {
        super(repository);
    }
}
