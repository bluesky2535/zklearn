package com.zk.springboot.utils;

import org.elasticsearch.common.unit.TimeValue;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;

public class HtmlUtil {

    public static void main(String[] args) throws Exception {
        String url="https://search.jd.com/Search?keyword=学习";
        Document document= Jsoup.parse(new URL(url),30000);
        System.out.println(document.toString());
        Element j_goodsList = document.getElementById("J_goodsList");
        Elements li = j_goodsList.getElementsByTag("li");
        for (Element element : li) {
            String attr = element.getElementsByTag("img").eq(0).attr("src");
            String price = element.getElementsByClass("p-price").eq(0).text();
            String title = element.getElementsByClass("p-name").eq(0).text();

            System.out.println(attr+price+title);        }


    }






}
