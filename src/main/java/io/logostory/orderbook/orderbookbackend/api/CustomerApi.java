package io.logostory.orderbook.orderbookbackend.api;

import io.logostory.orderbook.orderbookbackend.domain.Customer;
import io.logostory.orderbook.orderbookbackend.domain.dto.CustomerDTO;
import io.logostory.orderbook.orderbookbackend.service.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
public class CustomerApi {


    private CustomerService customerService;


    @Autowired
    public CustomerApi(CustomerService customerService) {
        this.customerService = customerService;
    }

    //TODO DTO , View , Domain 객체에 대한 convention 을 듣고 싶음.
    @GetMapping(path = "/customer/{id}")
    public ResponseEntity<CustomerDTO> find(@PathVariable Long id) {
        if (id == null || id < 1) {
            return ResponseEntity.status(400).build();
        }
        return ResponseEntity.ok(customerService.find(id));
    }

    @PostMapping(path = "/customer")
    public ResponseEntity<String> write(@RequestBody CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return ResponseEntity.status(400).build();
        }
        Long customerId = customerService.save(customerDTO);

        return ResponseEntity.ok(customerId + "등록이 완료되었습니다 :) ");
    }

    @PutMapping(path = "/customer")
    public ResponseEntity<String> update(@RequestBody CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return ResponseEntity.status(400).build();
        }

        boolean isSuccess = customerService.update(customerDTO);

        if(isSuccess){
            return ResponseEntity.ok("삭제가 완료되었습니다 :) ");
        }

        return ResponseEntity.status(500).build();
    }

    @DeleteMapping(path = "/customer/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (id == null || id < 1) {
            return ResponseEntity.status(400).build();
        }
        // 중간에 오류가 났는지 확인 할 수 있는 방법 ?
        customerService.delete(id);

        return ResponseEntity.ok("삭제가 완료되었습니다 :) ");
    }

}
