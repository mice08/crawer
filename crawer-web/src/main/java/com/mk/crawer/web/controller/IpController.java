package com.mk.crawer.web.controller;

import com.mk.crawer.biz.model.crawer.HotelMapping;
import com.mk.crawer.biz.utils.MyCrawler;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeashi on 16/3/7.
 */
@Controller
@RequestMapping(value = "/ipproxy")
public class IpController {

    @RequestMapping(value = "/ipobtain", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> catheOtaPrice(HotelMapping record) {
        Map<String, Object> result = new HashMap<String, Object>();
        try{
            this.startCatch();
        }catch (Exception e){
            e.printStackTrace();
        }
        result.put("success","true");

        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }

    public static void main(String[] args) throws Exception {
//        String crawlStorageFolder = "/Users/jeashi/imike/crawl";
//        int numberOfCrawlers = 7;
//
//        CrawlConfig config = new CrawlConfig();
//        config.setCrawlStorageFolder(crawlStorageFolder);
//
//
//        PageFetcher pageFetcher = new PageFetcher(config);
//        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
//        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
//        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
//
//
////        controller.addSeed("http://www.yun-daili.com/free.asp");
//         controller.addSeed("http://www.ip84.com/dl");
//
//
//        controller.start(MyCrawler.class, numberOfCrawlers);
    }

    public  void   startCatch() throws Exception {
        String crawlStorageFolder = "/Users/jeashi/imike/crawl";
        int numberOfCrawlers = 7;

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);


        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);


//        controller.addSeed("http://www.yun-daili.com/free.asp");
        controller.addSeed("http://www.ip84.com/dl");


        controller.start(MyCrawler.class, numberOfCrawlers);
    }

}
