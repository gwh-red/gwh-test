package com.gwh.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gwh.entity.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class ESDocDemo {

    private static RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));

    public static void main(String[] args) throws IOException {

        docGet();
        //关闭链接
        esClient.close();
    }

    /**
     * 1.插入数据
     *
     * @throws IOException
     */
    public static void docInsert() throws IOException {
        //获取插入数据的对象
        IndexRequest request = new IndexRequest();
        //设置 索引 数据id
        request.index("user").id("1001");

        User user = new User();
        user.setName("zhansan");
        user.setAge(20);
        user.setSex("N");

        ObjectMapper mappers = new ObjectMapper();
        String userJson = mappers.writeValueAsString(user);
        // 向ES插入数据需要转换成Json
        request.source(userJson, XContentType.JSON);

        IndexResponse response = esClient.index(request, RequestOptions.DEFAULT);

        System.out.println(response.getResult());


    }

    /**
     * 2.修改数据
     *
     * @throws IOException
     */
    public static void docUpdate() throws IOException {
        UpdateRequest request = new UpdateRequest();
        request.index("user").id("1001");
        request.doc(XContentType.JSON, "sex", "男");

        UpdateResponse response = esClient.update(request, RequestOptions.DEFAULT);

        System.out.println(response.getResult());

    }

    /**
     * 3.查询数据
     *
     * @throws IOException
     */
    public static void docGet() throws IOException {
        GetRequest request = new GetRequest();
        request.index("user").id("1001");
        GetResponse response = esClient.get(request, RequestOptions.DEFAULT);
        System.out.println(response.getSourceAsString());
    }

    /**
     * 4.删除数据
     *
     * @throws IOException
     */
    public static void docDelete() throws IOException {

        DeleteRequest createIndexRequest = new DeleteRequest();
        createIndexRequest.index("user").id("1001");
        DeleteResponse delete = esClient.delete(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(delete.getResult());


    }
}
