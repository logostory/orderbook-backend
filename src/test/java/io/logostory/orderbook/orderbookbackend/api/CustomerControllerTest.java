package io.logostory.orderbook.orderbookbackend.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.logostory.orderbook.orderbookbackend.domain.dto.CustomerDTO;
import io.logostory.orderbook.orderbookbackend.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CustomerApi.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService service;

    private ObjectMapper mapper = new ObjectMapper();

    public static final Long CUSTOMER_ID = 1L;

    @Test
    public void normalReadCase() throws Exception {
        //given
        Long customerId = 1L;
        CustomerDTO mockDTO = getMockCustomerDTO();
        given(service.find(customerId)).willReturn(mockDTO);

        //when
        ResultActions results = mockMvc.perform(get("/customer/" + customerId)
                .contentType(MediaType.APPLICATION_JSON_UTF8));

        // then "logging"
        results.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void wrongReadCase() throws Exception {
        //given
        Long customerId = -1L;

        //when
        ResultActions results = mockMvc.perform(get("/customer/" + customerId)
                .contentType(MediaType.APPLICATION_JSON_UTF8));

        // then "logging"
        results.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());

        // and
        then(service).should(never()).find(customerId);
    }

    @Test
    public void normalWriteCase() throws Exception {
        //given
        CustomerDTO mockDTO = getMockCustomerDTO();
        String json = mapper.writeValueAsString(mockDTO);
        given(service.save(any())).willReturn(CUSTOMER_ID);

        //when
        ResultActions results = mockMvc.perform(post("/customer")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON_UTF8));

        // then
        results.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void normalUpdateCase() throws Exception {
        //given
        CustomerDTO mockDTO = getMockCustomerDTO();
        String json = mapper.writeValueAsString(mockDTO);
        given(service.update(any())).willReturn(true);

        //when
        ResultActions results = mockMvc.perform(put("/customer")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON_UTF8));

        // then "logging"
        results.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

    }

    @Test
    public void normalDeleteCase() throws Exception {
        //given

        //when
        ResultActions results = mockMvc.perform(delete("/customer/" + CUSTOMER_ID)
                .contentType(MediaType.APPLICATION_JSON_UTF8));

        // then
        then(service).should(only()).delete(CUSTOMER_ID);

        // and
        results.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

    }

    private CustomerDTO getMockCustomerDTO() {
        CustomerDTO mockDTO = new CustomerDTO();
        mockDTO.setCustomerId(CUSTOMER_ID);
        mockDTO.setName("customerName");
        return mockDTO;
    }

}
