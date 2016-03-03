package com.mk.crawer.web.pod.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by chenqi on 16/3/1.
 */
public class PodController {
    public static void main(String args[]) throws IOException {
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);

        doc = Jsoup.connect("http://en.wikipedia.org/").get();
        Elements newsHeadlines = doc.select("#mp-itn b a");
    }
}
