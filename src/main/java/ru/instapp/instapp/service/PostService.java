package ru.instapp.instapp.service;

import org.springframework.data.domain.Sort;
import ru.instapp.instapp.domain.IAccountDomain;
import ru.instapp.instapp.domain.PostDomain;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

public interface PostService {

    List<PostDomain> getAll(Sort sort);

    Optional<PostDomain> getById(Long id);

    List<PostDomain> getAllByIAccount(IAccountDomain account);

    List<PostDomain> getAllByIAccount_Id(Long id);
    
    List<PostDomain> getAllPublishingAtMonth(Long accountId, Calendar date);

    PostDomain save(PostDomain s);

    void deleteById(Long id);
}
