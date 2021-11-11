package com.bhaiti.beans.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.bhaiti.beans.StudentRegistration;

@RestController
public class StudentDeleteController {

    @DeleteMapping("/delete/student/{regdNum}")
    public String deleteStudentRecord(@PathVariable("regdNum") String regdNum) {
        System.out.println("In deleteStudentRecord");
        return StudentRegistration.getInstance().deleteStudent(regdNum);
    }
}