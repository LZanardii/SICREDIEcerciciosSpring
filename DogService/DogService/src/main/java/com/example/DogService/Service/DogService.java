package com.example.DogService.Service;


import com.example.DogService.Model.Dog;
import com.example.DogService.Model.MockDogProvider;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DogService {

    private final MockDogProvider mockDogProvider;

    public void add(Dog dto) {
        mockDogProvider.add(dto);
    }

    public void delete(long id) {
        mockDogProvider.delete(id);
    }

    public List<Dog> getDogs() {
        return mockDogProvider.getDogs();
    }

    public Dog getDogById(long id) {
        return mockDogProvider.findDogById(id);
    }
}
