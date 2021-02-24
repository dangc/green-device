package com.nuri.green.device.spec;

import com.nuri.green.device.entity.CommPoint;
import com.nuri.green.device.entity.CommPointLogRdo;
import com.nuri.green.device.entity.CommPointRdo;

import java.util.List;

public interface CommPointService {

    List<CommPointRdo> findAllByCondition(CommPoint commPoint);

    int count(CommPoint commPoint);

    CommPointRdo findById(int commPointId);

    int insert(CommPoint commPoint);

    int update(CommPoint commPoint);

    boolean existById(int commPointId);

    List<CommPointLogRdo> commPointLog(CommPoint commPoint);
}
