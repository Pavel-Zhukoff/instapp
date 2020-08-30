package ru.instapp.instapp.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.instapp.instapp.domain.IAccountDomain;
import ru.instapp.instapp.domain.PostDomain;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<PostDomain, Long> {

    List<PostDomain> findAll(Sort sort);

    Optional<PostDomain> findById(Long id);

    List<PostDomain> findAllByInstagramAccount(IAccountDomain account);

    List<PostDomain> findAllByInstagramAccount_Id(Long id);

    PostDomain save(PostDomain s);

    void deleteById(Long id);
}
