package guru.springfamework.api.v1.mapper;

import guru.springframework.api.v1.mapper.CustomerMapper;
import guru.springframework.model.CustomerDTO;
import guru.springframework.domain.Customer;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerMapperTest {

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    public void customerToCustomerDTO() {
        //given
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstname("Joe");
        customer.setLastname("Bucket");


        //when
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        //then
        assertEquals("Joe", customerDTO.getFirstname());
        assertEquals("Bucket", customerDTO.getLastname());
    }

}