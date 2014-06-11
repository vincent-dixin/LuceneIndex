package com.xin.test.solr;

import org.apache.solr.client.solrj.beans.Field;

/**
 * Created by vincent on 2014/6/10.
 */
public class Book {

    @Field
    private String id;

    @Field("book_title")
    private String title;

    @Field("book_content")
    private String content;

    public Book(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
