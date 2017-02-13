package com.cuking.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by cuking on 2017/2/10.
 */
@Entity
@Table()
public class Department implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String descrip;

    private Date createDate;

    private Date updateDate;


}
