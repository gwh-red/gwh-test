package com.gwh.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;

public class ESDocQuery {

    private static RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));

    public static void main(String[] args) throws IOException {

        SearchRequest searchRequest = new SearchRequest();
        //SearchSourceBuilder条件构造器
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();


        searchSourceBuilder.query(QueryBuilders.fuzzyQuery("name", "zhansan").fuzziness(Fuzziness.ONE));

        searchRequest.indices("user").source(searchSourceBuilder);


        SearchResponse search = esClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = search.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(search.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
        esClient.close();

        //7.范围查询
//        SearchRequest searchRequest = new SearchRequest();
//        //SearchSourceBuilder条件构造器
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
//
//        rangeQuery.gte(30);
//        rangeQuery.lte(50);
//
//        searchSourceBuilder.query(rangeQuery);
//
//        searchRequest.indices("user").source(searchSourceBuilder);

        //6.匹配查询
//        SearchRequest searchRequest = new SearchRequest();
//
//        //SearchSourceBuilder条件构造器
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        // must =  mustNot!=
//        //boolQueryBuilder.must(QueryBuilders.matchQuery("age", 30));
//        //boolQueryBuilder.must(QueryBuilders.matchQuery("sex", "男"));
//        //boolQueryBuilder.mustNot(QueryBuilders.matchQuery("sex", "男"));
//        //boolQueryBuilder.should(QueryBuilders.matchQuery("age", 30));
//        //boolQueryBuilder.should(QueryBuilders.matchQuery("age", 40));
//
//
//        searchSourceBuilder.query(boolQueryBuilder);
//
//        searchRequest.indices("user").source(searchSourceBuilder);


        //5.字段排除或只要什么字段
//        SearchRequest searchRequest = new SearchRequest();
//        //SearchSourceBuilder条件构造器
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//
//        String[] excludes = {"age"};//排除
//        String[] includes = {};//要什么字段
//        searchSourceBuilder.fetchSource(includes, excludes);
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
//        searchRequest.indices("user").source(searchSourceBuilder);


        //4.排序
//       SearchRequest searchRequest = new SearchRequest();
//        //SearchSourceBuilder条件构造器
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.sort("age", SortOrder.DESC);
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
//        searchRequest.indices("user").source(searchSourceBuilder);

        //3.分页
//        SearchRequest searchRequest = new SearchRequest();
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//
//        searchSourceBuilder.from(0);
//        searchSourceBuilder.size(2);
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
//        searchRequest.indices("user").source(searchSourceBuilder);


        //1.查询索引中全部数据
//      SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user").source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));


        //2.条件查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user").source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age",30)));

    }

    /**
     * 1.查询全部
     */
    public static void docQuery() throws IOException {

        //查询索引中全部数据
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user").source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));

        SearchResponse search = esClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = search.getHits();

        System.out.println(hits.getTotalHits());
        System.out.println(search.getTook());

        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }


    }

    /**
     * 2.条件查询
     */
    public static void docTermQuery() throws IOException {
        //查询索引中全部数据
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user").source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age", 30)));

        SearchResponse search = esClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = search.getHits();

        System.out.println(hits.getTotalHits());
        System.out.println(search.getTook());

        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
    }
}
