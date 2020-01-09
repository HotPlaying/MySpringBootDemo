package com.training.mysites.service;

import com.training.mysites.domain.Content;
import com.training.mysites.domain.Search;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ContentService {
    public void save(Content content);
    public void delete(Content content);
    public void deleteById(Integer id);
    public void deletes(Iterable<Content> contents);
    public Content findById(Integer id);
    public Page<Content> findBySearch(Search search, Pageable pageable);
}
