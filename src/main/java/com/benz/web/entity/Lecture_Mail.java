package com.benz.web.entity;

import com.benz.web.cfgs.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "LECTUREMAIL",schema = Schema.HR)
@Getter
@Setter
public class Lecture_Mail {

    @Id
    @SequenceGenerator(name = "mailID_GEN",sequenceName = Schema.HR+".MAILID_SEQ",initialValue = 10,allocationSize = 1)
    @GeneratedValue(generator = "mailID_GEN",strategy = GenerationType.SEQUENCE)
    @Column(name="MAILID")
    private int mailId;
    @Column(name="MAILADDRS")
    private String mailAddrs;
   
}
