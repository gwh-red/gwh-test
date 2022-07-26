package com.gwh.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

public class ESIndexDemo {

    private static RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));

    public static void main(String[] args) throws IOException {
        //1.创建索引
        //indexCreate();

        //2.查询索引
        //indexSearch();

        //3.删除索引
        indexDelete();


        //关闭链接
        esClient.close();
    }


    /**
     * 3.删除索引
     *
     * @throws IOException
     */
    public static void indexDelete() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("user1");
        AcknowledgedResponse delete = esClient.indices().delete(request, RequestOptions.DEFAULT);

        System.out.println(delete.isAcknowledged());

    }

    /**
     * 2.查询索引
     *
     * @throws IOException
     */
    public static void indexSearch() throws IOException {
        GetIndexRequest request = new GetIndexRequest("user1");
        GetIndexResponse getIndexResponse = esClient.indices().get(request, RequestOptions.DEFAULT);
        System.out.println(getIndexResponse.getAliases());
        System.out.println(getIndexResponse.getMappings());
        System.out.println(getIndexResponse.getSettings());
    }

    /**
     * 1.创建索引
     *
     * @throws IOException
     */
    public static void indexCreate() throws IOException {

        CreateIndexRequest createIndexRequest = new CreateIndexRequest("user1");
        CreateIndexResponse createIndexResponse = esClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse.isAcknowledged());


    }
}
