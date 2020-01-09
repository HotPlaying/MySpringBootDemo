package com.training.mysites.dao;

import com.training.mysites.domain.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SiteRepository extends JpaRepository<Site, Integer> {
}
