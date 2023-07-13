package com.dans.job.application.port.out;

import com.dans.job.application.domain.model.Position;

import java.util.List;

public interface LoadAllPositionsPort {

    List<Position> loadAllPositions();

}
