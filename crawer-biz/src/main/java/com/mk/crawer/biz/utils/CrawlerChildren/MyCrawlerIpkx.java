package com.mk.crawer.biz.utils.CrawlerChildren;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;

import java.util.regex.Pattern;

/**
 * Created by jeashi on 16/3/9.
 */
public class MyCrawlerIpkx extends WebCrawler {

    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg"
            + "|png|mp3|mp3|zip|gz))$");


    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        return !FILTERS.matcher(href).matches()
                && href.startsWith("http://www.kxdaili.com/");

    }


    @Override
    public void visit(Page page) {
        MyCrawlerBase mlb = new MyCrawlerBase("tag", "tbody", 0,1,4,2,3);
        mlb.handlePage(page);
    }
}
