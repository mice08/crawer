package com.mk.crawer.web.controller;

import com.mk.crawer.biz.model.crawer.HotelMapping;
import com.mk.crawer.biz.model.crawer.RoomTypeMapping;
import com.mk.crawer.biz.servcie.IHotelMappingBusinessService;
import com.mk.crawer.biz.servcie.IRoomTypeMappingBusinessService;
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
@RequestMapping(value = "/roomtypemapping", produces = MediaType.APPLICATION_JSON_VALUE)

public class RoomTypeMappingController {

    @Autowired
    private IRoomTypeMappingBusinessService roomTypeMappingBusinessService;

    @RequestMapping(value = "/add")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> addRoomTypeMapping(HttpServletRequest request) {
        HashMap hm = new HashMap();
        boolean  success = true;
        String result = "";
        String code ="1";

        String  otsRoomTypeId = request.getParameter("otsRoomTypeId");
        if(StringUtils.isEmpty(otsRoomTypeId)){
            success = false;
            code = "-2";
            result = "otsRoomTypeId不能为空";
            return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        String  exRoomTypeId  = request.getParameter("exRoomTypeId");
        if(StringUtil.isEmpty(exRoomTypeId)){
            success = false;
            code = "-2";
            result = "exRoomTypeId不能为空";
            return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        RoomTypeMapping roomTypeMapping = new RoomTypeMapping();
        roomTypeMapping.setExRoomTypeId(Long.parseLong(exRoomTypeId));
        roomTypeMapping.setOtsRoomTypeId(Long.parseLong(otsRoomTypeId));
        roomTypeMapping.setValid("T");

        roomTypeMappingBusinessService.insert(roomTypeMapping);

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
    public ResponseEntity<Map<String,Object>> updateRoomTypeMapping(HttpServletRequest request) {
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

        String  otsRoomTypeId = request.getParameter("otsRoomTypeId");
        String  exRoomTypeId  = request.getParameter("exRoomTypeId");

        boolean  bl = false;

        RoomTypeMapping roomTypeMapping = new RoomTypeMapping();
        roomTypeMapping.setId(Long.parseLong(id));
        if(StringUtil.isNotEmpty(otsRoomTypeId)){
            bl = true;
            roomTypeMapping.setOtsRoomTypeId(Long.parseLong(otsRoomTypeId));
        }
        if(StringUtil.isNotEmpty(exRoomTypeId)){
            bl = true;
            roomTypeMapping.setExRoomTypeId(Long.parseLong(exRoomTypeId));
        }

        try {
            if(bl){
                roomTypeMappingBusinessService.update(roomTypeMapping);
                success = true;
                result = "操作成功";
                code ="1";
            }else{
                success = false;
                result = "操作失败";
                code ="-3";
                return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.BAD_REQUEST);
            }

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

    @RequestMapping(value = "/delete")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> deleteRoomTypeMapping(HttpServletRequest request) {
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
            roomTypeMappingBusinessService.deleteByPrimaryKey(Long.parseLong(id));
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
    public ResponseEntity<Map<String,Object>> queryRoomTypeMapping(HttpServletRequest request) {
        HashMap hm = new HashMap();
        boolean  success = true;
        String result = "";
        String code ="1";

        String  id = request.getParameter("id");
        String  otsRoomTypeId = request.getParameter("otsRoomTypeId");
        String  exRoomTypeId  = request.getParameter("exRoomTypeId");

        HashMap  parme = new HashMap();

        if(StringUtil.isNotEmpty(id)){
            parme.put("id", id);
        }
        if(StringUtil.isNotEmpty(otsRoomTypeId)){
            parme.put("otsRoomTypeId", otsRoomTypeId);
        }
        if(StringUtil.isNotEmpty(exRoomTypeId)) {
            parme.put("exRoomTypeId", exRoomTypeId);
        }
        List list = new ArrayList<RoomTypeMapping>();
        try {
            list = roomTypeMappingBusinessService.queryHotelMapping(parme);
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
