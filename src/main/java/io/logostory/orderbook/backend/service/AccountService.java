package io.logostory.orderbook.backend.service;

import io.logostory.orderbook.backend.domain.entity.account.Account;
import io.logostory.orderbook.backend.domain.entity.account.AccountAdapter;
import io.logostory.orderbook.backend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> accountOptional = this.accountRepository.findByUsername(username);
        Account account = accountOptional.orElseThrow(() -> new UsernameNotFoundException(username));
        return new AccountAdapter(account);
    }



    public void createAccount(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        this.accountRepository.save(account);
    }
}
