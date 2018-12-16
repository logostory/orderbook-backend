package io.logostory.orderbook.backend.controller;

import io.logostory.orderbook.backend.domain.dto.account.AccountDto;
import io.logostory.orderbook.backend.domain.entity.account.Account;
import io.logostory.orderbook.backend.repository.AccountRepository;
import io.logostory.orderbook.backend.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "api")
public class AccountController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepository  accountRepository;

    @PostMapping("signup")
    public ResponseEntity create(@RequestBody @Valid AccountDto accountDto,
                                 Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }

        if (! accountRepository.findByUsername(accountDto.getUsername()).isPresent()) {
            Account account = modelMapper.map(accountDto, Account.class);
            accountService.createAccount(account);
            return ResponseEntity.ok(HttpStatus.CREATED);
        }else {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

}
