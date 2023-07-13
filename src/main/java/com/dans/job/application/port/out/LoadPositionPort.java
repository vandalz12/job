package com.dans.job.application.port.out;

import com.dans.job.application.domain.model.Position;

public interface LoadPositionPort {

    Position loadPositionById(String id);

}
