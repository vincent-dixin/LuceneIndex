package com.xin.test.entity;


import org.apache.solr.client.solrj.beans.Field;

/**
 * 新闻
 * @author Thinking
 */
public class News {

    @Field
    private String id;
	@Field("news_title")
	private String title;
    @Field("news_shortcontent")
	private String shortContent;
    @Field("news_content")
	private String content;
    @Field("news_url")
	private String url;
    @Field("news_date")
	private String date;
	private String other1;
	private String other2;
	private String other3;

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
	public String getShortContent() {
		return shortContent;
	}
	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOther1() {
		return other1;
	}
	public void setOther1(String other1) {
		this.other1 = other1;
	}
	public String getOther2() {
		return other2;
	}
	public void setOther2(String other2) {
		this.other2 = other2;
	}
	public String getOther3() {
		return other3;
	}
	public void setOther3(String other3) {
		this.other3 = other3;
	}
	
	
}
