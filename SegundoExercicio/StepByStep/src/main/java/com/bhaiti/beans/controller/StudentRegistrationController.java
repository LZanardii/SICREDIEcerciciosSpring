package com.bhaiti.beans.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.bhaiti.beans.*;

@Controller
public class StudentRegistrationController {

    @RequestMapping(method = RequestMethod.POST, value="/register/student")

    @ResponseBody
    public StudentRegistrationReply registerStudent(@RequestBody Student student) {
        System.out.println("In registerStudent");
        StudentRegistrationReply stdregreply = new StudentRegistrationReply();
        StudentRegistration.getInstance().add(student);
        //We are setting the below value just to reply a message back to the caller
        stdregreply.setName(student.getName());
        stdregreply.setAge(student.getAge());
        stdregreply.setRegistrationNumber(student.getRegistrationNumber());
        stdregreply.setRegistrationStatus("Successful");

        return stdregreply;
    }

}
