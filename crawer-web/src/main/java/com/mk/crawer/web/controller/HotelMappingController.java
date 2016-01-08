package com.mk.crawer.web.controller;

import com.mk.crawer.biz.model.crawer.HotelMapping;
import com.mk.crawer.biz.servcie.IHotelMappingBusinessService;
import com.mk.crawer.biz.servcie.impl.TCityListBusinessServiceImpl;
import com.mk.framework.UrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jeashi on 2016/1/6.
 */

@Controller
@RequestMapping(value = "/hotelmapping", produces = MediaType.APPLICATION_JSON_VALUE)

public class HotelMappingController {

    @Autowired
    private IHotelMappingBusinessService hotelMappingBusinessService;

        @RequestMapping(value = "/add")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> addHotelMapping(HttpServletRequest request) {
        HashMap hm = new HashMap();
        boolean  success = true;
        String result = "";
        String code ="1";


        String  otsHotelId = request.getParameter("otsHotelId");
        if(StringUtils.isEmpty(otsHotelId)){
            success = false;
            code = "-2";
            result = "otsHotelId不能为空";
            return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String  otsHotelName  = request.getParameter("otsHotelName");
        String  exHotelId  = request.getParameter("exHotelId");

        if(StringUtil.isEmpty(exHotelId)){
            success = false;
            code = "-2";
            result = "exHotelId不能为空";
            return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        String  exHotelName  = request.getParameter("exHotelName");

        HotelMapping  hotelMapping = new HotelMapping();
        hotelMapping.setOtsHotelId(Long.parseLong(otsHotelId));
        hotelMapping.setOtsHotelName(otsHotelName);
        hotelMapping.setExHotelId(Long.parseLong(exHotelId));
        hotelMapping.setExHotelName(exHotelName);
        hotelMapping.setValid("T");

        hotelMappingBusinessService.insert(hotelMapping);

        success = true;
        result = "操作成功";
        code ="1";

        hm.put("success",success);
        hm.put("result",result);
        hm.put("code",code);

        return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.OK);
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> updateHotelMapping(HttpServletRequest request) {
        HashMap hm = new HashMap();
        boolean  success = true;
        String result = "";
        String code ="1";

        String  id = request.getParameter("id");

        if(StringUtils.isEmpty(id)){
            success = false;
            code = "-2";
            result = "id不能为空";
            return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String  otsHotelId = request.getParameter("otsHotelId");
        String  otsHotelName  = request.getParameter("otsHotelName");
        String  exHotelId  = request.getParameter("exHotelId");
        String  exHotelName  = request.getParameter("exHotelName");

        boolean bl = false;

        HotelMapping  hotelMapping = new HotelMapping();
        hotelMapping.setId(Long.parseLong(id));
        if(StringUtil.isNotEmpty(otsHotelId)){
            hotelMapping.setOtsHotelId(Long.parseLong(otsHotelId));
            bl = true;
        }
        if(StringUtil.isNotEmpty(otsHotelName)){
            hotelMapping.setOtsHotelName(otsHotelName);
            bl = true;
        }
        if(StringUtil.isNotEmpty(otsHotelName)){
            hotelMapping.setExHotelId(Long.parseLong(exHotelId));
            bl = true;
        }
        if(StringUtil.isNotEmpty(otsHotelName)){
            hotelMapping.setExHotelName(exHotelName);
            bl = true;
        }
        try {
            if(bl){
                hotelMappingBusinessService.update(hotelMapping);
                success = true;
                result = "操作成功";
                code ="1";
            }else{
                success = false;
                result = "请输入正确的参数";
                code ="-3";
                return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            e.printStackTrace();
            success = false;
            result = "操作失败";
            code ="-3";
            return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.BAD_REQUEST);

        }finally{
            hm.put("success",success);
            hm.put("result",result);
            hm.put("code",code);

            return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> deleteHotelMapping(HttpServletRequest request) {
        HashMap hm = new HashMap();
        boolean  success = true;
        String result = "";
        String code ="1";

        String  id = request.getParameter("id");

        if(StringUtils.isEmpty(id)){
            success = false;
            code = "-2";
            result = "id不能为空";
            return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try {
            hotelMappingBusinessService.deleteByPrimaryKey(Long.parseLong(id));
            success = true;
            result = "操作成功";
            code ="1";
        }catch (Exception e){
            e.printStackTrace();
            success = false;
            result = "操作失败";
            code ="-3";
        }finally{

            hm.put("success",success);
            hm.put("result",result);
            hm.put("code",code);
            return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/query")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> queryHotelMapping(HttpServletRequest request) {
        HashMap hm = new HashMap();
        boolean  success = true;
        String result = "";
        String code ="1";

        String  id = request.getParameter("id");
        String  otsHotelId = request.getParameter("otsHotelId");
        String  otsHotelName  = request.getParameter("otsHotelName");
        String  exHotelId  = request.getParameter("exHotelId");
        String  exHotelName  = request.getParameter("exHotelName");

        HashMap  parme = new HashMap();

        if(StringUtil.isNotEmpty(id)){
            parme.put("id", id);
        }
        if(StringUtil.isNotEmpty(otsHotelId)){
            parme.put("otsHotelId", otsHotelId);
        }
        if(StringUtil.isNotEmpty(otsHotelName)){
            parme.put("otsHotelName", otsHotelName);
        }

        if(StringUtil.isNotEmpty(exHotelId)){
            parme.put("exHotelId", exHotelId);
        }

        if(StringUtil.isNotEmpty(exHotelId)){
            parme.put("exHotelId", exHotelId);
        }
        if (StringUtil.isNotEmpty(otsHotelName)){
            parme.put("exHotelName", exHotelName);
        }
        List list  = new ArrayList<HotelMapping>();
        try {
            list =  hotelMappingBusinessService.queryHotelMapping(parme);
            success = true;
            result = "操作成功";
            code ="1";
        }catch (Exception e){
            e.printStackTrace();
            success = false;
            result = "操作失败";
            code ="-3";
        }finally{
            hm.put("success",success);
            hm.put("list",list);
            hm.put("size",list.size());
            hm.put("code",code);

            return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.OK);
        }
    }

}
