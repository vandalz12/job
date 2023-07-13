package com.dans.job.application.port.in;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class FindPositionByIdCommand {

    private String id;

}
