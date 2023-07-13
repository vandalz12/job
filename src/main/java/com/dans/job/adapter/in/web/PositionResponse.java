package com.dans.job.adapter.in.web;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

import java.time.OffsetDateTime;

@Getter
@Builder
@Jacksonized
@ToString
public class PositionResponse {

    private String id;
    private String type;
    private String url;
    private OffsetDateTime createdAt;
    private String company;
    private String companyUrl;
    private String location;
    private String title;
    private String description;
    private String howToApply;
    private String companyLogo;

}
