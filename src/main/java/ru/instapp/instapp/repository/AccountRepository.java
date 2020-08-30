package ru.instapp.instapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.instapp.instapp.domain.AccountDomain;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountDomain, Long> {

    List<AccountDomain> findAll();

    Optional<AccountDomain> findById(Long id);

    Optional<AccountDomain> findByEmail(String email);

    AccountDomain save(AccountDomain s);

    void deleteById(Long id);

}
