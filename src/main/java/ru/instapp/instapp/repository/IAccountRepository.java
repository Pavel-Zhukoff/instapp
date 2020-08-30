package ru.instapp.instapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.instapp.instapp.domain.AccountDomain;
import ru.instapp.instapp.domain.IAccountDomain;

import java.util.List;
import java.util.Optional;

public interface IAccountRepository extends JpaRepository<IAccountDomain, Long> {
    List<IAccountDomain> findAll();

    Optional<IAccountDomain> findById(Long id);

    Optional<IAccountDomain> findByName(String name);

    List<IAccountDomain> findAllByAccount(AccountDomain account);

    List<IAccountDomain> findAllByAccount_Id(Long id);

    IAccountDomain save(IAccountDomain s);

    void deleteById(Long id);
}
