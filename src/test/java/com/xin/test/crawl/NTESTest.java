package com.xin.test.crawl;

import com.xin.test.entity.News;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class NTESTest {

    private final static String URL = "http://localhost:8983/solr";
    private HttpSolrServer server = null;

    @Before
    public void setUp() throws Exception {
        server = new HttpSolrServer(URL);

    }


    @Test
    public void testCrawl163LatestNews() throws Exception {
        for(News news: NTES.crawl163LatestNews("shehui")){
            System.out.println("----------------------------------------------------------------------------------------------------------");
//			System.out.println(news.getContent());
//			System.out.println(news.getDate());
            System.out.println(news.getShortContent());
//			System.out.println(news.getTitle());
//			System.out.println(news.getUrl());
        }
    }

    @Test
    public void testCrawl163LatestNewsForSolr() throws Exception {
        List<News> newsList = NTES.crawl163LatestNews("world");
        server.addBeans(newsList);
        server.commit();
    }
}