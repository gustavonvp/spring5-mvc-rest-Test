package guru.springfamework.controller.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.model.CustomerDTO;
import guru.springframework.api.v1.model.VendorDTO;

public class AbstractControllerTest {

    public static String asJsonString(CustomerDTO customerDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(customerDTO);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String asJsonString(VendorDTO vendorDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(vendorDTO);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

}
