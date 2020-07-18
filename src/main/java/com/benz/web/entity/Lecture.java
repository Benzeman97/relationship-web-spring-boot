package com.benz.web.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.benz.web.cfgs.Schema;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="LECTURE",schema = Schema.HR)
@Getter
@Setter
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="LECTID")
    private int lectId;
    @Column(name="FNAME",nullable=false)
    private String fname;
    @Column(name="LNAME",nullable=false)
    private String lname;

    @OneToMany(targetEntity = Lecture_Mail.class,cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "LECTID",referencedColumnName = "LECTID")
    private Set<Lecture_Mail> lectureMails;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "LECTURESUBJECT",
    joinColumns = @JoinColumn(name="LECTID"),
    inverseJoinColumns = @JoinColumn(name="SCODE"))
    private Set<Subject> subjects;

	

}
