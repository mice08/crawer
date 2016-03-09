package com.mk.crawer.biz.utils;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by jeashi on 16/3/9.
 */
public class DocumentUtils {
    public static Document load(String path){
        try {
            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            File file=new File(path);
            Document document = builder.parse(file);
            return document;
        }
        catch (Exception e) {

            e.printStackTrace();
            throw new RuntimeException("load ["+path+"]    error" );
        }
    }


}
