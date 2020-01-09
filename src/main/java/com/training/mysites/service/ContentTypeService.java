package com.training.mysites.service;

import com.training.mysites.domain.ContentType;

import java.util.List;

public interface ContentTypeService {
    public void save(ContentType type);
    public void delete(ContentType type);
    public void deletes(Iterable<ContentType> types);
    public void deleteById(Integer id);
    public List<ContentType> findByParent(ContentType parent);
    public List<ContentType> findAll();
    public ContentType findById(Integer id);
}
