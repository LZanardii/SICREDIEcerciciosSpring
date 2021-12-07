package br.sicredi.devdojosecurity.demo.validations;

import br.sicredi.devdojosecurity.demo.domain.Student;
import br.sicredi.devdojosecurity.demo.repository.DbRepository;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class StudentValidations {

    private final DbRepository dbRepository;

    public boolean containsStudent(Student student){
        return dbRepository.getStudents().stream().anyMatch(Student -> Student.getCpf().equals(student.getCpf()));
    }

    public Student findByCpf(String cpf){
        if (dbRepository.getStudents().stream().anyMatch(Student -> Student.getCpf().equals(cpf))){
            return dbRepository.getStudents().stream().filter(Student -> Student.getCpf().equals(cpf)).findFirst().get();
        }else
            return null;
    }

}
