package com.dans.job.adapter.in.web;

import com.dans.job.application.port.in.FindPositionByIdUseCase;
import com.dans.job.application.port.in.FindPositionByIdCommand;
import com.dans.job.application.port.in.FindAllPositionUseCase;
import com.dans.job.constant.ResourcePath;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PositionController {

    private final PositionResponseMapper positionResponseMapper;
    private final FindAllPositionUseCase findAllPositionUseCase;
    private final FindPositionByIdUseCase findPositionByIdUseCase;

    @GetMapping(value = ResourcePath.POSITION_PATH, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PositionResponse>> getPositions() {
        return ResponseEntity.ok(
                findAllPositionUseCase.findAllPositions()
                        .stream()
                        .map(positionResponseMapper::mapPositionToPositionResponse)
                        .toList()
        );
    }

    @GetMapping(value = ResourcePath.POSITION_BY_ID_PATH, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PositionResponse> getPositionById(
            @PathVariable("id") String id
    ) {
        return ResponseEntity.ok(
                positionResponseMapper.mapPositionToPositionResponse(
                        findPositionByIdUseCase.findPositionById(
                                FindPositionByIdCommand
                                        .builder()
                                        .id(id)
                                        .build()
                        )
                )
        );
    }

}
