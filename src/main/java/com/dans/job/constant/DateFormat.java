package com.dans.job.constant;

public enum DateFormat {

    DEFAULT_DATE_FORMAT("EEE MMM dd HH:mm:ss 'UTC' yyyy");

    private String format;

    private DateFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return this.format;
    }

}
