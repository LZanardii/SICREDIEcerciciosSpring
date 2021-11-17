package com.example.DogService.Controller;


import com.example.DogService.Model.Dog;
import com.example.DogService.Service.DogService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class DogController {

    private final DogService service;

    @GetMapping("/dogs")
    public List<Dog> getDogs() {
        return service.getDogs();
    }

    @PostMapping("/dogs/post")
    public void postDogs(@RequestBody Dog dto) {
        service.add(dto);
    }

    @GetMapping("/dogs/{id}")
    public Dog getById(@PathVariable(required = true) long id) {
        return service.getDogById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(required = true) long id) {
        service.delete(id);
    }
}