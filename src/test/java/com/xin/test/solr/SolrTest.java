package com.xin.test.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vincent on 2014/6/10.
 */
public class SolrTest {

    private final static String URL = "http://localhost:8983/solr";
    private HttpSolrServer server = null;

    @Before
    public void setUp() throws Exception {
        server = new HttpSolrServer(URL);

    }

    @Test
    public void testSimple() {
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id","1");
        doc.addField("title","这是我的第一个solrj程序");
        try {
            server.add(doc);
            server.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJavaBean() throws Exception {
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("2","走出软件作坊","三五个人十来条枪*如何成为开发正规军"));
        bookList.add(new Book("3","Java 编程思想","学习Java的第一本书"));
        bookList.add(new Book("4","NodeJS指南","好书！写的非常详细。"));
        server.addBeans(bookList);
        server.commit();

    }

    @Test
    public void testQuery() throws Exception {
        SolrQuery query = new SolrQuery("*:*");
        QueryResponse qrp = server.query(query);
        SolrDocumentList sdl = qrp.getResults();
        System.out.println(sdl.getNumFound());
        for (SolrDocument solrDocument : sdl) {
            System.out.println(solrDocument);
            System.out.println(solrDocument.get("book_title"));
            System.out.println(solrDocument.get("book_title"));
        }
    }

    @Test
    public void testHighlight() throws Exception {
        SolrQuery query = new SolrQuery("book_content:第一");
        query.setHighlight(true).setHighlightSimplePre("<span class='highligter'>")
                .setHighlightSimplePost("</span>");
        query.setParam("hl.fl","book_title","book_content");
        QueryResponse qrp = server.query(query);
        SolrDocumentList sdl = qrp.getResults();
        System.out.println(sdl.getNumFound());
        for (SolrDocument solrDocument : sdl) {
            String id = (String)solrDocument.get("id");
            if(qrp.getHighlighting().get(id) != null) {
                System.out.println(qrp.getHighlighting().get(id).get("book_title"));
                System.out.println(qrp.getHighlighting().get(id).get("book_content"));
            }

        }

    }
}
