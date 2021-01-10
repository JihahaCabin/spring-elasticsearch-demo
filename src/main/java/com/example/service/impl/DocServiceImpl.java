package com.example.service.impl;

import com.example.dao.DocRepository;
import com.example.entity.DocBean;
import com.example.service.IDocService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service("elasticService")
@Slf4j
public class DocServiceImpl implements IDocService {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;
    @Autowired
    private DocRepository docRepository;

    //默认返回前10条，后续可定制
    private Pageable pageable = PageRequest.of(0, 10);

    @Override
    public void createIndex() {
        elasticsearchTemplate.createIndex(DocBean.class);
    }

    @Override
    public void deleteIndex(String index) {
        elasticsearchTemplate.deleteIndex(index);
    }


    /**
     * 获取映射
     */
    @Override
    public Map<String, Object> getMapping() {
        Map<String, Object> mapping = elasticsearchTemplate.getMapping(DocBean.class);
        return mapping;
    }

    /**
     * 新增或修改数据，当id相同，就会update
     *
     * @param docBean
     */
    @Override
    public void save(DocBean docBean) {
        docRepository.save(docBean);
    }

    @Override
    public void saveAll(List<DocBean> list) {
        docRepository.saveAll(list);
    }


    /**
     * 根据id删除数据
     */
    @Override
    public void deleteById(Long id) {
        docRepository.deleteById(id);
    }

    @Override
    public Iterator<DocBean> findAll() {
        return docRepository.findAll().iterator();
    }

    @Override
    public Page<DocBean> findByContent(String content) {
        return docRepository.findByContent(content, pageable);
    }

    @Override
    public Page<DocBean> findByFirstCode(String firstCode) {
        return docRepository.findByFirstCode(firstCode, pageable);
    }

    @Override
    public Page<DocBean> findBySecordCode(String secordCode) {
        return docRepository.findBySecordCode(secordCode, pageable);
    }

    @Override
    public Page<DocBean> query(String key) {
        return docRepository.findByContent(key, pageable);
    }

    @Override
    public DocBean findById(Long id) {
        Optional<DocBean> byId = docRepository.findById(id);
        DocBean docBean = byId.orElse(null);
        return docBean;
    }

    /**
     * 范围查找type
     *
     * @param from
     * @param to
     * @return
     */
    @Override
    public Page<DocBean> findByTypeBetween(Integer from, Integer to) {
        return docRepository.findByTypeBetween(from, to, pageable);
    }
}

