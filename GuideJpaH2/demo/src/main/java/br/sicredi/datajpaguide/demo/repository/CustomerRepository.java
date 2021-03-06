package br.sicredi.datajpaguide.demo.repository;

import br.sicredi.datajpaguide.demo.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {

}
