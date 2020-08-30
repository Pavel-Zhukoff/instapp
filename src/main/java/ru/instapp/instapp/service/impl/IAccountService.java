package ru.instapp.instapp.service.impl;

import org.springframework.stereotype.Service;
import ru.instapp.instapp.domain.AccountDomain;
import ru.instapp.instapp.domain.IAccountDomain;
import ru.instapp.instapp.repository.IAccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IAccountService implements ru.instapp.instapp.service.IAccountService {

    private final IAccountRepository iAccountRepository;

    public IAccountService(IAccountRepository iAccountRepository) {
        this.iAccountRepository = iAccountRepository;
    }

    @Override
    public List<IAccountDomain> getAll() {
        return iAccountRepository.findAll();
    }

    @Override
    public Optional<IAccountDomain> getById(Long id) {
        return iAccountRepository.findById(id);
    }

    @Override
    public Optional<IAccountDomain> getByName(String name) {
        return iAccountRepository.findByName(name);
    }

    @Override
    public List<IAccountDomain> getAllByAccount(AccountDomain account) {
        return iAccountRepository.findAllByAccount(account);
    }

    @Override
    public List<IAccountDomain> getAllByAccount_Id(Long id) {
        return iAccountRepository.findAllByAccount_Id(id);
    }

    @Override
    public IAccountDomain save(IAccountDomain s) {
        return iAccountRepository.save(s);
    }

    @Override
    public void deleteById(Long id) {
        iAccountRepository.deleteById(id);
    }
}
