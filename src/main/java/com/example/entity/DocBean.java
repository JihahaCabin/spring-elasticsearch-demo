package com.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@Accessors(chain = true)
/**
 * 加上了@Document注解之后，默认情况下这个实体中所有的属性都会被建立索引、并且分词。
 * indexName索引名称 限定小写
 * shards = 5 默认分区数
 * replicas = 1 每个分区默认的备份数
 * refreshInterval = “1s” 刷新间隔
 * indexStoreType = “fs” 索引文件存储类型
 */
@Document(indexName = "ems", shards = 1, replicas = 0)
public class DocBean {

    //Id注解Elasticsearch里相应于该列就是主键，查询时可以使用主键查询
    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private String firstCode;

    @Field(type = FieldType.Keyword)
    private String secordCode;

    @Field(type = FieldType.Text)
    private String content;

    @Field(type = FieldType.Integer)
    private Integer type;

    public DocBean(Long id, String firstCode, String secordCode, String content, Integer type) {
        this.id = id;
        this.firstCode = firstCode;
        this.secordCode = secordCode;
        this.content = content;
        this.type = type;
    }
}

