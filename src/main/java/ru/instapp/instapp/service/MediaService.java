package ru.instapp.instapp.service;

import ru.instapp.instapp.domain.MediaDomain;
import ru.instapp.instapp.domain.PostDomain;

import java.util.List;
import java.util.Optional;

public interface MediaService {
    List<MediaDomain> getAll();

    Optional<MediaDomain> getById(Long id);

    Optional<MediaDomain> getByName(String name);

    List<MediaDomain> getAllByPost(PostDomain post);

    MediaDomain save(MediaDomain s);

    void deleteById(Long id);
}
