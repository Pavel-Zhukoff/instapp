package ru.instapp.instapp.service.impl;

import org.springframework.stereotype.Service;
import ru.instapp.instapp.domain.MediaDomain;
import ru.instapp.instapp.domain.PostDomain;
import ru.instapp.instapp.repository.MediaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MediaService implements ru.instapp.instapp.service.MediaService {

    private final MediaRepository mediaRepository;

    public MediaService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    @Override
    public List<MediaDomain> getAll() {
        return mediaRepository.findAll();
    }

    @Override
    public Optional<MediaDomain> getById(Long id) {
        return mediaRepository.findById(id);
    }

    @Override
    public Optional<MediaDomain> getByName(String name) {
        return mediaRepository.findByName(name);
    }

    @Override
    public List<MediaDomain> getAllByPost(PostDomain post) {
        return mediaRepository.findAllByPost(post);
    }

    @Override
    public MediaDomain save(MediaDomain s) {
        return mediaRepository.save(s);
    }

    @Override
    public void deleteById(Long id) {
        mediaRepository.deleteById(id);
    }
}
