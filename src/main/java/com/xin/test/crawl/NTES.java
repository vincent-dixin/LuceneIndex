package com.xin.test.crawl;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import com.xin.test.entity.News;


public class NTES {
	
	public static List<News> crawl163LatestNews(String category) throws IOException, ParseException{
		
		Whitelist.simpleText();
		//加载文档
		Document doc=Jsoup.connect("http://news.163.com/"+category+"/").get();
		//获取头条新闻
		Elements es=doc.getElementsByAttributeValueContaining("class", "item-top");
		List<News> list=new ArrayList<News>();
		News news=null;
		
		for(Element element:es){
			news=new News();
            news.setId(UUID.randomUUID().toString());
			news.setTitle(element.getElementsByTag("a").text());
			news.setUrl(element.getElementsByTag("a").attr("href"));
			news.setDate(element.getElementsByTag("span").text());
			news.setShortContent(element.getElementsByTag("p").text());
			doc=Jsoup.connect(element.getElementsByTag("a").attr("href")).get();
			//移除广告标签
			doc.getElementsByAttributeValue("class", "gg200x300").remove();
			if(null!=doc.getElementById("endText")){
				news.setContent(doc.getElementById("endText").children().toString());
			}else{
				news.setContent("链接无法访问");
			}
			list.add(news);
		}
		return list;
		
	}
	
}
