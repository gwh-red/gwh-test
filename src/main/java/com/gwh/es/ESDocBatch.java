package com.gwh.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class ESDocBatch {

    private static RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));

    public static void main(String[] args) throws IOException {

        docInsertBatch();
        //关闭链接
        esClient.close();
    }

    /**
     * 1.批量新增
     */
    public static void docInsertBatch() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();

        bulkRequest.add(new IndexRequest().index("user").id("1007").source(XContentType.JSON, "name", "zhansan2", "age", 40, "sex", "男"));
        bulkRequest.add(new IndexRequest().index("user").id("1008").source(XContentType.JSON, "name", "zhansan33", "age", 30, "sex", "女"));
        bulkRequest.add(new IndexRequest().index("user").id("1009").source(XContentType.JSON, "name", "zhansan232", "age", 20, "sex", "女"));
        bulkRequest.add(new IndexRequest().index("user").id("1010").source(XContentType.JSON, "name", "zhansan1", "age", 40, "sex", "男"));
        bulkRequest.add(new IndexRequest().index("user").id("1011").source(XContentType.JSON, "name", "zhansan5", "age", 50, "sex", "女"));
        bulkRequest.add(new IndexRequest().index("user").id("1012").source(XContentType.JSON, "name", "zhansan6", "age", 60, "sex", "男"));


        BulkResponse bulk = esClient.bulk(bulkRequest, RequestOptions.DEFAULT);

        System.out.println(bulk.getTook());
        System.out.println(bulk.getItems());

    }

    /**
     * 2.批量删除
     */
    public static void docDeleteBatch() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();


        bulkRequest.add(new DeleteRequest().index("user").id("1001"));
        bulkRequest.add(new DeleteRequest().index("user").id("1002"));
        bulkRequest.add(new DeleteRequest().index("user").id("1003"));


        BulkResponse bulk = esClient.bulk(bulkRequest, RequestOptions.DEFAULT);

        System.out.println(bulk.getTook());
        System.out.println(bulk.getItems());

    }
}
