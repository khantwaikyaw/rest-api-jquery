/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwk.lesson2;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.LastModifiedDate;

/**
 *
 * @author Aung Thu Moe
 */
public abstract class MutableModel extends DateStampedModel {
    
    private static final long serialVersionUID = -5427271280750032834L;
    
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date LastModifiedDate;
    
    public MutableModel(){
        this.LastModifiedDate = new Date();
    }

    public Date getLastModifiedDate() {
        return LastModifiedDate;
    }

    public void setLastModifiedDate(Date LastModifiedDate) {
        this.LastModifiedDate = LastModifiedDate;
    }
    
    
    
    
    
}
