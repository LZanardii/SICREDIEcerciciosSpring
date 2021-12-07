package br.sicredi.devdojosecurity.demo.controllers;


import br.sicredi.devdojosecurity.demo.domain.Student;
import br.sicredi.devdojosecurity.demo.error.ResourceNotFoundException;
import br.sicredi.devdojosecurity.demo.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping("/students/get")
    public List<Student> getStudents(){

        return service.getStudents();
    }

    @GetMapping("students/get/{cpf}")
    public ResponseEntity<Student> getStudentByCpf(@PathVariable String cpf){
        verifyIfStudentExists(cpf);
        Student student = service.findByCpf(cpf);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/admin/post")
    public String postStudent(@RequestBody Student student){
        return service.addStudent(student);
    }

    @DeleteMapping ("/admin/delete/{cpf}")
    public ResponseEntity<?> deleteStudent(@PathVariable String cpf){
        verifyIfStudentExists(cpf);
        service.deleteStudentByCpf(cpf);
        return new ResponseEntity<>("Estudante portador do cpf:" + cpf + " deletado.",HttpStatus.OK);
    }

    private void verifyIfStudentExists(String cpf){
        Student student = service.findByCpf(cpf);
        if (student == null)
            throw new ResourceNotFoundException("Estudante portador do cpf: " + cpf + " não encontrado.");
    }





}
