package guru.springfamework.service;

import guru.springfamework.api.v1.model.CustomerDTO;

import java.util.Collection;

public interface CustomerService {

    Collection<? extends guru.springframework.model.CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(Long id);

    CustomerDTO createNewCustomer(CustomerDTO customerDTO);

    CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO);

    CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO);

    void deleteCustomerById(Long id);

}
