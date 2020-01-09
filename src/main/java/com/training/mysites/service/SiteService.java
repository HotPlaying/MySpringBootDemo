package com.training.mysites.service;

import com.training.mysites.domain.Site;

import java.util.List;

public interface SiteService {
    public void save(Site s);
    public List<Site> findAll();
}
