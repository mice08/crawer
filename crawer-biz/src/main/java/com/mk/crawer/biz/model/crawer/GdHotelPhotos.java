package com.mk.crawer.biz.model.crawer;

public class GdHotelPhotos {
    private Long id;

    private String hotelSourceId;

    private String title;

    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelSourceId() {
        return hotelSourceId;
    }

    public void setHotelSourceId(String hotelSourceId) {
        this.hotelSourceId = hotelSourceId == null ? null : hotelSourceId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}