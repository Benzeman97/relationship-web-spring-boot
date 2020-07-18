package com.benz.web.entity;

import com.benz.web.cfgs.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SUBJECT56",schema = Schema.HR)
@Getter
@Setter
public class Subject {

    @Id
    @Column(name="SCODE",nullable = false)
    private String sCode;
    @Column(name = "SNAME")
    private String sName;
    @Column(name = "CREDIT")
    private int credit;

}
