package com.mk.whotel.biz.utils;


import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kirinli on 15/9/9.
 */
public class ServiceOutput implements Serializable {

    final Logger logger = org.slf4j.LoggerFactory.getLogger(ServiceOutput.class);

    public final static String STR_MSG_SUCCESS = "success";
    public final static String STR_MSG_ERRCODE = "errcode";
    public final static String STR_MSG = "msg";
    public final static String STR_MSG_ERRMSG = "errmsg";
    public final static String STR_MSG_TIMES = "$times$";

    /**
     *
     */
    private static final long serialVersionUID = 2497009091266355249L;

    private boolean success;
    private String errcode;
    private String errmsg;
    private Map<String, Object> msgAttrs;

    /**
     *
     */
    public ServiceOutput() {
        msgAttrs = new HashMap<String, Object>();
    }

    /**
     *
     * @return
     */
    public boolean isSuccess() {
        return success;
    }
    /**
     *
     * @param success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     *
     * @return
     */
    public String getErrcode() {
        return errcode;
    }
    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    /**
     *
     * @return
     */
    public String getErrmsg() {
        return errmsg;
    }
    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    /**
     *
     * @param errmsg
     */
    public void setFault(String errmsg) {
        this.setSuccess(false);
        this.setErrcode("-1");
        this.setErrmsg(errmsg);
    }

    /**
     *
     * @return
     */
    public Map<String, Object> getMsgAttrs() {
        return msgAttrs;
    }
    public void setMsgAttrs(Map<String, Object> msgAttrs) {
        this.msgAttrs = msgAttrs;
    }

    public void setMsgAttr(String key, Object value) {
        msgAttrs.put(key, value);
    }
    public Object getMsgAttr(String key) {
        return msgAttrs.get(key);
    }

    /**
     *
     * @return
     */
    public String toJSONString() {
        String jsonStr = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            jsonStr = mapper.writeValueAsString(this);
        } catch (Exception e) {
            logger.error("ServiceOutput序列化出错: {} ", e.getMessage());
        }
        return jsonStr;
    }

}
