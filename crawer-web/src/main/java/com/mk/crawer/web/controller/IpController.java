package com.mk.crawer.web.controller;

import com.mk.crawer.biz.model.crawer.HotelMapping;
import com.mk.crawer.biz.servcie.IIpService;
import com.mk.crawer.biz.thread.IpProxyThread;
import com.mk.crawer.biz.utils.DocumentUtils;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeashi on 16/3/7.
 */
@Controller
@RequestMapping(value = "/ipproxy")
public class IpController {

    @Autowired
    private IIpService  ipService;

    @RequestMapping(value = "/ipobtain", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> catheIpProxy(HotelMapping record) {
        Map<String, Object> result = new HashMap<String, Object>();
        try{
            this.startCatchBitch();
        }catch (Exception e){
            e.printStackTrace();
        }
        result.put("success","true");

        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }


    @RequestMapping(value = "/startinsert", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertIpProxy(HotelMapping record) {
        Map<String, Object> result = new HashMap<String, Object>();
        try{

            IpProxyThread ipt = new IpProxyThread();
            ipt.start();
            System.out.println("线程启动");
        }catch (Exception e){
            e.printStackTrace();
        }
        result.put("success","true");

        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/checkcanuse", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkIpProxyCanUse() {
        Map<String, Object> result = new HashMap<String, Object>();
        ipService.updateIpProxyStatus();
        result.put("success","true");

        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }


    public  void  startCatchBitch()throws Exception {
        String crawlStorageFolder = "/Users/jeashi/imike/crawl";  //中间数据存储的文件夹
        int numberOfCrawlers = 1;  //并发线程的数目：
        int maxDepthOfCrawling = 1; //设置抓取的深度  0只抓取种子页面
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
//        config.setMaxDepthOfCrawling(maxDepthOfCrawling);

        String resourcePath = this.getClass().getResource("/").getPath()+"resource.xml";
        Document doc = DocumentUtils.load(resourcePath);
        NodeList nodeList = doc.getElementsByTagName("page");
        Node node  = nodeList.item(0);
        Element el  = (Element)node;
        NodeList checkerNodeList  = el.getElementsByTagName("classprocessor");
        int checklen = checkerNodeList.getLength();
        System.out.println("##########抓取ip结开始##########,需要抓取网站数:"+checklen);
        for( int i=0;i<checklen;i++  ){
            try{
                PageFetcher pageFetcher = new PageFetcher(config);
                RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
                RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);

                Element checkerEl  = (Element)checkerNodeList.item(i);
                String  classPath = checkerEl.getAttribute("path");
                String  url = checkerEl.getAttribute("url");
                CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
                controller.addSeed(url);
                Class  cl = Class.forName(classPath);
                controller.start(cl, numberOfCrawlers);
            }catch(Exception e){
                System.out.println("##########抓取ip结出现异常##########,需要抓取网站,异常工具类为第:"+(i+1)+"个");
                e.printStackTrace();
            }finally{
                continue;
            }

        }
        System.out.println("##########抓取ip结束##########");
    }


    public  void   startCatch() throws Exception {
        String crawlStorageFolder = "/Users/jeashi/imike/crawl";  //中间数据存储的文件夹
        int numberOfCrawlers = 1;  //并发线程的数目：
        int maxDepthOfCrawling = 1; //设置抓取的深度  0只抓取种子页面
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
//        config.setMaxDepthOfCrawling(maxDepthOfCrawling);

        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);


        controller.addSeed("http://www.haodailiip.com/guonei/110000/1");
//        controller.addSeed("http://www.yun-daili.com/free.asp");
//        controller.addSeed("http://www.ip84.com/dl");  //抓取的种子（seed）

//        String  classPath = "com.mk.crawer.biz.utils.CrawlerChildren.impl.MyCrawlerIp84";
        String  classPath = "com.mk.crawer.biz.utils.CrawlerChildren.MyCrawlerIpyun";

        Class  cl = Class.forName(classPath);

        controller.start(cl, numberOfCrawlers);
    }

}
