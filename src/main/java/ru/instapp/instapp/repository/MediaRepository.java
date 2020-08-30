package ru.instapp.instapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.instapp.instapp.domain.MediaDomain;
import ru.instapp.instapp.domain.PostDomain;

import java.util.List;
import java.util.Optional;

public interface MediaRepository extends JpaRepository<MediaDomain, Long> {
    List<MediaDomain> findAll();

    Optional<MediaDomain> findById(Long id);

    Optional<MediaDomain> findByName(String name);

    List<MediaDomain> findAllByPost(PostDomain post);

    MediaDomain save(MediaDomain s);

    void deleteById(Long id);
}
