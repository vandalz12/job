package com.dans.job.adapter.out.external;

import com.dans.job.application.domain.model.Position;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PositionExternalResponseMapper {

    public Position mapPositionExternalResponseToPosition(PositionExternalResponse positionExternalResponse) {
        if(Objects.isNull(positionExternalResponse)) {
            return null;
        }
        return Position
                .builder()
                .id(positionExternalResponse.getId())
                .type(positionExternalResponse.getType())
                .url(positionExternalResponse.getUrl())
                .createdAt(positionExternalResponse.getCreatedAt())
                .company(positionExternalResponse.getCompany())
                .companyUrl(positionExternalResponse.getCompanyUrl())
                .location(positionExternalResponse.getLocation())
                .title(positionExternalResponse.getTitle())
                .description(positionExternalResponse.getDescription())
                .howToApply(positionExternalResponse.getHowToApply())
                .companyLogo(positionExternalResponse.getCompanyLogo())
                .build();
    }

}
