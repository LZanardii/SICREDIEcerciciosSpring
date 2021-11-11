package com.bhaiti.beans.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.bhaiti.beans.Student;
import com.bhaiti.beans.StudentRegistration;

@RestController
public class StudentUpdateController {

    @PutMapping("/update/student")
    public String updateStudentRecord(@RequestBody Student stdn) {
        System.out.println("In updateStudentRecord");
        return StudentRegistration.getInstance().upDateStudent(stdn);
    }

}

