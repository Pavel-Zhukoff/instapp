package ru.instapp.instapp.service.impl;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.instapp.instapp.domain.IAccountDomain;
import ru.instapp.instapp.domain.PostDomain;
import ru.instapp.instapp.repository.PostRepository;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService implements ru.instapp.instapp.service.PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDomain> getAll(Sort sort) {
        return postRepository.findAll(sort);
    }

    @Override
    public Optional<PostDomain> getById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<PostDomain> getAllByIAccount(IAccountDomain account) {
        return postRepository.findAllByInstagramAccount(account);
    }

    @Override
    public List<PostDomain> getAllByIAccount_Id(Long id) {
        return postRepository.findAllByInstagramAccount_Id(id);
    }

    @Override
    public List<PostDomain> getAllPublishingAtMonth(Long accountId, Calendar date) {

        return postRepository
                .findAllByInstagramAccount_Id(accountId)
                .stream()
                .filter(elem -> elem.getPublicationDate().get(Calendar.MONTH) == date.get(Calendar.MONTH))
                .collect(Collectors.toList());
    }

    @Override
    public PostDomain save(PostDomain s) {
        return postRepository.save(s);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
