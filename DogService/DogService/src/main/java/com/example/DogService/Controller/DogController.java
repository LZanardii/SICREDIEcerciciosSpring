package com.example.DogService.Controller;


import com.example.DogService.Model.Dog;
import com.example.DogService.Service.DogService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Dog>> getDogs() {
        return new ResponseEntity<>(service.getDogs(), HttpStatus.OK);
    }

    @PostMapping("/dogs/post")
    public ResponseEntity<String> postDogs(@RequestBody Dog dto) {
        return new ResponseEntity<>(service.add(dto), HttpStatus.OK);
    }

    @GetMapping("/dogs/{id}")
    public Dog getById(@PathVariable(required = true) long id) {
        return service.getDogById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable(required = true) long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

}