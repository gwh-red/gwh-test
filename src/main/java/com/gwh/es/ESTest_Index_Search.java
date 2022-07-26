package com.gwh.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

public class ESTest_Index_Search {

    public static void main(String[] args) throws IOException {
        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );
        //查询索引
        GetIndexRequest request = new GetIndexRequest("user");
        GetIndexResponse createIndexResponse = esClient.indices().get(request, RequestOptions.DEFAULT);


        System.out.println(createIndexResponse.getAliases());
        System.out.println(createIndexResponse.getMappings());
        System.out.println(createIndexResponse.getSettings());

        //关闭客户端
        esClient.close();

    }
}
