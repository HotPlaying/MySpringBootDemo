package com.training.mysites.dao;

import com.training.mysites.domain.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ContentRepository extends JpaRepository<Content, Integer>, JpaSpecificationExecutor<Content> {

}
