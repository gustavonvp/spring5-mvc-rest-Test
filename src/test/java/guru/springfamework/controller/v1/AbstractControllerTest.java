package guru.springfamework.controller.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springfamework.api.v1.model.CustomerDTO;

public class AbstractControllerTest {

    public static String asJsonString(CustomerDTO customerDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(customerDTO);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
