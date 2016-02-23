package com.mk.crawer.biz.model.crawer;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * Created by BurizaDo on 2/23/16.
 */
public class MtHotelService {
    public int id;
    public String md5;
    public int poiId;
    public int attrId;
    public String attrDesc;
    public String attrDetail;
    public String imgUrl;
    public String poiDesc;
    public String poiExtendsInfos;
    public String generateMD5(){
        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
        return md5PasswordEncoder.encodePassword(String.valueOf(poiId) + String.valueOf(attrId) + attrDesc, null);
    }
}
