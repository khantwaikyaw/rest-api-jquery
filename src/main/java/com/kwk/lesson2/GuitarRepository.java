/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwk.lesson2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aung Thu Moe
 */
@Repository
public interface GuitarRepository extends JpaRepository<Guitar, Long> {
}