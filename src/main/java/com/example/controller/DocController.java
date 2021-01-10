package com.example.controller;

import com.example.entity.DocBean;
import com.example.service.IDocService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/doc")
@Api(tags = "Doc通用查找")
public class DocController {

    @Autowired
    private IDocService docService;

    @GetMapping("/init")
    @ApiOperation(value = "初始化数据")
    public void init() {
        List<DocBean> list = new ArrayList<>();

        list.add(new DocBean(1L, "XX0193", "XX8064", "我是中国人", 1));
        list.add(new DocBean(2L, "XX0210", "XX7475", "在中国里每个人都安居乐业", 1));
        list.add(new DocBean(3L, "XX0257", "XX8097", "社会中诚信是个很重要的东西", 2));
        docService.saveAll(list);

    }

    @GetMapping("/all")
    @ApiOperation(value = "查询所有数据")
    public Iterator<DocBean> all() {
        return docService.findAll();
    }

    @GetMapping("/findById")
    @ApiOperation(value = "根据ID查找")
    public DocBean findById(@RequestParam(value = "id") Long id) {
        return docService.findById(id);
    }

    @GetMapping("/findByContent")
    @ApiOperation(value = "根据关键词模糊查找content")
    public Page<DocBean> findByContent(@RequestParam(value = "sSearch") String sSearch) {
        return docService.findByContent(sSearch);
    }

    @GetMapping("/findByFirstCode")
    @ApiOperation(value = "精确查找FirstCode")
    public Page<DocBean> findByFirstCode(@RequestParam(value = "firstCode") String firstCode) {
        return docService.findByFirstCode(firstCode);
    }


    @GetMapping("/findByTypeBetween")
    @ApiOperation(value = "范围查找type")
    public Page<DocBean> findByTypeBetween(@RequestParam(value = "from") Integer from, @RequestParam(value = "to") Integer to) {
        return docService.findByTypeBetween(from, to);
    }


    @PostMapping("/addDoc")
    @ApiOperation(value = "新增或修改数据，当id相同，就会update")
    public void addDoc(@RequestBody DocBean docBean) {
        docService.save(docBean);
    }

    @DeleteMapping("/delete")
    public void deleteDoc(@RequestParam Long id) {
        docService.deleteById(id);
    }

}


