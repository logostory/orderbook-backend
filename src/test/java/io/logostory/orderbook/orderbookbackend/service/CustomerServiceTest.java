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
    private Long customerId;


    @Before
    public void setup(){
        CustomerDTO customerDTO = getMockCustomerDTO();
        customerId  = customerService.save(customerDTO);
    }


    @Test
    public void updateTest(){
        // 문제 Insert TC 가 없고, Update 가 insert에 의존되어 있다.

        CustomerDTO selectObj = customerService.find(customerId);
        String updateName = "updateName";
        selectObj.setName(updateName);

        customerService.update(selectObj);

        CustomerDTO actualCustomerDTO = customerService.find(customerId);
        assertThat(actualCustomerDTO.getName(), is(updateName));
    }

    private CustomerDTO getMockCustomerDTO() {
        CustomerDTO mockDTO = new CustomerDTO();
        mockDTO.setCustomerId(1L);
        mockDTO.setName("mockName");
        return mockDTO;
    }
}