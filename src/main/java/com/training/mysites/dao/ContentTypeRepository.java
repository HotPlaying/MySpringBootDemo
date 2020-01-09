package com.training.mysites.dao;

import com.training.mysites.domain.ContentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ContentTypeRepository extends JpaRepository<ContentType,Integer> {
    public List<ContentType> findByParent(ContentType parent);
}
