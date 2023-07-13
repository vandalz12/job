package com.dans.job.application.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;

@Getter
@Builder
@ToString
public class Position {

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
