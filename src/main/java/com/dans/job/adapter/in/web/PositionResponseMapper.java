package com.dans.job.adapter.in.web;

import com.dans.job.application.domain.model.Position;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PositionResponseMapper {

    public PositionResponse mapPositionToPositionResponse(Position position) {
        if(Objects.isNull(position)) {
            return null;
        }
        return PositionResponse
                .builder()
                .id(position.getId())
                .type(position.getType())
                .url(position.getUrl())
                .createdAt(position.getCreatedAt())
                .company(position.getCompany())
                .companyUrl(position.getCompanyUrl())
                .location(position.getLocation())
                .title(position.getTitle())
                .description(position.getDescription())
                .howToApply(position.getHowToApply())
                .companyLogo(position.getCompanyLogo())
                .build();
    }

}
