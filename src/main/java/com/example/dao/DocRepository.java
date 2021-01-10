package com.example.dao;

import com.example.entity.DocBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface DocRepository extends ElasticsearchRepository<DocBean, Long> {

    Page<DocBean> findByContent(String content, Pageable pageable);

    Page<DocBean> findByFirstCode(String firstCode, Pageable pageable);

    Page<DocBean> findBySecordCode(String secordCode, Pageable pageable);

    Page<DocBean> findByTypeBetween(Integer from, Integer to, Pageable pageable);

}
