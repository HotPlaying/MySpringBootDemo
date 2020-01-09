package com.training.mysites.service;

import com.training.mysites.dao.ContentTypeRepository;
import com.training.mysites.domain.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ContentTypeServiceImpl implements ContentTypeService{
    @Autowired
    private ContentTypeRepository contentTypeRepository;

    @Override
    public void save(ContentType type) {
        contentTypeRepository.save(type);
    }

    @Override
    public void delete(ContentType type) {
        contentTypeRepository.delete(type);
    }

    @Override
    @Transactional
    public void deletes(Iterable<ContentType> types) {
        contentTypeRepository.deleteAll(types);
    }

    @Override
    public void deleteById(Integer id) {
        contentTypeRepository.deleteById(id);
    }

    @Override
    public List<ContentType> findByParent(ContentType parent) {
        return contentTypeRepository.findByParent(parent);
    }

    @Override
    public List<ContentType> findAll() {
        return contentTypeRepository.findAll();
    }

    @Override
    public ContentType findById(Integer id) {
        Optional<ContentType> oct = contentTypeRepository.findById(id);
        if (oct.isPresent())
            return oct.get();
        return null;
    }
}
