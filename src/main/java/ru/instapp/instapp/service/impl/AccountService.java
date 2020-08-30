package ru.instapp.instapp.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.instapp.instapp.domain.AccountDomain;
import ru.instapp.instapp.repository.AccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements ru.instapp.instapp.service.AccountService {

    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;

    public AccountService(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<AccountDomain> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<AccountDomain> getById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Optional<AccountDomain> getByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public AccountDomain save(AccountDomain s) {
        Optional<AccountDomain> account = accountRepository.findByEmail(s.getEmail());
        if (account.isPresent()) return null;
        s.setPassword(passwordEncoder.encode(s.getPassword()));
        return accountRepository.save(s);
    }

    @Override
    public void deleteById(Long id) {
        Optional<AccountDomain> account = accountRepository.findById(id);
        account.ifPresent(e -> accountRepository.deleteById(id));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<AccountDomain> account = accountRepository.findByEmail(s);
        if (account.isEmpty()) throw new UsernameNotFoundException("Пользователь не найден");
        return account.get();
    }
}
