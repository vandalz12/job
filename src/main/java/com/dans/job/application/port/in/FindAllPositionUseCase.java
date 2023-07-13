package com.dans.job.application.port.in;

import com.dans.job.application.domain.model.Position;

import java.util.List;

public interface FindAllPositionUseCase {

    List<Position> findAllPositions();

}
