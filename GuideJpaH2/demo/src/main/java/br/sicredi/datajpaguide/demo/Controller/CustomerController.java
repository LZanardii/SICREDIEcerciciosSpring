package br.sicredi.datajpaguide.demo.Controller;


import br.sicredi.datajpaguide.demo.Service.CustomerService;
import br.sicredi.datajpaguide.demo.model.CustomerModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class CustomerController {

    @Autowired
    private final CustomerService service;

    @PostMapping("/customers")
    public ResponseEntity<?> postCustomer(@RequestBody CustomerModel customer){
        service.addUser(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @GetMapping("/customers")
    public ResponseEntity<?> getCustomers(@PathParam("lastName") String lastName,
                                          @PathParam("cpf") String cpf){
        if (lastName != null) {
            service.logInfoString(lastName, "lastName");
            return new ResponseEntity<List<CustomerModel>>(service.findByLastName(lastName), HttpStatus.OK);
        }else if (cpf != null){
            service.logInfoString(cpf,"cpf");
            return new ResponseEntity<CustomerModel>(service.findByCpf(cpf), HttpStatus.OK);
        }else {
            service.logInfoString("zero", "findAll");
            return new ResponseEntity<List<CustomerModel>>(service.findAllCustomers(), HttpStatus.OK);
        }
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<?> findById(@PathVariable("id")long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }


}
