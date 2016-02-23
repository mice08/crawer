package com.mk.crawer.biz.model.crawer;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * Created by BurizaDo on 2/23/16.
 */
public class MtImage {
    public int id;
    public int poiid;
    public String md5;
    public String typeName;
    public String url;
    public String imgDesc;
    public int typeid;
    public String generateMD5(){
        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
        return md5PasswordEncoder.encodePassword(String.valueOf(poiid) + imgDesc + url, null);
    }
}
