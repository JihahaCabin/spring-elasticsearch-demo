package com.example.service;

import com.example.entity.DocBean;
import org.springframework.data.domain.Page;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public interface IDocService {

    /**
     * 创建索引和映射
     */
    void createIndex();

    /**
     * 删除索引
     *
     * @param index
     */
    void deleteIndex(String index);

    /**
     * 查询映射
     *
     * @return
     */
    Map<String, Object> getMapping();

    /**
     * 新增或修改数据，当id相同，就会update
     *
     * @param docBean
     */
    void save(DocBean docBean);

    /**
     * 批量新增
     *
     * @param list
     */
    void saveAll(List<DocBean> list);

    /**
     * 查询所有数据
     *
     * @return
     */
    Iterator<DocBean> findAll();

    /**
     * 根据ID删除数据
     */
    void deleteById(Long id);


    Page<DocBean> findByContent(String content);

    Page<DocBean> findByFirstCode(String firstCode);

    Page<DocBean> findBySecordCode(String secordCode);

    Page<DocBean> query(String key);

    /**
     * 根据ID查找
     *
     * @param id
     * @return
     */
    DocBean findById(Long id);

    /**
     * 范围查找type
     *
     * @param from
     * @param to
     * @return
     */
    Page<DocBean> findByTypeBetween(Integer from, Integer to);
}

