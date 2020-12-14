package com.zk.springboot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zk.springboot.pojo.Person;
import com.zk.springboot.pojo.Student;
import org.apache.lucene.search.highlight.Highlighter;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSpringBoot {
    @Autowired
    Person person;

    @Autowired
    DataSource dataSource;

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Test
    public void test1() {
        System.out.println(person.getName());
        System.out.println(person);
    }

    @Test
    public void test2() throws SQLException {
        Class<? extends DataSource> aClass = dataSource.getClass();
        Connection connection = dataSource.getConnection();
        System.out.println(aClass);
        System.out.println(connection);
    }


    /**
     * 创建索引
     *
     * @throws SQLException
     * @throws IOException
     */
    @Test
    public void test3() throws SQLException, IOException {
        CreateIndexRequest cirq = new CreateIndexRequest("zk_index");
        CreateIndexResponse cirp = restHighLevelClient.indices().create(cirq, RequestOptions.DEFAULT);
        System.out.println(cirp);
    }

    /**
     * 获取索引
     *
     * @throws SQLException
     * @throws IOException
     */
    @Test
    public void test4() throws SQLException, IOException {
        GetIndexRequest cirq = new GetIndexRequest("zk_index");
        boolean exists = restHighLevelClient.indices().exists(cirq, RequestOptions.DEFAULT);

        System.out.println(exists);
    }

    /**
     * 删除索引
     *
     * @throws SQLException
     * @throws IOException
     */
    @Test
    public void test5() throws SQLException, IOException {
        DeleteIndexRequest cirq = new DeleteIndexRequest("zk_index");
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(cirq, RequestOptions.DEFAULT);
        System.out.println(delete.isAcknowledged());
    }

    /**
     * 创建文档
     *
     * @throws SQLException
     * @throws IOException
     */
    @Test
    public void test6() throws SQLException, IOException {
        IndexRequest request = new IndexRequest("zk_index_2");
        request.id("10");
        request.timeout(TimeValue.timeValueSeconds(1));

        Student s = new Student();
        s.setId(12);
        s.setName("王五");
        ObjectMapper mapper = new ObjectMapper();
        String s1 = mapper.writeValueAsString(s);
        request.source(s1, XContentType.JSON);
        IndexResponse index = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        System.out.println(index.toString());
        System.out.println(index.status());
    }

    /**
     *
     */
    /**
     * 获取文档
     *
     * @throws SQLException
     * @throws IOException
     */
    @Test
    public void test7() throws Exception {
        GetRequest request = new GetRequest("zk_index_2", "2");

        GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        System.out.println(response.getSource());
        boolean exists = restHighLevelClient.exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    /**
     * 更新文档
     *
     * @throws SQLException
     * @throws IOException
     */
    @Test
    public void test8() throws Exception {
        UpdateRequest request = new UpdateRequest("zk_index_2", "10");
        request.timeout(TimeValue.timeValueSeconds(1));
        Student s = new Student();
        s.setId(666);
        s.setName("王五二");
        ObjectMapper mapper = new ObjectMapper();
        String s1 = mapper.writeValueAsString(s);
        request.doc(s1, XContentType.JSON);
        UpdateResponse update = restHighLevelClient.update(request, RequestOptions.DEFAULT);
        System.out.println(update.toString());
    }


    /**
     * 删除文档
     *
     * @throws SQLException
     * @throws IOException
     */
    @Test
    public void test9() throws Exception {
        DeleteRequest request = new DeleteRequest("zk_index_2", "10");

        DeleteResponse delete = restHighLevelClient.delete(request, RequestOptions.DEFAULT);
        System.out.println(delete.toString());
    }


    /**
     * 批量插入
     *
     * @throws SQLException
     * @throws IOException
     */
    @Test
    public void test10() throws Exception {
        BulkRequest request = new BulkRequest();

        ArrayList<Student> list = new ArrayList();
        list.add(new Student(1, "张三"));
        list.add(new Student(2, "wangwu"));
        list.add(new Student(3, "zhaoliu"));
        list.add(new Student(4, "fangqi"));
        list.add(new Student(5, "liuming"));
        ObjectMapper mapper = new ObjectMapper();
        for (int i = 0; i < list.size(); i++) {
            request.add(new IndexRequest("zk_index_2").id(i + "").source(mapper.writeValueAsString(list.get(i)).toString(), XContentType.JSON));
        }
        BulkResponse bulk = restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
        System.out.println(bulk.hasFailures());

    }

    //查询文档
    @Test
    public void test11() throws Exception {
        SearchRequest request = new SearchRequest("zk_index_2");
        //构建搜索条件
        SearchSourceBuilder ssb = new SearchSourceBuilder();

        //构建查询条件
        TermQueryBuilder matchQueryBuilder = QueryBuilders.termQuery("name.keyword", "张三");
        ssb.query(matchQueryBuilder);
        ssb.timeout(TimeValue.timeValueSeconds(60));
        //设置高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("name.keyword");
        highlightBuilder.requireFieldMatch(false);
        highlightBuilder.preTags("<span style='color:red'>");
        highlightBuilder.postTags("</span>");
        ssb.highlighter(highlightBuilder);

        //执行搜索
        request.source(ssb);
        SearchResponse search = restHighLevelClient.search(request, RequestOptions.DEFAULT);

        ArrayList<Map<String, Object>> list = new ArrayList<>();
        for (SearchHit hit : search.getHits().getHits()) {

            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField highlightField = highlightFields.get("name.keyword");
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();

            if (highlightField != null) {
                Text[] fragments = highlightField.getFragments();
                String temp_name = "";
                for (Text fragment : fragments) {
                    temp_name += fragment;
                }
                sourceAsMap.put("name.keyword", temp_name);
            }

            list.add(sourceAsMap);

        }

        System.out.println(list);

    }


}
