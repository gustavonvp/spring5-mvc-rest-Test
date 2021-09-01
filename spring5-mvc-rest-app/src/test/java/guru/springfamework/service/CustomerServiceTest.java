package guru.springfamework.service;

import guru.springframework.api.v1.mapper.CustomerMapper;
import guru.springframework.model.CustomerDTO;
import guru.springframework.controller.v1.CustomerController;
import guru.springframework.domain.Customer;
import guru.springframework.repositories.CustomerRepository;
import guru.springframework.service.CustomerService;
import guru.springframework.service.CustomerServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class CustomerServiceTest {

    public static final Long ID = 2L;
    public static final String NAME = "Jimmy";
    public static final String LASTNAME = "Doe";

    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);
    }

    @Test
    public void getAllCustomer() {
        //given
        List<Customer> customers = Arrays.asList(new Customer(), new Customer(), new Customer());

        when(customerRepository.findAll()).thenReturn(customers);

        //thenReturn
        assertEquals(3, customers.size());
    }

    @Test
    public void getCustomerById() {

        //given
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstname(NAME);
        customer.setLastname(LASTNAME);

        when(customerRepository.findById(any())).thenReturn(java.util.Optional.of(customer));

        //when
        CustomerDTO customerDTO = customerService.getCustomerById(ID);

        //then
        assertEquals(NAME, customerDTO.getFirstname());
        assertEquals(LASTNAME,customerDTO.getLastname());
    }

    @Test
    public void createNewCustomer() throws Exception {

        //given
         CustomerDTO customerDTO = new CustomerDTO();
         customerDTO.setFirstname("Jim");

         Customer savedCustomer = new Customer();
         savedCustomer.setFirstname(customerDTO.getFirstname());
         savedCustomer.setLastname(customerDTO.getLastname());
         savedCustomer.setId(1L);

         when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);

         //when
        CustomerDTO saveDto = customerService.createNewCustomer(customerDTO);

        //then
        assertEquals(customerDTO.getFirstname(), saveDto.getFirstname());
        assertEquals(CustomerController.BASE_URL + "/1" , saveDto.getCustomerUrl());
    }

    @Test
    public void saveCustomerByDTO() throws Exception {

        //given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstname("Jim");

        Customer savedCustomer = new Customer();
        savedCustomer.setFirstname(customerDTO.getFirstname());
        savedCustomer.setLastname(customerDTO.getLastname());
        savedCustomer.setId(1L);

        when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);

        //when
        CustomerDTO savedDto = customerService.saveCustomerByDTO(1L, customerDTO);

        //then
        assertEquals(customerDTO.getFirstname(), savedDto.getFirstname());
        assertEquals(CustomerController.BASE_URL + "/1", savedDto.getCustomerUrl());


    }

    @Test
    public void deleteCustomerById() throws  Exception {
         Long id = 1L;

         customerRepository.deleteById(id);

         verify(customerRepository, times(1)).deleteById(anyLong());
    }
}