package br.sicredi.devdojosecurity.demo.repository;

import br.sicredi.devdojosecurity.demo.domain.Student;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
@Getter
public class DbRepository {

    private final ArrayList<Student>  students = new ArrayList<>();


}
