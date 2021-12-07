package br.sicredi.datajpaguide.demo.Service;

import br.sicredi.datajpaguide.demo.exception.CustomerBadRequestException;
import br.sicredi.datajpaguide.demo.exception.CustomerNotFoundException;
import br.sicredi.datajpaguide.demo.model.CustomerModel;
import br.sicredi.datajpaguide.demo.repository.CustomerRepository;
import br.sicredi.datajpaguide.demo.validations.CpfValidation;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Component
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<CustomerModel> findAllCustomers() {

        return repository.findAll();
    }

    public void addUser(CustomerModel customer) {

        //valida os atributos para que não sejam null
        if (customer.getCpf() == null || customer.getFirstName() == null || customer.getLastName() == null) {

            throw new CustomerBadRequestException("Input de informações inválido");
        }

        //valida se o cpf é verífico
        if (CpfValidation.cpdValidation(customer.getCpf())) {

            List<CustomerModel> listAllCustomers = findAllCustomers();

           if (listAllCustomers.stream().anyMatch(Customer -> Customer.getCpf().equals(customer.getCpf()))) {

                throw new CustomerBadRequestException("Cpf já cadastrado no sistema");

            } else
                repository.save(customer);

        }else
            throw new CustomerBadRequestException("Cpf inválido");
    }


    public List<CustomerModel> findByLastName(String lastName){

        List<CustomerModel> listAllCustomers = findAllCustomers();

        ArrayList<CustomerModel> listCustomerByLastName = new ArrayList<>();

        for (CustomerModel x: listAllCustomers){

            if (x.getLastName().equals(lastName)){

                listCustomerByLastName.add(x);
            }
        }

        if (listCustomerByLastName.size() == 0){
            throw new CustomerNotFoundException("Não encontramos customers cadastrados com esse recurso");
        }

        return listCustomerByLastName;
    }

    public CustomerModel findByCpf(String cpf){

        List<CustomerModel> listAllCustomers = findAllCustomers();

        for (CustomerModel x: listAllCustomers){

            if (x.getCpf().equals(cpf)){

                return x;
            }
        }

        throw new CustomerNotFoundException("Não encontramos customers cadastrados com esse recurso");
    }

    public Optional<CustomerModel> findById(long id){
        if (repository.findById(id).isPresent())
            return repository.findById(id);
        throw new CustomerNotFoundException("Não encontramos customers cadastrados com esse recurso");
    }

    public void logInfoString(String param, String method) {
        if (method.equals("lastName"))
            log.info("LOG - findByLastName Customers:" + findByLastName(param));
        else if (method.equals("findAll"))
            log.info("LOG - findAll Customers: " + findAllCustomers());
        else if (method.equals("cpf")){
            log.info("LOG - findByCpf Customers: " + findByCpf(param));
        }

    }



}
