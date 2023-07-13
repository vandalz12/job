package com.dans.job.application.domain.service;

import com.dans.job.application.domain.model.Position;
import com.dans.job.application.port.in.FindPositionByIdUseCase;
import com.dans.job.application.port.in.FindPositionByIdCommand;
import com.dans.job.application.port.in.FindAllPositionUseCase;
import com.dans.job.application.port.out.LoadPositionPort;
import com.dans.job.application.port.out.LoadAllPositionsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionService implements FindAllPositionUseCase, FindPositionByIdUseCase {

    private final LoadAllPositionsPort loadAllPositionsPort;
    private final LoadPositionPort loadPositionPort;

    @Override
    public List<Position> findAllPositions() {
        return loadAllPositionsPort.loadAllPositions();
    }

    @Override
    public Position findPositionById(FindPositionByIdCommand command) {
        return loadPositionPort.loadPositionById(command.getId());
    }
}
