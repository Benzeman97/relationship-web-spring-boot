package com.benz.web.services;

import com.benz.web.dao.LectureDAO;
import com.benz.web.entity.Lecture;
import com.benz.web.entity.Lecture_Mail;
import com.benz.web.entity.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class LectureService {

    @Autowired
    private LectureDAO lectureDAO;

    public void saveLectureDetails()
    {
        Lecture lecture3=new Lecture();
        lecture3.setFname("Dileeka");
        lecture3.setLname("Alwis");

        Lecture_Mail mail1=new Lecture_Mail();
        mail1.setMailAddrs("alwis@gmail.com");

        Lecture_Mail mail2=new Lecture_Mail();
        mail2.setMailAddrs("dileeka@gmail.com");


        Lecture lecture4=new Lecture();
        lecture4.setFname("Manoja");
        lecture4.setLname("Weerasekara");

        Lecture_Mail mail3=new Lecture_Mail();
        mail3.setMailAddrs("manoja@gmail.com");

        Lecture_Mail mail4=new Lecture_Mail();
        mail4.setMailAddrs("weerasekara@gmail.com");


        Subject sub1=new Subject();
        sub1.setSCode("103.4DB");
        sub1.setSName("Database");
        sub1.setCredit(10);

        Subject sub2=new Subject();
        sub2.setSCode("105.5AL");
        sub2.setSName("Algorithm");
        sub2.setCredit(20);

        Subject sub3=new Subject();
        sub3.setSCode("102.2SD");
        sub3.setSName("System Analysis and Design");
        sub3.setCredit(10);

        Subject sub4=new Subject();
        sub4.setSCode("101.0PR");
        sub4.setSName("Final Project");
        sub4.setCredit(40);
        
        Set<Lecture_Mail> mails1=new HashSet<>();
        mails1.add(mail1);
        mails1.add(mail2);
        
        Set<Lecture_Mail> mails2=new HashSet<>();
        mails2.add(mail3);
        mails2.add(mail4);

        Set<Subject> subjects1=new HashSet<>();
        subjects1.add(sub1);
        subjects1.add(sub3);

        Set<Subject> subjects2=new HashSet<>();
        subjects2.add(sub2);
        subjects2.add(sub4);


        lecture3.setLectureMails(mails1);
        lecture4.setLectureMails(mails2);
        
        lecture3.setSubjects(subjects1);
        lecture4.setSubjects(subjects2);

      
        lectureDAO.save(lecture3);
        lectureDAO.save(lecture4);

        System.out.println("Lecture details have been saved");
    }
    
   
}
