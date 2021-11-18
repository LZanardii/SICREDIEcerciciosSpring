package com.example.DogService.Service;


import com.example.DogService.Exception.DogsException;
import com.example.DogService.Exception.DogsServiceException;
import com.example.DogService.Model.Dog;
import com.example.DogService.Model.MockDogProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DogService {

    private final MockDogProvider mockDogProvider;

    public String add(Dog dto) {
        if (mockDogProvider.findDogById(dto.getId()) != null){
            throw new DogsException("Esta ID já existe, insira outra.");
        }

        mockDogProvider.add(dto);
        return "Dog adicionado com sucesso.";
    }

    public String delete(long id) {
        if (mockDogProvider == null)
            throw new DogsServiceException();
        else if (mockDogProvider.getDogs().isEmpty())
            throw new DogsException("Lista de cachorros vazia, você não pode deletar!");
        else if (mockDogProvider.findDogById(id) == null)
            throw new DogsException("Id inserido não encontrado");

        mockDogProvider.delete(id);
        return "Dog Deletado";
    }

    public List<Dog> getDogs()  {
        if (mockDogProvider == null)
            throw new DogsServiceException();
        else {
            List<Dog> res = mockDogProvider.getDogs();
            if (res.isEmpty())
                throw new DogsException("Lista de cachorros vazia!");
            else
                return res;
        }
    }


    public Dog getDogById(long id) {
        return mockDogProvider.findDogById(id);
    }
}
