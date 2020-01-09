package com.training.mysites.service;

import com.training.mysites.dao.SiteRepository;
import com.training.mysites.domain.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteServiceImpl implements SiteService{
    @Autowired
    private SiteRepository siteRepository;

    @Override
    public void save(Site s) {
        siteRepository.save(s);
    }

    @Override
    public List<Site> findAll() {
        return siteRepository.findAll();
    }
}
