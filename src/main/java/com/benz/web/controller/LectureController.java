package com.benz.web.controller;

import com.benz.web.services.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lecture")
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @PostMapping("/save")
    public void save()
    {
         try{
            lectureService.saveLectureDetails();
         }catch (Exception ex)
         {
             ex.printStackTrace();
         }
    }

}
