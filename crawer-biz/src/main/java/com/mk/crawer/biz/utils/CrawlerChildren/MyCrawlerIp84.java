package com.mk.crawer.biz.utils.CrawlerChildren;

import com.alibaba.fastjson.JSONArray;
import com.mk.crawer.biz.model.crawer.IpProxy;
import com.mk.crawer.biz.servcie.impl.IpServiceImpl;
import com.mk.framework.AppUtils;
import com.mk.framework.MkJedisConnectionFactory;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by jeashi on 16/3/9.
 */
public class MyCrawlerIp84 extends WebCrawler{

    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg"
            + "|png|mp3|mp3|zip|gz))$");
    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        return !FILTERS.matcher(href).matches()
                && href.startsWith("http://www.ip84.com/dl");

    }


    @Override
    public void visit(Page page) {
        MyCrawlerBase  mlb =  new  MyCrawlerBase("class","list",0,1,2,3,4);
        mlb.handlePage(page);
        /*
        String url = page.getWebURL().getURL();
        System.out.println("URL: " + url);

        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String text = htmlParseData.getText();
            String html = htmlParseData.getHtml();
            Set<WebURL> links = htmlParseData.getOutgoingUrls();

            Document doc = Jsoup.parse(html);

            Elements tableElement = doc.getElementsByClass("list");
            Elements  trElement = tableElement.get(0).getElementsByTag("tr");

            List<IpProxy> ipProxyList = new ArrayList<IpProxy>();
            for(int i=1;i<trElement.size();i++){
                Elements  tdElement = trElement.get(i).getElementsByTag("td");
                IpProxy ip = getIpProxy(tdElement);
                if(null==ip){
                    continue;
                }else{
                    ipProxyList.add(ip);
                }
            }
            if(!CollectionUtils.isEmpty(ipProxyList)){
                try{
                    IpServiceImpl ipServiceImpl = AppUtils.getBean(IpServiceImpl.class);
                    int  res =  ipServiceImpl.addIpProxyBatch(ipProxyList);
                    System.out.println("执行结束,影响行数:"+res);
                }catch (Exception exc){
                    exc.printStackTrace();
                }
            }

        }
         */
    }

    /*
    public    IpProxy   getIpProxy(Elements  tdElement ){
        if(null==tdElement){
            return null;
        }
        String  ipAddress = tdElement.get(0).text();
        String  port = tdElement.get(1).text();
        String  proxyAddress = tdElement.get(2).text();
        String  note = tdElement.get(3).text();
        String  type = tdElement.get(4).text();  //1:http;2:https
        IpProxy  ipProxy = new  IpProxy();
        ipProxy.setIpAddress(ipAddress);
        ipProxy.setPort(port);
        ipProxy.setProxyAddress(proxyAddress);
        ipProxy.setNote(note);
        ipProxy.setType(type);
        ipProxy.setCreateTime(new Date());
        ipProxy.setCheckStatus("1"); //设置校检状态为初始化
        ipProxy.setIsVaild("T");
        return  ipProxy;
    }

    public  void  addRedisGroup(List<IpProxy>   ipProxyList){
        if(null==ipProxyList){
            return ;
        }
        MkJedisConnectionFactory jedisFactory = AppUtils.getBean(MkJedisConnectionFactory.class);
        Jedis jedis = null;
        try{
            jedis =  jedisFactory.getJedis();
            jedis.lpush("IPPROXYLIST", JSONArray.toJSONString(ipProxyList));
        }catch (Exception e) {
            System.out.println("写入redis失败");
            e.printStackTrace();
        }finally {
            if(null!=jedis){
                jedis.close();
            }
        }
    }
    */
}
