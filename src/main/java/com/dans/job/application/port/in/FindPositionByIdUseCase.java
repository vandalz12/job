package com.dans.job.application.port.in;

import com.dans.job.application.domain.model.Position;

public interface FindPositionByIdUseCase {

    Position findPositionById(FindPositionByIdCommand command);

}
