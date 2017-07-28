/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kwk.lesson2;

import java.util.Date;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.LastModifiedDate;

/**
 *
 * @author Aung Thu Moe
 */
@MappedSuperclass
public abstract class MutableModel extends DateStampedModel {
    
    private static final long serialVersionUID = -5427271280750032834L;
    
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date lastModifiedDate;
    
    public MutableModel(){
        this.lastModifiedDate = new Date();
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date LastModifiedDate) {
        this.lastModifiedDate = LastModifiedDate;
    }
    
}
