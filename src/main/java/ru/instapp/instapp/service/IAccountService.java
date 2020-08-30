package ru.instapp.instapp.service;

import ru.instapp.instapp.domain.AccountDomain;
import ru.instapp.instapp.domain.IAccountDomain;

import java.util.List;
import java.util.Optional;

public interface IAccountService {

    List<IAccountDomain> getAll();

    Optional<IAccountDomain> getById(Long id);

    Optional<IAccountDomain> getByName(String name);

    List<IAccountDomain> getAllByAccount(AccountDomain account);

    List<IAccountDomain> getAllByAccount_Id(Long id);

    IAccountDomain save(IAccountDomain s);

    void deleteById(Long id);
}
