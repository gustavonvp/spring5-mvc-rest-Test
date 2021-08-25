package guru.springfamework.service;

import guru.springfamework.api.v1.mapper.CategoryMapper;
import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import org.hibernate.mapping.Any;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


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
}