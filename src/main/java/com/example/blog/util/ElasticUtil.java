package com.example.blog.util;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.HitsMetadata;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import co.elastic.clients.elasticsearch.indices.DeleteIndexResponse;
import co.elastic.clients.elasticsearch.indices.GetIndexResponse;
import com.example.blog.entity.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ElasticUtil {

    @Resource
    ElasticsearchClient elasticsearchClient;

//    public void create(String indexName) throws IOException {
//        CreateIndexResponse createIndexResponse = elasticsearchClient.indices().create(c -> c.index(indexName));
//        Boolean acknowledged = createIndexResponse.acknowledged();
//        System.out.println("索引操作 = " + acknowledged);
//
//    }
//
//    public void search(String indexName) throws IOException {
//        GetIndexResponse getIndexResponse = elasticsearchClient.indices().get(e -> e.index(indexName));
//        System.out.println("getIndexResponse.result() = " + getIndexResponse.result());
//        System.out.println("getIndexResponse.result().keySet() = " + getIndexResponse.result().keySet());
//    }
//
//    public void delete(String indexName) throws IOException {
//        DeleteIndexResponse deleteIndexResponse = elasticsearchClient.indices().delete(e -> e.index(indexName));
//        System.out.println("删除操作 = " + deleteIndexResponse.acknowledged());
//    }
//
//    public void insertDoc(User user) throws IOException {
//        CreateResponse createResponse = elasticsearchClient.create(e -> e.index("user_db").id(String.valueOf(user.getId())).document(user));
//        System.out.println("createResponse.result() = " + createResponse.result());
//    }
//
//    public void getDoc(int userid) throws IOException {
//        GetResponse<User> getResponse = elasticsearchClient.get(e -> e.index("user_db").id(String.valueOf(userid)), User.class);
//        System.out.println("getResponse.source().toString() = " + getResponse.source().toString());
//    }
//
//    public void updateDoc(int userid) throws IOException {
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "java客户端aaa");
//        // 构建请求
//        UpdateResponse<User> updateResponse = elasticsearchClient.update(e -> e.index("user_db").id(String.valueOf(userid)).doc(map), User.class);
//        System.out.println("updateResponse.result() = " + updateResponse.result());
//
//    }
//
//    public void deleteDoc(int userid) throws IOException {
//        DeleteResponse deleteResponse = elasticsearchClient.delete(e -> e.index("user_db").id(String.valueOf(userid)));
//        System.out.println("deleteResponse.result() = " + deleteResponse.result());
//    }
//
//    public void batchAddDoc() throws IOException {
//        List<BulkOperation> list = new ArrayList<>();
//        list.add(new BulkOperation.Builder().create(
//                d -> d.document(new User(2, "男", "19")).id("2").index("user_db")).build());
//        list.add(new BulkOperation.Builder().create(
//                d -> d.document(new User(3, "男", "20")).id("3").index("user_db")).build());
//        list.add(new BulkOperation.Builder().create(
//                d -> d.document(new User(4, "女", "21")).id("4").index("user_db")).build());
//        // 调用bulk方法执行批量插入操作
//        BulkResponse bulkResponse = elasticsearchClient.bulk(e -> e.index("user_db").operations(list));
//        System.out.println("bulkResponse.items() = " + bulkResponse.items());
//    }
//
//    public void queryAllDoc() throws IOException {
//        SearchResponse<User> searchResponse = elasticsearchClient.search(e -> e.index("user_db").query(q -> q.matchAll(m -> m)), User.class);
//        HitsMetadata<User> hits = searchResponse.hits();
//        for (Hit<User> hit : hits.hits()) {
//            User u = hit.source();
//            System.out.println(u);
//        }
//        System.out.println("searchResponse.hits().total().value() = " + searchResponse.hits().total().value());
//    }
//
//    public void fuzzQueryDoc() throws IOException {
//        // 模糊查询，fuzziness表示差几个可以查询出来
//        SearchResponse<User> searchResponse = elasticsearchClient.search(s -> s.index("user_db").query(q -> q
//                        .fuzzy(f -> f.field("password").value("20").fuzziness("1")))
//                , User.class);
//        searchResponse.hits().hits().forEach(h -> System.out.println(h.source().toString()));
//    }
//
//    public void highlightQuery() throws IOException {
//        SearchResponse<User> searchResponse = elasticsearchClient.search(s -> s.index("user_db").query(q -> q
//                                .term(t -> t.field("name").value("女")))
//                        .highlight(h -> h.fields("name", f -> f.preTags("<font color='red'>").postTags("</font>")))
//                , User.class);
//        searchResponse.hits().hits().forEach(h -> System.out.println(h.source().toString()));
//    }
}
