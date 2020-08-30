package ru.instapp.instapp.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.instapp.instapp.domain.AccountDomain;

import java.util.List;
import java.util.Optional;

public interface AccountService extends UserDetailsService {

    List<AccountDomain> getAll();

    Optional<AccountDomain> getById(Long id);

    Optional<AccountDomain> getByEmail(String email);

    AccountDomain save(AccountDomain s);

    void deleteById(Long id);

    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}
