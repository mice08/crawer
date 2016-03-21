package com.mk.crawer.api.dtos;

import org.springframework.util.StringUtils;

public class Photos {

    private String title;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (!StringUtils.isEmpty(title)&&!title.equals("[]")){
            this.title = title;
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        if (!StringUtils.isEmpty(url)&&!url.equals("[]")){
            this.url = url;
        }
    }
}
