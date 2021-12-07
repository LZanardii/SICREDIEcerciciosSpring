package br.sicredi.devdojosecurity.demo.service;


import br.sicredi.devdojosecurity.demo.domain.Student;
import br.sicredi.devdojosecurity.demo.repository.DbRepository;
import br.sicredi.devdojosecurity.demo.validations.StudentValidations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentService {

    private final DbRepository repository = new DbRepository();
    private final StudentValidations validations = new StudentValidations(repository);

    public StudentService(){
        repository.getStudents().add(new Student("Leo", 19, "05046035073"));
        repository.getStudents().add(new Student("Pedro", 20, "74706802091"));
        repository.getStudents().add(new Student("Evandro", 19, "89011902068"));
        repository.getStudents().add(new Student("Maria", 20, "05046024039"));
        repository.getStudents().add(new Student("Roberta", 21, "89011902167"));
    }

    //métodos de controle para os arrays do repository
    public String addStudent(Student student) {
        if (!validations.containsStudent(student)) {
            repository.getStudents().add(student);
            return "Estudante adicionado";
        }else
            return "Estudante já cadastrado";

    }

    public String deleteStudentByCpf(String cpf) {
        if (validations.findByCpf(cpf) != null) {
            repository.getStudents().remove(findByCpf(cpf));
            return "Estudante removido";
        }else
            return "Estudante inexistente ";

    }

    public Student findByCpf(String cpf){
        if (validations.findByCpf(cpf) != null){
            return validations.findByCpf(cpf);
        }else
            return null;

    }

    public ArrayList<Student> getStudents(){

        return repository.getStudents();
    }



}
