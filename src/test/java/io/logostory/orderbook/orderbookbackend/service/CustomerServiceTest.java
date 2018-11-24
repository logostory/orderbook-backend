package io.logostory.orderbook.orderbookbackend.service;

import io.logostory.orderbook.orderbookbackend.domain.Customer;
import io.logostory.orderbook.orderbookbackend.domain.dto.CustomerDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;


    @Before
    public void setup(){

    }

    @Test
    public void insertTest(){
        CustomerDTO customerDTO = getMockCustomerDTO();
        customerService.save(customerDTO);
        CustomerDTO selectObj = customerService.find(1L);

        //CustomerDTO customerDTO = getMockCustomerDTO();
        String updateName = "updateName";
        selectObj.setName(updateName);

        customerService.update(selectObj);
        CustomerDTO customer1 = customerService.find(1L);

        assertThat(customer1.getName(), is(updateName));
    }

    private CustomerDTO getMockCustomerDTO() {
        CustomerDTO mockDTO = new CustomerDTO();
        mockDTO.setCustomerId(1L);
        mockDTO.setName("mockName");
        return mockDTO;
    }
}