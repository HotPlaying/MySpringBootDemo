package com.training.mysites.service;

import com.training.mysites.dao.ContentRepository;
import com.training.mysites.domain.Content;
import com.training.mysites.domain.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ContentServiceImpl implements ContentService{
    @Autowired
    private ContentRepository contentRepository;

    @Override
    public void save(Content content) {
        if (content.getCid()==null) {
            content.setCdate(LocalDateTime.now());
        }
        contentRepository.save(content);
    }

    @Override
    public void delete(Content content) {
        contentRepository.delete(content);
    }

    @Override
    public void deleteById(Integer id) {
        contentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deletes(Iterable<Content> contents) {
        contentRepository.deleteAll(contents);
    }

    @Override
    public Content findById(Integer id) {
        Optional<Content> oc = contentRepository.findById(id);
        if (oc.isPresent())
            return oc.get();
        return null;
    }

    public Page<Content> findBySearch(Search search, Pageable pageable) {
        if (pageable.getSort().isUnsorted()) {
            pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("cid").descending());
        }
        return contentRepository.findAll(new Specification<Content>() {
            @Override
            public Predicate toPredicate(Root<Content> r, CriteriaQuery<?> q, CriteriaBuilder cb) {
                Predicate p = cb.conjunction(); //与关系
                Predicate b = cb.disjunction(); //或关系
                if (search.getKeyword()!=null&&!"".equals(search.getKeyword())) {
                    //用关键字模糊查询，字段包括title和content
                    String kw = "%" + search.getKeyword()+ "%";
                    Predicate a1 = cb.like(r.get("title").as(String.class), kw);
                    Predicate a2 = cb.like(r.get("contents").as(String.class), kw);
                    b.getExpressions().add(a1);
                    b.getExpressions().add(a2);
                }
                if (search.getSdate()!=null) {  //如果开始时间存在就添加开始时间条件
                    Predicate a1 = cb.greaterThanOrEqualTo(r.get("cdate").as(LocalDate.class), search.getSdate());
                    p.getExpressions().add(a1);
                }
                if (search.getEdate()!=null) {  //如果结束时间存在就添加结束时间条件
                    Predicate a1 = cb.lessThanOrEqualTo(r.get("cdate").as(LocalDate.class), search.getEdate());
                    p.getExpressions().add(a1);
                }
                if(b.getExpressions().size()>0) {   //把或关系与与关系合并
                    p.getExpressions().add(b);
                }
                return p;
            }
        }, pageable);
    }
}
