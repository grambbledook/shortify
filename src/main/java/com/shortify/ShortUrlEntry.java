package com.shortify;

public class ShortUrlEntry {

    private String shortUrl;
    private String originalUrl;

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

}
