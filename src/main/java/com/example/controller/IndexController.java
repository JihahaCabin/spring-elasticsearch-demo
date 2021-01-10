package com.example.controller;

import com.example.service.IDocService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/index")
@Api(tags = "索引和映射")
public class IndexController {

    @Autowired
    private IDocService elasticService;

    @GetMapping("/create")
    public void createIndex() {
        elasticService.createIndex();
    }

    @DeleteMapping("/delete")
    public void deleteIndex(@RequestParam String indexName) {
        elasticService.deleteIndex(indexName);
    }

    @GetMapping("/getMapping")
    public Map<String, Object> getMapping() {
        return elasticService.getMapping();
    }
}
